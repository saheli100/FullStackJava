//import { MyCoach } from "./MyCoach" ;
import { MyCoach } from "./MyCoach";
export class MyCricketCoach extends MyCoach
{
    public getDailyWorkout(): string {
        return "Practice Spin Bowling today..!";
    }
    public a(): void {
        console.log("hello from function a()");
    }
   
}
