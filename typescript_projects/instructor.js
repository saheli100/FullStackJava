"use strict";
// import {​​​​​​ Course }​​​​​​ from "./course";
// class Instructor
// {​​​​​​
//     instructorId:number;
//     instructorName: string;
//     coursesTeach:Course[];
// }
Object.defineProperty(exports, "__esModule", { value: true });
var course_1 = require("./course");
var Instructor = /** @class */ (function () {
    function Instructor(_instructorId, _instructorName, _coursesTeach) {
        this._instructorId = _instructorId;
        this._instructorName = _instructorName;
        this._coursesTeach = _coursesTeach;
    }
    Object.defineProperty(Instructor.prototype, "instructorId", {
        get: function () {
            return this._instructorId;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Instructor.prototype, "instructorName", {
        get: function () {
            return this._instructorName;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Instructor.prototype, "coursesTeach", {
        get: function () {
            return this._coursesTeach;
        },
        enumerable: false,
        configurable: true
    });
    return Instructor;
}());
var myCourse1 = new course_1.Course(1, "Java", ":xyz");
var myCourse2 = new course_1.Course(2, ".net", "abc");
var myCourse3 = new course_1.Course(3, "Node JS", "def");
var courses = [];
courses.push(myCourse1);
courses.push(myCourse2);
courses.push(myCourse3);
var instructor = new Instructor(100, "somebody", courses);
console.log(instructor.instructorId + "\n" + instructor.instructorName);
console.log(" \n Printing the courses student " + instructor.instructorName + " is enrolled for: \n\n");
for (var i = 0; i < instructor.coursesTeach.length; i++) {
    console.log(instructor.coursesTeach[i].getCourseDetails());
}
