class Customer
{​​​​​​
    //properties
    firstName:string;
    lastName:string;
    constructor(theFirst:string,thelast:string)
    {​​​​​​
        console.log('constructor called...');
        this.firstName=theFirst;
        this.lastName=thelast;
    }​​​​​​
}​​​​​​
//object of customer class
console.log('constructor calling....');
let myCustomer=new Customer('ramesh','tendulkar');
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);




