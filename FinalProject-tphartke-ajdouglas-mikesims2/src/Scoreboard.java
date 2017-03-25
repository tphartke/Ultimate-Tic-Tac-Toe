class Scoreboard {
    private static int Xscore = 0;
    private static int Oscore = 0;

    static void outputCurrentSessionScoring() {
        addScoreForXWin();
        addScoreForOWin();
        repeatScoreForTie();
    }

    private static void addScoreForXWin() {
        if (TicTacToe.checkForXWin()) {
            Xscore += 1;
            UI.outputField.append("X score\t" + Xscore + "\t" + "O score\t" + Oscore + "\n");
        }
    }

    private static void addScoreForOWin() {
        if (TicTacToe.checkForOWin()) {
            Oscore += 1;
            UI.outputField.append("X score\t" + Xscore + "\t" + "O score\t" + Oscore + "\n");
        }
    }
    private static void repeatScoreForTie() {
        if (TicTacToe.checkTieCondition()) {
            UI.outputField.append("X score\t" + Xscore + "\t" + "O score\t" + Oscore + "\n");
        }
    }
}
