#!/bin/bash

pushd `dirname $0`
mvn package
java -cp target/hbasedemo-1.0.0.jar com.bornski.hadoop.hbasedemo.ReadmeDemo
popd
