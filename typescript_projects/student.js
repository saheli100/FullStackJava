"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var course_1 = require("./course");
var Student = /** @class */ (function () {
    function Student(_studentId, _studentFullName, _stream, _courses) {
        this._studentId = _studentId;
        this._studentFullName = _studentFullName;
        this._stream = _stream;
        this._courses = _courses;
    }
    Object.defineProperty(Student.prototype, "studentId", {
        get: function () {
            return this._studentId;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Student.prototype, "studentFullName", {
        get: function () {
            return this._studentFullName;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Student.prototype, "stream", {
        get: function () {
            return this._stream;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Student.prototype, "courses", {
        get: function () {
            return this._courses;
        },
        enumerable: false,
        configurable: true
    });
    return Student;
}());
var myCourse1 = new course_1.Course(1, "Java", ":John");
var myCourse2 = new course_1.Course(2, ".net", "Marry");
var myCourse3 = new course_1.Course(3, "Node JS", "Sachin");
var courses = [];
courses.push(myCourse1);
courses.push(myCourse2);
courses.push(myCourse3);
var student = new Student(100, "John Doe", "Computer Science", courses);
console.log(student.studentId + "\n" + student.studentFullName + "\n" + student.stream);
console.log(" \n Printing the courses student " + student.studentFullName + " is enrolled for: \n\n");
for (var i = 0; i < student.courses.length; i++) {
    console.log(student.courses[i].getCourseDetails());
}
