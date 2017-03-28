import java.awt.*;

class UltimateTicTacToe {
    private static int verticalBoardIndex;
    private static int verticalCoordinate;
    private static int zCoordinate;
    private static int enabledHorizontalIndex;
    private static int enabledVerticalIndex;

    static void enableGameCoordinates(){
        initializeCoordinates();
        enabledVerticalIndex = getEnabledVerticalIndex();
        enabledHorizontalIndex = zCoordinate;
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

    private static void initializeCoordinates(){
        verticalBoardIndex = myActionListener.verticalBoardIndex;
        verticalCoordinate = myActionListener.verticalCoordinate;
        zCoordinate  = myActionListener.zCoordinate;
    }

    private static void enableButtons(){
        for(int i = enabledVerticalIndex; i < enabledVerticalIndex + 3; i++){
            for(int j = 0; j < 3; j++){
                UI.boardButtons[i][enabledHorizontalIndex][j].setEnabled(true);
                UI.boardButtons[i][enabledHorizontalIndex][j].setBackground(Color.white);
            }
        }
    }
}
