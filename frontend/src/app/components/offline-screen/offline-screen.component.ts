import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { BackendStatusService } from '../../services/backend-status';
import { IonicModule } from '@ionic/angular';
import { timeout } from 'rxjs/operators';

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
    window.addEventListener('online', () => this.tentarReconectar());

    this.intervalo = setInterval(() => {
      this.tentarReconectar();
    }, 10000);
  }

  tentarReconectar() {
    this.tentativa++;
    this.http.get(`${environment.apiUrl}/faq`, { responseType: 'text' }).pipe(
      timeout(8000)
    ).subscribe({
      next: () => {
        this.statusService.setOnline();
        this.router.navigate(['/home']);
      },
      error: () => { }
    });
  }

  ngOnDestroy() {
    clearInterval(this.intervalo);
    window.removeEventListener('online', () => this.tentarReconectar());
  }
}