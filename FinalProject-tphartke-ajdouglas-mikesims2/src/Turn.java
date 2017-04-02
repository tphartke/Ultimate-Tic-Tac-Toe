class Turn {
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
        boolean gameTied = TicTacToe.checkTieCondition();
        if(gameTied){
            tieDialogue();
            myActionListener.makeButtonsUnEnabled();
        }
    }

    private void victoryDialogue(){
        String winningTurnPiece = checkCurrentTurnPiece();
        UI.outputField.append(getCurrentPlayer(winningTurnPiece) + " wins!\n");
        Scoreboard.outputCurrentSessionScoring();
    }

    static String getCurrentPlayer(String CurrentTurnPiece){
        if(CurrentTurnPiece.equals("X")){
            return UI.player1Name.getText();
        }
        else{
            return UI.player2Name.getText();
        }
    }

    private void tieDialogue(){
        UI.outputField.append("Tie game\n");
        Scoreboard.outputCurrentSessionScoring();
    }
}
