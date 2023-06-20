"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
exports.MyCricketCoach = void 0;
//import { MyCoach } from "./MyCoach" ;
var MyCoach_1 = require("./MyCoach");
var MyCricketCoach = /** @class */ (function (_super) {
    __extends(MyCricketCoach, _super);
    function MyCricketCoach() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    MyCricketCoach.prototype.getDailyWorkout = function () {
        return "Practice Spin Bowling today..!";
    };
    MyCricketCoach.prototype.a = function () {
        console.log("hello from function a()");
    };
    return MyCricketCoach;
}(MyCoach_1.MyCoach));
exports.MyCricketCoach = MyCricketCoach;
