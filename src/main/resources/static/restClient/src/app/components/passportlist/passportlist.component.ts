import { Component, OnInit } from '@angular/core';
import { Passport } from '../../passport';
import { UserService } from '../../shared-service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-passportlist',
  templateUrl: './passportlist.component.html',
  styleUrls: ['./passportlist.component.css']
})
export class PassportlistComponent implements OnInit {
private passports:Passport[];
  constructor(private _userService:UserService, private _router:Router ) { }

  ngOnInit() {
    this._userService.getPassports().subscribe((passports)=>{
      console.log(passports);
      this.passports=passports;
    },(error)=>{
      console.log(error);
    })
  }

  /********************* Passport actions */

deletePassport(passport){
  this._userService.deletePassport(passport.id).subscribe((data)=>{
    this.passports.splice(this.passports.indexOf(passport),1);
  },(error)=>{
    console.log(error);
  });
}

updatePassport(passport){
  this._userService.setterPassport(passport);
  this._router.navigate(['/passport']);
}

createPassport(){
  let passport = new Passport();
  this._userService.setterPassport(passport);
  this._router.navigate(['/passport'])
}


}
