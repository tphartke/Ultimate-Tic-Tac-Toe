import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
    private myActionListener listener;

    @Before
    public void setUp(){
        Turn.turnNumber = 1;
        listener = new myActionListener();
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
    @Test
    public void testWriteXToBoardLocation(){
        UI.boardButtons[0][0][0].doClick();
        Assert.assertEquals(UI.boardButtons[0][0][0].getText(), "X");
    }

    @Test
    public void testWriteOToBoardLocation(){
        UI.boardButtons[0][0][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        Assert.assertEquals(UI.boardButtons[1][0][0].getText(), "O");
    }

    @Test
    public void testXDiagonalWin1(){
        UI.boardButtons[2][0][2].doClick();
        UI.boardButtons[6][2][0].doClick();
        UI.boardButtons[1][0][1].doClick();
        UI.boardButtons[3][1][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        Assert.assertTrue(TicTacToe.diagonalVictory("X"));
    }

    @Test
    public void testXDiagonalWin2(){
        UI.boardButtons[0][0][2].doClick();
        UI.boardButtons[0][2][0].doClick();
        UI.boardButtons[1][0][1].doClick();
        UI.boardButtons[3][1][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        Assert.assertTrue(TicTacToe.diagonalVictory("X"));
    }

    @Test
    public void testODiagonalWin1(){
        UI.boardButtons[3][2][0].doClick();
        UI.boardButtons[2][0][2].doClick();
        UI.boardButtons[6][2][0].doClick();
        UI.boardButtons[1][0][1].doClick();
        UI.boardButtons[3][1][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        Assert.assertTrue(TicTacToe.diagonalVictory("O"));
    }

    @Test
    public void testODiagonalWin2(){
        UI.boardButtons[6][1][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        UI.boardButtons[6][0][0].doClick();
        UI.boardButtons[1][0][1].doClick();
        UI.boardButtons[3][1][0].doClick();
        UI.boardButtons[0][0][2].doClick();
        Assert.assertTrue(TicTacToe.diagonalVictory("O"));
    }

    @Test
    public void testXVerticalVictory1(){
        UI.boardButtons[0][0][2].doClick();
        UI.boardButtons[0][2][0].doClick();
        UI.boardButtons[0][0][1].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        Assert.assertTrue(TicTacToe.verticalVictory("X"));
    }

    @Test
    public void testXVerticalVictory2(){
        UI.boardButtons[1][0][2].doClick();
        UI.boardButtons[3][2][0].doClick();
        UI.boardButtons[1][0][1].doClick();
        UI.boardButtons[3][1][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        Assert.assertTrue(TicTacToe.verticalVictory("X"));
    }

    @Test
    public void testXVerticalVictory3(){
        UI.boardButtons[2][0][2].doClick();
        UI.boardButtons[6][2][0].doClick();
        UI.boardButtons[2][0][1].doClick();
        UI.boardButtons[6][1][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        Assert.assertTrue(TicTacToe.verticalVictory("X"));
    }

    @Test
    public void testOVerticalVictory1(){
        UI.boardButtons[3][0][0].doClick();
        UI.boardButtons[0][0][2].doClick();
        UI.boardButtons[0][2][0].doClick();
        UI.boardButtons[0][0][1].doClick();
        UI.boardButtons[0][1][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        Assert.assertTrue(TicTacToe.verticalVictory("O"));
    }

    @Test
    public void testOVerticalVictory2(){
        UI.boardButtons[3][0][0].doClick();
        UI.boardButtons[1][0][2].doClick();
        UI.boardButtons[3][2][0].doClick();
        UI.boardButtons[1][0][1].doClick();
        UI.boardButtons[3][1][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        Assert.assertTrue(TicTacToe.verticalVictory("O"));
    }

    @Test
    public void testOVerticalVictory3(){
        UI.boardButtons[3][0][0].doClick();
        UI.boardButtons[2][0][2].doClick();
        UI.boardButtons[6][2][0].doClick();
        UI.boardButtons[2][0][1].doClick();
        UI.boardButtons[6][1][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        Assert.assertTrue(TicTacToe.verticalVictory("O"));
    }

    @Test
    public void testXHorizontalVictory1(){
        UI.boardButtons[2][0][0].doClick();
        UI.boardButtons[6][0][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[3][0][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        Assert.assertTrue(TicTacToe.horizontalVictory("X"));
    }

    @Test
    public void testXHorizontalVictory2(){
        UI.boardButtons[2][0][1].doClick();
        UI.boardButtons[6][1][0].doClick();
        UI.boardButtons[1][0][1].doClick();
        UI.boardButtons[3][1][0].doClick();
        UI.boardButtons[0][0][1].doClick();
        Assert.assertTrue(TicTacToe.horizontalVictory("X"));
    }

    @Test
    public void testXHorizontalVictory3(){
        UI.boardButtons[2][0][2].doClick();
        UI.boardButtons[6][2][0].doClick();
        UI.boardButtons[1][0][2].doClick();
        UI.boardButtons[3][2][0].doClick();
        UI.boardButtons[0][0][2].doClick();
        Assert.assertTrue(TicTacToe.horizontalVictory("X"));
    }

    @Test
    public void testOHorizontalVictory1(){
        UI.boardButtons[6][2][0].doClick();
        UI.boardButtons[2][0][0].doClick();
        UI.boardButtons[6][0][0].doClick();
        UI.boardButtons[1][0][0].doClick();
        UI.boardButtons[3][0][0].doClick();
        UI.boardButtons[0][0][0].doClick();
        Assert.assertTrue(TicTacToe.horizontalVictory("O"));
    }

    @Test
    public void testOHorizontalVictory2(){
        UI.boardButtons[6][2][0].doClick();
        UI.boardButtons[2][0][1].doClick();
        UI.boardButtons[6][1][0].doClick();
        UI.boardButtons[1][0][1].doClick();
        UI.boardButtons[3][1][0].doClick();
        UI.boardButtons[0][0][1].doClick();
        Assert.assertTrue(TicTacToe.horizontalVictory("O"));
    }

    @Test
    public void testOHorizontalVictory3(){
        UI.boardButtons[6][1][0].doClick();
        UI.boardButtons[2][0][2].doClick();
        UI.boardButtons[6][2][0].doClick();
        UI.boardButtons[1][0][2].doClick();
        UI.boardButtons[3][2][0].doClick();
        UI.boardButtons[0][0][2].doClick();
        Assert.assertTrue(TicTacToe.horizontalVictory("O"));
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

    @Test
    public void testAIWriteName(){
        UI.AIGameButton.doClick();
        Assert.assertEquals(UI.player2Name.getText(), "AI");
    }

    @Test
    public void testWritePlayerName(){
        UI.player1Name.setText("Timmy");
        Assert.assertEquals(UI.player1Name.getText(), "Timmy");
    }
}
