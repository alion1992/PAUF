<a href="https://angular.dev/guide/forms/reactive-forms">Documentación oficial</a>

<p>Los formularios reactivos ofrecen un enfoque basado en modelos para gestionar las entradas de formulario cuyos valores cambian con el tiempo. Vamos a ver cómo crear y actualizar un control de formulario básico, cómo usar varios controles en un grupo, cómo validar valores de formulario y cómo crear formularios dinámicos donde puede agregar o eliminar controles en tiempo de ejecución.</p>

## Para que usarlos

Los formularios reactivos son una forma de crear y gestionar formularios en Angular desde el TypeScript, no desde el HTML.
Toda la lógica del formulario (estructura, validaciones, valores, estados…) vive en el componente, y la vista solo se encarga de mostrarlo.

Las ventajas que nos ofrecen son:

- El formulario es grande o complejo

- Necesitas validaciones avanzadas

- Los datos cambian dinámicamente

- Quieres testear el formulario con facilidad

## Elementos que lo componen

### FormGroup

```ts
this.formulario = new FormGroup({
  nombre: new FormControl(''),
  edad: new FormControl(0)
});
```

### FormArray

```ts
hobbies: new FormArray([])
```

### Validators

Angular trae validadores ya hechos:

- required
- minLength
- maxLength
- email
- pattern

```ts
email: new FormControl('', [Validators.required, Validators.email])
```

```html
<form [formGroup]="formulario">
  <input type="text" formControlName="nombre">
</form>
```

### Estados del formulario

- valid / invalid
- touched / untouched
- dirty / pristine
- errors

```html
@if (formulario.get('nombre')?.invalid && formulario.get('nombre')?.touched) {
  <div>
    El nombre es obligatorio
  </div>
}
```


