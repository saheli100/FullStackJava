class Person
{
   private _firstName:string;
   private _lastName:string;
    private _email:string;
    private _age:number;
    private _isTrue:boolean;

public get firstName():string
{
    return this._firstName;
}
public get lastName():string
{
    return this._lastName;
}
public get email():string
{
    return this._email;
}
public get age():number
{
    return this._age;
}
public get isTrue():boolean
{
    return this._isTrue;
}
public set firstName(fname:string)
{
    this._firstName=fname;
}
public set lastName(lName:string)
{
    this._lastName=lName;
}
public set email(email:string)
{
    this._email=email;
}
public set age(age:number)
{
    this._age=age;
}
public set isTrue(isTrue:boolean)
{
    this._isTrue=isTrue;
}
}
//object of customer class
console.log('constructor calling....');
let myPerson=new Person();
myPerson.firstName="John";
myPerson.lastName="Doe";
myPerson.email="john@gmail.com";
myPerson.age=22;
myPerson.isTrue=true;
console.log(myPerson.firstName);
console.log(myPerson.lastName);
console.log(myPerson.email);
console.log(myPerson.age);
console.log(myPerson.isTrue);