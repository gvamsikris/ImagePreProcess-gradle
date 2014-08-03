/**
 * 
 */

$(function() {

	var imageArray = [];
	var imageIndex = 0;
	var imageObj = new Image();

	function drawImage(imageObj) {
		
		console.log("drawImage");
		var stage = new Kinetic.Stage({
			container : "container",
			width : 800,
			height : 600

		});
		var layer = new Kinetic.Layer();
		layer.setDraggable("draggable");

		// darth vader
		// var canvasOffset=canvas.offset();
		var darthVaderImg = new Kinetic.Image({
			image : imageObj,
			x : 0,
			y : 0,
			width : 800,
			height : 600,

		});

		// add cursor styling
		darthVaderImg.on('mouseover', function() {
			document.body.style.cursor = 'pointer';
		});
		darthVaderImg.on('mouseout', function() {
			document.body.style.cursor = 'default';
		});
		var zoomAmount = 1;
		document.onkeydown = function(event) {
			// console.log();
			e = event || window.event; // because of Internet Explorer
										// quirks...
			k = e.which || e.charCode || e.keyCode; // because of browser
													// differences...
			// alert()
			if (k == 65) {
				zoomAmount = zoomAmount + 0.1;
				zoom(zoomAmount);
			} else if (k == 90) {
				zoomAmount = zoomAmount - 0.1;
				zoom(zoomAmount);
			}

		}
		function zoom(zoomAmount) {
			layer.setScale({
				x : zoomAmount,
				y : zoomAmount
			})
			console.log("---" + layer.getScale());
			layer.draw();
		}
		var rotatedDegree = 0;
		document.onkeyup = function(event) {
			e = event || window.event; // because of Internet Explorer
										// quirks...
			k = e.which || e.charCode || e.keyCode; // because of browser
													// differences...
			if (k == 82 && e.altKey) {
				if (rotatedDegree == 0) {
					darthVaderImg.rotateDeg(90);
					darthVaderImg.setX(darthVaderImg.getHeight());
					rotatedDegree = 90;
				} else {
					darthVaderImg.rotateDeg(-90);
					darthVaderImg.setX(0);
					rotatedDegree = 0;
				}

				layer.draw();
			}

		}

		layer.add(darthVaderImg);
		stage.add(layer);
	}

	$("#saveButton").click(function() {
		var data = $("#imageForm").serialize();
		console.log(data);
		$.ajax({
			"url" : "/image",
			"type" : "POST",
			"data" : data,
			"success" : function(data) {
				console.log(data);
				imageIndex++;
				if (imageIndex < imageArray.length) {
					imageObj.src = "file:///" + imageArray[imageIndex].path;
					drawImage(imageObj);
					$("#imageForm").reset();
				}
			},
			"error" : function() {
				alert("error in saving image data");
			}
		});
	});

	$(".batch").click(function() {
		var batchId = $(this).attr("batchid");
		console.log(batchId);
		$.getJSON("/image/byBatch/" + batchId, {
			date : new Date()
		}, function(data) {
			// $("#mainImage").attr("src", "file:///" + data[0].path);
			console.log(data);
			imageArray = data;
			imageindex = 0;
			imageObj.src = "file:///" + data[0].path;
			$("#imageId").val(data[0].id);
			drawImage(imageObj);
		});
	});

	$(".list-group-item").click(function() {
		$(".list-group-item").removeClass("list-group-item-info");
		$(this).addClass("list-group-item-info");
	});
});
