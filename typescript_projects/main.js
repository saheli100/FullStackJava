"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var employee_1 = require("./employee");
var manager_1 = require("./manager");
var supervisor_1 = require("./supervisor");
var employee = new employee_1.Employee("Sachin", "Tendulkar", "sachin@email.com");
console.log(employee.getDetails());
//dynamic method dispatching...
employee = new manager_1.Manager("Sales");
console.log(employee.getDetails());
//refering supervisor object
employee = new supervisor_1.Supervisor("Ranchi");
console.log(employee.getDetails());
