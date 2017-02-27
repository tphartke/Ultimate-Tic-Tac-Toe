class Turn {
    static int turnNumber = 1;
    private TicTacToe currentGame = new TicTacToe();

    char checkCurrentTurnPiece(){
        if(turnNumber % 2 == 0){
            return 'O';
        }
        return 'X';
    }

    static int getTurnNumber(){
        return turnNumber;
    }

    boolean gameIsFinished(){
        boolean gameWon = gameIsWon();
        boolean gameTied = gameIsTied();
        return gameTied || gameWon;
    }

    private boolean gameIsWon(){
        boolean gameWon = currentGame.checkForWinCondition();
        if(gameWon){
            victoryDialogue();
        }
        return gameWon;
    }

    boolean gameIsTied(){
        boolean gameTied = currentGame.checkTieCondition();
        if(gameTied){
            tieDialogue();
        }
        return gameTied;
    }

    private void victoryDialogue(){
        char winningTurnPiece = checkCurrentTurnPiece();
        UI.outputField.append(winningTurnPiece + " wins!\n");
    }

    private void tieDialogue(){
        UI.outputField.append("Tie game\n");
    }
}
