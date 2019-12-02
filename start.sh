#!/usr/bin/env bash
command -v docker >/dev/null 2>&1
command -v docker-compose >/dev/null 2>&1
sh build-install/build.sh
docker-compose up