import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { BackendStatusService } from '../../services/backend-status';
import { IonicModule } from '@ionic/angular';

@Component({
  selector: 'app-offline-screen',
  templateUrl: './offline-screen.component.html',
  styleUrls: ['./offline-screen.component.scss'],
  standalone: true,
  imports: [IonicModule, CommonModule]
})
export class OfflineScreenComponent implements OnInit, OnDestroy {
  tentativa = 0;
  private intervalo: any;

  constructor(
    private http: HttpClient,
    private router: Router,
    private statusService: BackendStatusService
  ) { }

  ngOnInit() {
    this.intervalo = setInterval(() => {
      this.tentativa++;
      this.http.get(`${environment.apiUrl}/faq`, { responseType: 'text' }).subscribe({
        next: () => {
          this.statusService.setOnline();
          this.router.navigate(['/home']);
        },
        error: () => { }
      });
    }, 10000);
  }

  ngOnDestroy() {
    clearInterval(this.intervalo);
  }
}