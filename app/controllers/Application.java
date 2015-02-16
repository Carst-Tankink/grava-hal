package controllers;

import models.GravaHal;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;
import views.html.*;
import views.formdata.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result startGravaHal() {
      GravaHalFormData gameData = Form.form(GravaHalFormData.class).bindFromRequest().get();
      GravaHal game = new GravaHal(gameData.playerOne, gameData.playerTwo);
      game.save();
      return redirect(routes.Application.game(game.getGameId()));
    }
    
    public static Result game(String gameId) {
      Model.Finder<String, GravaHal> finder =
          new Model.Finder<String, GravaHal>(String.class, GravaHal.class);
      GravaHal gh_game = finder.byId(gameId);

      if (gh_game != null) {
        return ok(game.render(gh_game));
      }
      else {
        return notFound("Game not found").as("text/html");
      }
    }

}
