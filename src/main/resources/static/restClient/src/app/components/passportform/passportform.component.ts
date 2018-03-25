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

 // private passport:Passport;

  private passport = new Passport();
  private passportError: Passport;
  private isPassCreated: boolean=false;
  private passportExist: boolean=false;

  constructor(
    private _userService:UserService,
    private _rotuer:Router
  ) { }

  ngOnInit() {
    this.passport=this._userService.getterPassport();
  }

  createPassport(){
    this._userService.createPassport(this.passport).subscribe(
      data=>{
        console.log(data);
        this.passport=new Passport();
        this.isPassCreated=true;
        this.passportExist=false;
        this.passportError= new Passport();
      },
      error=>{
        this.passportError=error.error;
        this.isPassCreated=false;
        if(error.status==409){
          this.isPassCreated=false;
          this.passportExist=true;
        }
        console.log(error);
      }
    )
  }

  processPassportForm(){
    if(this.passport.ppid==undefined){
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
