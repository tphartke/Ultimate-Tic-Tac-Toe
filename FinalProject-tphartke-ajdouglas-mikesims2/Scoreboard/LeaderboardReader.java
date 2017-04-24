import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;

class LeaderboardReader{
    private static Document document;
    static int playerWins;
    static int playerLosses;

    LeaderboardReader(Document document) throws ParseException{
        LeaderboardReader.document = document;
    }

    static ArrayList<Player> readXML() throws ParseException{
        ArrayList<Player> playersList = new ArrayList<>();
        addPlayersToArrayList(playersList);
        return playersList;
    }

    private static void addPlayersToArrayList(ArrayList<Player> playersList){
        NodeList players = document.getElementsByTagName("player");
        for(int i = 0; i < players.getLength(); i++){
            Element nPlayer = (Element)players.item(i);
            playerWins = Integer.parseInt(nPlayer.getAttribute("wins"));
            playerLosses = Integer.parseInt(nPlayer.getAttribute("losses"));
            Player player = new Player(nPlayer.getAttribute("playerName"));
            System.out.println(playerWins + " " + playerLosses);
            playersList.add(player);

        }
    }

    String toString(ArrayList<Player> playersList){
        String result = "Player \t wins \t losses \t total games\n";
        for(Player player : playersList){
            result += player.toString();
        }
        return result;
    }


    static LinkedList<Player> playerList = new LinkedList<>();

    static boolean newPlayer(String playerName){
        for (Player aPlayer : playerList) {
            if (playerName.equals(aPlayer.getName())){
                return false;
            }
        }
        return true;
    }

    static void scoreboardReader() throws IOException {

    }
}

