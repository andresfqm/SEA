document.addEventListener("DOMContentLoaded", function() {

	var navbars=document.querySelectorAll('.mostrarNavbars, #ofuscador');
	for (var navbar of navbars) {
	navbar.addEventListener("click",mostrarNavbars);// Inicializando el método mostrarTaskBar()
	}
	function mostrarNavbars(e) {
		e.preventDefault();
		var target=document.querySelector(this.getAttribute("data-target"));
		if(target){
			target.dataset.active=(target.dataset.active==="true")? "false": "true";
		} else{
			var navbars=document.querySelectorAll('.mostrarNavbars');
			for (var navbar of navbars) {
				document.querySelector(navbar.getAttribute("data-target")).dataset.active="false";
			}
		}
		document.querySelector("#ofuscador").classList.toggle("visible");
	}
	/*******************************
	Generador de la taskbar
	*******************************/
	var pestana=document.querySelector("#taskEventos");
	var fecha = document.createElement("div");
	fecha.setAttribute("id", "fechaSistema")
	pestana.appendChild(fecha);
	mostrarFecha();
	for (let i = 0; i < 10; i++) {
		pestana.innerHTML+="<div class='tarea'><div><span>10:00</span><span>Llamar a Prismacolor</span></div><div>Se confirman precios, cliente desea que se le llame</div></div>";
	}
	pestana=document.querySelectorAll('#taskNotificaciones, #taskTareas');
	for (let tab of pestana) {
		for (let i = 0; i < 15; i++) {
			if (tab.innerHTML==="") {
				tab.innerHTML="<a href='#' class='tarea'><div><span>16:38</span><span>Orden de Producción #1254</span></div><div>Se solicita corregir la OP</div></a>";
			} else {
				tab.innerHTML+="<a href='#' class='tarea'><div><span>16:38</span><span>Orden de Producción #1254</span></div><div>Se solicita corregir la OP</div></a>";
			}
		}
	}
	function mostrarFecha() {
		/*******************************
		Fecha en la sección de eventos
		*******************************/
		var meses = ["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"];
		var diasSemana = ["Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"];
		var f=new Date();
		document.querySelector("#fechaSistema").innerHTML=diasSemana[f.getDay()] + ",<br />" + f.getDate() + " de " + meses[f.getMonth()];
	}
});
