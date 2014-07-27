var container, scene, camera, renderer, controls, stats;
var clock = new THREE.Clock();

function create3d(){
	//container

	container = $("#canvas");

	// SCENE
	scene = new THREE.Scene();
	// CAMERA
	var SCREEN_WIDTH = container.width(), SCREEN_HEIGHT = container.height();
	var VIEW_ANGLE = 45, ASPECT = SCREEN_WIDTH / SCREEN_HEIGHT, NEAR = 0.1, FAR = 20000;
	camera = new THREE.PerspectiveCamera( VIEW_ANGLE, ASPECT, NEAR, FAR);
	scene.add(camera);
	camera.position.set(0,150,400);
	camera.lookAt(scene.position);
}