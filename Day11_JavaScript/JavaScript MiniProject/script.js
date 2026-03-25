
let tasks=[];
window.onload=function()
{
    let saved=localStorage.getItem("tasks");
    if(saved)
    {
        tasks=JSON.parse(saved);
        renderTasks();
    }
}
function addTask()
{
    let input=document.getElementById("taskInput");
    let taskText=input.value;
    if(taskText==="")return ;
    tasks.push(taskText);
    input.value="";
    renderTasks();

}
function tenderTasks()
{
    let list=document.getElementById("taskList");
    list.innerHTML="";
    for(let index=0;index<tasks.length;index++)
    {
        let li=document.createElement("li");
        li.innerHTML=
                    ${tasks[i]}
                    <button onclick="deleteTask(${i}">

                    </button>;
                    list.appendChild(li);
    }
}
function deleteTask(index)
{
    tasks.splice(index,1);
    renderTasks();
}
function toggleComplete(event)
{
    event.target.classList.toggle("completed");
}
li.onclick=toggleComplete;
localStorage.setItem("tasks",JSON.stringify(tasks));
let saved =localStorage.getItem("tasks");
if(saved)
{
    tasks=JSON.parse(saved);
    renderTasks();
}



