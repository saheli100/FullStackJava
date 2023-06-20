import {​​​​​​ Coach }​​​​​​ from "./coach";
import {​​​​​​ FortuneService }​​​​​​ from "./FortuneService";
export class CricketCoach implements Coach
{​​​​​​
    constructor(private _fortuneService:FortuneService)
    {​​​​​​
    }​​​​​​
    getDailyFortune(): string {​​​​​​
       return this._fortuneService.getFortune();
    }​​​​​​
    getDailyWorkout(): string {​​​​​​
        return "Practice batting today.."
    }​​​​​​
    
}​​​​​​
