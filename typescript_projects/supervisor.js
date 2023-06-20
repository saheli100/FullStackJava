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
exports.Supervisor = void 0;
//import { Employee } from "./Employee";
var employee_1 = require("./employee");
var Supervisor = /** @class */ (function (_super) {
    __extends(Supervisor, _super);
    function Supervisor(_locationName) {
        var _this = _super.call(this, "Marry", "Public", "marry@email.com") || this;
        _this._locationName = _locationName;
        return _this;
    }
    Supervisor.prototype.getDetails = function () {
        return _super.prototype.getDetails.call(this) + " Location Of Supervisor Is: " + this._locationName;
    };
    return Supervisor;
}(employee_1.Employee));
exports.Supervisor = Supervisor;
//import { Employee } from "./employee";
