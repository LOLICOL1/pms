#!/bin/sh

error_exit ()
{
    echo "ERROR: $1 !"
    exit 1
}

BASE_DIR=`readlink -f $(cd $(dirname $0)/..; pwd)`

PID=`ps -ef | grep "app.home=${BASE_DIR}" | grep java | grep -v grep | awk '{print $2}'`
if [ -z "$PID" ] ; then
  error_exit "No application running"
fi

APP_NAME=`ps -ef | grep "app.home=${BASE_DIR}" | grep java | grep -v grep | awk '{match($0,/app\.name=(\S+)/,a);print a[1]}'`

echo "The ${APP_NAME}(${PID}) is running..."

kill ${PID}

echo "Send shutdown request to ${APP_NAME}(${PID}) OK !"
