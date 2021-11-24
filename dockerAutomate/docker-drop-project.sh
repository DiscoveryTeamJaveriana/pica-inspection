#!/usr/bin/env bash

REPOSITORY_HOME="$(pwd)" 

function cdRepositoryHome(){
    cd "$REPOSITORY_HOME/$1"
}

cdRepositoryHome
docker-compose down --volumes

cdRepositoryHome inspection-db
sh dropDatabase.sh