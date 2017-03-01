document.addEventListener("DOMContentLoaded", function () {
	var botonesNotificacion = document.querySelectorAll(".notificacion");
	for (var i = 0; i < botonesNotificacion.length; i++) {
		botonesNotificacion[i].addEventListener("click", pruebaNotificacion)
	}
	function pruebaNotificacion() {
		if (Notification) {
			if (Notification.permission !== "granted") {
				Notification.requestPermission();
			}
			var title = "SEA";
			var cuerpo = {
				icon: "/img/favicon.ico",
				body: "Así se mostrarán las notificaciones durante la ejecución del sistema.\nHaga clic aquí para ir a la sección de reportes"
			}
			var notificacion = new Notification(title, cuerpo)
			notificacion.onclick = function () {
				var win = window.open("/reportes/", '_blank');
				win.focus();
			}
			setTimeout(function () {
				notificacion.close()
			}, 10000)
		}
	}
	;
});