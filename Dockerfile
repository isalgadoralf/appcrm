# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk-jammy

# Establecer variables de entorno
ENV SERVER_PORT=8080
ENV JAVA_OPTS="-Xms512m -Xmx1024m"

# Variables para la conexión a la base de datos
ENV DB_HOST=postgres-db2
ENV DB_PORT=5432
ENV DB_NAME=dbsales
ENV DB_USER=postgres
ENV DB_PASSWORD=D3v3l0p3r2023*

# Crear un usuario no privilegiado para ejecutar la aplicación
RUN groupadd -r javaapp && useradd -r -g javaapp javaapp

# Crear directorio de la aplicación y establecer permisos
RUN mkdir /app && chown -R javaapp:javaapp /app

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR desde la etapa de construcción
COPY --from=build /app/target/appcrm-0.0.1-SNAPSHOT.jar /app/app.jar

# Cambiar al usuario no privilegiado
USER javaapp

# Exponer el puerto de la aplicación
EXPOSE ${SERVER_PORT}

# Ejecutar la aplicación
CMD ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar \
    --spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME} \
    --spring.datasource.username=${DB_USER} \
    --spring.datasource.password=${DB_PASSWORD}"]
