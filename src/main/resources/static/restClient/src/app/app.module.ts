import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import{RouterModule, Routes} from '@angular/router';
import{HttpModule} from '@angular/http';
import{FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { ListuserComponent } from './components/listuser/listuser.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import {UserService} from './shared-service/user.service';
import { NidlistComponent } from './components/nidlist/nidlist.component';
import { PassportlistComponent } from './components/passportlist/passportlist.component';
const appRoutes:Routes=[
    {path:'', component:ListuserComponent},
    {path:'op', component:UserFormComponent},
    {path:'nids', component:NidlistComponent},
    {path:'ppids', component:PassportlistComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserFormComponent,
    NidlistComponent,
    PassportlistComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
