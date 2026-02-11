# Almacenamiento en el Navegador: LocalStorage, SessionStorage y Cookies (Angular)

Cuando desarrollamos aplicaciones Angular, muchas veces necesitamos
guardar información en el navegador del usuario.\
Las tres opciones más utilizadas son:

-   LocalStorage
-   SessionStorage
-   Cookies

Cada una tiene características distintas y es importante saber cuándo
usar cada una.

------------------------------------------------------------------------

## LocalStorage

### ¿Qué es?

Es un mecanismo de almacenamiento que permite guardar datos en el
navegador sin fecha de expiración.\
Los datos permanecen incluso si el usuario cierra el navegador o
reinicia el equipo.

### Características

-   Capacidad aproximada: 5-10 MB\
-   Solo guarda strings\
-   Persistente\
-   No se envía al servidor automáticamente

### Cuándo usarlo

Ideal para datos que deben mantenerse en el tiempo:

-   Tema oscuro / claro\
-   Preferencias de usuario\
-   Idioma seleccionado\
-   Datos no sensibles

### Cuándo NO usarlo

-   Tokens de autenticación sensibles\
-   Contraseñas\
-   Información privada

### Ejemplo en Angular

``` typescript
// Guardar dato
localStorage.setItem('usuario', 'Francisco');

// Obtener dato
const usuario = localStorage.getItem('usuario');

// Borrar dato
localStorage.removeItem('usuario');

// Limpiar todo
localStorage.clear();
```

------------------------------------------------------------------------

## SessionStorage

### ¿Qué es?

Funciona igual que LocalStorage, pero los datos solo viven durante la
sesión del navegador.

Cuando el usuario cierra la pestaña, los datos desaparecen.

### Características

-   Capacidad: \~5 MB\
-   Solo strings\
-   Se elimina al cerrar la pestaña\
-   No se comparte entre pestañas

### Cuándo usarlo

Perfecto para información temporal:

-   Datos de un formulario\
-   Progreso de un asistente\
-   Información de navegación\
-   Filtros temporales

### No usarlo para

-   Datos que deban persistir\
-   Preferencias del usuario

### Ejemplo en Angular

``` typescript
sessionStorage.setItem('pasoFormulario', '2');

const paso = sessionStorage.getItem('pasoFormulario');

sessionStorage.removeItem('pasoFormulario');
```

------------------------------------------------------------------------

## Cookies

### ¿Qué son?

Pequeños archivos que se almacenan en el navegador y se envían
automáticamente al servidor en cada petición HTTP.

Muy usadas para:

-   Autenticación\
-   Seguimiento de sesión\
-   Analítica

### Características

-   Tamaño máximo: 4 KB\
-   Pueden tener fecha de expiración\
-   Se envían al backend\
-   Más vulnerables si no se configuran bien

### Cuándo usarlas

-   Tokens de sesión (especialmente con HttpOnly)\
-   Sistemas de login tradicionales\
-   Recordar usuario

### Evitar para

-   Grandes cantidades de datos\
-   Información no necesaria para el servidor

### Ejemplo en Angular (document.cookie)

``` typescript
// Crear cookie
document.cookie = "usuario=Francisco; max-age=3600; path=/";

// Leer cookies
const cookies = document.cookie;

// Borrar cookie
document.cookie = "usuario=; max-age=0";
```

En Angular suele recomendarse usar librerías como:

    npm install ngx-cookie-service

------------------------------------------------------------------------

## Tabla Comparativa

  Característica         LocalStorage   SessionStorage         Cookies
  ---------------------- -------------- ---------------------- ------------------
  Persistencia           Permanente     Hasta cerrar pestaña   Configurable
  Tamaño                 5-10 MB        \~5 MB                 4 KB
  Se envía al servidor   No             No                     Sí
  Seguridad              Media          Media                  Alta si HttpOnly
  Uso típico             Preferencias   Datos temporales       Autenticación

------------------------------------------------------------------------

## ¿Cuál debo usar en Angular?

Regla rápida:

-   LocalStorage: Preferencias duraderas\
-   SessionStorage: Datos temporales\
-   Cookies: Autenticación / comunicación con backend

------------------------------------------------------------------------

## Buenas prácticas

### Usa siempre JSON

``` typescript
localStorage.setItem('usuario', JSON.stringify(usuario));
const user = JSON.parse(localStorage.getItem('usuario')!);
```

### Centraliza el acceso en un servicio

Muy recomendable en Angular:

``` typescript
@Injectable({ providedIn: 'root' })
export class StorageService {

  setLocal(key:string, value:any){
    localStorage.setItem(key, JSON.stringify(value));
  }

  getLocal(key:string){
    return JSON.parse(localStorage.getItem(key)!);
  }
}
```

Evita acceder directamente desde los componentes.

------------------------------------------------------------------------

## Error muy común

Guardar objetos sin convertirlos:

Incorrecto:

``` typescript
localStorage.setItem('usuario', usuario);
```

Correcto:

``` typescript
localStorage.setItem('usuario', JSON.stringify(usuario));
```

------------------------------------------------------------------------

## Conclusión

-   LocalStorage: Persistencia\
-   SessionStorage: Sesión actual\
-   Cookies: Comunicación con servidor

Elegir bien el tipo de almacenamiento mejora:

-   Seguridad\
-   Rendimiento\
-   Experiencia de usuario
