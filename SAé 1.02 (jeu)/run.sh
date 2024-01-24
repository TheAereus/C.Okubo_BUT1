#!/bin/bash
export CLASSPATH=`find ./lib -name "*.jar" | tr '\n' ':'`
export MAINCLASS=WordGuessr
java -cp ${CLASSPATH}:classes $MAINCLASS