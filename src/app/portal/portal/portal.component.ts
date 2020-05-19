import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NotificationService } from 'src/app/service/notification.service';

@Component({
  selector: 'app-portal',
  templateUrl: './portal.component.html',
  styleUrls: ['./portal.component.sass'],
  encapsulation: ViewEncapsulation.None,
})
export class PortalComponent implements OnInit {

  data : any;
  constructor(private notificationService : NotificationService) { }

  ngOnInit(): void {
    this.notificationService.startListening();
  }

  ngOnDestroy(): void {
    this.notificationService.stopListening();
  }

  closeModal(){
    var allNotification : HTMLDivElement = <HTMLDivElement>document.getElementById("all-notification");
    allNotification.innerHTML = '';
    allNotification.parentElement.parentElement.classList.remove("is-active");
  }

  getChildData($event){
    this.data = $event;
  }
  

}
