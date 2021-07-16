const URL = 'http://localhost:8081';
let users = [];

const indexUsers = () => {
    fetch(`${URL}/users`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            users = result;
            renderUsers();
        });
    });
    renderUsers();
};

const renderUsers = () => {
    const display = document.querySelector('#entryDisplay');
    display.innerHTML = '';
    users.forEach((user) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(user.id));
        row.appendChild(createCell(user.username));
        row.appendChild(createCell(user.ability));
        display.appendChild(row);
    });
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const createUser = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const user = {};
    user['username'] = formData.get(user.username);
    user['password'] = formData.get(user.password);
    user['role'] = formData.get(user.role);
    user['ability'] = formData.get(user.ability);

    fetch(`${URL}/users`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then((result) => {
        result.json().then((user) => {
            users.push(user);
            renderUsers();
        });
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const createUserForm = document.querySelector('#createUserForm');
    createUserForm.addEventListener('submit', createEntry);
    indexUsers();
});