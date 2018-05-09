SERVER_NAME='getting-started'
PRG_PATH=$(dirname $0)
PRG_HOME=$(readlink -f $PRG_PATH/..)
LIB_PATH=$PRG_HOME/lib
CONF_PATH=$PRG_HOME/config

SERVER_PORT=`sed -nr '/port: [0-9]+/ s/.*port: +([0-9]+).*/\1/p' $CONF_PATH/application.yml`
CLASS_PATH=$CONF_PATH:$LIB_PATH:$LIB_PATH/*
JAR_NAME='getting-started.jar'
#JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n"
JAVA_OPTS="-Xms1024M -Xmx1024M -XX:MaxPermSize=512M -XX:PermSize=512M"
JAVA_ENV=" -Dlogging.path=$PRG_HOME/logs -Dlogging.config=$CONF_PATH/log4j2.xml -Dspring.config.location=$CONF_PATH/application.yml -DAPP_HOST=$(hostname)-$(whoami)" 

echo -e "Starting the $SERVER_NAME ..."
java -jar $CLASS_PATH $JAVA_OPTS $JAVA_ENV $LIB_PATH/$JAR_NAME
