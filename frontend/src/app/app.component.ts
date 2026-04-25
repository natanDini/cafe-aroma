import { Component } from '@angular/core';
import {
  IonApp, IonRouterOutlet, IonMenu, IonHeader, IonToolbar,
  IonTitle, IonButtons, IonButton, IonContent, IonList,
  IonItem, IonLabel, IonMenuToggle, IonIcon
} from '@ionic/angular/standalone';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BackendStatusService } from './services/backend-status';
import { OfflineScreenComponent } from './components/offline-screen/offline-screen.component';
import { addIcons } from 'ionicons';
import {
  closeOutline, homeOutline, cafeOutline, mailOutline,
  helpCircleOutline, shieldCheckmarkOutline
} from 'ionicons/icons';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  imports: [
    IonApp, IonRouterOutlet, IonMenu, IonHeader, IonToolbar,
    IonTitle, IonButtons, IonButton, IonContent, IonList,
    IonItem, IonLabel, IonMenuToggle, IonIcon,
    CommonModule, RouterModule, OfflineScreenComponent
  ],
})
export class AppComponent {
  constructor(public statusService: BackendStatusService) {

    statusService.setOffline();
    
    addIcons({
      closeOutline, homeOutline, cafeOutline, mailOutline,
      helpCircleOutline, shieldCheckmarkOutline
    });
  }
}