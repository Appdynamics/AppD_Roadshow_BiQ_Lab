FROM java:8-jdk
MAINTAINER Michael Englert <michi.eng@gmail.com>

ARG USER
ARG PASSWORD
ARG BASEURL
ARG VERSION

ENV APPDYNAMICS_CONTROLLER_HOST_NAME="always.appd.duckdns.org" \
    APPDYNAMICS_CONTROLLER_PORT="443" \
    APPDYNAMICS_AGENT_APPLICATION_NAME="" \
    APPDYNAMICS_AGENT_TIER_NAME="tier" \
    APPDYNAMICS_AGENT_NODE_NAME="node" \
    APPDYNAMICS_CONTROLLER_SSL_ENABLED="true" \
    APPDYNAMICS_AGENT_ACCOUNT_NAME="customer1" \
    APPDYNAMICS_AGENT_ACCOUNT_ACCESS_KEY="H16h53cur3"

ADD chain.pem /
ADD start.sh /

RUN apt-get update \
    && apt-get install -q -y vim curl unzip \
    && git clone https://github.com/michaelenglert/AppD_Summit_BiQ_Lab \
    && javac /AppD_Summit_BiQ_Lab/com/appdynamics/* \
    && cd /AppD_Summit_BiQ_Lab \
    && jar cfe ../app.jar com.appdynamics.eCommerce ./com/appdynamics/*.class \
    && cd .. \
    && curl --referer http://www.appdynamics.com -c ./cookies.txt -d "username=$USER&password=$PASSWORD" https://login.appdynamics.com/sso/login/ \
    && curl --referer http://www.appdynamics.com -L -o /analytics-agent.zip -b ./cookies.txt $BASEURL/analytics/$VERSION/analytics-agent-$VERSION.zip \
    && curl --referer http://www.appdynamics.com -L -o /app-agent.zip -b ./cookies.txt $BASEURL/sun-jvm/$VERSION/AppServerAgent-$VERSION.zip \
    && keytool -trustcacerts -keystore $JAVA_HOME/jre/lib/security/cacerts -storepass changeit -noprompt -importcert -file /chain.pem \
    && unzip /analytics-agent.zip -d / \
    && unzip /app-agent.zip -d /app-agent \
    && apt-get remove --purge -q -y curl unzip \
    && apt-get autoremove -q -y \
    && apt-get clean -q -y \
    && rm -rf /AppD_Summit_BiQ_Lab /cookies.txt /app-agent.zip /analytics-agent.zip /chain.pem

CMD /start.sh
