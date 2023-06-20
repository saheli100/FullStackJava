//import { MyCoach } from "./MyCoach" ;
import { MySwimmingCoach } from "./MySwimmingCoach";
export class MySwimCoach extends MySwimmingCoach
{
    public getDailyWorkout(): string {
        return "Practice Spin Bowling today..!";
    }
    public a(): void {
        console.log("hello from function a()");
    }
   
}
