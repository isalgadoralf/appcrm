# CRM Application

## Descripción
Este proyecto es una aplicación CRM (Customer Relationship Management) desarrollada con Spring Boot y Maven. La aplicación permite gestionar clientes, incluyendo la validación de campos obligatorios y la integración con una base de datos PostgreSQL.

## Requisitos
- Java 17 
- Maven 3.9.15
- PostgreSQL 16 o superior

## Configuración
### Base de Datos
1. Asegúrate de tener PostgreSQL instalado y en ejecución.
2. Crea una base de datos llamada `dbsales`.
3. Configura las credenciales de la base de datos en el archivo `src/main/resources/application.properties`.

```ini
spring.datasource.url=jdbc:postgresql://localhost:5432/dbsales
spring.datasource.username=postgres
spring.datasource.password=developer
```

### Puerto del Servidor
El servidor está configurado para ejecutarse en el puerto `9091`. Puedes cambiar esto en el archivo `src/main/resources/application.properties`.

```ini
server.port=9091
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
