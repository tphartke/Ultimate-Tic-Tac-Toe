import javax.swing.*;
import java.awt.*;
import java.io.IOException;


class SecondPanel extends JFrame {

    private JFrame frame = new JFrame("Tic-Tac-Toe LeaderBoard");
    private static final int FRAME_HEIGHT = 700;
    private static final int FRAME_WIDTH = 1200;
    private JPanel panel = new JPanel(new BorderLayout());
    static JTextArea scoreboardData = new JTextArea();


    SecondPanel() {
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

    private void initialize() {
        addComponentsToPanel();
        frame.add(panel);
    }

    private void addComponentsToPanel() {
        addScoreboard();
        panel.add(scoreboardData);
        scoreboardData.setEditable(false);
    }

    private void addScoreboard() {
        try {
            scoreboardData.append(LeaderboardReader.scoreboardReader());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
