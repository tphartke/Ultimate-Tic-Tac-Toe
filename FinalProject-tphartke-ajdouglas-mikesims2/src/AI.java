import java.util.Random;

public class AI {

Random sector = new Random();

void doAITurn(){
    while(Turn.checkCurrentTurnPiece() == 'O'){
        int horizontal = horizontalOpening();
        int vertical = verticalOpening();
        AITurn(horizontal, vertical);
    }

}

public int horizontalOpening(){
        int minimum = 0;
        int maximum = 2;
        return sector.nextInt(maximum - minimum) + minimum;
    }

public int verticalOpening(){
        int minimum = 0;
        int maximum = 2;
        return sector.nextInt(maximum - minimum) + minimum;
    }

public void AITurn(int horizontalOpening,int verticalOpening){
        UI.boardButtons[horizontalOpening][verticalOpening].doClick();

}

}
