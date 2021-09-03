#!/bin/sh

error_exit ()
{
    echo "ERROR: $1 !"
    exit 1
}

#==============================================================================
# JDK Detected
#==============================================================================

cygwin=false
darwin=false
os400=false
case "`uname`" in
CYGWIN*) cygwin=true;;
Darwin*) darwin=true;;
OS400*) os400=true;;
esac

[ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=$HOME/jdk/java
[ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=/usr/java
[ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=/opt/java/default
[ ! -e "$JAVA_HOME/bin/java" ] && unset JAVA_HOME

if [ -z "$JAVA_HOME" ]; then
  if $darwin; then
    if [ -x '/usr/libexec/java_home' ] ; then
      JAVA_HOME=`/usr/libexec/java_home`
    elif [ -d "/System/Library/Frameworks/JavaVM.framework/Versions/CurrentJDK/Home" ]; then
      JAVA_HOME="/System/Library/Frameworks/JavaVM.framework/Versions/CurrentJDK/Home"
    fi
  else
    JAVA_PATH=`dirname $(readlink -f $(which javac))`
    if [ "x$JAVA_PATH" != "x" ]; then
      JAVA_HOME=`dirname $JAVA_PATH 2>/dev/null`
    fi
  fi
  if [ -z "$JAVA_HOME" ]; then
        error_exit "Please set the JAVA_HOME variable in your environment, We need java(x64)! jdk8 or later is better!"
  fi
fi
export JAVA_HOME
export JAVA="$JAVA_HOME/bin/java"

#==============================================================================
# Arguments processing
#==============================================================================

export APP_NAME=$USER
export DEBUG=false
export BASE_DIR=`cd $(dirname $0)/..; pwd`
export DEFAULT_SEARCH_LOCATIONS="classpath:/,optional:classpath:/config/,file:./,optional:file:./config/"
export CUSTOM_SEARCH_LOCATIONS=${DEFAULT_SEARCH_LOCATIONS},file:${BASE_DIR}/conf/
while getopts ":s:d:" opt
do
  case $opt in
    s)
      APP_NAME=$OPTARG;;
    d)
      DEBUG=true
      DEBUG_PORT=$OPTARG;;
    ?)
    error_exit "unknown parameter";;
  esac
done

#==============================================================================
# JVM Configuration
#==============================================================================

if $DEBUG; then
  JAVA_OPTS="${JAVA_OPTS} -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=${DEBUG_PORT},server=y,suspend=n"
fi

JAVA_OPTS="${JAVA_OPTS} -server -Xms128m -Xmx128m -Xss256k -XX:NewRatio=1 -XX:SurvivorRatio=8 -XX:MetaspaceSize=96m -XX:MaxMetaspaceSize=96m"
JAVA_OPTS="${JAVA_OPTS} -XX:-OmitStackTraceInFastThrow -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${BASE_DIR}/logs/java_heapdump.hprof"
JAVA_OPTS="${JAVA_OPTS} -XX:-UseLargePages"

JAVA_MAJOR_VERSION=$($JAVA -version 2>&1 | sed -E -n 's/.* version "([0-9]*).*$/\1/p')
if [[ "$JAVA_MAJOR_VERSION" -ge "9" ]] ; then
  JAVA_OPTS="${JAVA_OPTS} -Xlog:gc*:file=${BASE_DIR}/logs/gc.log:time,tags:filecount=10,filesize=102400"
else
  JAVA_OPTS="${JAVA_OPTS} -Djava.ext.dirs=${JAVA_HOME}/jre/lib/ext:${JAVA_HOME}/lib/ext"
  JAVA_OPTS="${JAVA_OPTS} -Xloggc:${BASE_DIR}/logs/gc.log -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M"
fi

JAVA_OPTS="${JAVA_OPTS} -Dapp.home=${BASE_DIR} -Dapp.name=${APP_NAME}"
JAVA_OPTS="${JAVA_OPTS} -jar ${BASE_DIR}/lib/${APP_NAME}.jar"
JAVA_OPTS="${JAVA_OPTS} ${JAVA_OPTS_EXT}"
JAVA_OPTS="${JAVA_OPTS} --spring.config.location=${CUSTOM_SEARCH_LOCATIONS}"
JAVA_OPTS="${JAVA_OPTS} --logging.config=${BASE_DIR}/conf/logback.xml"

#==============================================================================
# Starting
#==============================================================================

cd $BASE_DIR

PID=`ps -ef | grep "app.home=${BASE_DIR}" | grep java | grep -v grep | awk '{print $2}'`
if [ -n "$PID" ]; then
  APP_NAME=`ps -ef | grep "app.home=${BASE_DIR}" | grep java | grep -v grep | awk '{match($0,/app\.name=(\S+)/,a);print a[1]}'`
  error_exit "The ${APP_NAME}(${PID}) already started"
fi

if [ ! -d "${BASE_DIR}/logs" ]; then
  mkdir ${BASE_DIR}/logs
fi

echo "$JAVA ${JAVA_OPTS}"
# check the start.out log output file
if [ ! -f "${BASE_DIR}/logs/start.out" ]; then
  touch "${BASE_DIR}/logs/start.out"
fi
# start
echo "$JAVA ${JAVA_OPTS}" > ${BASE_DIR}/logs/start.out 2>&1 &
nohup $JAVA ${JAVA_OPTS} >> ${BASE_DIR}/logs/start.out 2>&1 &
echo "Application is starting，you can check the ${BASE_DIR}/logs/start.out"
