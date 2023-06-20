//import { Employee } from ".employee";
import { Employee } from "./employee";
export class Manager extends Employee
{
    constructor(private _departmentName:string)
    {
        super("John","Doe","john@email.com");
    }
 
    public getDetails(): string {
        return super.getDetails()+" Department Name: "+ this._departmentName;
       
    }
}
