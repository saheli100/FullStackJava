class Customer
{
   private _firstName:string;
   private _lastName:string;
   
   /*public getFirstName():string
   {
     return this.firstName;
   }
   public getLastName():string
   {
    return this.lastName;
   }
   public setFirstNameAndLastName(fName:string,lName:string)
   {
        this.firstName=fName;
        this.lastName=lName;
   }
*/
public get firstName():string
{
    return this._firstName;
}
public get lastName():string
{
    return this._lastName;
}
public set firstName(fname:string)
{
    this._firstName=fname;
}
public set lastName(lName:string)
{
    this._lastName=lName;
}
}
//object of customer class
console.log('constructor calling....');
let myCustomer=new Customer();
myCustomer.firstName="John";
myCustomer.lastName="Doe";
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);