import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

class SecondPanel extends JFrame {

    private JFrame frame = new JFrame("Tic-Tac-Toe LeaderBoard");
    private static final int FRAME_HEIGHT = 700;
    private static final int FRAME_WIDTH = 1200;
    private JPanel panel = new JPanel(new BorderLayout());
    static JTextArea scoreboardData = new JTextArea();


    SecondPanel() throws ParserConfigurationException, SAXException, ParseException, IOException {
        super();
        createFrame();
        initialize();
        frame.setVisible(true);
    }

    private void createFrame() {
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void initialize() throws ParserConfigurationException, SAXException, ParseException, IOException {
        addComponentsToPanel();
        frame.add(panel);
    }

    private void addComponentsToPanel() throws ParserConfigurationException, SAXException, ParseException, IOException {
        addScoreboard();
        addPlayerDataToPanel();
        panel.add(scoreboardData);
        scoreboardData.setEditable(false);
    }

    private void addPlayerDataToPanel() throws ParserConfigurationException, SAXException, IOException, ParseException {
        UI.parser = new LeaderboardParser();
        UI.reader = new LeaderboardReader(UI.parser.getDocument());
        UI.playersList = UI.reader.readXML();
        scoreboardData.append(UI.reader.toString(UI.playersList));
    }

    private void addScoreboard() {
        scoreboardData.append(LeaderboardReader.playerList.toString());
    }
}
