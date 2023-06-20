//import { Employee } from "./Employee";
import { Employee } from "./employee";
export class Supervisor extends Employee
{
   constructor(private _locationName:string)
   {
     super("Marry","Public","marry@email.com");
   }  
   public getDetails(): string {
    return super.getDetails()+" Location Of Supervisor Is: "+this._locationName;
       
   }
}
//import { Employee } from "./employee";
