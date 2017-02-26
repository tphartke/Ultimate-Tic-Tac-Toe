import static java.lang.Math.pow;

class TicTacToe {
    private char[][] playingBoard = new char[3][3];
    private int boardLength = 3;
    boolean checkForWinCondition(){
      return checkForOWin() || checkForXWin();
    }

    private boolean checkForOWin(){
        if(verticalVictory('O')){
            return true;
        }
        else if(horizontalVictory('O')){
            return true;
        }
       else if(diagonalVictory('O')){
            return true;
        }
        return false;
    }

    private boolean checkForXWin(){
        if(verticalVictory('X')){
            return true;
        }
        else if(horizontalVictory('X')){
            return true;
        }
       else if(diagonalVictory('X')){
            return true;
        }
        return false;
    }



    private boolean verticalVictory(char ticTacToePiece){
        for(int i = 0; i < boardLength; i++){
            if(playingBoard[i][0] == ticTacToePiece && playingBoard[i][1] == ticTacToePiece && playingBoard[i][2] == ticTacToePiece){
                return true;
            }
        }
        return false;
    }

    private boolean horizontalVictory(char ticTacToePiece){
        for(int i = 0; i < boardLength; i++){
            if(playingBoard[0][i] == ticTacToePiece && playingBoard[1][i] == ticTacToePiece && playingBoard[2][i] == ticTacToePiece){
                return true;
            }

        }
        return false;
    }

    private boolean diagonalVictory(char ticTacToePiece){

        if(UI.boardButtons[0][0].equals(ticTacToePiece) && UI.boardButtons[1][1].equals(ticTacToePiece) && UI.boardButtons[2][2].equals(ticTacToePiece)){
            return true;

        }
        else if(UI.boardButtons[0][2].equals(ticTacToePiece) && UI.boardButtons[1][1].equals(ticTacToePiece) && UI.boardButtons[2][0].equals(ticTacToePiece)){
            return true;

        }
        return false;
    }

    boolean checkTieCondition(){
        return playingBoardIsFull() && !checkForWinCondition();
    }

    private boolean playingBoardIsFull(){
        boolean result = true;
        if(Turn.getTurnNumber() <= pow(boardLength, 2)){
            result = false;
        }
        return result;
    }

    void writeMoveToPlayingBoard(int x, int y, char characterToBeAdded){
        playingBoard[x][y] = characterToBeAdded;
        for(int i = 0; i < boardLength; i++){
            for(int j = 0; j < boardLength; j++){
                System.out.print(playingBoard[i][j]);
            }
        }
    }




}
