#!/bin/bash

tondir=target/TON-SDK

projectdir=`pwd`
[ -d "$tondir" ] || git clone --single-branch --branch 1.1.0 https://github.com/tonlabs/TON-SDK.git $tondir
cd jni
cargo build --release || exit

resdir=$projectdir/binding/src/main/resources
mkdir -p $resdir || exit
cp target/release/*.so $resdir
cp target/release/*.dylib $resdir

cd $projectdir

if command -v docker; then
    if [[ "$(docker images -q tonlabs/local-node 2> /dev/null)" == "" ]]; then
        docker run -d --name local-node -p80:80 tonlabs/local-node || exit
    elif ! docker ps | grep -q tonlabs/local-node; then
        docker start local-node || exit
    fi
    mvn install
else
    mvn -DskipTests install
fi


echo "Ok"
