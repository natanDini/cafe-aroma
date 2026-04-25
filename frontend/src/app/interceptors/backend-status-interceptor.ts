import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { catchError, throwError, timeout, TimeoutError } from 'rxjs';
import { BackendStatusService } from '../services/backend-status';

export const backendStatusInterceptor: HttpInterceptorFn = (req, next) => {
  const statusService = inject(BackendStatusService);

  return next(req).pipe(
    timeout(15000),
    catchError((error) => {
      console.log('[Interceptor] Erro capturado:', error.status, error.name, error.message);

      const isOffline =
        error instanceof TimeoutError ||
        error.name === 'TimeoutError' ||
        error.status === 0 ||
        error.status === 503 ||
        error.status === 504 ||
        error.status === 502 ||
        error.ok === false;

      if (isOffline) {
        console.log('[Interceptor] Backend offline — ativando tela de espera');
        statusService.setOffline();
      }

      return throwError(() => error);
    })
  );
};