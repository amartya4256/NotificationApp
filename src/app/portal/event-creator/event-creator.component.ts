import { Component, OnInit } from '@angular/core';
import { PortalService } from 'src/app/service/portal.service';

@Component({
  selector: 'app-event-creator',
  templateUrl: './event-creator.component.html',
  styleUrls: ['./event-creator.component.sass']
})
export class EventCreatorComponent implements OnInit {

  message : string
  users : any;
  constructor(private portalService : PortalService) { }

  ngOnInit(): void {
    this.getUserList();
  }

  addUser(selected, target){
    let username = selected.value;
    console.log(username);
    if(!target.value.split(" ").includes(username)){
      target.value+= " " + username;
    }
  }

  getUserList(){
    this.portalService.getUserList().subscribe((response : any) => {
      this.users = response;
      console.log(this.users);
    })
  }

  createEvent(subject, content, type, date, target){
    this.message = "Creating..."
    subject = subject.value;
    content = content.value;
    type = type.value;
    date = date.value;
    target = target.value.split(" ");
    target = target.filter(user => user!="");
    if(target.length == 0){
      this.message = "No recipient included."
      return;
    }
    let data = {
      subject : subject,
      content : content,
      type : type,
      date : date,
      target : target
    }
    this.portalService.createEvent(data).subscribe((response : any) => {
      this.message = response.message;
    })
  }

}
