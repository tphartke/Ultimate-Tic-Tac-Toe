import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AITests {

    @Before
    public void setUp() throws IOException {
        Turn.turnNumber = 1;
        @SuppressWarnings("Variable 'ui' is never used")
        UI ui = new UI(); //a UI must be initialized in order for the tests to run properly
        UI.newGameButton.doClick();
    }

@Test
    public void testTakeVerticalWin(){
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[0][0][2].doClick();
        UI.boardButtons[1][1][2].doClick();
        UI.boardButtons[3][2][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[3][0][0].doClick();
        UI.boardButtons[1][0][0].doClick();
    Assert.assertTrue(TicTacToe.verticalVictory("O"));

    }

@Test
    public void testTakeHorizontalWin(){
        UI.boardButtons[4][1][1].doClick();
        UI.boardButtons[3][1][0].doClick();
        UI.boardButtons[1][0][1].doClick();
        UI.boardButtons[3][1][1].doClick();
        UI.boardButtons[1][1][1].doClick();
    Assert.assertTrue(TicTacToe.horizontalVictory("O"));

    }

@Test
    public void testTakeDiagonalWin(){


    }

}
