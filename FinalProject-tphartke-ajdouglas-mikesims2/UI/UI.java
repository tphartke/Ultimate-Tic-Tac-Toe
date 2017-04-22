import java.awt.*;
import java.io.IOException;
import javax.swing.*;

class UI extends JFrame {
    static final int BOARD_HEIGHT = 9;
    static final int BOARD_COLUMNS = 3;
    static final int BOARD_SPACES = 3;

    static boolean playingAgainstAI;
    static boolean playingAgainstEasyAI;
    static boolean playingAgainstMediumAI;
    static boolean playingAgainstHardAI;
    static TextArea outputField = new TextArea();
    static JButton[][][] boardButtons = new JButton[9][3][3];
    static JLabel player1Score = new JLabel("0");
    static JLabel player2Score = new JLabel("0");
    static JButton newGameButton = new JButton("New Game");
    static JTextField player1Name = new JTextField("Player 1");
    static JTextField player2Name = new JTextField("Player 2");
    static JButton leaderboardButton = new JButton("Leaderboard");

    private static String[] AIDifficultyStrings = {"Select AI Difficulties", "Easy", "Medium", "Hard"};
    static JComboBox<String> AIGameMenu = new JComboBox<>(AIDifficultyStrings);

    private JFrame frame = new JFrame("Tic-Tac-Toe");
    private JPanel playingBoard = new JPanel(new GridLayout(9, 9));
    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel Player1DisplayPanel = new JPanel(new BorderLayout());
    private JPanel player2DisplayPanel = new JPanel(new BorderLayout());
    private JPanel buttonsPanel = new JPanel(new BorderLayout());
    private JPanel gameActionStartPanel = new JPanel(new BorderLayout());

    UI() throws IOException {
        createFrame();
        initialize();
        frame.setVisible(true);
    }

    private void createFrame() {
        frame.setSize(1200, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void initialize() throws IOException {
        initializePanel();
        initializeButtons();
        initializeOutputfield();
        addComponentsToPanel();
        frame.add(panel);
    }

    private void initializeButtons() throws IOException {
        initializeGameBoard();
        initializeStartButton();
        initializeAIMenu();
        initializeScoreboard();
        initializeLeaderboardButton();
    }

    private void initializePanel() {
        panel.setPreferredSize(new Dimension(800, 800));
        panel.setVisible(true);
    }

    private void initializeGameBoard() {
        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 3; ++j) {
                for(int k = 0; k < 3; ++k) {
                    initializeGameButton(i, j, k);
                }
            }
        }
    }

    private void initializeScoreboard() throws IOException {
        LeaderboardReader.scoreboardReader();
        initializePlayerDisplayPanels();
        player1Score.setHorizontalAlignment(SwingConstants.CENTER);
        player1Score.setVerticalAlignment(SwingConstants.CENTER);
        player2Score.setHorizontalAlignment(SwingConstants.CENTER);
        player2Score.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(Player1DisplayPanel, "West");
        panel.add(player2DisplayPanel, "Center");
    }

    private void initializePlayerDisplayPanels(){
        Player1DisplayPanel.add(player1Name, "North");
        Player1DisplayPanel.add(player1Score, "Center");
        Player1DisplayPanel.setPreferredSize(new Dimension(300, 100));
        Player1DisplayPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        player2DisplayPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        player2DisplayPanel.add(player2Name, "North");
        player2DisplayPanel.add(player2Score, "Center");
    }

    private void addComponentsToPanel() {
        buttonsPanel.add(AIGameMenu, "West");
        buttonsPanel.add(leaderboardButton, "East");
        panel.add(this.playingBoard, "North");
        panel.add(this.buttonsPanel, "South");
        panel.add(this.gameActionStartPanel, "East");
        gameActionStartPanel.add(outputField, "North");
        gameActionStartPanel.add(newGameButton, "Center");
    }

    private void initializeGameButton(int i, int j, int k) {
        boardButtons[i][j][k] = new JButton();
        boardButtons[i][j][k].setText("");
        boardButtons[i][j][k].setVisible(true);
        boardButtons[i][j][k].setPreferredSize(new Dimension(50, 50));
        boardButtons[i][j][k].setBackground(Color.white);
        boardButtons[i][j][k].addActionListener(new myActionListener());
        playingBoard.add(boardButtons[i][j][k]);
    }

    private void initializeStartButton() {
        newGameButton.addActionListener(new myActionListener());
        newGameButton.setPreferredSize(new Dimension(120, 60));
        panel.add(newGameButton, "South");
    }

    private void initializeOutputfield() {
        outputField.setPreferredSize(new Dimension(500, 100));
        outputField.setEditable(false);
    }

    private void initializeAIMenu() {
        AIGameMenu.addActionListener(new myActionListener());
    }

    private void initializeLeaderboardButton() {
        leaderboardButton.addActionListener(new myActionListener());
    }

    static void createLeaderboardFrame() {
        new SecondPanel();
    }

}
