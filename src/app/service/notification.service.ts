import * as SockJS from 'sockjs-client';
import { Injectable } from '@angular/core';
import { RxStompService } from '@stomp/ng2-stompjs';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { WebClientService } from './web-client.service';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private rxStompService: RxStompService, private webClient : WebClientService) { }

  notificationSubscription;

  startListening(){
    console.log(this.rxStompService.active);
    if(!this.rxStompService.active){
      this.rxStompService.activate();
    }
    this.notificationSubscription = this.rxStompService.watch('/user/queue/feed').subscribe((message) => {
      
      var img = <HTMLImageElement> document.getElementById("notification-icon");
      img.src = "assets\\notification.png";
      
      var mainDiv : HTMLDivElement = <HTMLDivElement>document.getElementById("container");
      // notification.classList.toggle("notification-off");
      
      var notificationContainer : HTMLDivElement = document.createElement("div");
      var cross : HTMLButtonElement = document.createElement("button");
      var notificationMessage : HTMLParagraphElement = document.createElement("p");
      mainDiv.appendChild(notificationContainer);
      notificationContainer.appendChild(cross);
      notificationContainer.appendChild(notificationMessage);
      notificationMessage.textContent = "You have a new notification...";
      notificationContainer.classList.add("notification", "is-link");
      cross.classList.add("delete");
      cross.onclick = function(){
        notificationContainer.remove();
      }

      setTimeout(() => {
        notificationContainer.remove();
      }, 10000);
    });
  }

  stopListening(){
    this.notificationSubscription.unsubscribe();
    this.rxStompService.deactivate();
  }

  getNotification(){
    return this.webClient.getData("read-notifications");
  }

  isUnread(){
    return this.webClient.getData("is-unread");
  }

  clearNotifications(){
    return this.webClient.getData("clear-notifications");
  }

}
