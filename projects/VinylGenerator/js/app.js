$.getJSON('https://api.discogs.com/users/seanfour20/collection').done(function(data) {
	// console.log(data.releases);
	window.albumInfo = data.releases;
});

function pickRandomAlbum() {

	obj_keys = Object.keys(window.albumInfo);
	ran_key = obj_keys[Math.floor(Math.random() *obj_keys.length)];
	randomAlbum = window.albumInfo[ran_key].basic_information;
	albumArtist = randomAlbum.artists["0"].name;
	albumTitle = randomAlbum.title;
	albumLabel = randomAlbum.labels["0"].name;

	document.getElementById("albumArtist").innerHTML = albumArtist;
	document.getElementById("albumTitle").innerHTML = albumTitle;
	document.getElementById("albumLabel").innerHTML = albumLabel;

	console.log(albumArtist);
	console.log(albumTitle);
	console.log(albumLabel);

}