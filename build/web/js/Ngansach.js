const x = document.getElementById('screen_info');
const y = document.getElementById('info');
 x.addEventListener('click',() => {
      x.classList.add('screen_info_off');  
      y.classList.add('info_off');
 })