#! /bin/bash
nohup java  -Dlog.home=/tmp/clusterTest  -jar gateway-2.0.0-SNAPSHOT.jar  > /tmp/clusterTest/nohup &
