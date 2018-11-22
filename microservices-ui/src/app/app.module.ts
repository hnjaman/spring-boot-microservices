import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import{RouterModule, Routes} from '@angular/router';
import{HttpModule} from '@angular/http';
import{HttpClientModule} from '@angular/common/http';
import{FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';

import { ListuserComponent } from './components/listuser/listuser.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { NidlistComponent } from './components/nidlist/nidlist.component';
import { PassportlistComponent } from './components/passportlist/passportlist.component';
import { NidformComponent } from './components/nidform/nidform.component';
import { PassportformComponent } from './components/passportform/passportform.component';
import { MapBoxComponent } from './components/map-box/map-box.component';
import { SmslistComponent } from './components/smslist/smslist.component';

import { UserService } from './shared-service/user.service';
import { MapService } from './shared-service/map.service';
import { SmsService } from './shared-service/sms.service';

const appRoutes:Routes=[
    {path:'', component:ListuserComponent},
    {path:'smslist', component: SmslistComponent},
    {path:'nidlist', component: NidlistComponent},
    {path:'passportlist', component: PassportlistComponent},
    {path:'op', component:UserFormComponent},
    {path:'nid', component:NidformComponent},
    {path:'passport', component:PassportformComponent},
    {path:'map', component:MapBoxComponent}
    
];

@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserFormComponent,
    NidformComponent,
    PassportformComponent,
    NidlistComponent,
    PassportlistComponent,
    MapBoxComponent,
    SmslistComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService,MapService,SmsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
