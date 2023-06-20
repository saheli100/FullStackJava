var Customer = /** @class */ (function () {
    function Customer() {
        //properties
        this.firstName = 'Marry';
        this.lastName = 'Public';
    }
    return Customer;
}());
//object of customer class
var myCustomer = new Customer();
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
