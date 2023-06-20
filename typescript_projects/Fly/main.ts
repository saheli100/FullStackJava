
import { Airbus } from "./Airbus";
import { Bird } from "./Bird";
import { Flyer } from "./Flyer";
import { SuperMan } from "./SuperMan";

 


let myFlyer : Flyer[] =[];

 

let flyers :Flyer;

 

flyers = new Bird;
myFlyer.push(flyers);

 


flyers = new SuperMan;
myFlyer.push(flyers);

 

flyers = new Airbus;
myFlyer.push(flyers);

 

for (let tempflyer of myFlyer)
{
    console.log(tempflyer.fly());
    console.log(tempflyer.land());
    console.log(tempflyer.takeOff());
}