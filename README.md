# CRM Application

## Descripción
Este proyecto es una aplicación CRM (Customer Relationship Management) desarrollada con Spring Boot y Maven. La aplicación permite gestionar clientes, incluyendo la validación de campos obligatorios y la integración con una base de datos PostgreSQL.

## Requisitos
- Java 21 
- Maven 3.9.15
- PostgreSQL 16 o superior



## Configuración
### Base de Datos
1. Asegúrate de tener PostgreSQL instalado y en ejecución.
2. Crea una base de datos llamada `dbsales`.


## Consideraciones para compilar con Jenkins
* Para ejecutar la aplicación, se tiene que tener la base de datos PostgreSQL instalada y en ejecución, además de tener el archivo `application.properties` configurado con las credenciales de la base de datos.
* Para compilar con Jenkins, se debe tener instalado el pluggin de Maven Integration plugin - version 3.23
* Se debe tener configurado el JDK 21 en la máquina donde se va a ejecutar la aplicación generada por de Jenkins
* los comandos de ejecución de la aplicación se deben ejecutar en la consola de comandos de Windows
* Se tiene que tener disponible los puertos 9091

## Pluggins Jenkins
- Maven Integration plugin - version 3.23

## Configurar variables de entorno para en pipeline Jenkins
* Se debe configurar las variables de entorno en el archivo `Jenkinsfile` para que la aplicación pueda conectarse a la base de datos.
```groovy
set "DB_USER=postgres"
set "DB_PASS=D3v3l0p3r2023*"
set "DB_URL=jdbc:postgresql://localhost:5432/dbsales"
DEPLOY_DIR=D:\\deploy\\springboot_app  //Directorio donde se va a desplegar la aplicación
```

## Pipeline Jenkins

```groovy
pipeline {
    agent any
    stages {
        stage('Checkout Projecto') {
            steps {
                git(branch: "main", url: "https://github.com/isalgadoralf/appcrm.git")
            }
        }
        stage('Set Application Properties') {
            steps {
                bat '''
                set "DB_USER=postgres"
                set "DB_PASS=D3v3l0p3r2023*"
                set "DB_URL=jdbc:postgresql://localhost:5432/dbsales"
                powershell -Command "(Get-Content src\\main\\resources\\application.properties) -replace 'spring.datasource.username=.*', 'spring.datasource.username=%DB_USER%' | Set-Content src\\main\\resources\\application.properties"
                powershell -Command "(Get-Content src\\main\\resources\\application.properties) -replace 'spring.datasource.password=.*', 'spring.datasource.password=%DB_PASS%' | Set-Content src\\main\\resources\\application.properties"
                powershell -Command "(Get-Content src\\main\\resources\\application.properties) -replace 'spring.datasource.url=.*', 'spring.datasource.url=%DB_URL%' | Set-Content src\\main\\resources\\application.properties"
                '''
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Deploy to Local Directory') {
            steps {
                // Copiar el archivo JAR al directorio de despliegue especificado
                bat '''
                set DEPLOY_DIR=D:\\deploy\\springboot_app
                if not exist %DEPLOY_DIR% mkdir %DEPLOY_DIR%
                copy target\\*.jar %DEPLOY_DIR%
                '''
            }
        }
    }
}
```

## Ejecución de la aplicación después de compilar con Jenkins
Para ejecutar la aplicación, se debe ir a la ubicación donde se encuentra el archivo jar generado por jenkins y ejecutar el siguiente comando:

```sh
start /B java -jar appcrm-0.0.1-SNAPSHOT.jar
```

## Ejecución
Para ejecutar la aplicación, usa el siguiente comando de Maven:

```sh
mvn spring-boot:run
```

## Pruebas
Para ejecutar las pruebas, usa el siguiente comando de Maven:

```sh
mvn test
```

## Endpoints
La aplicación expone los siguientes endpoints:

- `GET /clientes` - Obtiene una lista de clientes.
- `POST /clientes` - Crea un nuevo cliente.
- `PUT /clientes/{id}` - Actualiza un cliente existente.
- `DELETE /clientes/{id}` - Elimina un cliente.

## Configuración de CORS
La configuración de CORS permite solicitudes desde `http://localhost:3000`. Puedes cambiar esto en la clase `WebConfig`.

```java
@Override
public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", PUT", "DELETE", "OPTIONS");
}
```

## Validación de Campos
La clase `Cliente` incluye validaciones para los campos obligatorios. Los campos `telefono` y `direccion` no son obligatorios.

```java
@NotBlank(message = "Nombre is mandatory")
private String nombre;

@NotBlank(message = "Apellidos is mandatory")
private String apellidos;

@NotBlank(message = "NumDocumento is mandatory")
private String numDocumento;

@NotBlank(message = "TipoDocumento is mandatory")
private String tipoDocumento;

@NotBlank(message = "CodCliente is mandatory")
private String codCliente;

@NotBlank(message = "Email is mandatory")
private String email;
```
