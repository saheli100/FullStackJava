"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Employee = void 0;
var Employee = /** @class */ (function () {
    function Employee(_firstName, _lastName, _email) {
        this._firstName = _firstName;
        this._lastName = _lastName;
        this._email = _email;
    }
    Employee.prototype.getDetails = function () {
        return "First Name: " + this._firstName + " Last Name: " + this._lastName + " email: " + this._email;
    };
    return Employee;
}());
exports.Employee = Employee;
