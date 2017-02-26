class Turn {
    static int turnNumber = 1;
    private TicTacToe currentGame = new TicTacToe();

    Turn(){
        gameIsFinished();
    }

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
            System.out.println(tieDialogue());
        }
        else if(gameWon){
            System.out.println(victoryDialogue());
        }
        return gameTied || gameWon;
    }

    private String victoryDialogue(){
        char winningTurnPiece = checkCurrentTurnPiece();
        return winningTurnPiece + " wins!";
    }

    private String tieDialogue(){
        return "Tie game";
    }
}
