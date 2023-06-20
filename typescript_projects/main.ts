import { Employee } from "./employee";
import { Manager } from "./manager";
import { Supervisor } from "./supervisor";
let employee=new Employee("Sachin","Tendulkar","sachin@email.com");
console.log(employee.getDetails());
//dynamic method dispatching...
employee=new Manager("Sales");
console.log(employee.getDetails());
//refering supervisor object
employee=new Supervisor("Ranchi");
console.log(employee.getDetails());