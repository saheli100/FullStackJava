var Customer = /** @class */ (function () {
    function Customer() {
    }
    Object.defineProperty(Customer.prototype, "firstName", {
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
        get: function () {
            return this._firstName;
        },
        set: function (fname) {
            this._firstName = fname;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Customer.prototype, "lastName", {
        get: function () {
            return this._lastName;
        },
        set: function (lName) {
            this._lastName = lName;
        },
        enumerable: false,
        configurable: true
    });
    return Customer;
}());
//object of customer class
console.log('constructor calling....');
var myCustomer = new Customer();
myCustomer.firstName = "John";
myCustomer.lastName = "Doe";
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
