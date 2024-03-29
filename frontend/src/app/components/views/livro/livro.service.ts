import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Livro } from './livro.model';

@Injectable({
  providedIn: 'root'
})
export class LivroService {

  baseUrl: String = environment.baseUrl;

  constructor(private http: HttpClient, private _snack: MatSnackBar) { }

  findAllByAllCategoria(idCategoria: String): Observable<Livro[]> {
    const url = `${this.baseUrl}/livros?categoria=${idCategoria}`;
    return this.http.get<Livro[]>(url);
  }

  create(livro: Livro, idCategoria: String): Observable<Livro> {
    const url = `${this.baseUrl}/livros?categoria=${idCategoria}`;
    return this.http.post<Livro>(url, livro);
  }

  findById(idLivro: String): Observable<Livro> {
    const url = `${this.baseUrl}/livros/${idLivro}`;
    return this.http.get<Livro>(url);
  }

  update(livro: Livro): Observable<Livro> {
    const url = `${this.baseUrl}/livros/${livro.id}`;
    return this.http.put<Livro>(url,livro);
  }

  delete(idLivro: String): Observable<void> {
    const url = `${this.baseUrl}/livros/${idLivro}`;
    return this.http.delete<void>(url);
  }

  mensagem(msg: String): void {
    this._snack.open(`${msg}`, 'Ok', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }

}
