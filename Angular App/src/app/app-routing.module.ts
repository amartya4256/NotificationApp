import { NgModule } from '@angular/core';
import { Routes, RouterModule, CanActivate } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { PortalComponent } from './portal/portal/portal.component';
import { AuthGuard } from './service/authGuard';
import { LoginAuthGuard } from './service/loginGuard';


const routes: Routes = [
  {path : '', component : LoginComponent, canActivate : [LoginAuthGuard]},
  {path : 'portal', component : PortalComponent, canActivate: [AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
