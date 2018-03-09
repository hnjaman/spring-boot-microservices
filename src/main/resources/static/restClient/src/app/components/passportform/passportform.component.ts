import { Component, OnInit } from '@angular/core';
import { Passport } from '../../passport';
import { UserService } from '../../shared-service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-passportform',
  templateUrl: './passportform.component.html',
  styleUrls: ['./passportform.component.css']
})
export class PassportformComponent implements OnInit {
private passport:Passport;

  constructor(private _userService:UserService,private _rotuer:Router) { }

  ngOnInit() {
    this.passport=this._userService.getterPassport();
  }

  processPassportForm(){
    if(this.passport.id==undefined){
       this._userService.createPassport(this.passport).subscribe((passport)=>{
         console.log(passport);
         this._rotuer.navigate(['/']);
       },(error)=>{
         console.log(error);
       });
    }else{
       this._userService.updatePassport(this.passport).subscribe((passport)=>{
         console.log(passport);
         this._rotuer.navigate(['/']);
       },(error)=>{
         console.log(error);
       });
    }
  }

}
