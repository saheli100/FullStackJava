import {​​​​​​ FortuneService }​​​​​​ from "./FortuneService";
export class SadFortuneService implements FortuneService
{​​​​​​
    getFortune(): string {​​​​​​
        return "today is your bad day";
    }​​​​​​
    
}