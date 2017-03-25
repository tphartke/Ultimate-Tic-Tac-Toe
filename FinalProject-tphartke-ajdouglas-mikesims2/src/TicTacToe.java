import java.awt.*;
import static java.lang.Math.pow;

class TicTacToe {
    private static int boardLength = 3;
    private static int boardIndex = 0;

    static boolean checkForWinCondition(){
      return checkForOWin() || checkForXWin();
    }

    static boolean checkForOWin(){
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

    static boolean checkForXWin(){
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

    static boolean verticalVictory(String ticTacToePiece){
        for(int i = 0; i < boardLength; i++){
            if(UIButtonMatchesPiece(i, 0, ticTacToePiece) && UIButtonMatchesPiece(i, 1, ticTacToePiece) && UIButtonMatchesPiece(i, 2, ticTacToePiece)){
                setBackgroundColorForVerticalVictory(i);
                return true;
            }
        }
        return false;
    }

    static boolean horizontalVictory(String ticTacToePiece){
        for(int i = 0; i < boardLength; i++){
            if(UIButtonMatchesPiece(0, i, ticTacToePiece) && UIButtonMatchesPiece(1, i, ticTacToePiece) && UIButtonMatchesPiece(2, i, ticTacToePiece)){
                setBackgroundColorForHorizontalVictory(i);
                return true;
            }
        }
        return false;
    }

    static boolean diagonalVictory(String ticTacToePiece){

        if(UIButtonMatchesPiece(0, 0, ticTacToePiece) && UIButtonMatchesPiece(1, 1, ticTacToePiece) && UIButtonMatchesPiece(2, 2, ticTacToePiece)){
            UI.boardButtons[0][0][0].setBackground(Color.green);
            UI.boardButtons[1][1][0].setBackground(Color.green);
            UI.boardButtons[2][2][0].setBackground(Color.green);
            return true;
        }

        else if(UIButtonMatchesPiece(0, 2, ticTacToePiece) && UIButtonMatchesPiece(1, 1, ticTacToePiece) && UIButtonMatchesPiece(2, 0, ticTacToePiece)){
            UI.boardButtons[0][2][0].setBackground(Color.green);
            UI.boardButtons[1][1][0].setBackground(Color.green);
            UI.boardButtons[2][0][0].setBackground(Color.green);
            return true;
        }
        return false;
    }

    static boolean checkTieCondition(){
        return playingBoardIsFull() && !checkForWinCondition();
    }

    private static boolean playingBoardIsFull(){
        boolean result = true;
        if(Turn.getTurnNumber() <= pow(boardLength, 2)){
            result = false;
        }
        return result;
    }

    private static boolean UIButtonMatchesPiece(int x, int y, String ticTacToePiece){
        return UI.boardButtons[x][y][0].getText().matches(ticTacToePiece);
    }

    private static void setBackgroundColorForHorizontalVictory(int verticalIndex){
        UI.boardButtons[0][boardIndex][verticalIndex].setBackground(Color.green);
        UI.boardButtons[1][boardIndex][verticalIndex].setBackground(Color.green);
        UI.boardButtons[2][boardIndex][verticalIndex].setBackground(Color.green);
    }

    private static void setBackgroundColorForVerticalVictory(int horizontalIndex){
        UI.boardButtons[horizontalIndex][boardIndex][0].setBackground(Color.green);
        UI.boardButtons[horizontalIndex][boardIndex][0].setBackground(Color.green);
        UI.boardButtons[horizontalIndex][boardIndex][0].setBackground(Color.green);
    }
}
