var Address = /** @class */ (function () {
    function Address(addressLine1, addressLine2, city) {
        this._addressLine1 = addressLine1;
        this._addressLine2 = addressLine2;
        this._city = city;
    }
    Object.defineProperty(Address.prototype, "addressLine1", {
        get: function () {
            return this._addressLine1;
        },
        set: function (line1) {
            this._addressLine1 = line1;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Address.prototype, "addressLine2", {
        get: function () {
            return this._addressLine2;
        },
        set: function (line2) {
            this._addressLine2 = line2;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Address.prototype, "city", {
        get: function () {
            return this._city;
        },
        set: function (c) {
            this._city = c;
        },
        enumerable: false,
        configurable: true
    });
    return Address;
}());
var Customer = /** @class */ (function () {
    function Customer(fName, lName, address) {
        this._firstName = fName;
        this._lastName = lName;
        this._address = address;
    }
    Object.defineProperty(Customer.prototype, "firstName", {
        get: function () {
            return this._firstName;
        },
        set: function (fName) {
            this._firstName = fName;
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
    Object.defineProperty(Customer.prototype, "address", {
        get: function () {
            return this._address;
        },
        set: function (add) {
            this._address = add;
        },
        enumerable: false,
        configurable: true
    });
    return Customer;
}());
var myAddress = new Address("Telengana", "India", "Hyderabad");
var myCustomer = new Customer("Ram", "Kumar", myAddress);
console.log("First Name Is: " + myCustomer.firstName);
console.log("Last Name: " + myCustomer.lastName);
console.log("Address As Follows: \n" + myCustomer.address.addressLine1 + " " + myCustomer.address.addressLine2 + " " + myCustomer.address.city);
