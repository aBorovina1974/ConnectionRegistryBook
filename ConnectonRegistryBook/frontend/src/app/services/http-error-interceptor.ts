import { Injectable } from "@angular/core";
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";

@Injectable()
export class HttpErrorInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>,  next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request)
        .pipe(
            catchError((error: HttpErrorResponse) => {
                if(error instanceof ErrorEvent)
                {
                    return throwError('Greška na klijentskoj strani!');                    
                }
                else
                {
                    return throwError(error.error);
                }
            })
        );
    }
}
