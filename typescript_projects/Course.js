"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Course = void 0;
var Course = /** @class */ (function () {
    function Course(_courseId, _courseName, _instructorName) {
        this._courseId = _courseId;
        this._courseName = _courseName;
        this._instructorName = _instructorName;
    }
    Course.prototype.getCourseDetails = function () {
        return "Course Id: " + this._courseId + " Course Name: " + this._courseName + " Instructor Name: " + this._instructorName;
    };
    return Course;
}());
exports.Course = Course;
