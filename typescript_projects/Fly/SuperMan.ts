import { Flyer } from "./Flyer";
    
     
    
    export class SuperMan implements Flyer{
        land(): string {
            return "SuperMan lands";
        }
        takeOff(): string {
            return "SuperMan takesOff";
        }
        fly(): string {
            return "SuperMan flys ";
        }
    
    }
    
     
    