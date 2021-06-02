import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoriaService } from '../categoria.service';
import { Categoria } from '../categoria/categoria.model';

@Component({
  selector: 'app-categoria-create',
  templateUrl: './categoria-create.component.html',
  styleUrls: ['./categoria-create.component.css']
})
export class CategoriaCreateComponent implements OnInit {

  categoria : Categoria = {
    nome : '',
    descricao : ''
  }

  constructor(private service: CategoriaService, private router: Router) { }

  ngOnInit(): void {
  }

  create() : void {
    this.service.create(this.categoria).subscribe(resposta => {
      this.service.mensagem("Categoria salva com sucesso");
      this.router.navigate(['categorias'])
    }, ex => {
      for(let i=0; i<ex.error.erros.length; i++) {
        this.service.mensagem(ex.error.erros[i].message);
      }
    })
  }

  cancelar() : void {
    this.router.navigate(['categorias']);
  }

}
