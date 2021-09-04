#!/bin/sh

case $1 in
	start) exec sh `readlink -f $(dirname $0)`/startup.sh;;
	debug) exec sh `readlink -f $(dirname $0)`/startup.sh -d 10000;;
	stop|shutdown) exec sh `readlink -f $(dirname $0)`/shutdown.sh;;
	dump) exec sh `readlink -f $(dirname $0)`/dump.sh;;
	*) echo "Usage: sh $0 [start | stop | debug | dump]";;
esac
