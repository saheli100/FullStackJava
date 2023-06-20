

export class Course
{​​​​​​
    constructor(private _courseId:number,private _courseName: string,private _instructorName:string)
    {​​​​​​
    
    }​​​​​​
    public getCourseDetails():string
    {​​​​​​
        return "Course Id: "+this._courseId+" Course Name: "+this._courseName+" Instructor Name: "+this._instructorName
    }​​​​​​
    
}​​​​​​





