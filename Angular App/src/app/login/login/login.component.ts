import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';
import { Router } from '@angular/router';
import { CookieService } from 'src/app/cookie.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  message : string

  constructor(private loginService : LoginService, private router : Router, private cookieService : CookieService) { }

  ngOnInit(): void {
  }

  login(username, password){
    let data = {
      username : username.value,
      password : password.value
    };
    this.loginService.login(data).subscribe((response : {jwt : string, success : boolean, message : string}) => {
      if(response.success){
        this.cookieService.saveCookie("SESSIONID", response.jwt);
        this.router.navigate(['/portal']);
      }
      else{
        this.message = `*${response.message}`;
      }
    })
  }

}
