import { Injectable } from '@angular/core';
import { WebClientService } from './web-client.service';

@Injectable({
  providedIn: 'root'
})
export class PortalService {

  constructor(private webClient : WebClientService) { }

  getUserList(){
    return this.webClient.getData("user-list");
  }

  createEvent(data){
    return this.webClient.postData("create-event", data);
  }
}
