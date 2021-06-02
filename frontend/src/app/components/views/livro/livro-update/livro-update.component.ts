import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-update',
  templateUrl: './livro-update.component.html',
  styleUrls: ['./livro-update.component.css']
})
export class LivroUpdateComponent implements OnInit {

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
    this.livro.id = this.route.snapshot.paramMap.get('idLivro')!;
    this.findById();
  }

  findById(): void {
    this.service.findById(this.livro.id!).subscribe(resposta => {
      this.livro = resposta;
    });
  }

  update(): void {
    this.service.update(this.livro).subscribe(resposta => {
      this.router.navigate([`categorias/${this.idCategoria}/livros`]);
      this.service.mensagem('Livro atualizado com sucesso');
    }, ex => {
      this.router.navigate([`categorias/${this.idCategoria}/livros`]);
      this.service.mensagem('Não foi possível atualizar livro');
    })
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
