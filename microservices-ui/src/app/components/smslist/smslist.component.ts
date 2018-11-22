import { Component, OnInit } from '@angular/core';
import { Sms } from '../../sms';
import { SmsService } from '../../shared-service/sms.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-smslist',
  templateUrl: './smslist.component.html',
  styleUrls: ['./smslist.component.css']
})
export class SmslistComponent implements OnInit {
  private sms:Sms[];
  constructor(private smsService:SmsService, private _router:Router) { }

  ngOnInit() {
    this.smsService.getSms().subscribe((sms)=>{
      console.log(sms);
      this.sms=sms;
    },(error)=>{
      console.log(error);
    })
  }
}
