const wrapper = document.querySelector('.wrapper');
const ContinueLink = document.querySelector('.continue-link');

ContinueLink.addEventListener('click', ()=>{
  wrapper.classList.remove('active');
});