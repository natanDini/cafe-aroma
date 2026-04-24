import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { IonicModule } from '@ionic/angular';
import { addIcons } from 'ionicons';
import {
  menuOutline, closeOutline, homeOutline,
  cafeOutline, mailOutline, helpCircleOutline, shieldCheckmarkOutline
} from 'ionicons/icons';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  standalone: true,
  imports: [IonicModule, RouterModule]
})
export class HeaderComponent {
  constructor() {
    addIcons({ menuOutline, closeOutline, homeOutline, cafeOutline, mailOutline, helpCircleOutline, shieldCheckmarkOutline });
  }
}