import { HttpInterceptorFn, HttpRequest, HttpHandlerFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { BackendStatusService } from '../services/backend-status';

export const backendStatusInterceptor: HttpInterceptorFn = (req: HttpRequest<unknown>, next: HttpHandlerFn) => {
  const statusService = inject(BackendStatusService);

  return next(req).pipe(
    catchError((error) => {
      if (error.status === 0 || error.status === 503 || error.status === 504) {
        statusService.setOffline();
      }
      return throwError(() => error);
    })
  );
}