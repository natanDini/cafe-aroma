import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { Observable, BehaviorSubject, switchMap, of } from 'rxjs';
import { Api } from '../../services/api';
import { Categoria, Produto } from '../../interfaces/api.models';
import { HeaderComponent } from '../../components/layout/header/header.component';
import { FooterComponent } from '../../components/layout/footer/footer.component';
import { addIcons } from 'ionicons';
import { chevronDownOutline, chevronUpOutline } from 'ionicons/icons';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.page.html',
  styleUrls: ['./produtos.page.scss'],
  standalone: true,
  imports: [IonicModule, CommonModule, HeaderComponent, FooterComponent]
})
export class ProdutosPage implements OnInit {
  categorias$!: Observable<Categoria[]>;
  produtosPorCategoria: { [id: number]: Produto[] } = {};
  loadingCategoria: { [id: number]: boolean } = {};
  categoriaSelecionada: number | null = null;

  constructor(private apiService: Api) {
    addIcons({ chevronDownOutline, chevronUpOutline });
  }

  ngOnInit() {
    this.categorias$ = this.apiService.getCategorias();
  }

  toggleCategoria(categoria: Categoria) {

    if (this.categoriaSelecionada === categoria.id) {
      this.categoriaSelecionada = null;
      return;
    }

    this.categoriaSelecionada = categoria.id;

    if (!this.produtosPorCategoria[categoria.id]) {
      this.loadingCategoria[categoria.id] = true;
      this.apiService.getProdutosPorCategoria(categoria.id).subscribe({
        next: (produtos) => {
          this.produtosPorCategoria[categoria.id] = produtos;
          this.loadingCategoria[categoria.id] = false;
        },
        error: () => {
          this.loadingCategoria[categoria.id] = false;
        }
      });
    }
  }

  isAberta(id: number): boolean {
    return this.categoriaSelecionada === id;
  }
}