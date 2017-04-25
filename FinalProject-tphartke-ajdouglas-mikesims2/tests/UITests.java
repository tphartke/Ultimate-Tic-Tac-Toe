import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class UITests {
    private myActionListener listener;

    @Before
    public void setUp() throws IOException {
        Turn.turnNumber = 1;
        listener = new myActionListener();
        @SuppressWarnings("Variable 'ui' is never used")
        UI ui = new UI(); //a UI must be initialized in order for the tests to run properly
        UI.newGameButton.doClick();
    }

    @Test
    public void testNewGameButton(){
        Turn.turnNumber = 5;
        UI.newGameButton.doClick();
        Assert.assertEquals(1, Turn.getTurnNumber());
    }

    @Test
    public void testClearBoard(){
        UI.boardButtons[0][0][0].doClick();
        listener.clearGameBoard();
        Assert.assertEquals(UI.boardButtons[0][0][0].getText(), "");
    }

    @Test
    public void testEastAIWriteName(){
        UI.AIGameMenu.setSelectedIndex(1);
        Assert.assertEquals(UI.player2Name.getText(), "Easy AI");
    }
    @Test
    public void testMediumAIWriteName(){
        UI.AIGameMenu.setSelectedIndex(2);
        Assert.assertEquals(UI.player2Name.getText(), "Medium AI");
    }

    @Test
    public void testHardAIWriteName(){
        UI.AIGameMenu.setSelectedIndex(3);
        Assert.assertEquals(UI.player2Name.getText(), "Hard AI");
    }

    @Test
    public void testWritePlayerName(){
        UI.player1Name.setText("Timmy");
        Assert.assertEquals(UI.player1Name.getText(), "Timmy");
    }

}
