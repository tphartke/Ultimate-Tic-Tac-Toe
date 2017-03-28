import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
    private TicTacToe tictactoe;
    private myActionListener listener;

    @Before
    public void setUp(){
        Turn.turnNumber = 1;
        tictactoe = new TicTacToe();
        listener = new myActionListener();
        @SuppressWarnings("Variable 'ui' is never used")
        UI ui = new UI(); //a UI must be initialized in order for the tests to run properly
    }
    @Test
    public void testWriteXToBoardLocation(){
        UI.boardButtons[0][0][0].doClick();
        Assert.assertEquals(UI.boardButtons[0][0][0].getText(), "X");
    }

    @Test
    public void testWriteOToBoardLocation(){
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        Assert.assertEquals(UI.boardButtons[0][0][0].getText(), "O");
    }

    @Test
    public void testXDiagonalWin1(){
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[2][2][0].doClick();
        Assert.assertTrue(tictactoe.diagonalVictory("X"));
    }

    @Test
    public void testXDiagonalWin2(){
        UI.boardButtons[0][2][0].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        Assert.assertTrue(tictactoe.diagonalVictory("X"));
    }

    @Test
    public void testODiagonalWin1(){
        UI.boardButtons[0][2][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[2][2][0].doClick();
        Assert.assertTrue(tictactoe.diagonalVictory("O"));
    }

    @Test
    public void testODiagonalWin2(){
        UI.boardButtons[2][2][0].doClick();
        UI.boardButtons[0][2][0].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        Assert.assertTrue(tictactoe.diagonalVictory("O"));
    }

    @Test
    public void testXVerticalVictory1(){
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[2][1][0].doClick();
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        UI.boardButtons[1][2][0].doClick();
        Assert.assertTrue(tictactoe.verticalVictory("X"));
    }

    @Test
    public void testXVerticalVictory2(){
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[2][1][0].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        UI.boardButtons[0][2][0].doClick();
        Assert.assertTrue(tictactoe.verticalVictory("X"));
    }

    @Test
    public void testXVerticalVictory3(){
        UI.boardButtons[2][0][0].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[2][1][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[2][2][0].doClick();
        Assert.assertTrue(tictactoe.verticalVictory("X"));
    }

    @Test
    public void testOVerticalVictory1(){
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[2][1][0].doClick();
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        UI.boardButtons[1][2][0].doClick();
        Assert.assertTrue(tictactoe.verticalVictory("O"));
    }

    @Test
    public void testOVerticalVictory2(){
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[2][1][0].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        UI.boardButtons[0][2][0].doClick();
        Assert.assertTrue(tictactoe.verticalVictory("O"));
    }

    @Test
    public void testOVerticalVictory3(){
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[2][1][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[2][2][0].doClick();
        Assert.assertTrue(tictactoe.verticalVictory("O"));
    }

    @Test
    public void testXHorizontalVictory1(){
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        Assert.assertTrue(tictactoe.horizontalVictory("X"));
    }

    @Test
    public void testXHorizontalVictory2(){
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[2][1][0].doClick();
        Assert.assertTrue(tictactoe.horizontalVictory("X"));
    }

    @Test
    public void testXHorizontalVictory3(){
        UI.boardButtons[0][2][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[1][2][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[2][2][0].doClick();
        Assert.assertTrue(tictactoe.horizontalVictory("X"));
    }

    @Test
    public void testOHorizontalVictory1(){
        UI.boardButtons[2][2][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        Assert.assertTrue(tictactoe.horizontalVictory("O"));
    }

    @Test
    public void testOHorizontalVictory2(){
        UI.boardButtons[2][2][0].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[2][1][0].doClick();
        Assert.assertTrue(tictactoe.horizontalVictory("O"));
    }

    @Test
    public void testOHorizontalVictory3(){
        UI.boardButtons[1][1][0].doClick();
        UI.boardButtons[0][2][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[1][2][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[2][2][0].doClick();
        Assert.assertTrue(tictactoe.horizontalVictory("O"));
    }

    @Test
    public void testTieCondition(){
        Turn.turnNumber = 10;
        Assert.assertTrue(tictactoe.checkTieCondition());
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
}
