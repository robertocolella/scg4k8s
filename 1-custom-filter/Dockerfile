FROM --platform=linux/amd64 gradle:7-jdk11-alpine AS build
COPY --chown=gradle:gradle ./lib /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -PspringCloudVersion=2022.0.1

FROM alpine

RUN mkdir -p /app/extensions

COPY --from=build /home/gradle/src/build/libs/*.jar /app/extensions/gateway-extension.jar