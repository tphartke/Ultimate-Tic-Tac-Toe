

public class Turn {
    static int turnNumber = 1;

    static String checkCurrentTurnPiece(){
        if(turnNumber % 2 == 0){
            return "O";
        }
        return "X";
    }

    static int getTurnNumber(){
        return turnNumber;
    }

    void gameIsWon(){
        boolean gameWon = TicTacToe.checkForWinCondition();
        if(gameWon){
            victoryDialogue();
            myActionListener.makeButtonsUnEnabled();
        }
    }

    void gameIsTied(){
        boolean gameTied = UltimateTicTacToe.checkForLocalTie();
        if(gameTied){
            myActionListener.makeButtonsUnEnabled();
        }
    }

    private void victoryDialogue(){
        String winningTurnPiece = checkCurrentTurnPiece();
        UI.outputField.append(getCurrentPlayer(winningTurnPiece) + " wins board " + myActionListener.verticalBoardIndex + " " + myActionListener.horizontalBoardIndex + "\n");
    }

    static String getCurrentPlayer(String CurrentTurnPiece){
        if(CurrentTurnPiece.equals("X")){
            return UI.player1Name.getText();
        }
        else{
            return UI.player2Name.getText();
        }
    }

    void checkForGlobalVictory(){
        boolean globalVictory = UltimateTicTacToeVictoryConditions.checkForWinCondition();
        String winningTurnPiece = checkCurrentTurnPiece();
        if(globalVictory){
            UI.outputField.append(getCurrentPlayer(winningTurnPiece) + " wins!\n");
            Scoreboard.outputCurrentSessionScoring();
        }
    }

    void checkForGlobalTie(){
        boolean globalTie = TicTacToe.checkTieCondition();
        if(globalTie){
            UI.outputField.append("Tie game!\n");

        }
    }
}