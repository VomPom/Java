


var interval;
var pos = 0;
var images = document.getElementsByTagName('img');
var buttons = document.getElementsByName('button');
function loadViews() {
	run(images);
}

function mouseOverChangeColor(obj){
	clearInterval(interval);
	obj.style.background="gray";
}
function mouseOutChangeColor(obj){
	clearInterval(interval);
	obj.style.background="white";
	run(images);
}
var run = function(images) {

	interval = setInterval(function() {
		images[pos].style.display = 'none';
		pos = ++pos == images.length ? 0 : pos;
		images[pos].style.display = 'inline';
		for(var i=0;i<buttons.length;i++){
			if(pos==i){
				buttons[i].style.background="gray";
			}else{
				buttons[i].style.background="white";
			}
		}

	}, 2000);
}
