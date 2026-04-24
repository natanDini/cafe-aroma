import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { Api } from '../../services/api';
import { Observable } from 'rxjs';
import { Banner, Sobre } from '../../interfaces/api.models';
import { HeaderComponent } from '../../components/layout/header/header.component';
import { FooterComponent } from '../../components/layout/footer/footer.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
  standalone: true,
  imports: [IonicModule, CommonModule, HeaderComponent, FooterComponent, RouterModule]
})
export class HomePage implements OnInit {
  banner$!: Observable<Banner>;
  sobre$!: Observable<Sobre>;

  constructor(private apiService: Api) { }

  ngOnInit() {
    this.banner$ = this.apiService.getBanner();
    this.sobre$ = this.apiService.getSobre();
  }
}