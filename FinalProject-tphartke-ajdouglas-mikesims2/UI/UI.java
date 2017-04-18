import java.awt.*;
import javafx.scene.shape.Line;
import javax.swing.*;

class UI extends JFrame {
    static final int BOARD_HEIGHT = 9;
    static final int BOARD_COLUMNS = 3;
    static final int BOARD_SPACES = 3;
    static boolean playingAgainstAI;
    static TextArea outputField = new TextArea();
    static JButton[][][] boardButtons = new JButton[9][3][3];
    static JLabel player1Score = new JLabel("0");
    static JLabel player2Score = new JLabel("0");
    static JButton newGameButton = new JButton("New Game");
    static JButton AIGameButton = new JButton("Play vs. CPU");
    static JTextField player1Name = new JTextField("Player 1");
    static JTextField player2Name = new JTextField("Player 2");
    static JButton leaderboardButton = new JButton("Leaderboard");
    private static final int FRAME_HEIGHT = 700;
    private static final int FRAME_WIDTH = 1200;
    private JFrame frame = new JFrame("Tic-Tac-Toe");
    private JPanel playingBoard = new JPanel(new GridLayout(9, 9));
    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel Player1DisplayPanel = new JPanel(new BorderLayout());
    private JPanel player2DisplayPanel = new JPanel(new BorderLayout());
    private JPanel buttonsPanel = new JPanel(new BorderLayout());
    private JPanel gameActionStartPanel = new JPanel(new BorderLayout());

    UI() {
        this.createFrame();
        this.initialize();
        this.frame.setVisible(true);
    }

    private void createFrame() {
        this.frame.setSize(1200, 700);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    private void initialize() {
        this.initializePanel();
        this.initializeGameBoard();
        this.initializeStartButton();
        this.initializeAIButton();
        this.initializeScoreboard();
        this.initializeOutputfield();
        this.initializeLeaderboardButton();
        this.addComponentsToPanel();
        this.frame.add(this.panel);
    }

    private void addLines() {
        new Line((double)(boardButtons.length / 3), 0.0D, (double)(boardButtons.length / 3), 450.0D);
        new Line((double)(2 * boardButtons.length / 3), 0.0D, (double)(2 * boardButtons.length / 3), 450.0D);
        new Line(0.0D, 150.0D, (double)boardButtons.length, 150.0D);
        new Line(0.0D, 300.0D, (double)boardButtons.length, 300.0D);
    }

    private void initializePanel() {
        this.panel.setPreferredSize(new Dimension(800, 800));
        this.panel.setVisible(true);
    }

    private void initializeGameBoard() {
        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 3; ++j) {
                for(int k = 0; k < 3; ++k) {
                    this.initializeGameButton(i, j, k);
                }
            }
        }

    }

    private void initializeScoreboard() {
        this.Player1DisplayPanel.add(player1Name, "North");
        this.Player1DisplayPanel.add(player1Score, "Center");
        player1Score.setHorizontalAlignment(SwingConstants.CENTER);
        player1Score.setVerticalAlignment(SwingConstants.CENTER);
        this.Player1DisplayPanel.setPreferredSize(new Dimension(300, 100));
        this.Player1DisplayPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        this.player2DisplayPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        this.player2DisplayPanel.add(player2Name, "North");
        this.player2DisplayPanel.add(player2Score, "Center");
        player2Score.setHorizontalAlignment(SwingConstants.CENTER);
        player2Score.setVerticalAlignment(SwingConstants.CENTER);
        this.panel.add(this.Player1DisplayPanel, "West");
        this.panel.add(this.player2DisplayPanel, "Center");
    }

    private void addComponentsToPanel() {
        this.buttonsPanel.add(AIGameButton, "West");
        this.buttonsPanel.add(leaderboardButton, "East");
        this.panel.add(this.playingBoard, "North");
        this.panel.add(this.buttonsPanel, "South");
        this.panel.add(this.gameActionStartPanel, "East");
        this.gameActionStartPanel.add(outputField, "North");
        this.gameActionStartPanel.add(newGameButton, "Center");
    }

    private void initializeGameButton(int i, int j, int k) {
        boardButtons[i][j][k] = new JButton();
        boardButtons[i][j][k].setText("");
        boardButtons[i][j][k].setVisible(true);
        boardButtons[i][j][k].setPreferredSize(new Dimension(50, 50));
        boardButtons[i][j][k].setBackground(Color.white);
        boardButtons[i][j][k].addActionListener(new myActionListener());
        this.playingBoard.add(boardButtons[i][j][k]);
    }

    private void initializeStartButton() {
        newGameButton.addActionListener(new myActionListener());
        newGameButton.setPreferredSize(new Dimension(120, 60));
        this.panel.add(newGameButton, "South");
    }

    private void initializeOutputfield() {
        outputField.setPreferredSize(new Dimension(500, 100));
        outputField.setEditable(false);
    }

    private void initializeAIButton() {
        AIGameButton.addActionListener(new myActionListener());
    }

    private void initializeLeaderboardButton() {
        leaderboardButton.addActionListener(new myActionListener());
    }
}
