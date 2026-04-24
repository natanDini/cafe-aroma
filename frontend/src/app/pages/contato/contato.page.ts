import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { Api } from '../../services/api';
import { HeaderComponent } from '../../components/layout/header/header.component';
import { FooterComponent } from '../../components/layout/footer/footer.component';
import { addIcons } from 'ionicons';
import { checkmarkCircleOutline, mailOutline, personOutline, chatbubbleOutline } from 'ionicons/icons';

@Component({
  selector: 'app-contato',
  templateUrl: './contato.page.html',
  styleUrls: ['./contato.page.scss'],
  standalone: true,
  imports: [IonicModule, CommonModule, ReactiveFormsModule, HeaderComponent, FooterComponent]
})
export class ContatoPage {
  form: FormGroup;
  enviando = false;
  enviado = false;
  erro = false;

  constructor(private fb: FormBuilder, private apiService: Api) {
    addIcons({ checkmarkCircleOutline, mailOutline, personOutline, chatbubbleOutline });

    this.form = this.fb.group({
      nome: ['', [Validators.required, Validators.minLength(2)]],
      email: ['', [Validators.required, Validators.email]],
      mensagem: ['', [Validators.required, Validators.minLength(10)]]
    });
  }

  get nome() { return this.form.get('nome')!; }
  get email() { return this.form.get('email')!; }
  get mensagem() { return this.form.get('mensagem')!; }

  enviar() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    this.enviando = true;
    this.erro = false;

    this.apiService.enviarContato(this.form.value).subscribe({
      next: () => {
        this.enviando = false;
        this.enviado = true;
        this.form.reset();
      },
      error: () => {
        this.enviando = false;
        this.erro = true;
      }
    });
  }

  novoContato() {
    this.enviado = false;
    this.erro = false;
  }
}