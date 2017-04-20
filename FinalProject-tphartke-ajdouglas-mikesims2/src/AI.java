class AI {
    private int verticalBoardIndex = myActionListener.verticalBoardIndex;
    private int horizontalBoardIndex = myActionListener.horizontalBoardIndex;
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

    private void hardAI(){
        checkMiddleOfBoardAvailable();
        checkHorizontalVictoryClose();
        checkVerticalVictoryClose();
        checkDiagonalVictoryClose();
        doAITurn();
    }
    private void checkMiddleOfBoardAvailable(){
        if(UI.boardButtons[verticalBoardIndex+1][horizontalBoardIndex][1].isEnabled()){
            UI.boardButtons[verticalBoardIndex+1][horizontalBoardIndex][1].doClick();
        }
    }

    private void checkHorizontalVictoryClose(){
        for(int i = verticalBoardIndex; i < verticalBoardIndex+3; i++){
            checkHorizontalCoordinates(i, horizontalBoardIndex);
        }
    }

    private void checkHorizontalCoordinates(int i, int j){
        if(UIButtonMatchesPiece(i, j, 0) && UIButtonMatchesPiece(i, j, 1) && UI.boardButtons[i][j][2].isEnabled()){
         UI.boardButtons[i][j][2].doClick();
        }
        else if(UIButtonMatchesPiece(i, j, 1) && UIButtonMatchesPiece(i, j, 2) && UI.boardButtons[i][j][0].isEnabled()){
            UI.boardButtons[i][j][0].doClick();
        }
        else if(UIButtonMatchesPiece(i, j, 0) && UIButtonMatchesPiece(i, j, 2) && UI.boardButtons[i][j][1].isEnabled()){
            UI.boardButtons[i][j][1].doClick();
        }
    }

    private void checkVerticalVictoryClose(){
        for(int k = 0; k < 3; k++){
            checkVerticalCoordinates(verticalBoardIndex, horizontalBoardIndex, k);
        }
    }

    private void checkVerticalCoordinates(int i, int j, int k){
        if(UIButtonMatchesPiece(i, j, k) && UIButtonMatchesPiece(i+1, j, k) && UI.boardButtons[i+2][j][k].isEnabled()){
            UI.boardButtons[i+2][j][k].doClick();
        }
        else if(UIButtonMatchesPiece(i, j, k) && UIButtonMatchesPiece(i+2, j, k) && UI.boardButtons[i+1][j][k].isEnabled()){
            UI.boardButtons[i+1][j][k].doClick();
        }
        else if(UIButtonMatchesPiece(i+1, j, k) && UIButtonMatchesPiece(i+2, j, k) && UI.boardButtons[i][j][k].isEnabled()){
            UI.boardButtons[i][j][k].doClick();
        }
    }

    private void checkDiagonalVictoryClose(){
        checkDiagonalVictoryClose1(verticalBoardIndex, horizontalBoardIndex);
        checkDiagonalVictoryClose2(verticalBoardIndex, horizontalBoardIndex);
    }
    private void checkDiagonalVictoryClose1(int i, int j){
        if(UIButtonMatchesPiece(i, j, 0) && UIButtonMatchesPiece(i+1, j, 1) && UI.boardButtons[i+2][j][2].isEnabled()){
            UI.boardButtons[i+2][j][2].doClick();
        }
        else if(UIButtonMatchesPiece(i, j, 0) && UIButtonMatchesPiece(i+2, j, 2) && UI.boardButtons[i+1][j][1].isEnabled()){
            UI.boardButtons[i+1][j][1].doClick();
        }
        else if(UIButtonMatchesPiece(i+1, j, 1) && UIButtonMatchesPiece(i+2, j, 2) && UI.boardButtons[i][j][0].isEnabled()){
            UI.boardButtons[i][j][0].doClick();
        }
    }
    private void checkDiagonalVictoryClose2(int i, int j){
        if(UIButtonMatchesPiece(i, j, 2) && UIButtonMatchesPiece(i+1, j, 1) && UI.boardButtons[i+2][j][0].isEnabled()){
            UI.boardButtons[i+2][j][0].doClick();
        }
        else if(UIButtonMatchesPiece(i, j, 2) && UIButtonMatchesPiece(i+2, j, 0) && UI.boardButtons[i+1][j][1].isEnabled()){
            UI.boardButtons[i+1][j][1].doClick();
        }
        else if(UIButtonMatchesPiece(i+1, j, 1) && UIButtonMatchesPiece(i+2, j, 0) && UI.boardButtons[i][j][2].isEnabled()){
            UI.boardButtons[i][j][2].doClick();
        }
    }


    private boolean UIButtonMatchesPiece(int x, int y, int z) {
        return UI.boardButtons[x][y][z].getText().matches("O");
    }

}
