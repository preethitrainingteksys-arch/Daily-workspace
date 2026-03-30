let todos = JSON.parse(localStorage.getItem('todos')) || [];
const errorDiv=document.getElementById('error');


function addTodo() {
    const input = document.getElementById('todo-input');
    const text = input.value.trim();
    const time = document.getElementById('time-input').value;

    const priority = document.getElementById('priority').value;

    if (text === '') return;

    todos.push({
        text,
        time,
        priority,
        completed: false
    });

    input.value = '';
    saveTodos();
    renderTodos();
}
function sortTodo() {
    todos.sort((e1, e2) => {
        return e1.text.localeCompare(e2.text);
    })
    console.log(todos);
    renderTodos();
}




function saveTodos() {
    localStorage.setItem('todos', JSON.stringify(todos));
}

function deleteTodo(index) {
    todos.splice(index, 1);
    saveTodos();
    renderTodos();
}
function validate(event) { 
    errorDiv.style.display = (event.target.value.trim() !== '') ? 'none' : 'inline';
}


function toggleComplete(index) {
    todos[index].completed = !todos[index].completed;
    saveTodos();
    renderTodos();
}
function editTodo(index) {
    const newText = prompt("Edit your task:", todos[index].text);

    if (newText !== null && newText.trim() !== "") {
        todos[index].text = newText.trim();
        saveTodos();
        renderTodos();
    }
}


function renderTodos() {
    const highList = document.getElementById('high-list');
    const mediumList = document.getElementById('medium-list');
    const lowList=document.getElementById('low-list');

   highList.innerHTML="";
  mediumList.innerHTML="";
  lowList.innerHTML=""
;
    todos.forEach((todo, index) => {
        const li = document.createElement('li');

        if (todo.completed) li.classList.add('completed');

        li.innerHTML = `
        <div class="task-left">
            <span class="task-text">${todo.text}</span>
            <span class="task-time">${todo.time || ""}</span>
        </div>

        <div>
            <button class="YES" onclick="toggleComplete(${index})">✔</button>
            <button class="NO" onclick="deleteTodo(${index})">✖</button>
            <button onclick="editTodo(${index})">EditTask</button>
        </div>
        `;

        if (todo.priority === "high") {
            li.style.borderLeft = "5px solid red";
            highList.appendChild(li);
        } else if(todo.priority==="medium") {
            li.style.borderLeft = "5px solid orange";
            mediumList.appendChild(li);
        }
            else{
                li.style.borderLeft="5px solid green";
                lowList.appendChild(li);

            }
        
    });
}


renderTodos();