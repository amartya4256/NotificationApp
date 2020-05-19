import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CookieService {

  constructor() { }

  saveCookie(name : string, cookie : string){
    document.cookie = `${name}=${cookie}`;
  }

  getCookie(name : string){
    let cookies : string[] = document.cookie.split("; ");
    for(let cookie of cookies){
      if(cookie.startsWith(name)){
        return cookie.substring(name.length+1);
      }
    }
  }
}
