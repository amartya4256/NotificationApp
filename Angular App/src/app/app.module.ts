import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login/login.component';
import { PortalComponent } from './portal/portal/portal.component';
import { CustomInterceptor } from './config/http-interceptor.service';
import { InjectableRxStompConfig, RxStompService, rxStompServiceFactory } from '@stomp/ng2-stompjs';
import { myRxStompConfig } from './my-rx-stomp.config';
import { HeaderComponent } from './portal/header/header.component';
import { AuthGuard } from './service/authGuard';
import { EventCreatorComponent } from './portal/event-creator/event-creator.component';
import { JwtHelper } from 'angular2-jwt';
import { Http, Request, RequestOptions, RequestOptionsArgs, Response } from '@angular/http';
import { LoginAuthGuard } from './service/loginGuard';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PortalComponent,
    HeaderComponent,
    EventCreatorComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    LoginAuthGuard,
    JwtHelper,
    AuthGuard,
    {
      provide : HTTP_INTERCEPTORS,
      useClass : CustomInterceptor,
      multi : true
    },
    {
      provide: InjectableRxStompConfig,
      useValue: myRxStompConfig
    },
    {
      provide: RxStompService,
      useFactory: rxStompServiceFactory,
      deps: [InjectableRxStompConfig]
    }
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
