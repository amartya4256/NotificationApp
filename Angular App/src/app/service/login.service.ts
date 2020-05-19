import { Injectable } from '@angular/core';
import { WebClientService } from './web-client.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private webClientService : WebClientService) { }

  login(loginData : {username : string, password : string}){
    return this.webClientService.auth('authenticate', loginData);
  }
}
