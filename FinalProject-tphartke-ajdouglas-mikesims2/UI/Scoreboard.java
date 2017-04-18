class Scoreboard {
    private static int Xscore = 0;
    private static int Oscore = 0;

    static void outputCurrentSessionScoring() {
        addScoreForXWin();
        addScoreForOWin();
    }

    private static void addScoreForXWin() {
        if (UltimateTicTacToeVictoryConditions.checkForXWin()) {
            Xscore += 1;
            UI.outputField.append("X score\t" + Xscore + "\t" + "O score\t" + Oscore + "\n");
            UI.player1Score.setText(String.valueOf(Xscore));
        }
    }

    private static void addScoreForOWin() {
        if (UltimateTicTacToeVictoryConditions.checkForOWin()) {
            Oscore += 1;
            UI.outputField.append("X score\t" + Xscore + "\t" + "O score\t" + Oscore + "\n");
            UI.player2Score.setText(String.valueOf(Oscore));
        }
    }
}

