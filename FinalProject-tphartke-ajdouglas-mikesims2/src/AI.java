class AI {

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

}
