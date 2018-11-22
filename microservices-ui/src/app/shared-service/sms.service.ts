import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { RequestOptions, Http, Headers, Response } from '@angular/http';
import{Observable}   from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

import { Sms } from '../sms';

@Injectable()
export class SmsService {

  private baseUrl:string='http://localhost:8999';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});

  private httpheaders = {headers: new HttpHeaders({'content-type':'application/json'})};
 
  private sms = new Sms();

  constructor(
    private _http:Http,
    private http: HttpClient
  ) { }

  getSms(){
    return this._http.get(this.baseUrl+'/sms',this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
 }

}
