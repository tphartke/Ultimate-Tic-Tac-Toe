import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;

class LeaderboardReader{
    private Document document;

    LeaderboardReader(Document document) throws ParseException{
        this.document = document;
    }

    ArrayList<Player> readXML() throws ParseException{
        ArrayList<Player> playersList = new ArrayList<>();
        addPlayersToArrayList(playersList);
        return playersList;
    }

    private void addPlayersToArrayList(ArrayList<Player> playersList){
        NodeList players = document.getElementsByTagName("player");
        for(int i = 0; i < players.getLength(); i++){
            Element nPlayer = (Element)players.item(i);
            Player player = new Player(nPlayer.getAttribute("playerName"));
            playersList.add(player);

        }
    }

    String toString(ArrayList<Player> playersList){
        String result = "";
        for(Player player : playersList){
            result += player.toString();
        }
        return result;
    }

    private static final String FILENAME = "FinalProject-tphartke-ajdouglas-mikesims2/Files/leaderboardStorage.txt";
    static LinkedList<Player> playerList = new LinkedList<>();

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

