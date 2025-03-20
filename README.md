# Proyecto JPA en Spring Boot

## Descripción
Este proyecto es un ejemplo de aplicación web desarrollada con **Spring Boot** y **JPA (Java Persistence API)**. El propósito es demostrar cómo interactuar con bases de datos relacionales utilizando JPA a través de Spring Data JPA, que simplifica significativamente el acceso a datos.

## Tecnologías Utilizadas
- **Java 17 o superior**
- **Spring Boot (versión más reciente)**
- **Spring Data JPA**
- **H2 Database** (Base de datos en memoria para pruebas)
- **Maven** (Gestor de dependencias)
- **IntelliJ IDEA** (IDE recomendado)

## Estructura del Proyecto
El proyecto sigue la estructura estándar de un proyecto Spring Boot:
```
Proyecto-JPA-SpringBoot/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/proyectojpa/
│   │   │       ├── ProyectoJpaApplication.java
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql (Opcional, para datos iniciales)
├── pom.xml
```

## Configuración en `application.properties`
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

## Ejemplo de Entidad (`model/Usuario.java`)
```java
package com.example.proyectojpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

## Ejemplo de Repositorio (`repository/UsuarioRepository.java`)
```java
package com.example.proyectojpa.repository;

import com.example.proyectojpa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
```

## Ejemplo de Servicio (`service/UsuarioService.java`)
```java
package com.example.proyectojpa.service;

import com.example.proyectojpa.model.Usuario;
import com.example.proyectojpa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
```

## Ejemplo de Controlador (`controller/UsuarioController.java`)
```java
package com.example.proyectojpa.controller;

import com.example.proyectojpa.model.Usuario;
import com.example.proyectojpa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }
}
```

## Ejecutar la Aplicación
Ejecuta la aplicación desde tu IDE o mediante línea de comandos con:
```
mvn spring-boot:run
```
Accede a la consola H2 para verificar la base de datos en: `http://localhost:8080/h2-console`

## Pruebas
Puedes hacer peticiones HTTP a través de herramientas como **Postman** o **cURL**. Ejemplo de petición `POST`:
```
POST /usuarios
Content-Type: application/json

{
    "nombre": "Samu",
    "email": "samu@example.com"
}
```

## Conclusión
Este proyecto básico demuestra cómo utilizar **Spring Data JPA** para interactuar con bases de datos de forma sencilla y rápida. Es un excelente punto de partida para proyectos más avanzados con Spring Boot.

