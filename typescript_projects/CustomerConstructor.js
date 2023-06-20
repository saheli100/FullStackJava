var Customer = /** @class */ (function () {
    function Customer(theFirst, thelast) {
        console.log('constructor called...');
        this.firstName = theFirst;
        this.lastName = thelast;
    }
    return Customer;
}());
//object of customer class
console.log('constructor calling....');
var myCustomer = new Customer('ramesh', 'tendulkar');
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
