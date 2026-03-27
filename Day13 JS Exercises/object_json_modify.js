function modify(){
    const user ={name:"John",age:20};
let jsonStr=JSON.stringify(user);
//convert to obj and modify
let temp =JSON.parse(jsonStr);
temp.isAdult=temp.age>=18;
let finalObj=temp;
console.log(finalObj);

}
modify();
