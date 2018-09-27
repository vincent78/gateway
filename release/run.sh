#! /bin/bash
nohup java  -Dlog.home=/data/logs/IPAnalyze  -jar IPAnalyze-1.0-SNAPSHOT.jar  > /data/logs/IPAnalyze/nohup &
