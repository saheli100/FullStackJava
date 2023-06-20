let a = 0; let b = 1;

 

let c = 0;
console.log(a);
console.log(b);
while(c<20){
    c = a+b;
    console.log(c);
    a =b;
    b = c;
}