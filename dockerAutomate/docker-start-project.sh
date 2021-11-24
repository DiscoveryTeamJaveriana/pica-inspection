#!/usr/bin/env bash

REPOSITORY_HOME="$(pwd)" 

function cdRepositoryHome(){
    cd "$REPOSITORY_HOME/$1"
}

cdRepositoryHome inspection-db
sh initDatabase.sh

cdRepositoryHome eureka-server
mvn clean install -U -Dmaven.test.skip=true
docker build -t eureka-server .

cdRepositoryHome zuul-proxy
mvn clean install -U -Dmaven.test.skip=true
docker build -t zuul-proxy .

cdRepositoryHome pica-employee
mvn clean install -U -Dmaven.test.skip=true
docker build -t pica-employee .

cdRepositoryHome pica-historic
mvn clean install -U -Dmaven.test.skip=true
docker build -t pica-historic .

cdRepositoryHome pica-inspection
mvn clean install -U -Dmaven.test.skip=true
docker build -t pica-inspection .

cdRepositoryHome pica-location
mvn clean install -U -Dmaven.test.skip=true
docker build -t pica-location .

cdRepositoryHome pica-supervisor
mvn clean install -U -Dmaven.test.skip=true
docker build -t pica-supervisor .

cdRepositoryHome pica-notification
docker build -t pica-notification .

cdRepositoryHome pica-front
docker build -t pica-front .

cdRepositoryHome
docker-compose -f docker-compose.yml up -d