import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-create',
  templateUrl: './livro-create.component.html',
  styleUrls: ['./livro-create.component.css']
})
export class LivroCreateComponent implements OnInit {

  idCategoria: String = '';
  titulo = new FormControl('', Validators.minLength(3))
  autor = new FormControl('', Validators.minLength(3))
  texto = new FormControl('', Validators.minLength(10))

  livro: Livro = {
    id: '',
    titulo: '',
    autor: '',
    texto: ''
  }

  constructor(private service: LivroService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.idCategoria = this.route.snapshot.paramMap.get('idCategoria')!;
  }

  create(): void {
    this.service.create(this.livro, this.idCategoria).subscribe((resposta) => {
      this.router.navigate([`categorias/${this.idCategoria}/livros`]);
      this.service.mensagem("Livro criado com sucesso!");
    }, err => {
      this.router.navigate([`categorias/${this.idCategoria}/livros`]);
      this.service.mensagem("Erro ao criar novo livro! Tente mais tarde!");
    });
  }

  cancelar(): void {
    this.router.navigate([`categorias/${this.idCategoria}/livros`]);
  }

  getMessage() {
    if (this.titulo.invalid) {
      return 'O campo titulo deve conter entre 3 e 100 caracteres';
    }

    if (this.autor.invalid) {
      return 'O campo nome do autor deve conter entre 3 e 100 caracteres';
    }

    if (this.texto.invalid) {
      return 'O campo titulo deve conter entre 3 e 200 caracteres';
    }
    return false;
  }

}
