package controllers;

import models.GravaHal;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result startGravaHal() {
      GravaHal game = Form.form(GravaHal.class).bindFromRequest().get();
      game.save();
      return redirect(routes.Application.game(game.gameId));
    }
    
    public static Result game(String gameId) {
      return ok();
    }

}
