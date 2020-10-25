#!/bin/bash

SCRIPT_PATH="$( cd "$(dirname "$0")" >/dev/null 2>&1 || exit ; pwd -P )"


function setEnvironment() {
  readonly MARIADB_VERSION=10.5.6
  readonly MARIADB_PORT=3306

  ROOT_PW=$(cat "${SCRIPT_PATH}"/.env/root_pw)
}

function runContainer() {
  docker run --name mariadb -v "${SCRIPT_PATH}/init":/docker-entrypoint-initdb.d -e MYSQL_ROOT_PASSWORD="${ROOT_PW}" -p ${MARIADB_PORT}:${MARIADB_PORT} -d mariadb:"${MARIADB_VERSION}"
}

setEnvironment
runContainer