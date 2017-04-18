import java.awt.*;

class UltimateTicTacToe {
    private static int verticalBoardIndex;
    private static int verticalCoordinate;
    private static int horizontalCoordinate;
    private static int zCoordinate;
    private static int enabledHorizontalIndex;
    private static int enabledVerticalIndex;
    private static int globalVerticalBoardIndex;

    static char[][] ultimateTicTacToeGame = new char[3][3];

    static void enableGameCoordinates(){
        initializeCoordinates();
        enabledVerticalIndex = getEnabledVerticalIndex();
        enabledHorizontalIndex = zCoordinate;
        globalVerticalBoardIndex = getGlobalVerticalBoardIndex();
        enableButtons();
    }

    private static int getEnabledVerticalIndex(){
        int index;
        if(verticalCoordinate == verticalBoardIndex){
            index = 0;
        }
        else if(verticalCoordinate == verticalBoardIndex+1){
            index = 3;
        }
        else{
            index = 6;
        }
        return index;
    }

    private static int getGlobalVerticalBoardIndex(){
        int globalVerticalBoardIndex;
        if(verticalBoardIndex == 0){
            globalVerticalBoardIndex = 0;
        }
        else if(verticalBoardIndex == 3){
            globalVerticalBoardIndex = 1;
        }
        else{
            globalVerticalBoardIndex = 2;
        }
        return globalVerticalBoardIndex;
    }


    private static void initializeCoordinates(){
        verticalBoardIndex = myActionListener.verticalBoardIndex;
        verticalCoordinate = myActionListener.verticalCoordinate;
        horizontalCoordinate = myActionListener.horizontalBoardIndex;
        zCoordinate  = myActionListener.zCoordinate;
    }

    private static void enableButtons() {
        for (int i = enabledVerticalIndex; i < enabledVerticalIndex + 3; i++) {
            for (int j = 0; j < 3; j++) {
                enableButton(i, enabledHorizontalIndex, j);
                }
            }
        enableButtonsTieCondition();
        }

    static void enableButtonsTieCondition(){
        if(!SpaceInBoard()) {
            for (int i = 0; i < UI.BOARD_HEIGHT; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        enableButton(i, j, k);
                    }
                }
            }
        }
    }

    private static void enableButton(int i, int j, int k) {
        if (UI.boardButtons[i][j][k].getText().equals("")) {
            UI.boardButtons[i][j][k].setEnabled(true);
            UI.boardButtons[i][j][k].setBackground(Color.white);
        }
    }

    static boolean SpaceInBoard(){
        for(int i = enabledVerticalIndex; i < enabledVerticalIndex+3; i++) {
            for (int k = 0; k < 3; k++) {
                if (UI.boardButtons[i][zCoordinate][k].getText().equals("")){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkForLocalVictory(){
        return checkForLocalOVictory() || checkForLocalXVictory();
    }

    private static boolean checkForLocalOVictory(){
        if(TicTacToe.checkForOWin()){
            setBoardToOVictory();
            ultimateTicTacToeGame[globalVerticalBoardIndex][horizontalCoordinate] = 'O';
            return true;
        }
        return false;
    }

    private static void setBoardToOVictory(){
        for(int i = verticalBoardIndex; i < verticalBoardIndex+3; i++){
            for(int k = 0; k < 3; k++){
                UI.boardButtons[i][horizontalCoordinate][k].setEnabled(false);
                UI.boardButtons[i][horizontalCoordinate][k].setBackground(Color.green);
                UI.boardButtons[i][horizontalCoordinate][k].setText("O");
            }
        }
    }

    private static boolean checkForLocalXVictory(){
        if(TicTacToe.checkForXWin()){
            setBoardToXVictory();
            ultimateTicTacToeGame[globalVerticalBoardIndex][horizontalCoordinate] = 'X';
            return true;
        }
        return false;
    }

    private static void setBoardToXVictory(){
        for(int i = verticalBoardIndex; i < verticalBoardIndex+3; i++){
            for(int k = 0; k < 3; k++){
                UI.boardButtons[i][horizontalCoordinate][k].setEnabled(false);
                UI.boardButtons[i][horizontalCoordinate][k].setBackground(Color.red);
                UI.boardButtons[i][horizontalCoordinate][k].setText("X");
            }
        }
    }

    static boolean checkForLocalTie(){
        return !SpaceInBoard() && !UltimateTicTacToeVictoryConditions.checkForWinCondition();
    }

    static void clearUltimateTicTacToeGame(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                ultimateTicTacToeGame[i][j] = ' ';
            }
        }
    }
}
