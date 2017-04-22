#!/bin/bash

java -Dappdynamics.force.default.ssl.certificate.validation=false -javaagent:/app-agent/javaagent.jar -jar app.jar
