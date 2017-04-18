import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            Turn.turnNumber = 1;
            UltimateTicTacToe.clearUltimateTicTacToeGame();
            UI.outputField.append("\nNew game!\n");
            checkForNewPlayers();
        }

        else if(e.getSource() == UI.AIGameButton){
            clearGameBoard();
            Turn.turnNumber = 1;
            UI.playingAgainstAI = true;
            UI.player2Name.setText("AI");
            UI.outputField.append("Your play first!\n");

        }

        else if(e.getSource() == UI.leaderboardButton) {
            UI.createLeaderboardFrame();
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

    private void AITurn(){
        if(Turn.checkCurrentTurnPiece().equals("O")){
            AI.doAITurn();
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

    private void checkForNewPlayers(){
        Player player1 = new Player(UI.player1Name.getText());
        Player player2 = new Player(UI.player2Name.getText());

        if(LeaderboardReader.newPlayer(player1)){
            LeaderboardReader.playerList.add(player1);
            UI.outputField.append("Welcome " + player1.getName() + "!\n");
        }

        if(LeaderboardReader.newPlayer(player2)){
            LeaderboardReader.playerList.add(player2);
            UI.outputField.append("Welcome " + player2.getName() + "!\n");
        }
    }


}
