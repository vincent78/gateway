#!/bin/bash
tpid=$(cat pip)

if [ -n "$tpid" ] ;then
   echo $tpid
   kill -9 $tpid
   echo 'the process has killed'
else
   echo 'the process is not used'
fi