import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Categoria } from './categoria/categoria.model';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {
  baseUrl: String = environment.baseUrl;

  constructor(private http: HttpClient, private _snack: MatSnackBar) { }

  findAll():Observable<Categoria[]> {
    const url = `${this.baseUrl}/categorias`
    return this.http.get<Categoria[]>(url);
  }

  create(categoria: Categoria) : Observable<Categoria> {
    const url = `${this.baseUrl}/categorias`
    return this.http.post<Categoria>(url, categoria);
  }

  findById(id: String): Observable<Categoria> {
    const url = `${this.baseUrl}/categorias/${id}`
    return this.http.get<Categoria>(url);
  }

  delete(id: String): Observable<void> {
    const url = `${this.baseUrl}/categorias/${id}`
    return this.http.delete<void>(url);
  }

  update(categoria: Categoria): Observable<Categoria> {
    const url = `${this.baseUrl}/categorias/${categoria.id}`;
    return this.http.put<Categoria>(url, categoria);
  }

  mensagem(msg: String) : void {
    this._snack.open(`${msg}`, 'Ok',  {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }



}
