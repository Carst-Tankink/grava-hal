import models.GravaHal;

import org.junit.*;

import play.twirl.api.Content;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void initGame() {
      GravaHal game = new GravaHal("Alice", "Bob");
      assertThat(game.getPlayerOne()).isEqualTo("Alice");
      assertThat(game.getPlayerTwo()).isEqualTo("Bob");
      
      assertThat(game.getActivePlayer()).isEqualTo("Alice");
    }
    
    @Test
    public void renderTemplate() {
      Content html = views.html.index.render("Your new application is ready.");
      assertThat(contentType(html)).isEqualTo("text/html");
      assertThat(contentAsString(html)).contains("Your new application is ready.");
    }


}
