import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../src/environments/environment';
import { Banner, Sobre, Categoria, Produto, Faq, Contato } from '../interfaces/api.models';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class Api {

  private readonly URL = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getBanner(): Observable<Banner> {
    return this.http.get<Banner>(`${this.URL}/banner`);
  }

  getSobre(): Observable<Sobre> {
    return this.http.get<Sobre>(`${this.URL}/sobre`);
  }

  getCategorias(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(`${this.URL}/categoria`);
  }

  getProdutosPorCategoria(categoriaId: number): Observable<Produto[]> {
    return this.http.get<Produto[]>(`${this.URL}/produto/${categoriaId}`);
  }

  enviarContato(dados: { nome: string; email: string; mensagem: string }): Observable<any> {
    return this.http.post(`${this.URL}/contato`, dados, { responseType: 'text' });
  }

  getFaqs(): Observable<Faq[]> {
    return this.http.get<Faq[]>(`${this.URL}/faq`);
  }

  getContatos(): Observable<Contato[]> {
    return this.http.get<Contato[]>(`${this.URL}/contato`);
  }

  criarFaq(dados: { pergunta: string; resposta: string }): Observable<any> {
    return this.http.post(`${this.URL}/faq`, dados, { responseType: 'text' });
  }
}