import { Component, OnInit, Output, Renderer2 } from '@angular/core';
import { NotificationService } from 'src/app/service/notification.service';
import { Router, RouterStateSnapshot } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.sass']
})
export class HeaderComponent implements OnInit {

  constructor(private notificationService : NotificationService,
              private router : Router,
              private renderer : Renderer2) { }

  ngOnInit(): void {
    this.notificationService.isUnread().subscribe((response : {status : boolean}) => {
      if(response.status){
        var img = <HTMLImageElement> document.getElementById("notification-icon");
        img.src = "assets\\notification.png";
      }
    })
  }

  notificationClick(){
    this.notificationService.getNotification().subscribe((response : any) => {
      console.log("emitted");
      var modal : HTMLDivElement = <HTMLDivElement>document.getElementById("modal");
      modal.classList.add("is-active");
      this.addNotification(response);
      console.log(response);
      var img = <HTMLImageElement> document.getElementById("notification-icon");
      img.src = "assets\\no-notification.png";
    })
  }

  clearNotifications(){
    console.log("okay");
    this.notificationService.clearNotifications().subscribe((response : {status : boolean}) => {
      if(response.status==true){
        console.log("cleared"); 
        var allNotification : HTMLDivElement = <HTMLDivElement>document.getElementById("all-notification"); 
        allNotification.innerHTML = "No notification to show.";
      } 
    })
  }

  addNotification(data : any){
    var allNotification : HTMLDivElement = <HTMLDivElement>document.getElementById("all-notification");
    if(data.length == 0){
      allNotification.textContent = "No notification to show.";

    }

    else{
      for(let item of data){
        var notificationDiv : HTMLDivElement = <HTMLDivElement>document.createElement("div");
        notificationDiv.classList.add("notification-item");
        allNotification.appendChild(notificationDiv);
        notificationDiv.textContent = item.message;
      }

      var button : HTMLButtonElement = <HTMLButtonElement> document.createElement("button");
      button.classList.add("button");
      allNotification.appendChild(button);
      button.textContent = "Clear Notification";
      this.renderer.listen(button, 'click', () => {
        this.clearNotifications();
      })
      
    }
  }

  logout(){
    document.cookie = 'SESSIONID=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    this.router.navigate(['/']);
  }
}
