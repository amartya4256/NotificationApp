import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { JwtHelper } from 'angular2-jwt';

@Injectable()
export class AuthGuard implements CanActivate {
    constructor(
        private router: Router,
        private jwtHelper: JwtHelper
    ) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        let cookies = document.cookie.split("; ");
        for(let cookie of cookies){
            if(cookie.substring(0,9) == "SESSIONID"){
                var expired = this.jwtHelper.isTokenExpired(cookie.substring(10));
                if(expired){
                    this.router.navigate(['/'], { queryParams: { returnUrl: state.url }});
                    return false;
                }
                else{
                    return true;
                }
            }
        }

        // not logged in so redirect to login page with the return url
        
        return false;
    }
}
