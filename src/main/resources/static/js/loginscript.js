const wrapper = document.querySelector('.wrapper');
const loginLink = document.querySelector('.login-link');
const registerLink = document.querySelector('.register-link');
const nextLink = document.querySelector('.next-link');
const loginForm = document.querySelector('.form-box.login');
const registerForm = document.querySelector('.form-box.register');
const nextForm = document.querySelector('.form-box.next');

loginLink.addEventListener('click', () => {
    loginForm.classList.add('active');
    registerForm.classList.remove('active');
    nextForm.classList.remove('active');

    console.log("loginLink");
});

registerLink.addEventListener('click', () => {
    loginForm.classList.remove('active');
    registerForm.classList.add('active');
    nextForm.classList.remove('active');

    const currentForm = document.querySelector('.form-box.next');

    const username = currentForm.querySelector('input[name="username"]').value;
    const email = currentForm.querySelector('input[name="email"]').value;
    const userType = document.getElementById("user-type").value;

    // Log the values to the console to ensure they are correctly retrieved
    console.log("Hello");
    console.log("Username: " + username);
    console.log("Email: " + email);
    console.log("UserType: " + userType);

    // Set the values in the hidden fields of the third form
    const thirdForm = document.querySelector('.form-box.register');
    thirdForm.querySelector('input[name="username"]').value = username;
    thirdForm.querySelector('input[name="email"]').value = email;
    thirdForm.querySelector('input[name="type"]').value = userType;
});

nextLink.addEventListener('click', () => {
    loginForm.classList.remove('active');
    registerForm.classList.remove('active');
    nextForm.classList.add('active');

    console.log("nextLink");
});


function myFunction() {
  document.getElementById("login").style.display = "none";
}

function myFunctionII() {
  document.getElementById("login").style.display = "block";
}

function checkUser() {
  var userTypeSelect = document.getElementById("user-type");
  var serviceTypeDiv = document.getElementById("service-type");
  var askLocation = document.getElementById("ask-location");

  if (userTypeSelect.value === "service-provider") {
    serviceTypeDiv.style.display = "block";
    askLocation.style.display = "block";
    
  } else {
    serviceTypeDiv.style.display = "none";
    askLocation.style.display = "none";
    
  }
}



