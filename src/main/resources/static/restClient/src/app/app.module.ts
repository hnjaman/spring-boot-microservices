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
import { NidformComponent } from './components/nidform/nidform.component';
import { PassportformComponent } from './components/passportform/passportform.component';
const appRoutes:Routes=[
    {path:'', component:ListuserComponent},
    {path:'op', component:UserFormComponent},
    {path:'nid', component:NidformComponent},
    {path:'passport', component:PassportformComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserFormComponent,
    NidformComponent,
    PassportformComponent
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
