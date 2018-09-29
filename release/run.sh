#! /bin/bash
nohup java  -Dlog.home=/tmp/clusterTest  -jar gateway-1.0.0-SNAPSHOT.jar  > /dev/null 2>&1 &
