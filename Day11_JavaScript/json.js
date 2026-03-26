const json=`[
    {"id":1,"name":"A","active": true},
    {"id":2,"name":"B","active":false},
    {"id":3,"name":"C","active":true}
]`;
const employee={
    name:"Ram",
    salary:50000,
    skills:[{level:10,name:'Java'},
        {level:5,name:'JavaScript'}
    ]
}
console.log(employee.skills[2])

const users=JSON.parse(json);
console.log(users[0]);