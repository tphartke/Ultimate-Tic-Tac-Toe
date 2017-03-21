import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class myActionListener implements ActionListener {
    private Turn turn;
    private String currentTurnPiece;

    @Override
    public void actionPerformed(ActionEvent e) {
        turn = new Turn();
        currentTurnPiece = String.valueOf(turn.checkCurrentTurnPiece());
        for(int i = 0; i < UI.BOARD_HEIGHT; i++){//iterate through the three dimensional array
            for(int j = 0; j < UI.BOARD_COLUMNS; j++){
                for(int k = 0; k < UI.BOARD_SPACES; k++){
                    if(e.getSource() == UI.boardButtons[i][j][k]){
                        buttonPress(i, j, k);
                    }
                }
            }
        }

        if(e.getSource() == UI.newGameButton){
            clearGameBoard();
            Turn.turnNumber = 1;
            UI.outputField.append("\nNew game!\n");
        }

    }
    private void buttonPress(int x, int y, int z){
        UI.boardButtons[x][y][z].setText(currentTurnPiece);
        //UI.outputField.append("Put " + currentTurnPiece + " in board " + (z+1) + " column " + (y+1) + " row " + (x+1) + ".\n");
        UI.outputField.append(x + " " + y + " " + z + "\n");
        turn.gameIsWon();
        UI.boardButtons[x][y][z].setEnabled(false);
        Turn.turnNumber++;
        turn.gameIsTied();
    }

    static void makeButtonsUnEnabled(){
        for(int i = 0; i < UI.BOARD_HEIGHT; i++){//iterate through the three dimensional array
            for(int j = 0; j < UI.BOARD_COLUMNS; j++){
                for(int k = 0; k < UI.BOARD_SPACES; k++){
                    UI.boardButtons[i][j][k].setEnabled(false);
                    UI.boardButtons[i][j][k].setBackground(Color.lightGray);
                }
            }
        }
    }

    void clearGameBoard(){
        for(int i = 0; i < UI.BOARD_HEIGHT; i++){//iterate through the three dimensional array
            for(int j = 0; j < UI.BOARD_COLUMNS; j++){
                for(int k = 0; k < UI.BOARD_SPACES; k++){
                    clearButton(i, j, k);
                }
            }
        }
    }

    private void clearButton(int horizontalIndex, int verticalIndex, int boardIndex){
        UI.boardButtons[horizontalIndex][verticalIndex][boardIndex].setText("");
        UI.boardButtons[horizontalIndex][verticalIndex][boardIndex].setEnabled(true);
        UI.boardButtons[horizontalIndex][verticalIndex][boardIndex].setBackground(Color.white);
    }
}
