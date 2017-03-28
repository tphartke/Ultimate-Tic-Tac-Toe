class Turn {
    static int turnNumber = 1;

    static char checkCurrentTurnPiece(){
        if(turnNumber % 2 == 0){
            return 'O';
        }
        return 'X';
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
        char winningTurnPiece = checkCurrentTurnPiece();
        UI.outputField.append(winningTurnPiece + " wins!\n");
        Scoreboard.outputCurrentSessionScoring();
    }

    private void tieDialogue(){
        UI.outputField.append("Tie game\n");
        Scoreboard.outputCurrentSessionScoring();
    }
}
