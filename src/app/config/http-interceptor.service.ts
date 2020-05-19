import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CookieService } from 'src/app/cookie.service';
import { map, tap } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable()
export class CustomInterceptor implements HttpInterceptor {

constructor(private cookieService : CookieService,
            private router : Router) { }


intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const copiedReq = request.clone({
        withCredentials: true,
        setHeaders: {
            'Content-Type' : 'application/json; charset=utf-8',
            'Accept'       : 'application/json',
            'Authorization': `Bearer ${this.cookieService.getCookie("SESSIONID")}`,
          },
    });
    if (request.url.split("/").pop() == 'authenticate'){
        return next.handle(request).pipe();
    }

    return next.handle(copiedReq ).pipe(tap(event => {
            if (event instanceof HttpResponse) {
            
                    console.log(" all looks good");
                    // http response status code
                    console.log(event.status);
                }
            }, error => {
                    if(error.status == 403){
                        this.router.navigate(["/"]);
                    }

            }));
    }
}