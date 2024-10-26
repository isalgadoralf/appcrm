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
* Se tiene que tener disponible los puertos 9091 o el puerto que se vaya configurar para la aplicación en la máquina donde se va a ejecutar la aplicación generada por Jenkins (Agregar regla de firewall si es necesario)


## Pluggins Jenkins
- Maven Integration plugin - version 3.23
- Build With Parameters

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

    // Definimos los parámetros para las variables de la base de datos
    parameters {
        string(name: 'DB_USER', defaultValue: 'postgres', description: 'Usuario de la base de datos')
        password(name: 'DB_PASS', defaultValue: 'D3v3l0p3r2023*', description: 'Contraseña de la base de datos')
        string(name: 'DB_URL', defaultValue: 'jdbc:postgresql://localhost:5432/dbsales', description: 'URL de la base de datos')
        string(name: 'DEPLOY_DIR', defaultValue: 'D:\\deploy\\springboot_app', description: 'Directorio de despliegue')
    }

    environment {
        // Asignamos las variables de entorno para usarlas en las etapas
        DB_USER = "${params.DB_USER}"
        DB_PASS = "${params.DB_PASS}"
        DB_URL = "${params.DB_URL}"
        DEPLOY_DIR = "${params.DEPLOY_DIR}"
    }

    stages {
        stage('Checkout Proyecto') {
            steps {
                // Clona el repositorio desde la rama main
                git(branch: "main", url: "https://github.com/isalgadoralf/appcrm.git")
            }
        }

        stage('Configurar Propiedades de la Aplicación') {
            steps {
                // Configura las propiedades de la base de datos en el archivo application.properties
                bat """
                powershell -Command "(Get-Content src\\main\\resources\\application.properties) -replace 'spring.datasource.username=.*', 'spring.datasource.username=${DB_USER}' | Set-Content src\\main\\resources\\application.properties"
                powershell -Command "(Get-Content src\\main\\resources\\application.properties) -replace 'spring.datasource.password=.*', 'spring.datasource.password=${DB_PASS}' | Set-Content src\\main\\resources\\application.properties"
                powershell -Command "(Get-Content src\\main\\resources\\application.properties) -replace 'spring.datasource.url=.*', 'spring.datasource.url=${DB_URL}' | Set-Content src\\main\\resources\\application.properties"
                """
            }
        }

        stage('Compilar') {
            steps {
                // Compila el proyecto con Maven
                bat 'mvn clean install'
            }
        }

        stage('Desplegar en Directorio Local') {
            steps {
                // Despliega el JAR generado en un directorio local
                bat  """
                if not exist ${DEPLOY_DIR} mkdir ${DEPLOY_DIR}
                copy target\\*.jar  ${DEPLOY_DIR}
                """
            }
        }

        stage('Reiniciar JAR en Segundo Plano') {
            steps {
                // Reinicia el JAR en segundo plano usando PowerShell
                withEnv(['JENKINS_NODE_COOKIE=DontKillMe']) {
                    powershell '''
                    $DeployDir = 'D:\\deploy\\springboot_app'
                    $JarFile = Get-ChildItem -Path $DeployDir -Filter *.jar | Select-Object -First 1

                    # Verifica si ya hay un proceso Java ejecutándose
                    $javaProcess = Get-Process -Name "java" -ErrorAction SilentlyContinue | Where-Object { $_.Path -like "$DeployDir*" }

                    if ($javaProcess -ne $null) {
                        Write-Output "Deteniendo el proceso Java existente..."
                        Stop-Process -Id $javaProcess.Id -Force
                    }

                    # Inicia el nuevo JAR en segundo plano
                    if ($JarFile -ne $null) {
                        Write-Output "Iniciando el nuevo JAR en segundo plano..."
                        Start-Process -FilePath "java" -ArgumentList "-jar $($JarFile.FullName)" -WindowStyle Hidden
                    }
                    '''
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline ejecutado con éxito.'
        }
        failure {
            echo 'El pipeline falló.'
        }
    }
}

```

## Ejecución de la aplicación después de compilar con Jenkins
Para validar que el servicio se encuentra disponible después de compilar con Jenkins, hacer un GET a la siguiente URL:
- `GET /cliente` - Obtiene una lista de clientes.


**## Ejecución**
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

- `GET /cliente` - Obtiene una lista de clientes.
- `POST /cliente` - Crea un nuevo cliente.



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
