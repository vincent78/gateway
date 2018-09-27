#!/bin/bash
port=8086

tpid=`netstat -anp |grep $port|awk '{printf $7}'|cut -d/ -f1 `
if [ -n "$tpid" ] ;then
   echo $tpid
   kill -9 $tpid
   echo 'the process has killed'
else
   echo 'the port is not used'
fi