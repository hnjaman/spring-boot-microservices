"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
var core_1 = require("@angular/core");
var nid_1 = require("../../nid");
var NidformComponent = /** @class */ (function () {
    function NidformComponent(_userService) {
        this._userService = _userService;
        //private nid:Nid; 
        this.nid = new nid_1.Nid();
        this.isNidCreated = false;
        this.nidExist = false;
    }
    NidformComponent.prototype.ngOnInit = function () {
        this.nid = this._userService.getterNid();
    };
    NidformComponent.prototype.createNid = function () {
        var _this = this;
        var usermobile = this.nid.mobile;
        var phoneno = /^01([5-9]{1})([0-9]{8})|013([0-9]{8})$/;
        if (usermobile.length == 0) {
            alert("Mobile number can not be empty");
        }
        else if (usermobile.length != 11) {
            alert("Mobile number will be 11 digit");
        }
        else if (usermobile.match(phoneno)) {
            //alert(usermobile);
        }
        else {
            alert("Not valid number");
        }
        this._userService.createNid(this.nid).subscribe(function (data) {
            console.log(data);
            _this.nid = new nid_1.Nid();
            _this.isNidCreated = true;
            _this.nidExist = false;
            _this.nidError = new nid_1.Nid();
        }, function (error) {
            console.log(error);
            _this.nidError = error.error;
            console.log(error.error);
            _this.isNidCreated = false;
            if (error.status == 409) {
                _this.isNidCreated = false;
                _this.nidExist = true;
            }
        });
    };
    NidformComponent = __decorate([
        core_1.Component({
            selector: 'app-nidform',
            templateUrl: './nidform.component.html',
            styleUrls: ['./nidform.component.css']
        })
    ], NidformComponent);
    return NidformComponent;
}());
exports.NidformComponent = NidformComponent;
