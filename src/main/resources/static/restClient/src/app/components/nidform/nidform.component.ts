import { Component, OnInit } from '@angular/core';
import { Nid } from '../../nid';
import { UserService } from '../../shared-service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nidform',
  templateUrl: './nidform.component.html',
  styleUrls: ['./nidform.component.css']
})
export class NidformComponent implements OnInit {
private nid:Nid;
  constructor(private _userService:UserService,private _rotuer:Router) { }

  ngOnInit() {
    this.nid=this._userService.getter();
  }

  processNidForm(){
    if(this.nid.id==undefined){
       this._userService.createNid(this.nid).subscribe((nid)=>{
         console.log(nid);
         this._rotuer.navigate(['/']);
       },(error)=>{
         console.log(error);
       });
    }else{
       this._userService.updateNid(this.nid).subscribe((nid)=>{
         console.log(nid);
         this._rotuer.navigate(['/']);
       },(error)=>{
         console.log(error);
       });
    }
  }

}
