FROM java:8
MAINTAINER Ricardo T. <rickytaki@yahoo.com.br>
VOLUME /tmp
ADD comparador-0.0.1.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]