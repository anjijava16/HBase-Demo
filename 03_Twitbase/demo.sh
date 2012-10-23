#!/bin/bash

pushd `dirname $0`
git clone https://github.com/hbaseinaction/twitbase.git twitbase
pushd twitbase
mvn package
./bin/launcher init
./bin/launcher loadusers 100
./bin/launcher loadtwits 1000
./bin/launcher countshakespeare
popd
popd
