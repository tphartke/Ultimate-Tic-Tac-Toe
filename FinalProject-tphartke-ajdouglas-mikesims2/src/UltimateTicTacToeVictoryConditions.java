class UltimateTicTacToeVictoryConditions {
    private static int boardLength = 3;

    static boolean checkForWinCondition() {
        return checkForOWin() || checkForXWin();
    }

    static boolean checkForOWin() {
        if (verticalVictory('O')) {
            return true;
        } else if (horizontalVictory('O')) {
            return true;
        } else if (diagonalVictory('O')) {
            return true;
        }
        return false;
    }

    static boolean checkForXWin() {
        if (verticalVictory('X')) {
            return true;
        } else if (horizontalVictory('X')) {
            return true;
        } else if (diagonalVictory('X')) {
            return true;
        }
        return false;
    }

    private static boolean horizontalVictory(char ticTacToePiece) {
        for (int i = 0; i < boardLength; i++) {
            if (checkHorizontalVictoryCoordinates(i, ticTacToePiece)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkHorizontalVictoryCoordinates(int i, char ticTacToePiece) {
        boolean left = UIButtonMatchesPiece(i, 0, ticTacToePiece);
        boolean middle = UIButtonMatchesPiece(i, 1, ticTacToePiece);
        boolean right = UIButtonMatchesPiece(i, 2, ticTacToePiece);

        return left && middle && right;
    }

    private static boolean verticalVictory(char ticTacToePiece) {
        for (int i = 0; i < boardLength; i++) {
            if (checkVerticalVictoryCoordinates(i, ticTacToePiece)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkVerticalVictoryCoordinates(int i, char ticTacToePiece) {
        boolean top = UIButtonMatchesPiece(0, i, ticTacToePiece);
        boolean middle = UIButtonMatchesPiece(1, i, ticTacToePiece);
        boolean bottom = UIButtonMatchesPiece(2, i, ticTacToePiece);

        return top && middle && bottom;
    }

    private static boolean diagonalVictory(char ticTacToePiece) {
        return checkDiagonalVictoryCoordinates(ticTacToePiece);
    }

    private static boolean checkDiagonalVictoryCoordinates(char ticTacToePiece) {

        boolean bottomright = UIButtonMatchesPiece(2, 2, ticTacToePiece);
        boolean middle = UIButtonMatchesPiece(1, 1, ticTacToePiece);
        boolean topleft = UIButtonMatchesPiece(0, 0, ticTacToePiece);
        boolean diagonalvictory1 = bottomright && middle && topleft;

        boolean topright = UIButtonMatchesPiece(0, 2, ticTacToePiece);
        middle = UIButtonMatchesPiece(1, 1, ticTacToePiece);
        boolean bottomleft = UIButtonMatchesPiece(2, 0, ticTacToePiece);
        boolean diagonalvictory2 = topright && middle && bottomleft;

        return diagonalvictory1 || diagonalvictory2;
    }

    private static boolean UIButtonMatchesPiece(int x, int y, char ticTacToePiece) {
        return UltimateTicTacToe.ultimateTicTacToeGame[x][y] == ticTacToePiece;
    }
}

