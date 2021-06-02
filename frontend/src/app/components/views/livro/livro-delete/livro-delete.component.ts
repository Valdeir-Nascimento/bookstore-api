import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-delete',
  templateUrl: './livro-delete.component.html',
  styleUrls: ['./livro-delete.component.css']
})
export class LivroDeleteComponent implements OnInit {

  idCategoria: String = '';

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

  delete(): void {
    this.service.delete(this.livro.id!).subscribe(resposta => {
      this.router.navigate([`categorias/${this.idCategoria}/livros`]);
      this.service.mensagem('Livro removido com sucesso.');
      console.log(resposta);
    }, ex => {
      this.router.navigate([`categorias/${this.idCategoria}/livros`]);
      this.service.mensagem('Não foi possível remover o livro.');
    })
  }

  cancelar(): void {
    this.router.navigate([`categorias/${this.idCategoria}/livros`]);
  }

}
