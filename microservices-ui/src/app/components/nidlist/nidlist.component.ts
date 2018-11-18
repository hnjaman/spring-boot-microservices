import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared-service/user.service';
import { Router } from '@angular/router';
import { Nid } from '../../nid';

@Component({
  selector: 'app-nidlist',
  templateUrl: './nidlist.component.html',
  styleUrls: ['./nidlist.component.css']
})
export class NidlistComponent implements OnInit {
private nids:Nid[];
  constructor(private _userService:UserService, private _router:Router) { }

  ngOnInit() {
    this._userService.getNids().subscribe((nids)=>{
      console.log(nids);
      this.nids=nids;
    },(error)=>{
      console.log(error);
    })
  }

  
/** Nid actions */


deleteNid(nid){
  this._userService.deleteNid(nid.id).subscribe((data)=>{
    this.nids.splice(this.nids.indexOf(nid),1);
  },(error)=>{
    console.log(error);
  });
}

updateNid(nid){
  this._userService.setterNid(nid);
  this._router.navigate(['/nid']);
}

createNid(){
  let nid = new Nid();
  this._userService.setterNid(nid);
  this._router.navigate(['/nid']);
}


}
