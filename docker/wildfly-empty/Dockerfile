FROM jboss/wildfly:10.1.0.Final
MAINTAINER Felipe Rodrigues Michetti
ENV WILDFLY_HOME /opt/jboss/wildfly
ENV DEPLOY_DIR ${WILDFLY_HOME}/standalone/deployments/

# setup timezone
ENV TZ=America/Sao_Paulo
USER root
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
USER jboss

# create user admin
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

# to deploy app
ADD *.war /opt/jboss/wildfly/standalone/deployments/

COPY standalone.conf $WILDFLY_HOME/bin/

# necessary to create a folder before start, otherwise the gc.log and heapdump will not be created
RUN mkdir /opt/jboss/wildfly/standalone/log/

ENTRYPOINT ${WILDFLY_HOME}/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0
EXPOSE 8080 9990