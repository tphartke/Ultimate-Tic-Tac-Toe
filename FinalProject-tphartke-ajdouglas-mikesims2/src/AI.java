class AI {

    void doAITurn(){
        int horizontal = (int)(Math.random()*9);
        int vertical = (int)(Math.random()*3);
        int z = (int)(Math.random()*3);
        while(!UI.boardButtons[horizontal][vertical][z].isEnabled()){
            horizontal = horizontalOpening();
            vertical = verticalOpening();
            z = zOpening();
            System.out.println(horizontal + " " + vertical + " " + z);
        }
        System.out.println(horizontal + " " + vertical + " " + z);
        AITurn(horizontal, vertical, z);
    }

    private int horizontalOpening(){
        return (int)(Math.random()*9);
    }

    private int verticalOpening(){
        return (int)(Math.random()*3);
    }

    private int zOpening(){
        return (int)(Math.random()*3);
    }

    private void AITurn(int horizontalOpening,int verticalOpening, int zOpening){
        UI.boardButtons[horizontalOpening][verticalOpening][zOpening].doClick();

    }

}
