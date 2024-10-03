FROM openjdk:21-jdk-slim
LABEL authors="Daniel Mercado Tapias"

WORKDIR /app

COPY target/fiduciariabogotaback-1.0.0.jar /app/fiduciariabogotaback-1.0.0.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","fiduciariabogotaback-1.0.0.jar"]
