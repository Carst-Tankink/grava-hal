import java.util.Iterator;

import org.fluentlenium.core.domain.*;
import org.junit.*;

import play.test.*;
import play.libs.F.*;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


public class IntegrationTest {
  
  private void createGame(TestBrowser browser) {
    browser.goTo("http://localhost:3333");
    browser.fill("input[name=\"playerOne\"]").with("Alice");
    browser.fill("input[name=\"playerTwo\"]").with("Bob");
    browser.submit("#startGame");
  }

  @Test
  public void createGameTest() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        createGame(browser);
        // Redirection to started game
        assertThat(browser.url()).startsWith("http://localhost:3333/game/");

        // Game should mention who is playing
        assertThat(browser.pageSource()).contains("Alice");
        assertThat(browser.pageSource()).contains("Bob");
        
        assertThat(browser.pageSource()).contains("It is Alice's turn");
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

  @Test
  public void boardTest() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        createGame(browser);
        
        FluentList<FluentWebElement> pitList = browser.$(".pit");
        assertThat(pitList.size()).isEqualTo(12);
        
        for(FluentWebElement pit : pitList) {
          assertThat(pit.getText()).isEqualTo("6");
        }
        
        assertThat(browser.$(".grava-hal").size()).isEqualTo(2);
      }
    });
  }
}
