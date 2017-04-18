import javax.swing.*;

public class SecondPanel extends JFrame{
    private JTextArea playerScores;
    private JPanel panel1;

    private JFrame frame = new JFrame("Tic-Tac-Toe LeaderBoard");
    private static final int FRAME_HEIGHT = 700;
    private static final int FRAME_WIDTH = 1200;

    SecondPanel(){
        super();
        createFrame();
        frame.setVisible(true);
    }

    private void createFrame(){
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
