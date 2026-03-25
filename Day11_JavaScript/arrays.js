/*const callback=(value,index)=>{
    console.log(value,index);
    return value +1;
}
function mapdemo1()
{
    let numbers=[1,2,3,4,5];
    const incremented =numbers.map(callback);
    console.log(incremented);
    console.log(numbers);
    //numbers.map((value,index)=>{
       // console.log(value);
    
}
mapdemo1();*/

function filterdemo()
{
    let numbers=[1,2,3,4,5];
    const incremented = numbers.filter((value)=> value % 2==0);
    console.log(incremented);
    console.log(numbers);
}
filterdemo();

function challenge()
{
    let i=3;
    if(i=3)
    {
        console.log("success",i);
    }
}
challenge();

function printpyramid(numbers)
{
    
    for (let index = numbers; index >0; index--) {
        let rows="";
        
        for (let jindex = 0; jindex < index; jindex++) {
            rows+="*";   
        }
        console.log(rows);
    }

}
printpyramid(5);