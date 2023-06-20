var Person = /** @class */ (function () {
    function Person() {
    }
    Object.defineProperty(Person.prototype, "firstName", {
        get: function () {
            return this._firstName;
        },
        set: function (fname) {
            this._firstName = fname;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "lastName", {
        get: function () {
            return this._lastName;
        },
        set: function (lName) {
            this._lastName = lName;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "email", {
        get: function () {
            return this._email;
        },
        set: function (email) {
            this._email = email;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "age", {
        get: function () {
            return this._age;
        },
        set: function (age) {
            this._age = age;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "isTrue", {
        get: function () {
            return this._isTrue;
        },
        set: function (isTrue) {
            this._isTrue = isTrue;
        },
        enumerable: false,
        configurable: true
    });
    return Person;
}());
//object of customer class
console.log('constructor calling....');
var myPerson = new Person();
myPerson.firstName = "John";
myPerson.lastName = "Doe";
myPerson.email = "john@gmail.com";
myPerson.age = 22;
myPerson.isTrue = true;
console.log(myPerson.firstName);
console.log(myPerson.lastName);
console.log(myPerson.email);
console.log(myPerson.age);
console.log(myPerson.isTrue);
