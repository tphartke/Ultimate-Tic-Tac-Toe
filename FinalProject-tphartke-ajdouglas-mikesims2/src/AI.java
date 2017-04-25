class AI {
    private int verticalBoardIndex;
    private int horizontalBoardIndex;

    void doAITurn(){
        int vertical = (int)(Math.random()*9);
        int horizontal = (int)(Math.random()*3);
        int boardIndex = (int)(Math.random()*3);
        while(!UI.boardButtons[vertical][horizontal][boardIndex].isEnabled()){
            horizontal = horizontalOpening();
            vertical = verticalOpening();
            boardIndex = boardIndexOpening();
        }
        AITurn(horizontal, vertical, boardIndex);
    }

    private int verticalOpening(){
        return (int)(Math.random()*9);
    }

    private int horizontalOpening(){
        return (int)(Math.random()*3);
    }

    private int boardIndexOpening(){
        return (int)(Math.random()*3);
    }

    private void AITurn(int horizontalOpening,int verticalOpening, int boardIndexOpening){
        UI.boardButtons[verticalOpening][horizontalOpening][boardIndexOpening].doClick();

    }

    void mediumAI(){
        int randomChoice = (int)(Math.random()*2);
        if(randomChoice == 0){
            doAITurn();
        }
        else{
            hardAI();
        }
    }

    void hardAI(){
        verticalBoardIndex = myActionListener.verticalBoardIndex;
        horizontalBoardIndex = myActionListener.horizontalBoardIndex;
        if(!doHardAITurn()) {
            doAITurn();
        }
    }

    private boolean doHardAITurn(){
        if(checkHorizontalVictoryClose()){
            return true;
        }
        else if(checkVerticalVictoryClose()){
            return true;
        }
        else if(checkDiagonalVictoryClose()){
            return true;
        }
        else if(checkMiddleOfBoardAvailable()) {
            return true;
        }
        return false;
    }

    private boolean checkMiddleOfBoardAvailable(){
        if(UI.boardButtons[verticalBoardIndex+1][horizontalBoardIndex][1].isEnabled()){
            UI.boardButtons[verticalBoardIndex+1][horizontalBoardIndex][1].doClick();
            return true;
        }
        return false;
    }

    private boolean checkHorizontalVictoryClose(){
        for(int i = verticalBoardIndex; i < verticalBoardIndex+3; i++){
            if(checkHorizontalCoordinates(i, horizontalBoardIndex)){
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontalCoordinates(int i, int j){
        if(UIButtonMatchesPiece(i, j, 0) && UIButtonMatchesPiece(i, j, 1) && UI.boardButtons[i][j][2].isEnabled()){
         UI.boardButtons[i][j][2].doClick();
         return true;
        }
        else if(UIButtonMatchesPiece(i, j, 1) && UIButtonMatchesPiece(i, j, 2) && UI.boardButtons[i][j][0].isEnabled()){
            UI.boardButtons[i][j][0].doClick();
            return true;
        }
        else if(UIButtonMatchesPiece(i, j, 0) && UIButtonMatchesPiece(i, j, 2) && UI.boardButtons[i][j][1].isEnabled()){
            UI.boardButtons[i][j][1].doClick();
            return true;
        }
        return false;
    }

    private boolean checkVerticalVictoryClose(){
        for(int k = 0; k < 3; k++){
            if(checkVerticalCoordinates(verticalBoardIndex, horizontalBoardIndex, k)){
                return true;
            }
        }
        return false;
    }

    private boolean checkVerticalCoordinates(int i, int j, int k){
        if(UIButtonMatchesPiece(i, j, k) && UIButtonMatchesPiece(i+1, j, k) && UI.boardButtons[i+2][j][k].isEnabled()){
            UI.boardButtons[i+2][j][k].doClick();
            return true;
        }
        else if(UIButtonMatchesPiece(i, j, k) && UIButtonMatchesPiece(i+2, j, k) && UI.boardButtons[i+1][j][k].isEnabled()){
            UI.boardButtons[i+1][j][k].doClick();
            return true;
        }
        else if(UIButtonMatchesPiece(i+1, j, k) && UIButtonMatchesPiece(i+2, j, k) && UI.boardButtons[i][j][k].isEnabled()){
            UI.boardButtons[i][j][k].doClick();
            return true;
        }
        return false;
    }

    private boolean checkDiagonalVictoryClose(){
        boolean diagonal1 = checkDiagonalVictoryClose1(verticalBoardIndex, horizontalBoardIndex);
        boolean diagonal2 = checkDiagonalVictoryClose2(verticalBoardIndex, horizontalBoardIndex);
        return diagonal1 || diagonal2;
    }

    private boolean checkDiagonalVictoryClose1(int i, int j){
        if(UIButtonMatchesPiece(i, j, 0) && UIButtonMatchesPiece(i+1, j, 1) && UI.boardButtons[i+2][j][2].isEnabled()){
            UI.boardButtons[i+2][j][2].doClick();
            return true;
        }
        else if(UIButtonMatchesPiece(i, j, 0) && UIButtonMatchesPiece(i+2, j, 2) && UI.boardButtons[i+1][j][1].isEnabled()){
            UI.boardButtons[i+1][j][1].doClick();
            return true;
        }
        else if(UIButtonMatchesPiece(i+1, j, 1) && UIButtonMatchesPiece(i+2, j, 2) && UI.boardButtons[i][j][0].isEnabled()){
            UI.boardButtons[i][j][0].doClick();
            return true;
        }
        return false;
    }

    private boolean checkDiagonalVictoryClose2(int i, int j){
        if(UIButtonMatchesPiece(i, j, 2) && UIButtonMatchesPiece(i+1, j, 1) && UI.boardButtons[i+2][j][0].isEnabled()){
            UI.boardButtons[i+2][j][0].doClick();
            return true;
        }
        else if(UIButtonMatchesPiece(i, j, 2) && UIButtonMatchesPiece(i+2, j, 0) && UI.boardButtons[i+1][j][1].isEnabled()){
            UI.boardButtons[i+1][j][1].doClick();
            return true;
        }
        else if(UIButtonMatchesPiece(i+1, j, 1) && UIButtonMatchesPiece(i+2, j, 0) && UI.boardButtons[i][j][2].isEnabled()){
            UI.boardButtons[i][j][2].doClick();
            return true;
        }
        return false;
    }


    private boolean UIButtonMatchesPiece(int x, int y, int z) {
        return UI.boardButtons[x][y][z].getText().matches("O");
    }

}
