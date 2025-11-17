<h1>UD3. DESARROLLO Y DESPLIEGUE DE APLICACIONES BACK END CON SPRING BOOT</h1>

### ¿Qué es?

<p>Spring Boot es una herramienta de código abierto del ecosistema Spring Framework de Java que simplifica la creación de aplicaciones web y microservicios al eliminar la necesidad de configuraciones complejas</p>
<p>Se basa en tres pilares: Starters (dependencias preconfiguradas), auto-configuración condicional y servidores web embebidos para crear aplicaciones autónomas y listas para producción. Esto permite a los desarrolladores centrarse en la lógica de negocio en lugar de en la configuración del proyecto.  </p>

### Características clave

<ul>
  <li><strong>Auto-configuración:</strong> Spring Boot analiza las dependencias y configura automáticamente los componentes necesarios, como los servidores de aplicaciones, reduciendo la configuración manual. </li>
  <li>Starters: Son paquetes de dependencias que simplifican la adición de funcionalidades. Por ejemplo, spring-boot-starter-web incluye todo lo necesario para construir aplicaciones web. </li>
  <li><strong>Aplicaciones autónomas: </strong>Permite crear aplicaciones que se ejecutan de forma independiente, con servidores embebidos como Tomcat, sin necesidad de instalar un servidor de aplicaciones externo. </li>
<li><strong>Enfoque de \"convención sobre configuración\":</strong> Ofrece configuraciones por defecto que siguen las mejores prácticas, simplificando el proceso de desarrollo. </li>
<li><strong>Características listas para producción:</strong> Proporciona funcionalidades como métricas, comprobaciones de estado y configuración externalizada. </li>
</ul>

### Principales Beneficios

1. Desarrollo más rápido: Acelera el ciclo de desarrollo al eliminar la complejidad de la configuración. 
2. Menos código: La auto-configuración reduce la cantidad de código boilerplate que los desarrolladores deben escribir. 
3. Fácil integración: Se integra fácilmente con otras tecnologías como bases de datos, seguridad y monitoreo.

### Puesta en marcha

Para iniciar un nuevo proyecto en spring boot tenemos disponible el siguiente enlace:

<a href="https://start.spring.io/">Spring boot initializr</a>

La configuración que elegiremos nosotros es:

<img width="425" height="311" alt="image" src="https://github.com/user-attachments/assets/5aaa9a51-5c80-4af2-8ac2-fa6e0f21fab1" />

### Application properties

<p>El archivo application.properties (o su alternativa application.yml) se encuentra dentro de la carpeta
src/main/resources/ y sirve para configurar el comportamiento de la aplicación Spring Boot.</p>

<p>Spring Boot lo lee automáticamente al iniciar el proyecto y aplica sus valores a los distintos módulos:
base de datos, servidor, logs, seguridad, etc.</p>

```properties
spring.application.name=scrum
server.port=8080
spring.main.banner-mode=console
logging.level.root=INFO
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=franciscoaliahernandez
spring.datasource.password=
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true   

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

### Estructura del proyecto

```less
mi-proyecto/
│
├── mvnw / mvnw.cmd              → Scripts para ejecutar Maven sin instalarlo
├── pom.xml                      → Archivo de configuración de dependencias (Maven)
│
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/ejemplo/miapp/
    │   │       ├── MiAppApplication.java       → Clase principal (con @SpringBootApplication)
    │   │       ├── controller/                 → Controladores REST (manejan peticiones HTTP)
    │   │       ├── model/                      → Entidades o clases del modelo (JPA)
    │   │       ├── repository/                 → Interfaces que acceden a la BD (JpaRepository)
    │   │       ├── service/                    → Lógica de negocio (servicios)
    │   │       └── config/                     → Clases de configuración opcionales
    │   │
    │   └── resources/
    │       ├── static/                         → Recursos estáticos (CSS, JS, imágenes)
    │       ├── templates/                      → Vistas Thymeleaf (HTML si usas MVC)
    │       ├── application.properties          → Archivo de configuración principal
    │       └── banner.txt                      → Banner personalizado al iniciar la app (opcional)
    │
    └── test/
        └── java/
            └── com/ejemplo/miapp/
                └── MiAppApplicationTests.java   → Clases de prueba (JUnit)

```

Un ejemplo de como se mostraría en el IDE sería la siguiente:

<img width="288" height="393" alt="image" src="https://github.com/user-attachments/assets/18a57945-6e1c-4729-99a0-9872cb60535f" />

Es importante descatacar el pom.xml es el archivo de configuración de Maven, donde se definen las dependencias (Spring Web, JPA, PostgreSQL, etc.), versión de Java y plugins de compilación.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.3.2</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.daw</groupId>
	<artifactId>scrum</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>scrum</name>
	<description>Demo project for Spring Boot</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>


	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

```
### Controladores

Un controlador (Controller) es la parte de la aplicación que recibe las peticiones del usuario o cliente (por ejemplo, desde el navegador o una API) y devuelve una respuesta.

Forma parte del patrón MVC (Modelo - Vista - Controlador) y actúa como intermediario entre la vista y la lógica de negocio (servicios).

```java
@RestController
public class UsuarioController {
    @GetMapping("/api/hola")
    public String hola() {
        return "Hola";
    }

    @GetMapping("/api/adios")
    public String home() {
        return "Adios";
    }
}
```

| Anotación                 | Descripción                                        | Ejemplo                                          |
| ------------------------- | -------------------------------------------------- | ------------------------------------------------ |
| `@RestController`         | Indica que la clase es un controlador REST.        | `@RestController`                                |
| `@RequestMapping("/api")` | Define una ruta base común para todos los métodos. | `@RequestMapping("/api/usuarios")`               |
| `@GetMapping`             | Petición HTTP GET (obtener datos).                 | `@GetMapping("/listar")`                         |
| `@PostMapping`            | Petición HTTP POST (crear recurso).                | `@PostMapping("/nuevo")`                         |
| `@PutMapping`             | Petición HTTP PUT (actualizar recurso).            | `@PutMapping("/{id}")`                           |
| `@DeleteMapping`          | Petición HTTP DELETE (eliminar recurso).           | `@DeleteMapping("/{id}")`                        |
| `@PathVariable`           | Extrae valores de la URL.                          | `@GetMapping("/{id}")` → `@PathVariable Long id` |
| `@RequestBody`            | Recoge el cuerpo de la petición (JSON).            | `@PostMapping` → `@RequestBody Usuario usuario`  |
| `@RequestParam`           | Recoge parámetros de consulta.                     | `?nombre=Fran` → `@RequestParam String nombre`   |


### DTO 

Un DTO (Data Transfer Object) es una clase simple que sirve para transportar datos entre diferentes capas de la aplicación (por ejemplo, del controlador al servicio, o del servicio al cliente), sin exponer directamente las entidades del modelo (JPA).

Aunque podríamos devolver directamente una entidad (Usuario, Producto, etc.), no es recomendable en aplicaciones reales.
Los motivos:
<ul>
  <li>Seguridad: evitamos exponer campos sensibles de las entidades (como contraseñas o datos internos).</li>
  
  <li>Control: elegimos qué información enviamos o recibimos.</li>
  
  <li>Separación de responsabilidades: mantenemos la lógica de negocio independiente del formato de intercambio de datos.</li>
  
  <li>Eficiencia: podemos agrupar o transformar datos para simplificar las respuestas del API.</li>
</ul>

### Servicio

```java
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioDTO(u.getId(), u.getNombre(), u.getEmail()))
                .toList();
    }
}
```
### Model

```java
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String pwd;
```

### Repository

```java
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
```
### Hibernate mapeo de clases

Para realizar un mapeo de una clase tenemos que utilizar la etiqueta @Entity

```java

@Entity
@Table(name = "usuarios") 
public class Usuario {
```

Con Table indicamos el nombre de la tabla de la BBDD

Para el campo Id de clave primaria:

```java
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
```

Cuando mapeamos una columna en la bbdd si queremos configurar alguno de los parámetros hay que indicarselo como argumento en la etiqueta @Column

```java
@Column(nullable = false, unique = true, length = 50)
    private String nombreUsuario;

    @Column(nullable = false)
    private String password;
```

### Relaciones 

	<strong>One to One</strong><br>
	
	
	//Clase Persona
	@OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "dni_id", referencedColumnName = "id", unique = true)
    private Dni dni;


	
	//Clase Dni
	 @OneToOne(mappedBy = "dni", fetch = FetchType.LAZY)
	    private Persona persona;

	
<strong>One to Many</strong><br>
Para indicar una relación en la bbdd 

```java
//Clase Usuario
@OneToMany(
            mappedBy = "usuario",   
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<Tarea> tareas = new HashSet<>();
```

```java
//Clase Tarea
// Muchas tareas pertenecen a un usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
```

