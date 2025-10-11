// CONFIG

const username = 'keanu'; // change to match your backend username
const API_BASE = `http://localhost:8080/users/${username}/todos`;

// DOM Elements
const todoForm = document.getElementById('todoForm');
const todoInput = document.getElementById('todoInput');
const todoList = document.getElementById('todoList');

// Helper: fetch wrapper

async function apiFetch(path = '', options = {}) {
    const res = await fetch(`${API_BASE}${path}`, options);
    if (!res.ok) {
        const text = await res.text();
        throw new Error(`${res.status} ${res.statusText} - ${text}`);
    }
    return res.status === 204 ? null : res.json();
}

// READ: Load all todos

async function loadTodos() {
    try {
        const todos = await apiFetch();
        todoList.innerHTML = '';
        todos.forEach(renderTodo);
    } catch (err) {
        console.error('Error loading todos:', err);
        alert('Failed to load todos. Check console.');
    }
}


//Add new todo
todoForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const description = todoInput.value.trim();
    if (!description) return;
    try {
        await apiFetch('', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ description: description, username: username, done: false, targetDate: null })
        });
        todoInput.value = '';
        loadTodos();
    } catch (err) {
        console.error('Error creating todo:', err);
        alert('Failed to create todo. Check console.');
    }
});


//Display each todo
function renderTodo(todo) {
    const li = document.createElement('li');
    li.dataset.id = todo.id;

    const span = document.createElement('span');
    span.textContent = todo.description;

    const actions = document.createElement('div');

    const editBtn = document.createElement('button');
    editBtn.textContent = 'Edit';
    editBtn.dataset.action = 'edit';

    const deleteBtn = document.createElement('button');
    deleteBtn.textContent = 'Delete';
    deleteBtn.dataset.action = 'delete';

    actions.append(editBtn, deleteBtn);
    li.append(span, actions);
    todoList.appendChild(li);
}


//Edit / Delete
todoList.addEventListener('click', async (ev) => {
    const btn = ev.target.closest('button');
    if (!btn) return;

    const li = btn.closest('li');
    const id = li.dataset.id;

    if (btn.dataset.action === 'edit') {
        const current = li.querySelector('span').textContent;
        const updated = prompt('Edit task', current);
        if (!updated || !updated.trim()) return;

        try {
            const todoToUpdate = {
                id: id,
                username: username,
                description: updated.trim(),
                done: false,
                targetDate: null
            };

            await fetch(`${API_BASE}/${id}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(todoToUpdate)
            });

            loadTodos();
        } catch (err) {
            console.error('Error updating todo:', err);
            alert('Failed to update todo. Check console.');
        }
    } else if (btn.dataset.action === 'delete') {
        if (!confirm('Delete this task?')) return;

        try {
            await fetch(`${API_BASE}/${id}`, { method: 'DELETE' });
            loadTodos();
        } catch (err) {
            console.error('Error deleting todo:', err);
            alert('Failed to delete todo. Check console.');
        }
    }
});

loadTodos();
