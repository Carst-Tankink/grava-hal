function playFrom(name, side, pit) {
  $.post(jsRoutes.controllers.Application.playFrom(name, side, pit).url, function() {
	  location.reload();
  });
}