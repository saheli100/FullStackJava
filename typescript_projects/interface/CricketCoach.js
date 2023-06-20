"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.CricketCoach = void 0;
var CricketCoach = /** @class */ (function () {
    function CricketCoach(_fortuneService) {
        this._fortuneService = _fortuneService;
    }
    CricketCoach.prototype.getDailyFortune = function () {
        return this._fortuneService.getFortune();
    };
    CricketCoach.prototype.getDailyWorkout = function () {
        return "Practice batting today..";
    };
    return CricketCoach;
}());
exports.CricketCoach = CricketCoach;
