const URL = 'http://localhost:8081';
let users = [];

const loginUser = (appUser) => {
    fetch(`${URL}/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(appUser)
    }).then((result) => {
        window.localStorage.setItem('auth',result.headers.get("Authorization"));
    });
};

document.addEventListener('click', function(){
    const createLoginForm = document.querySelector('#loginform');
    createLoginForm.addEventListener('submit', loginUser);
});