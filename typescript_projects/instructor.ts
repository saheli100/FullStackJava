// import {​​​​​​ Course }​​​​​​ from "./course";
// class Instructor
// {​​​​​​
//     instructorId:number;
//     instructorName: string;
//     coursesTeach:Course[];
// }

import { Course } from "./course";
class Instructor
{

 

constructor(private _instructorId:number, private _instructorName:string, private _coursesTeach:Course[])
    {
    }

 

public get instructorId():number
    {
        return this._instructorId 
    }
    public get instructorName():string
{
  return this._instructorName
}
public get coursesTeach():Course[]
{
    return this._coursesTeach;
}
}
let myCourse1=new Course(1,"Java",":xyz");
let myCourse2=new Course(2,".net","abc");
let myCourse3=new Course(3,"Node JS","def");
let courses: Course[]=[];
courses.push(myCourse1);
courses.push(myCourse2);
courses.push(myCourse3);

 

let instructor=new Instructor(100,"somebody",courses);
console.log(instructor.instructorId+"\n"+instructor.instructorName);
console.log(" \n Printing the courses student "+instructor.instructorName+" is enrolled for: \n\n");
for(let i=0;i<instructor.coursesTeach.length;i++)
{
  console.log(instructor.coursesTeach[i].getCourseDetails());   
}