import { Injectable, signal } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class BackendStatusService {
  readonly offline = signal(false);

  setOffline() { this.offline.set(true); }
  setOnline() { this.offline.set(false); }
}