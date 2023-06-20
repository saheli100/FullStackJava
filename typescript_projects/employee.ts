export class Employee
{
    constructor(private _firstName:string,private _lastName:string,private _email:string)
    {
    }
    public getDetails():string
    {
        return "First Name: "+this._firstName+" Last Name: "+this._lastName+" email: "+this._email;
    }
}
