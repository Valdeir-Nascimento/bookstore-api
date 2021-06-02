import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-read',
  templateUrl: './livro-read.component.html',
  styleUrls: ['./livro-read.component.css']
})
export class LivroReadComponent implements OnInit {

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

  cancelar(): void {
    this.router.navigate([`categorias/${this.idCategoria}/livros`]);
  }

}
