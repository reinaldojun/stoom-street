FROM registry-docker.localhost:5000/openjdk:11

MAINTAINER Reinaldo Viana Developer Team

VOLUME /config

ADD target/stoom-street-0.0.1.jar stoom-street-0.0.1.jar

COPY target/classes/config/* /config/

ENV JAVA_OPTS="-Xmx256m -Xms128m -XX:MetaspaceSize=48m -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar stoom-street-0.0.1.jar" ]
