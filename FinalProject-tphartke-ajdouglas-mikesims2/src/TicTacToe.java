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

    private boolean verticalVictory(String ticTacToePiece){
        for(int i = 0; i < boardLength; i++){
            if(UI.boardButtons[i][0].getText().matches(ticTacToePiece) && UI.boardButtons[i][1].getText().matches(ticTacToePiece) && UI.boardButtons[i][2].getText().matches(ticTacToePiece)){
                return true;
            }
        }
        return false;
    }

    private boolean horizontalVictory(String ticTacToePiece){
        for(int i = 0; i < boardLength; i++){
            if(UI.boardButtons[0][i].getText().matches(ticTacToePiece) && UI.boardButtons[1][i].getText().matches(ticTacToePiece) && UI.boardButtons[2][i].getText().matches(ticTacToePiece)){
                return true;
            }

        }
        return false;
    }

    private boolean diagonalVictory(String ticTacToePiece){

        if(UI.boardButtons[0][0].getText().matches(ticTacToePiece) && UI.boardButtons[1][1].getText().matches(ticTacToePiece) && UI.boardButtons[2][2].getText().matches(ticTacToePiece)){
            return true;

        }
        else if(UI.boardButtons[0][2].getText().matches(ticTacToePiece) && UI.boardButtons[1][1].getText().matches(ticTacToePiece) && UI.boardButtons[2][0].getText().matches(ticTacToePiece)){
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
}
