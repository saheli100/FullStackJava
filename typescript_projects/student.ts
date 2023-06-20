import {​​​​​​ Course }​​​​​​ from "./course";
class Student
{​​​​​​
    constructor(private _studentId:number, private _studentFullName:string, private _stream:string, private _courses:Course[])
    {​​​​​​
    }​​​​​​



    public get studentId():number
    {​​​​​​
        return this._studentId ;
    }​​​​​​
    public get studentFullName():string
    {​​​​​​
        return this._studentFullName;
    }​​​​​​
public get stream():string
{​​​​​​
    return this._stream;
}​​​​​​
public get courses():Course[]
{​​​​​​
    return this._courses;
}​​​​​​
}​​​​​​
let myCourse1=new Course(1,"Java",":John");
let myCourse2=new Course(2,".net","Marry");
let myCourse3=new Course(3,"Node JS","Sachin");
let courses: Course[]=[];
courses.push(myCourse1);
courses.push(myCourse2);
courses.push(myCourse3);
let student=new Student(100,"John Doe","Computer Science",courses);
console.log(student.studentId+"\n"+student.studentFullName+"\n"+student.stream);
console.log(" \n Printing the courses student "+student.studentFullName+" is enrolled for: \n\n");
for(let i=0;i<student.courses.length;i++)
{​​​​​​
  console.log(student.courses[i].getCourseDetails());   
}​​​​​​




​​​​​​




