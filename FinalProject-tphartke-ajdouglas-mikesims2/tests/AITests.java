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
    public void testPlayEasyAI(){
        UI.AIGameMenu.setSelectedIndex(1);
        UI.boardButtons[0][0][0].doClick();
        Assert.assertEquals(Turn.checkCurrentTurnPiece(), "X");
    }

    @Test
    public void testPlayMediumAI(){
        UI.AIGameMenu.setSelectedIndex(2);
        UI.boardButtons[0][0][0].doClick();
        Assert.assertEquals(Turn.checkCurrentTurnPiece(), "X");
    }

    @Test
    public void testPlayHardAI(){
        UI.AIGameMenu.setSelectedIndex(3);
        UI.boardButtons[0][0][0].doClick();
        Assert.assertEquals(Turn.checkCurrentTurnPiece(), "X");
    }
}
