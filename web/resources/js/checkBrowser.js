document.addEventListener("DOMContentLoaded", function() {
	if (!(window.CSS && window.CSS.supports && window.CSS.supports("( display: grid ) and ( --var: grid ) and ( display: var(--var) )" ))){
		if(decodeURI(location.pathname)!="/browserUpdate.html"){
			window.location="/browserUpdate.html";
		}
	} else if(decodeURI(location.pathname)=="/browserUpdate.html"){
		window.location="/auth/";
	}
});