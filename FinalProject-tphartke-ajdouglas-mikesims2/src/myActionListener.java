import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class myActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        TicTacToe currentGame = new TicTacToe();
        Turn turn = new Turn();
        String currentTurnPiece = String.valueOf(turn.checkCurrentTurnPiece());
        char turnPiece = turn.checkCurrentTurnPiece();

        if(e.getSource() == UI.boardButtons[0][0]){
            UI.boardButtons[0][0].setText(currentTurnPiece);
            currentGame.writeMoveToPlayingBoard(0, 0, turnPiece);
            turn.turnNumber++;
            turn.gameIsFinished();
            UI.boardButtons[0][0].setEnabled(false);
        }

        else if(e.getSource() == UI.boardButtons[0][1]){
            UI.boardButtons[0][1].setText(currentTurnPiece);
            currentGame.writeMoveToPlayingBoard(0, 1, turnPiece);
            turn.turnNumber++;
            turn.gameIsFinished();
            UI.boardButtons[0][1].setEnabled(false);
        }

        else if(e.getSource() == UI.boardButtons[0][2]){
            UI.boardButtons[0][2].setText(currentTurnPiece);
            currentGame.writeMoveToPlayingBoard(0, 2, turnPiece);
            turn.turnNumber++;
            turn.gameIsFinished();
            UI.boardButtons[0][2].setEnabled(false);
        }

        else if(e.getSource() == UI.boardButtons[1][0]){
            UI.boardButtons[1][0].setText(currentTurnPiece);
            currentGame.writeMoveToPlayingBoard(1, 0, turnPiece);
            turn.turnNumber++;
            turn.gameIsFinished();
            UI.boardButtons[1][0].setEnabled(false);
        }

        else if(e.getSource() == UI.boardButtons[1][1]){
            UI.boardButtons[1][1].setText(currentTurnPiece);
            currentGame.writeMoveToPlayingBoard(1, 1, turnPiece);
            turn.turnNumber++;
            turn.gameIsFinished();
            UI.boardButtons[1][1].setEnabled(false);
        }

        else if(e.getSource() == UI.boardButtons[1][2]){
            UI.boardButtons[1][2].setText(currentTurnPiece);
            currentGame.writeMoveToPlayingBoard(1, 2, turnPiece);
            turn.turnNumber++;
            turn.gameIsFinished();
            UI.boardButtons[1][2].setEnabled(false);
        }

        else if(e.getSource() == UI.boardButtons[2][0]){
            UI.boardButtons[2][0].setText(currentTurnPiece);
            currentGame.writeMoveToPlayingBoard(2, 0, turnPiece);
            turn.turnNumber++;
            turn.gameIsFinished();
            UI.boardButtons[2][0].setEnabled(false);
        }

        else if(e.getSource() == UI.boardButtons[2][1]){
            UI.boardButtons[2][1].setText(currentTurnPiece);
            currentGame.writeMoveToPlayingBoard(2, 1, turnPiece);
            turn.turnNumber++;
            turn.gameIsFinished();
            UI.boardButtons[2][1].setEnabled(false);
        }

        else if(e.getSource() == UI.boardButtons[2][2]){
            UI.boardButtons[2][2].setText(currentTurnPiece);
            currentGame.writeMoveToPlayingBoard(2, 2, turnPiece);
            turn.turnNumber++;
            turn.gameIsFinished();
            UI.boardButtons[2][2].setEnabled(false);
        }
    }
}
