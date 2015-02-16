package controllers;

import models.GravaHal;
import play.data.Form;
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
      return ok();
    }

}
