function fold(ele){
	document.getElementsByClassName('sidebar')[0].style.left = '';
}

function unfold(ele){
	document.getElementsByClassName('sidebar')[0].style.left = '0';
}

window.time = setInterval("showTime()",1000);
function showTime(){
	document.getElementById("time").innerHTML= myDate.getTime();
}