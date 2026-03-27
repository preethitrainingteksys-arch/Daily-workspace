let todos = JSON.parse(localStorage.getItem('todos')) || [];
const errorDiv=document.getElementById('error');


function addTodo() {
    const input = document.getElementById('todo-input');
    const text = input.value.trim();
    const time = document.getElementById('time-input').value;

    const selected = document.querySelector('input[name="priority"]:checked');
    const priority = selected ? selected.value : "important";

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
saveTodos();
renderTodos();



function saveTodos() {
    localStorage.setItem('todos', JSON.stringify(todos));
}

function deleteTodo(index) {
    todos.splice(index, 1);
    saveTodos();
    renderTodos();
}
function validate() { 
    errorDiv.style.display = (event.target.value.trim() !== '') ? 'none' : 'inline';
}


function toggleComplete(index) {
    todos[index].completed = !todos[index].completed;
    saveTodos();
    renderTodos();
}


function renderTodos() {
    const urgentList = document.getElementById('urgent-list');
    const importantList = document.getElementById('important-list');

   urgentList.innerHTML="";
   importantList.innerHTML="";

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
        </div>
        `;

        if (todo.priority === "urgent") {
            li.style.borderLeft = "red";
            urgentList.appendChild(li);
        } else {
            li.style.borderLeft = " orange";
            importantList.appendChild(li);
        }
    });
}


renderTodos();