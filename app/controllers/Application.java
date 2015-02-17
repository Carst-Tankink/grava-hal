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
    
    private static GravaHal gameById(String gameId) {
      Model.Finder<String, GravaHal> finder =
          new Model.Finder<String, GravaHal>(String.class, GravaHal.class);
      return finder.byId(gameId);      
    }
    
    private static Result gameNotFound = notFound("Game not found").as("text/html");
    
    public static Result game(String gameId) {
      GravaHal gh_game = gameById(gameId);
      
      if (gh_game != null) {
        return ok(game.render(gh_game));
      }
      else {
        return gameNotFound;
      }
    }
    
    public static Result playFrom(String gameId, String player, int pit) {
      GravaHal gh_game = gameById(gameId);
      
      if (gh_game != null) {
        gh_game.playFrom(player, pit);
        gh_game.save();
        return ok();
      }
      else {
        return gameNotFound;
      }
    }
}
