var Customer = /** @class */ (function () {
    function Customer() {
    }
    Customer.prototype.getFirstName = function () {
        return this.firstName;
    };
    Customer.prototype.getLastName = function () {
        return this.lastName;
    };
    Customer.prototype.setFirstNameAndLastName = function (fName, lName) {
        this.firstName = fName;
        this.lastName = lName;
    };
    return Customer;
}());
//object of customer class
console.log('constructor calling....');
var myCustomer = new Customer();
myCustomer.setFirstNameAndLastName('Sachin', 'Tendulkar');
console.log(myCustomer.getFirstName());
console.log(myCustomer.getLastName());
