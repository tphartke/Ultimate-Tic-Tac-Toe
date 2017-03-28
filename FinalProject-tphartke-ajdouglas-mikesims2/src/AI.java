import java.util.Random;

public class AI {

    private Random sector = new Random();

    void doAITurn(){
        while(Turn.checkCurrentTurnPiece() == 'O'){
            int horizontal = horizontalOpening();
            int vertical = verticalOpening();
            int z = zOpening();
            AITurn(horizontal, vertical, z);
        }

    }

    private int horizontalOpening(){
        int minimum = 0;
        int maximum = 8;
        return sector.nextInt(maximum - minimum) + minimum;
    }

    private int verticalOpening(){
        int minimum = 0;
        int maximum = 2;
        return sector.nextInt(maximum - minimum) + minimum;
    }

    private int zOpening(){
        int minimum = 0;
        int maximum = 2;
        return sector.nextInt(maximum - minimum) + maximum;
    }

    private void AITurn(int horizontalOpening,int verticalOpening, int zOpening){
        UI.boardButtons[horizontalOpening][verticalOpening][zOpening].doClick();

    }

}
