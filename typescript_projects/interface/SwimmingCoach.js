"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.SwimmingCoach = void 0;
var SwimmingCoach = /** @class */ (function () {
    function SwimmingCoach(_fortuneService) {
        this._fortuneService = _fortuneService;
    }
    SwimmingCoach.prototype.getDailyWorkout = function () {
        return "Practice Back Volley Today...";
    };
    SwimmingCoach.prototype.getDailyFortune = function () {
        return this._fortuneService.getFortune();
    };
    return SwimmingCoach;
}());
exports.SwimmingCoach = SwimmingCoach;
