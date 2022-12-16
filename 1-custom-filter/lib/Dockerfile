FROM gradle:7-jdk11-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -PspringCloudVersion=2022.0.1

FROM alpine

RUN mkdir -p /app/extensions

COPY --from=build /home/gradle/src/build/libs/*.jar /app/extensions/gateway-extension.jar
