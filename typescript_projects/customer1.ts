class Customer
{
   private firstName:string;
   private lastName:string;
   
   public getFirstName():string
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
}





//object of customer class
console.log('constructor calling....');
let myCustomer=new Customer();
myCustomer.setFirstNameAndLastName('Sachin','Tendulkar');
console.log(myCustomer.getFirstName());
console.log(myCustomer.getLastName());