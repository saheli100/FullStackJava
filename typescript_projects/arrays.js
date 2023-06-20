var reviews = [5, 5, 4, 3, 7];
reviews.push(10);
reviews.pop();
//let sum,avg,highest=0;
for (var i = 0; i < reviews.length; i++) {
    console.log(reviews[i]);
    //sum=(reviews[i]+reviews[i+1]);
}
//console.log(avg=sum/5);
var sum = 0;
var avg = 0;
var highest = 0;
for (var i = 0; i < reviews.length; i++) {
    sum += reviews[i];
    avg = sum / reviews.length;
    if (highest <= reviews[i]) {
        highest = reviews[i];
    }
}
console.log("Average " + avg);
console.log("Highest " + highest);
