const users=[
    {name:"A",role:"admin",salary:40000},
    {name:"B",role:"users",salary:50990},
    {name:"C",role:"user",salary:8799}
];

function groupBySalary(users)
{
    const grouped=users.reduce((acc,user)=>
{
    if(!acc[user.salary])acc[user.salary]=[];
    acc[user.salary].push(user);
    return acc;
},{});

console.log(grouped); 
}

groupBySalary(users);

//





    