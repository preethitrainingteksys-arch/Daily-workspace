/*
class User
{
     name='Preethi';
}
const user1=new User();
console.log(user1.name);
*/
const users=
[
    {"id":1,"name":"A","active": true},
    {"id":2,"name":"B","active":false},
    {"id":3,"name":"C","active":true}

];
console.log(users[0].name);//access the first object 

function countActive(users)//to find how many active users are there
{   return users.filter((users,index)=>{
    return users.active;
//try using for loop
})
}
//users[2].active=false//to change the third object active to true->false
//another exercise change all true->false and all false->true
console.log(countActive(users));
//to toggle all users
function toggleusers(users)
{
    for (let index = 0; index <users.length; index++) {
        users[i].active=!users[i].active;
        
    }
    return users;
}
console.log(users);


const user1=
{
    name:'Preethi',
    age:22,
    address:{
        Housenumber:1378,
        street:'Old Mig',
        pin:502032

    }
}
console.log(user1.name);
console.log(user1.address.pin);
console.log(user1.address);