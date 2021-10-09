#!/bin/bash

tondir=target/TON-SDK

projectdir=`pwd`
branch=1.23.0
#`git rev-parse --abbrev-ref HEAD`

[ -d "$tondir" ] || git clone --single-branch --branch $branch https://github.com/tonlabs/TON-SDK.git $tondir
cd jni
cargo build --release || exit

resdir=$projectdir/binding/src/main/resources
mkdir -p $resdir || exit
cp target/release/*.so $resdir 2>/dev/null
cp target/release/*.dylib $resdir 2>/dev/null

cd $projectdir

if command -v docker; then
    if [[ "$(docker images -q tonlabs/local-node 2> /dev/null)" == "" ]]; then
        docker run -d --name local-node -e USER_AGREEMENT=yes -p80:80 tonlabs/local-node:latest || exit
    elif ! docker ps | grep -q tonlabs/local-node; then
        docker start local-node || exit
    fi
    mvn install
else
    mvn -DskipTests install
fi


echo "Ok"
