/*function add(a,b)
{
    console.log(arguments);
    let sum=0;
    for (let index = 0; index < arguments.length; index++) {
        sum+=arguments[index];//const elemsnt =arguments[index]//
        //sum+=elemnt;//sum=sum+element;
        
    }
    return sum;
    
}
const result =add(3,4,6,7);
console.log(result);*/
const addAsArrow=(numbers)=>
{
    let sum=0;
    for (let index = 0; index < numbers.length; index++) {
        const element = numbers[index];
        sum=sum+element;
        
    }
    return sum;
}
console.log(addAsArrow([1,2,3]));