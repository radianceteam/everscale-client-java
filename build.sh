#!/bin/bash

tondir=target/TON-SDK

projectdir=`pwd`
[ -d "$tondir" ] || git clone https://github.com/tonlabs/TON-SDK.git $tondir
cd $tondir/ton_client/client

node build.js || exit
cp build/* $projectdir/binding/src/main/resources
cd $projectdir

if [[ "$(docker images -q tonlabs/local-node 2> /dev/null)" == "" ]]; then
    docker run -d --name local-node -p80:80 tonlabs/local-node || exit
elif ! docker ps | grep -q tonlabs/local-node; then
    docker start local-node || exit
fi

mvn package

echo "Ok"
