import static java.lang.Math.pow;

class TicTacToe {
    private int boardLength = 3;
    boolean checkForWinCondition(){
      return checkForOWin() || checkForXWin();
    }

    private boolean checkForOWin(){
        if(verticalVictory("O")){
            return true;
        }
        else if(horizontalVictory("O")){
            return true;
        }
       else if(diagonalVictory("O")){
            return true;
        }
        return false;
    }

    private boolean checkForXWin(){
        if(verticalVictory("X")){
            return true;
        }
        else if(horizontalVictory("X")){
            return true;
        }
       else if(diagonalVictory("X")){
            return true;
        }
        return false;
    }

    boolean verticalVictory(String ticTacToePiece){
        for(int i = 0; i < boardLength; i++){
            if(UIButtonMatchesPiece(i, 0, ticTacToePiece) && UIButtonMatchesPiece(i, 1, ticTacToePiece) && UIButtonMatchesPiece(i, 2, ticTacToePiece)){
                return true;
            }
        }
        return false;
    }

    boolean horizontalVictory(String ticTacToePiece){
        for(int i = 0; i < boardLength; i++){
            if(UIButtonMatchesPiece(0, i, ticTacToePiece) && UIButtonMatchesPiece(1, i, ticTacToePiece) && UIButtonMatchesPiece(2, i, ticTacToePiece)){
                return true;
            }

        }
        return false;
    }

    boolean diagonalVictory(String ticTacToePiece){

        if(UIButtonMatchesPiece(0, 0, ticTacToePiece) && UIButtonMatchesPiece(1, 1, ticTacToePiece) && UIButtonMatchesPiece(2, 2, ticTacToePiece)){
            return true;

        }
        else if(UIButtonMatchesPiece(0, 2, ticTacToePiece) && UIButtonMatchesPiece(1, 1, ticTacToePiece) && UIButtonMatchesPiece(2, 0, ticTacToePiece)){
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

    private boolean UIButtonMatchesPiece(int x, int y, String ticTacToePiece){
        return UI.boardButtons[x][y].getText().matches(ticTacToePiece);
    }
}
