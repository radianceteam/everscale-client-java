#!/bin/bash

tondir=target/TON-SDK

projectdir=`pwd`
[ -d "$tondir" ] || git clone --single-branch --branch platform-jni https://github.com/radianceteam/TON-SDK.git $tondir
cd $tondir/ton_client/platforms/ton-client-jni
git pull
cargo build --release || exit

resdir=$projectdir/binding/src/main/resources
mkdir -p $resdir && cp ../../../target/release/*.so $resdir
cd $projectdir

if [[ "$(docker images -q tonlabs/local-node 2> /dev/null)" == "" ]]; then
    docker run -d --name local-node -p80:80 tonlabs/local-node || exit
elif ! docker ps | grep -q tonlabs/local-node; then
    docker start local-node || exit
fi

mvn package

echo "Ok"
