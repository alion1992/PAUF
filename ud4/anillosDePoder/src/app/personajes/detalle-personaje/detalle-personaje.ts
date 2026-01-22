import { Component, OnInit } from '@angular/core';
import { PersonajesService } from '../../servicios/personajes-service';

@Component({
  selector: 'app-detalle-personaje',
  imports: [],
  templateUrl: './detalle-personaje.html',
  styleUrl: './detalle-personaje.css',
})
export class DetallePersonaje implements OnInit {

  constructor(private personaService: PersonajesService){}


  ngOnInit(): void {
    
  }
}
