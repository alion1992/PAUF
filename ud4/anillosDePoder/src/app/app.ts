import { Component, OnInit, signal } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { PaisesService } from './servicios/paises-service';
import { timeInterval } from 'rxjs';
import { PopupConfirmar } from './modal/popup-confirmar/popup-confirmar';
import { ViewChild } from '@angular/core';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet,ButtonModule,RouterLink, PopupConfirmar],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  protected readonly title = signal('anillosDePoder');

  constructor(private paisService: PaisesService) {}

  paises : any [] = []
  error = ''
  @ViewChild(PopupConfirmar) popup!: PopupConfirmar;

  ngOnInit(): void {
    
    this.cargarPaises()
  }

  confirmDelete = {
    message: 'EY',
    header: 'Eliminar personaje'
  }
  

  cargarPaises () {
    this.paisService.getAllCountries().subscribe({
      next: data => {
        
        this.paises = data;
        console.log(this.paises)
      }, 
        error: err => {
          this.error = ' Se ha producido un error en la peticion'
        }  
    })
  }

  abrirModal(){
    this.confirmDelete = {
    message: '¿Seguro que quieres borrar este personaje?',
    header: 'Eliminar personaje'
    };
    this.popup.confirm2;
  }
  


}
