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
        boolean gameWon = currentGame.checkForWinCondition();
        boolean gameTied = currentGame.checkTieCondition();
        if(gameTied){
            tieDialogue();
        }
        else if(gameWon){
            victoryDialogue();
        }
        return gameTied || gameWon;
    }

    private void victoryDialogue(){
        char winningTurnPiece = checkCurrentTurnPiece();
        UI.outputField.append(winningTurnPiece + " wins!\n");
    }

    private void tieDialogue(){
        UI.outputField.append("Tie game\n");
    }
}
