# Proyecto Spring Boot - Instrucciones de Despliegue

Este proyecto es una aplicación web construida con **Spring Boot**. A continuación se presentan los pasos para desplegar la aplicación en un entorno de producción utilizando **Docker** y **PostgreSQL**.

## Requisitos previos

Antes de desplegar la aplicación, asegúrate de cumplir con los siguientes requisitos:

1. **Docker** instalado en el sistema. Puedes instalarlo siguiendo las instrucciones en: [https://docs.docker.com/get-docker/](https://docs.docker.com/get-docker/).
3. **PostgreSQL** instalado localmente o configurado en un contenedor Docker.

## Variables de entorno

Asegúrate de configurar las siguientes variables de entorno para la base de datos en el sistema o en el archivo `application.properties`:

```properties
# Configuración de la base de datos PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:54320/techtest
spring.datasource.username=daniel
spring.datasource.password=damt
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Generación de Docker

Tenga certeza que el .jar ha sido generado correctamente con el comando:
```
mvn clean package
```

```properties
FROM openjdk:21-jdk-slim
LABEL authors="Daniel Mercado Tapias"

WORKDIR /app

COPY target/fiduciariabogotaback-1.0.0.jar /app/fiduciariabogotaback-1.0.0.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","fiduciariabogotaback-1.0.0.jar"]
```

Una vez generada la imagen construya el contenedor.

```
dock build -t fiduciariabgotaimg .
```


### Pruebas

Haga uso de los endpoints mediante postman o el front desplegado