import { Flyer } from "./Flyer";
    
     
    
    
    export class Bird implements Flyer{
    
     
    
        land(): string {
            return "Bird  lands";;
        }
        takeOff(): string {
            return "Bird  TakeOff";
        }
        fly(): string {
            return "That Bird is flying High Today..";
        }
    
    }
    
     