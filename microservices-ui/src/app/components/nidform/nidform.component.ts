import { Component, OnInit } from '@angular/core';
import { Nid } from '../../nid';
import { UserService } from '../../shared-service/user.service';
import { Router } from '@angular/router';
import { error } from 'util';

@Component({
  selector: 'app-nidform',
  templateUrl: './nidform.component.html',
  styleUrls: ['./nidform.component.css']
})
export class NidformComponent implements OnInit {

  //private nid:Nid; 

  private nid = new Nid();

  private nidError:Nid;
  private isNidCreated:boolean=false;
  private nidExist:boolean=false;
  

  constructor(
    private _userService:UserService,
   // private _rotuer:Router
  ) { }

  ngOnInit() {
    this.nid=this._userService.getterNid();
  }


  createNid(){

        var usermobile = this.nid.mobile;
	      var phoneno = /^01([5-9]{1})([0-9]{8})|013([0-9]{8})$/;
	     
	      if(usermobile.length == 0){
	     	  alert("Mobile number can not be empty");
	      }else if(usermobile.length != 11){
	     	  alert("Mobile number will be 11 digit");
	      }else if(usermobile.match(phoneno)) {
		  	  //alert(usermobile);
		    }else {
		      alert("Not valid number");
		    }

    this._userService.createNid(this.nid).subscribe(
      data=>{
        console.log(data);
        this.nid=new Nid();
        this.isNidCreated=true;
        this.nidExist=false;
        this.nidError= new Nid();
      },
      error=>{
        console.log(error);
        this.nidError=error.error;
        console.log(error.error);
        this.isNidCreated=false;
        if(error.status==409){
          this.isNidCreated=false;
          this.nidExist=true;
        }
      }
    )
  }
  
  /** 
    processNidForm(){
      if(this.nid.nid==undefined){
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
          //this.updateNid=true;
        },(error)=>{
          console.log(error);
        });
      }
    }
  *******************************/
}
