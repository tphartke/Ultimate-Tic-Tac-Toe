import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class myActionListener implements ActionListener {
    private Turn turn;
    private String currentTurnPiece;

    @Override
    public void actionPerformed(ActionEvent e) {
        turn = new Turn();
        currentTurnPiece = String.valueOf(turn.checkCurrentTurnPiece());

        if(e.getSource() == UI.boardButtons[0][0]){
            buttonPress(0, 0);
        }

        else if(e.getSource() == UI.boardButtons[0][1]){
            buttonPress(0, 1);
        }

        else if(e.getSource() == UI.boardButtons[0][2]){
            buttonPress(0, 2);
        }

        else if(e.getSource() == UI.boardButtons[1][0]){
            buttonPress(1, 0);
        }

        else if(e.getSource() == UI.boardButtons[1][1]){
            buttonPress(1, 1);
        }

        else if(e.getSource() == UI.boardButtons[1][2]){
            buttonPress(1, 2);
        }

        else if(e.getSource() == UI.boardButtons[2][0]){
            buttonPress(2, 0);
        }

        else if(e.getSource() == UI.boardButtons[2][1]){
            buttonPress(2, 1);
        }

        else if(e.getSource() == UI.boardButtons[2][2]){
           buttonPress(2, 2);
        }
        else if(e.getSource() == UI.newGameButton){
            clearGameBoard();
            Turn.turnNumber = 1;
            UI.outputField.append("New game!\n");

        }
    }
    private void buttonPress(int x, int y){
        UI.boardButtons[x][y].setText(currentTurnPiece);
        UI.outputField.append("Put " + currentTurnPiece + " in column " + (y+1) + " row " + (x+1) + ".\n");
        Turn.turnNumber++;
        makeButtonsUnEnabled();
        UI.boardButtons[x][y].setEnabled(false);
    }
    private void makeButtonsUnEnabled(){
        if(turn.gameIsFinished()){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    UI.boardButtons[i][j].setEnabled(false);
                }
            }
        }
    }

    private void clearGameBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                UI.boardButtons[i][j].setText("");
                UI.boardButtons[i][j].setEnabled(true);
            }
        }
    }
}
