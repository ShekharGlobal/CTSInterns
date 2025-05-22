import { Component } from '@angular/core';
@Component({
 selector: 'app-first',
 templateUrl: './first.component.html',
 styleUrls: ['./first.component.css']
 
})
export class firstComponent {
 title = 'Cognizant';

 num:number = 0;

 fruits = ['Apple', 'Banana', 'Cherry', 'Date', 'pomegranate'];


 clickMe(arg1:any,arg2:any){
    if(arg1 === "admin" && arg2 === "admin"){
    alert("Login Success");
    }else{
    alert("Login Fail");
    }
    };
   }