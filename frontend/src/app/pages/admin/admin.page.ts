import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { Observable } from 'rxjs';
import { Api } from '../../services/api';
import { Contato } from '../../interfaces/api.models';
import { HeaderComponent } from '../../components/layout/header/header.component';
import { FooterComponent } from '../../components/layout/footer/footer.component';
import { addIcons } from 'ionicons';
import {
  mailOutline, personOutline, timeOutline,
  chatbubbleOutline, checkmarkCircleOutline,
  helpCircleOutline
} from 'ionicons/icons';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.page.html',
  styleUrls: ['./admin.page.scss'],
  standalone: true,
  imports: [IonicModule, CommonModule, ReactiveFormsModule, HeaderComponent, FooterComponent]
})
export class AdminPage implements OnInit {
  contatos$!: Observable<Contato[]>;
  faqForm: FormGroup;

  enviando = false;
  enviado = false;
  erro = false;

  constructor(private apiService: Api, private fb: FormBuilder) {
    addIcons({ mailOutline, personOutline, timeOutline, chatbubbleOutline, checkmarkCircleOutline, helpCircleOutline });

    this.faqForm = this.fb.group({
      pergunta: ['', [Validators.required, Validators.minLength(5)]],
      resposta: ['', [Validators.required, Validators.minLength(5)]]
    });
  }

  ngOnInit() {
    this.contatos$ = this.apiService.getContatos();
  }

  get pergunta() { return this.faqForm.get('pergunta')!; }
  get resposta() { return this.faqForm.get('resposta')!; }

  formatarData(data: string): string {
    return new Date(data).toLocaleString('pt-BR', {
      day: '2-digit', month: '2-digit', year: 'numeric',
      hour: '2-digit', minute: '2-digit'
    });
  }

  salvarFaq() {
    if (this.faqForm.invalid) {
      this.faqForm.markAllAsTouched();
      return;
    }

    this.enviando = true;
    this.erro = false;

    this.apiService.criarFaq(this.faqForm.value).subscribe({
      next: () => {
        this.enviando = false;
        this.enviado = true;
        this.faqForm.reset();
        setTimeout(() => this.enviado = false, 4000);
      },
      error: () => {
        this.enviando = false;
        this.erro = true;
      }
    });
  }
}