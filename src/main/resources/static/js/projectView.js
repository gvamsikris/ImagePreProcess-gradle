/**
 * 
 */

$(function() {
	
	var imageArray = [];
	var imageIndex = 0;

	var canvas = document.getElementById("canvas");
	var context = canvas.getContext("2d");
	var scale = 1.5;
	var originx = 0;
	var originy = 0;
	var imageObj = new Image();
	imageObj.src = 'file:///D:/images/StdRackBack.jpg';
	
	var zoom = function(zoomPar, mousex, mousey){
		context.translate(originx, originy);
		context.scale(zoomPar, zoomPar);
		context.translate(
				-(mousex / scale + originx - mousex / (scale * zoomPar)), 
				-(mousey / scale + originy - mousey / (scale * zoomPar)));

		originx = (mousex / scale + originx - mousex / (scale * zoomPar));
		originy = (mousey / scale + originy - mousey / (scale * zoomPar));
		scale *= zoomPar;
	}

	function draw() {
		// From: http://goo.gl/jypct
		// Store the current transformation matrix
		context.save();

		// Use the identity matrix while clearing the canvas
		context.setTransform(1, 0, 0, 1, 0, 0);
		context.clearRect(0, 0, canvas.width, canvas.height);

		// Restore the transform
		context.restore();

		// Draw on transformed context
		context.drawImage(imageObj, 0, 0, 600, 600);

	}
	
	setInterval(draw, 100);
	
	canvas.onkeydown = function(){
		var mousex = event.clientX - canvas.offsetLeft;
		var mousey = event.clientY - canvas.offsetTop;
		zoom(zoomPar, mousex, mousey);
	}
	
	canvas.onmousewheel = function(event) {
		var mousex = event.clientX - canvas.offsetLeft;
		var mousey = event.clientY - canvas.offsetTop;
		var wheel = event.wheelDelta / 120;// n or -n
		// according to Chris comment
		console.log("zoom");
		var zoomPar = Math.pow(1 + Math.abs(wheel) / 2, wheel > 0 ? 1 : -1);
		console.log(zoomPar);
		console.log(mousex);
		console.log(mousey);
		zoom(zoomPar, mousex, mousey);
	}
	
	$("#saveButton").click(function(){
		var data = $("#imageForm").serialize();
		console.log(data);
		$.ajax({
			"url": "/image",
			"type": "POST",
			"data": data,
			"success": function(data){
				console.log(data);
				imageIndex++;
				if(imageIndex < imageArray.length){
					imageObj.src = "file:///" + imageArray[imageIndex].path;
					draw();
					$("#imageForm").reset();
				}
			},
			"error":function(){
				alert("error in saving image data");
			}
		});
	});

	$(".batch").click(function() {
		var batchId = $(this).attr("batchid");
		console.log(batchId);
		$.getJSON("/image/byBatch/" + batchId ,{date:new Date()}, function(data) {
			//$("#mainImage").attr("src", "file:///" + data[0].path);
			console.log(data);
			imageArray = data;
			imageindex = 0;
			imageObj.src = "file:///" + data[0].path;
			$("#imageId").val(data[0].id);
			draw();
		});
	});

	$(".list-group-item").click(function() {
		$(".list-group-item").removeClass("list-group-item-info");
		$(this).addClass("list-group-item-info");
	});
});
