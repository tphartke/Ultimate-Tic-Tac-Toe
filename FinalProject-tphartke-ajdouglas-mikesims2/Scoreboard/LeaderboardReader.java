import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

class LeaderboardReader{

    private static final String FILENAME = "FinalProject-tphartke-ajdouglas-mikesims2/Files/leaderboardStorage.txt";
    static LinkedList<Player> playerList = new LinkedList<>();

    static void scoreboardReader() throws IOException {
        BufferedReader bufferedReader;
        String CurrentLine;
        bufferedReader = new BufferedReader(new FileReader(FILENAME));

        while ((CurrentLine = bufferedReader.readLine()) != null) {
            Player player = new Player(CurrentLine);
            playerList.add(player);
            SecondPanel.scoreboardData.append(player.toString());
        }
    }

    static boolean newPlayer(Player player){
        for (Player aPlayer : playerList) {
            if (player.getName().equals(aPlayer.getName())){
                return false;
            }
        }
        return true;
    }

    LinkedList<Player> createNewPlayer(String playerName){
        playerList.add(new Player(playerName));
        return playerList;
    }
}

