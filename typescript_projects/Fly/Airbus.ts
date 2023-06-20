import { Flyer } from "./Flyer";
    
     
    
    export class Airbus implements Flyer{
        land(): string {
            return "Flight lands at scheduled time";
        }
        takeOff(): string {
            return "Flight takesOff";
        }
        fly(): string {
            return "Flight flys at high altitude    ";
        }
    
    }
    