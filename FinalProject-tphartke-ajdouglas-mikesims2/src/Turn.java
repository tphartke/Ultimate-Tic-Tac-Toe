class Turn {
    static int turnNumber = 1;
    private TicTacToe currentGame = new TicTacToe();

    static char checkCurrentTurnPiece(){
        if(turnNumber % 2 == 0){
            return 'O';
        }
        return 'X';
    }

    static int getTurnNumber(){
        return turnNumber;
    }

    boolean gameIsWon(){
        boolean gameWon = TicTacToe.checkForWinCondition();
        if(gameWon){
            victoryDialogue();
            myActionListener.makeButtonsUnEnabled();
        }
        return gameWon;
    }

    boolean gameIsTied(){
        boolean gameTied = TicTacToe.checkTieCondition();
        if(gameTied){
            tieDialogue();
            myActionListener.makeButtonsUnEnabled();
        }
        return gameTied;
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
