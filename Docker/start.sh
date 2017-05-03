#!/bin/bash

sed -i -e 's/1g/128m/g' /analytics-agent/conf/analytics-agent.properties

java -Xmx256m -Xms256m -Dappdynamics.force.default.ssl.certificate.validation=false -javaagent:/app-agent/javaagent.jar -jar app.jar
