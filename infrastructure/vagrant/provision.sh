#!/bin/bash

function updateOS() {
  apt -y update && apt upgrade -y
}

function installDocker() {
  apt -y remove docker docker-engine docker.io
  apt -y install docker.io
  usermod -a -G docker vagrant
}

function configureDocker() {
  systemctl start docker
  systemctl enable docker
}

updateOS
installDocker
configureDocker