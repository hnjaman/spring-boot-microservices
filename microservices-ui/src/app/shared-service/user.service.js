"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var http_2 = require("@angular/common/http");
var Observable_1 = require("rxjs/Observable");
require("rxjs/add/operator/map");
require("rxjs/add/operator/catch");
require("rxjs/add/observable/throw");
var user_1 = require("../user");
var nid_1 = require("../nid");
var passport_1 = require("../passport");
var UserService = /** @class */ (function () {
    function UserService(_http, http) {
        this._http = _http;
        this.http = http;
        this.baseUrl = 'http://localhost:8888';
        this.headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        this.options = new http_1.RequestOptions({ headers: this.headers });
        this.httpheaders = { headers: new http_2.HttpHeaders({ 'content-type': 'application/json' }) };
        /** private httpheader = {Headers: new this.httpheader({'Content-Type':'application/json'})}; */
        this.user = new user_1.User();
        this.nid = new nid_1.Nid();
        this.passport = new passport_1.Passport();
    }
    /************************* Nid */
    UserService.prototype.getNids = function () {
        return this._http.get(this.baseUrl + '/nids', this.options).map(function (response) { return response.json(); })["catch"](this.errorHandler);
    };
    UserService.prototype.getNid = function (nid) {
        return this._http.get(this.baseUrl + '/nids/' + nid, this.options).map(function (response) { return response.json(); })["catch"](this.errorHandler);
    };
    UserService.prototype.deleteNid = function (nid) {
        return this._http["delete"](this.baseUrl + '/nids/' + nid, this.options).map(function (response) { return response.json(); })["catch"](this.errorHandler);
    };
    UserService.prototype.updateNid = function (nid) {
        return this._http.put(this.baseUrl + '/nid', JSON.stringify(nid), this.options).map(function (response) { return response.json(); })["catch"](this.errorHandler);
    };
    UserService.prototype.createNid = function (nid) {
        return this.http.post(this.baseUrl + '/nid', nid, this.httpheaders)["catch"](this.errorHandler);
    };
    // createNid(nid:Nid){
    //   return this._http.post(this.baseUrl+'/nid',JSON.stringify(nid), this.options).map((response:Response)=>response.json())
    // .catch(this.errorHandler);
    // }
    // createUser(user){
    //     return this.http.post(this.url,user,this.httpheaders);
    // }
    /*********************************** Passport */
    UserService.prototype.getPassports = function () {
        return this._http.get(this.baseUrl + '/passports', this.options).map(function (response) { return response.json(); })["catch"](this.errorHandler);
    };
    UserService.prototype.getPassport = function (ppid) {
        return this._http.get(this.baseUrl + '/passports/' + ppid, this.options).map(function (response) { return response.json(); })["catch"](this.errorHandler);
    };
    UserService.prototype.deletePassport = function (ppid) {
        return this._http["delete"](this.baseUrl + '/passports/' + ppid, this.options).map(function (response) { return response.json(); })["catch"](this.errorHandler);
    };
    UserService.prototype.updatePassport = function (passport) {
        return this._http.put(this.baseUrl + '/passport', JSON.stringify(passport), this.options).map(function (response) { return response.json(); })["catch"](this.errorHandler);
    };
    UserService.prototype.createPassport = function (passport) {
        return this.http.post(this.baseUrl + '/passport', passport, this.httpheaders)["catch"](this.errorHandler);
    };
    /********************************** Users */
    /**
      getUsers(){
        return this._http.get(this.baseUrl+'/users',this.options).map((response:Response)=>response.json())
          .catch(this.errorHandler);
      }
    
      getUser(id:Number){
        return this._http.get(this.baseUrl+'/user/'+id,this.options).map((response:Response)=>response.json())
          .catch(this.errorHandler);
      }
    
      deleteUser(id:Number){
        return this._http.delete(this.baseUrl+'/user/'+id,this.options).map((response:Response)=>response.json())
          .catch(this.errorHandler);
      }
    
      createUser(user:User){
        return this._http.post(this.baseUrl+'/user',JSON.stringify(user),  this.options).map((response:Response)=>response.json())
          .catch(this.errorHandler);
      }
    
      updateUser(user:User){
        return this._http.put(this.baseUrl+'/user',JSON.stringify(user),  this.options).map((response:Response)=>response.json())
          .catch(this.errorHandler);
      }
    
      **********************************/
    UserService.prototype.errorHandler = function (error) {
        return Observable_1.Observable["throw"](error || "SERVER ERROR");
    };
    // setter(nid:Nid){
    //     this.nid=nid;
    // }
    // getter(){
    //   return this.nid;
    // }
    UserService.prototype.setterNid = function (nid) {
        this.nid = nid;
    };
    UserService.prototype.getterNid = function () {
        return this.nid;
    };
    UserService.prototype.setterPassport = function (passport) {
        this.passport = passport;
    };
    UserService.prototype.getterPassport = function () {
        return this.passport;
    };
    UserService = __decorate([
        core_1.Injectable()
    ], UserService);
    return UserService;
}());
exports.UserService = UserService;
