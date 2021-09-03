#!/bin/sh

case $1 in
	start) exec sh startup.sh;;
	debug) exec sh startup.sh -d 10000;;
	stop|shutdown) exec sh shutdown.sh;;
	restart) sh shutdown.sh; sleep 10; exec sh startup.sh;;
	dump) exec sh dump.sh;;
	*) echo "Usage: sh $0 [start | debug | stop | restart | dump]";;
esac
