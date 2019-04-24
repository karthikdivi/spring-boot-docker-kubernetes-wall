FROM alpine:edge
RUN apk add --no-cache openjdk8
COPY target/spring-boot-docker-kubernetes-wall-0.0.1-SNAPSHOT.jar /opt/wall/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/wall/lib/spring-boot-docker-kubernetes-wall-0.0.1-SNAPSHOT.jar", "--server.port=${PORT}"]
EXPOSE $PORT