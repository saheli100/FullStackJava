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
exports.MySwimCoach = void 0;
//import { MyCoach } from "./MyCoach" ;
var MySwimmingCoach_1 = require("./MySwimmingCoach");
var MySwimCoach = /** @class */ (function (_super) {
    __extends(MySwimCoach, _super);
    function MySwimCoach() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    MySwimCoach.prototype.getDailyWorkout = function () {
        return "Practice Spin Bowling today..!";
    };
    MySwimCoach.prototype.a = function () {
        console.log("hello from function a()");
    };
    return MySwimCoach;
}(MySwimmingCoach_1.MySwimmingCoach));
exports.MySwimCoach = MySwimCoach;
