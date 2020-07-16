#!/usr/bin/env bash
docker container stop analyzer
docker container rm analyzer
docker run --ip 172.19.0.131 -p 8055:8055 --name analyzer melon-analyzer:latest