import java.awt.*;

class TicTacToe {
    private static final int boardLength = 3;
    private static int horizontalBoardIndex = myActionListener.horizontalBoardIndex;
    private static int verticalBoardIndex = myActionListener.verticalBoardIndex;

    static boolean checkForWinCondition(){
        horizontalBoardIndex = myActionListener.horizontalBoardIndex;
        verticalBoardIndex = myActionListener.verticalBoardIndex;
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

    static boolean horizontalVictory(String ticTacToePiece){
        for(int i = 0; i < 3; i++){
            if(checkHorizontalVictoryCoordinates(i, ticTacToePiece)){
                setBackgroundColorForHorizontalVictory(i);
                return true;
            }
        }
        return false;
    }

    private static boolean checkHorizontalVictoryCoordinates(int i, String ticTacToePiece){
        boolean top = UIButtonMatchesPiece(verticalBoardIndex, horizontalBoardIndex, i, ticTacToePiece);
        boolean middle = UIButtonMatchesPiece(verticalBoardIndex+1, horizontalBoardIndex, i, ticTacToePiece);
        boolean bottom = UIButtonMatchesPiece(verticalBoardIndex+2, horizontalBoardIndex, i, ticTacToePiece);

        return top && middle && bottom;
    }

    static boolean verticalVictory(String ticTacToePiece){
        for(int i = verticalBoardIndex; i < verticalBoardIndex+boardLength; i++){
            if(checkVerticalVictoryCoordinates(i, ticTacToePiece)){
                setBackgroundColorForVerticalVictory(i);
                return true;
            }
        }
        return false;
    }

    private static boolean checkVerticalVictoryCoordinates(int i, String ticTacToePiece){
        boolean left = UIButtonMatchesPiece(i, horizontalBoardIndex, 0, ticTacToePiece);
        boolean middle = UIButtonMatchesPiece(i, horizontalBoardIndex, 1, ticTacToePiece);
        boolean right = UIButtonMatchesPiece(i, horizontalBoardIndex, 2, ticTacToePiece);

        return left && middle && right;
    }

    static boolean diagonalVictory(String ticTacToePiece){

        if(checkDiagonalVictoryCoordinates(ticTacToePiece)){
            UI.boardButtons[verticalBoardIndex][horizontalBoardIndex][2].setBackground(Color.green);
            UI.boardButtons[verticalBoardIndex+1][horizontalBoardIndex][1].setBackground(Color.green);
            UI.boardButtons[verticalBoardIndex+2][horizontalBoardIndex][0].setBackground(Color.green);
            return true;
        }

        else if(checkDiagonalVictoryCoordinates(ticTacToePiece)){
            UI.boardButtons[verticalBoardIndex+2][horizontalBoardIndex][2].setBackground(Color.green);
            UI.boardButtons[verticalBoardIndex+1][horizontalBoardIndex][1].setBackground(Color.green);
            UI.boardButtons[verticalBoardIndex][horizontalBoardIndex][0].setBackground(Color.green);
            return true;
        }
        return false;
    }

    private static boolean checkDiagonalVictoryCoordinates(String ticTacToePiece){
        boolean bottomright = UIButtonMatchesPiece(verticalBoardIndex+2, horizontalBoardIndex, 2, ticTacToePiece);
        boolean middle = UIButtonMatchesPiece(verticalBoardIndex+1, horizontalBoardIndex, 1, ticTacToePiece);
        boolean topleft = UIButtonMatchesPiece(verticalBoardIndex, horizontalBoardIndex, 0, ticTacToePiece);
        boolean diagonalvictory1 = bottomright && middle && topleft;

        boolean topright = UIButtonMatchesPiece(verticalBoardIndex, horizontalBoardIndex, 2, ticTacToePiece);
        middle = UIButtonMatchesPiece(verticalBoardIndex+1, horizontalBoardIndex, 1, ticTacToePiece);
        boolean bottomleft = UIButtonMatchesPiece(verticalBoardIndex+2, horizontalBoardIndex, 0, ticTacToePiece);
        boolean diagonalvictory2 = topright && middle && bottomleft;

        return diagonalvictory1 || diagonalvictory2;
    }

    static boolean checkTieCondition(){
        return playingBoardIsFull() && !checkForWinCondition();
    }

    private static boolean playingBoardIsFull(){
        boolean result = true;
        for(int i = 0; i < UI.BOARD_HEIGHT; i++){
            for(int j = 0; j < UI.BOARD_COLUMNS; j++){
                for(int k = 0; k < UI.BOARD_SPACES; k++){
                    if(UI.boardButtons[i][j][k].isEnabled()){
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static boolean UIButtonMatchesPiece(int x, int y, int z, String ticTacToePiece){
        return UI.boardButtons[x][y][z].getText().matches(ticTacToePiece);
    }

    private static void setBackgroundColorForVerticalVictory(int horizontalIndex){
        UI.boardButtons[horizontalIndex][horizontalBoardIndex][0].setBackground(Color.green);
        UI.boardButtons[horizontalIndex][horizontalBoardIndex][1].setBackground(Color.green);
        UI.boardButtons[horizontalIndex][horizontalBoardIndex][2].setBackground(Color.green);
    }

    private static void setBackgroundColorForHorizontalVictory(int verticalIndex){
        UI.boardButtons[verticalBoardIndex][horizontalBoardIndex][verticalIndex].setBackground(Color.green);
        UI.boardButtons[verticalBoardIndex+1][horizontalBoardIndex][verticalIndex].setBackground(Color.green);
        UI.boardButtons[verticalBoardIndex+2][horizontalBoardIndex][verticalIndex].setBackground(Color.green);
    }

}
