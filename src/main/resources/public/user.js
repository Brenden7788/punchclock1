const URL = 'http://localhost:8081';

const loginUser = (user) => {
    fetch(`${URL}/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then((result) => {
        window.localStorage.setItem('auth',result.headers.get("Authorization"));
    });
};

document.addEventListener('click', function(){
    const createLoginForm = document.querySelector('#loginform');
    createLoginForm.addEventListener('submit', loginUser);
});