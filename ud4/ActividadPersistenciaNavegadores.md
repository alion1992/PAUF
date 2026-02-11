## Actividad Persistencia Navegadores

Nuestro equipo de backend nos ha proporcionado un servicio para obtener los portadores del anillo, en el se muestran tanto los portadores actuales, como un histórico de portadores:

```java
@GetMapping("/api/listaPortadores")
    public List<PortadorAnilloDTO> listar() {
        return portadoresService.findAll();
    }
```

Queremos hacer uso del localstorage para evitar que una misma llamada se realice en multitud de ocasiones sobrecargando el componente front es por ello que cachearemos la respuesta para que solo sea llamado una vez el servicio.

El objetivo es mostrar en una tabla de https://primeng.org/table los resultados de los portadores (resultado esperado):

<img width="1264" height="402" alt="image" src="https://github.com/user-attachments/assets/5ed70dcf-cedb-4a67-aea5-0a143dafb824" />

Comprobar que la carga solo se realiza una vez por medio del console log:

<img width="375" height="111" alt="image" src="https://github.com/user-attachments/assets/2d9aa4d2-9efb-4afa-a2e2-697247113db2" />

