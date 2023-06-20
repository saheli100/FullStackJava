var a = 0;
var b = 1;
var c = 0;
console.log(a);
console.log(b);
while (c < 20) {
    c = a + b;
    console.log(c);
    a = b;
    b = c;
}
