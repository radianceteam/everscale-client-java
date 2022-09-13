@ECHO OFF
SET PROJECT_DIR=%~dp0
SET TON_DIR=%PROJECT_DIR%\target\TON-SDK

IF NOT EXIST %TON_DIR% (
    git clone --single-branch --branch 1.37.1 https://github.com/tonlabs/TON-SDK.git %TON_DIR%
)

cd jni
cargo build --release
IF ERRORLEVEL 1 ( EXIT )
SET RESOURCES_DIR=%PROJECT_DIR%\binding\src\main\resources
IF NOT EXIST %RESOURCES_DIR% ( md %RESOURCES_DIR% )
copy target\release\*.dll %RESOURCES_DIR%
cd %PROJECT_DIR%

docker version
IF ERRORLEVEL 1 (
    mvn -DskipTests install
) ELSE (
    docker images | findstr /C:"tonlabs/local-node"
    IF ERRORLEVEL 1 (
        docker run -d --name local-node -e USER_AGREEMENT=yes -p80:80 tonlabs/local-node
    ) ELSE (
        docker ps | findstr /C:"tonlabs/local-node"
        IF ERRORLEVEL 1 (
            docker start local-node || exit
        )
    )
    mvn install
)