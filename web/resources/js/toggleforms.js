window.addEventListener("DOMContentLoaded", function () {
	var buttonsToggle=document.querySelectorAll(".toggleSubForm");
	var subForm=document.getElementById('subForm');
	var form;
	for (let i=0; i<buttonsToggle.length; i++) {
		buttonsToggle[i].addEventListener("click", function (e) {
			if(this.nodeName=="A") e.preventDefault();
			if (buttonsToggle[i].getAttribute("href")) {
				form=document.querySelector(buttonsToggle[i].getAttribute("href"));
			}
			if(!form.classList.contains("mostrar")){
				subForm.classList.toggle("mostrar");
				form.classList.toggle("mostrar");
			} else {
				if(form.checkValidity()==true){
					subForm.classList.toggle("mostrar");
					form.classList.toggle("mostrar");
				}
			}
			form.onreset=function () {
				subForm.classList.toggle("mostrar");
				form.classList.toggle("mostrar");
			}
		});
	}
});