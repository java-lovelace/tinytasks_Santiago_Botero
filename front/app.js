const API_URL = "http://localhost:8080/api/todos";

const todoList = document.getElementById("todoList");
const form = document.getElementById("todoForm");
const titleInput = document.getElementById("titleInput");

// Cargar tareas al iniciar
document.addEventListener("DOMContentLoaded", loadTodos);

// Enviar formulario
form.addEventListener("submit", async (e) => {
  e.preventDefault();
  const title = titleInput.value.trim();
  if (title.length < 3) {
    alert("Title must be at least 3 characters long");
    return;
  }
  await createTodo(title);
  titleInput.value = "";
});

// ======= FUNCIONES PRINCIPALES =======

async function loadTodos() {
  const res = await fetch(API_URL);
  const todos = await res.json();
  renderTodos(todos);
}

async function createTodo(title) {
  const res = await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title }),
  });
  if (res.ok) {
    loadTodos();
  } else {
    const error = await res.json();
    alert(error.error);
  }
}

async function toggleTodo(id) {
  const res = await fetch(`${API_URL}/${id}/toggle`, { method: "PUT" });
  if (res.ok) loadTodos();
  else alert("Task not found");
}

async function deleteTodo(id) {
  const res = await fetch(`${API_URL}/${id}`, { method: "DELETE" });
  if (res.ok || res.status === 204) loadTodos();
  else alert("Task not found");
}

// ======= RENDER =======
function renderTodos(todos) {
  todoList.innerHTML = "";
  todos.forEach((todo) => {
    const li = document.createElement("li");
    li.className =
      "list-group-item d-flex justify-content-between align-items-center";

    const span = document.createElement("span");
    span.textContent = todo.title;
    if (todo.done) span.style.textDecoration = "line-through";

    const btnGroup = document.createElement("div");

    const toggleBtn = document.createElement("button");
    toggleBtn.textContent = todo.done ? "Undo" : "Done";
    toggleBtn.className = "btn btn-sm btn-outline-success me-2";
    toggleBtn.onclick = () => toggleTodo(todo.id);

    const delBtn = document.createElement("button");
    delBtn.textContent = "Delete";
    delBtn.className = "btn btn-sm btn-outline-danger";
    delBtn.onclick = () => deleteTodo(todo.id);

    btnGroup.append(toggleBtn, delBtn);
    li.append(span, btnGroup);
    todoList.appendChild(li);
  });
}
