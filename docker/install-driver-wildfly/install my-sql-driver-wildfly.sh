wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.15.tar.gz
wget https://jdbc.postgresql.org/download/postgresql-9.4.1212.jar

tar -xf mysql-connector-java-8.0.15.tar.gz
cp mysql-connector-java-8.0.15/mysql-connector-java-8.0.15.jar .
rm -rf mysql-connector-java-8.0.15
rm -f mysql-connector-java-8.0.15.tar.gz
mkdir -p /home/felipe/wildfly-11.0.0.Final/modules/system/layers/base/com/mysql/main
mv mysql-connector-java-8.0.15.jar /home/felipe/wildfly-11.0.0.Final/modules/system/layers/base/com/mysql/main
cd /home/felipe/wildfly-11.0.0.Final/modules/system/layers/base/com/mysql/main
touch module.xml
echo '<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.1" name="com.mysql">
<resources>
   <resource-root path="mysql-connector-java-8.0.15.jar"/>
</resources>
<dependencies>
  <module name="javax.api"/>
  <module name="javax.transaction.api"/>
</dependencies>
</module>' >> module.xml
cd /home/felipe/wildfly-11.0.0.Final/bin
sh jboss-cli.sh


# exec in cli ...

# /subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver-class-name=com.mysql.jdbc.Driver)

# module add --name=org.postgres --resources=/home/felipe/Desktop/install-driver-wildfly/postgresql-9.4.1212.jar --dependencies=javax.api,javax.transaction.api /subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)

# Add the datasource
# ENV DATASOURCE_NAME postgresDS
# ENV DATASOURCE_JNDI java:/postgresDS
# data-source add --jndi-name=java:/postgresDS --name=postgresDS --connection-url=jdbc:postgresql://localhost:5432/workix --driver-name=postgres --user-name=postgres --password=postgres
# data-source add --jndi-name=java:/mysqlDS --name=mysqlDS --connection-url=jdbc:mysql://localhost:3306/workix --driver-name=mysql --user-name=root --password=root

# Configure Message Queue
# /subsystem=messaging-activemq/server=default/jms-queue=jobsTopic:add(entries=[java:/jms/topics/jobsTopic])
# /subsystem=messaging-activemq/server=default/jms-queue=usersTopic:add(entries=[java:/jms/topics/usersTopic])

