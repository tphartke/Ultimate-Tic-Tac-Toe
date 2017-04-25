import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

class myActionListener implements ActionListener {
    private Turn turn;
    private AI AI;
    private String currentTurnPiece;
    static int verticalBoardIndex;
    static int horizontalBoardIndex;
    static int verticalCoordinate;
    static int zCoordinate;

    @Override
    public void actionPerformed(ActionEvent e) {
        turn = new Turn();
        AI = new AI();
        currentTurnPiece = String.valueOf(Turn.checkCurrentTurnPiece());
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
            UI.playingAgainstAI = false;
            UI.playingAgainstEasyAI = false;
            UI.playingAgainstMediumAI = false;
            UI.playingAgainstEasyAI = false;
            Turn.turnNumber = 1;
            UltimateTicTacToe.clearUltimateTicTacToeGame();
            UI.outputField.append("\nNew game!\n");
        }

        else if(e.getSource() == UI.AIGameMenu){
            AISetUp();
            UI.playingAgainstAI = true;
            UI.outputField.append("Your play first!\n");
        }
    }

    private void AISetUp(){
        clearGameBoard();
        Turn.turnNumber = 1;
        getAIDifficultySelected();
    }

    private void getAIDifficultySelected(){
        String difficultySelected = (String)UI.AIGameMenu.getSelectedItem();
        switch (difficultySelected) {
            case "Easy":
                UI.playingAgainstEasyAI = true;
                UI.player2Name.setText("Easy AI");
                break;
            case "Medium":
                UI.playingAgainstMediumAI = true;
                UI.player2Name.setText("Medium AI");
                break;
            case "Hard":
                UI.playingAgainstHardAI = true;
                UI.player2Name.setText("Hard AI");
                UI.outputField.append("Good Luck...\n");
                break;
            default:
                UI.playingAgainstAI = false;
                UI.player2Name.setText("Player 2");
                break;
        }
    }

    private void buttonPress(int x, int y, int z){
        setIndexes(x, y, z);
        UI.boardButtons[x][y][z].setText(currentTurnPiece);
        UI.boardButtons[x][y][z].setBackground(Color.blue);
        UI.outputField.append(Turn.getCurrentPlayer(currentTurnPiece) +" put " + currentTurnPiece + " in coordinate " + x + " " + y + " " + z + "\n");
        turn.gameIsWon();
        UI.boardButtons[x][y][z].setEnabled(false);
        Turn.turnNumber++;
        turn.checkForGlobalVictory();
        makeButtonsUnEnabled();
        if(!UltimateTicTacToeVictoryConditions.checkForWinCondition()){
            setUpForNextTurn();
        }
    }

    private void setUpForNextTurn(){
        turn.checkForGlobalTie();
        UltimateTicTacToe.enableGameCoordinates();
        UltimateTicTacToe.checkForLocalVictory();
        turn.gameIsTied();
        if(!UltimateTicTacToe.SpaceInBoard()){
            UltimateTicTacToe.enableButtonsTieCondition();
        }
        if(UI.playingAgainstAI){
            AITurn();
        }
    }

    private void doAIDifficultyTurn(){
        if(UI.playingAgainstEasyAI){
            AI.doAITurn();
        }
        else if(UI.playingAgainstMediumAI){
            AI.mediumAI();
        }
        else{
            AI.hardAI();
        }
    }

    private void AITurn(){
        if(Turn.checkCurrentTurnPiece().equals("O")){
            doAIDifficultyTurn();
        }
    }

    private void setIndexes(int x, int y, int z){
        verticalBoardIndex = boardFinder.findVerticalCoordinate(x);
        horizontalBoardIndex = y;
        verticalCoordinate = x;
        zCoordinate = z;
    }

    static void makeButtonsUnEnabled(){
        for(int i = 0; i < UI.BOARD_HEIGHT; i++){//iterate through the three dimensional array
            for(int j = 0; j < UI.BOARD_COLUMNS; j++){
                for(int k = 0; k < UI.BOARD_SPACES; k++){
                    if (UI.boardButtons[i][j][k].getText().equals("")){
                        UI.boardButtons[i][j][k].setEnabled(false);
                        UI.boardButtons[i][j][k].setBackground(Color.lightGray);
                    }
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
