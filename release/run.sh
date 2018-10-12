#! /bin/bash

./stop.sh

nohup java  -Dlog.home=/data/logs/gateway  -jar gateway-1.0.0-SNAPSHOT.jar  > /dev/null 2>&1 &

./showlog.sh