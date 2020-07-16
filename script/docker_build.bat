@echo off
pushd "%~dp0"

cd ../
call ./gradlew.bat clean build --stacktrace
cd ./docker
docker build -t melon-analyzer:latest .
docker container stop analyzer
docker container rm analyzer
docker run -d --net mynet --ip 172.19.0.131 -p 8055:8055 --name analyzer melon-analyzer:latest
cd ../

:exit
popd
@echo on