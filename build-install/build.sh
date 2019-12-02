#!/usr/bin/env bash
cd shop-config-server
mvn clean install
cd ../shop-eureka-server
mvn clean install
cd ../shop-gateway-server
mvn clean install
cd ../event-register-api
mvn clean install