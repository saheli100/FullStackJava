import {​​​​​​ Coach }​​​​​​ from "./coach";
import {​​​​​​ FortuneService }​​​​​​ from "./FortuneService";
export class SwimmingCoach implements Coach
{​​​​​​
    constructor(private _fortuneService:FortuneService){​​​​​​}​​​​​​
    getDailyWorkout(): string {​​​​​​
        return "Practice Back Volley Today..."
        
    }​​​​​​
    getDailyFortune(): string {​​​​​​
       return this._fortuneService.getFortune();
    }​​​​​​
    
}​​​​​​