import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ScoreboardTests {

    @Before
    public void setUp() throws IOException {
        Turn.turnNumber = 1;
        @SuppressWarnings("Variable 'ui' is never used")
        UI ui = new UI(); //a UI must be initialized in order for the tests to run properly
        UI.newGameButton.doClick();
    }

    @Test
    public void testPlayerOneScoreboard() {
        UI.boardButtons[2][0][2].doClick();
        UI.boardButtons[6][2][0].doClick();
        UI.boardButtons[1][0][1].doClick();
        UI.boardButtons[3][1][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        Assert.assertEquals(UI.player1Score.getText(), "6");
    }

    @Test
    public void testPlayerTwoScoreboard() {
        UI.boardButtons[3][2][0].doClick();
        UI.boardButtons[2][0][2].doClick();
        UI.boardButtons[6][2][0].doClick();
        UI.boardButtons[1][0][1].doClick();
        UI.boardButtons[3][1][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        Assert.assertEquals(UI.player1Score.getText(), "3");
    }
}
