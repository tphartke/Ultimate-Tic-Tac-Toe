
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LeaderboardReader {

    private static final String FILENAME = "FinalProject-tphartke-ajdouglas-mikesims2/Files/leaderboardStorage.txt";

    static String scoreboardReader() throws IOException {

        BufferedReader bufferedReader;

        String CurrentLine;
        bufferedReader = new BufferedReader(new FileReader(FILENAME));

        while ((CurrentLine = bufferedReader.readLine()) != null) {
            SecondPanel.scoreboardData.append(CurrentLine);
        }
        return "";
    }
}

