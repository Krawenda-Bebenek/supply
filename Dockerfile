# Maven build container 

FROM maven:3.6.3-openjdk-11 AS maven_build

#COPY pom.xml /tmp/

#COPY src /tmp/src/

WORKDIR /tmp/

RUN mvn package

#pull base image

FROM openjdk

#maintainer 
MAINTAINER bebenek13@gmail.com
#expose port 8080
EXPOSE 8080
#RUN ln -s  /exchangeDefinition/hello-world-0.1.0.jar /tmp/target/hello-world-0.1.0.jar


CMD java -jar /tmp/target/hello-world-0.1.0.jar; echo "cool"

#copy hello world to docker image from builder image

#COPY --from=maven_build /tmp/target/hello-world-0.1.0.jar /exchangeDefinition/hello-world-0.1.0.jar
