import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { Observable } from 'rxjs';
import { Api } from '../../services/api';
import { Faq } from '../../interfaces/api.models';
import { HeaderComponent } from '../../components/layout/header/header.component';
import { FooterComponent } from '../../components/layout/footer/footer.component';
import { addIcons } from 'ionicons';
import { chevronDownOutline, chevronUpOutline } from 'ionicons/icons';

@Component({
  selector: 'app-faq',
  templateUrl: './faq.page.html',
  styleUrls: ['./faq.page.scss'],
  standalone: true,
  imports: [IonicModule, CommonModule, HeaderComponent, FooterComponent]
})
export class FaqPage implements OnInit {
  faqs$!: Observable<Faq[]>;
  aberta: number | null = null;

  constructor(private apiService: Api) {
    addIcons({ chevronDownOutline, chevronUpOutline });
  }

  ngOnInit() {
    this.faqs$ = this.apiService.getFaqs();
  }

  toggle(id: number) {
    this.aberta = this.aberta === id ? null : id;
  }

  isAberta(id: number): boolean {
    return this.aberta === id;
  }
}