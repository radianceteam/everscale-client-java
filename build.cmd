@ECHO OFF
SET PROJECT_DIR=%~dp0
SET TON_DIR=%PROJECT_DIR%\target\TON-SDK

IF NOT EXIST %TON_DIR% (
    git clone --single-branch --branch platform-jni https://github.com/radianceteam/TON-SDK.git %TON_DIR%
)

cd %TON_DIR%/ton_client/platforms/ton-client-jni
git pull

cargo build --release
IF ERRORLEVEL 1 ( EXIT )
copy ..\..\..\target\release\*.dll %PROJECT_DIR%\binding\src\main\resources
cd %PROJECT_DIR%

docker version
IF ERRORLEVEL 1 (
    mvn -DskipTests package
) ELSE (
    docker images | findstr /C:"tonlabs/local-node"
    IF ERRORLEVEL 1 (
        docker run -d --name local-node -p80:80 tonlabs/local-node
    ) ELSE (
        docker ps | findstr /C:"tonlabs/local-node"
        IF ERRORLEVEL 1 (
            docker start local-node || exit
        )
    )
    mvn package
)