import org.junit.*;

import play.test.*;
import play.libs.F.*;
import static play.test.Helpers.*;

import static org.fest.assertions.Assertions.*;


public class IntegrationTest {

  @Test
  public void createGameTest() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333");
        browser.fill("input[name=\"playerOne\"]").with("Alice");
        browser.fill("input[name=\"playerTwo\"]").with("Bob");
        browser.submit("#startGame");

        // Redirection to started game
        assertThat(browser.url()).startsWith("http://localhost:3333/game/");

        // Game should mention who is playing
        assertThat(browser.pageSource()).contains("Alice");
        assertThat(browser.pageSource()).contains("Bob");
      }
    });
  }

  @Test
  public void noGameTest() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333/game/404");

        assertThat(browser.pageSource()).contains("Game not found");
      }
    });
  }

}
