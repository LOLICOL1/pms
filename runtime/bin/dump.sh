#!/bin/bash

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
export PATH=$JAVA_HOME/bin:$PATH

#==============================================================================
# Dumping
#==============================================================================

BASE_DIR=`cd $(dirname $0)/.. && pwd`
DUMP_DIR="${BASE_DIR}/dump/`date +%Y-%m-%dT%H:%M:%S`"

PID=`ps -ef | grep "app.home=${BASE_DIR}" | grep java | grep -v grep | awk '{print $2}'`
if [ -z "$PID" ]; then
  error_exit "No application running"
fi

if [ ! -d ${DUMP_DIR} ]; then
  mkdir -p ${DUMP_DIR}
fi

APP_NAME=`ps -ef | grep "app.home=${BASE_DIR}" | grep java | grep -v grep | awk '{match($0,/app\.name=(\S+)/,a);print a[1]}'`
echo "Dumping ${APP_NAME}(${PID}) ..."

jinfo $PID > $DUMP_DIR/jinfo-$PID.dump 2>&1
jstat -gc $PID > $DUMP_DIR/jstat-gc-$PID.dump 2>&1
jstat -gcutil $PID > $DUMP_DIR/jstat-gcutil-$PID.dump 2>&1
jstat -gccapacity $PID > $DUMP_DIR/jstat-gccapacity-$PID.dump 2>&1
jstack $PID > $DUMP_DIR/jstack-$PID.dump 2>&1
jmap $PID > $DUMP_DIR/jmap-$PID.dump 2>&1
jmap -heap $PID > $DUMP_DIR/jmap-heap-$PID.dump 2>&1
jmap -histo $PID > $DUMP_DIR/jmap-histo-$PID.dump 2>&1

if [ -r /usr/sbin/lsof ]; then
  /usr/sbin/lsof -p $PID > $DUMP_DIR/lsof.dump
fi
if [ -r /bin/netstat ]; then
  /bin/netstat -an > $DUMP_DIR/netstat.dump 2>&1
fi
if [ -r /usr/bin/iostat ]; then
  /usr/bin/iostat > $DUMP_DIR/iostat.dump 2>&1
fi
if [ -r /usr/bin/mpstat ]; then
  /usr/bin/mpstat > $DUMP_DIR/mpstat.dump 2>&1
fi
if [ -r /usr/bin/vmstat ]; then
  /usr/bin/vmstat > $DUMP_DIR/vmstat.dump 2>&1
fi
if [ -r /usr/bin/free ]; then
  /usr/bin/free -th > $DUMP_DIR/free.dump 2>&1
fi
if [ -r /usr/bin/sar ]; then
  /usr/bin/sar > $DUMP_DIR/sar.dump 2>&1
fi
if [ -r /usr/bin/uptime ]; then
  /usr/bin/uptime > $DUMP_DIR/uptime.dump 2>&1
fi

echo "INFO: Dump at: $DUMP_DIR OK !"
