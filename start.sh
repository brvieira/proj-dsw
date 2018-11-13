#!/bin/bash

DIR="$(cd "$(dirname "$0")" && pwd)"

echo "Running Docker start script from "$DIR

read -p "Mysql port: " MYSQL_PORT
read -p "Tomcat port: " TOMCAT_PORT

#Removing old images
    docker rmi -f mysql-image tomcat-image
#Building our images
    docker build -t mysql-image $DIR/mysql
    docker build -t tomcat-image $DIR/tomcat

#Removing old network
    docker network remove dsw-net
    
#Creating our network
    docker network create dsw-net

#Removing our containers if them are running
    docker rm -f mysql-container tomcat-container

#Running our containers
    docker run -d --name mysql-container --net dsw-net -p $MYSQL_PORT:3306 mysql-image
    docker run -it --net dsw-net -v $DIR/dist:/usr/local/tomcat/webapps -p $TOMCAT_PORT:8080 --name tomcat-container tomcat-image
