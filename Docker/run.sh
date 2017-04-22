#!/bin/bash

echo -e "\x1B[7mPortal User\x1B[27m"
read user

echo -e "\x1B[7mPortal Password\x1B[27m"
read -s password

docker build \
--build-arg USER=$user \
--build-arg PASSWORD=$password \
--build-arg BASEURL=https://aperture.appdynamics.com/download/prox/download-file \
--build-arg VERSION=4.3.0.0 \
-t michi/biqlab .
