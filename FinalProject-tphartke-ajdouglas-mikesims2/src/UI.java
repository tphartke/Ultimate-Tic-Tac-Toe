import javafx.scene.shape.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.TextArea;

class UI extends JFrame {
    static final int BOARD_HEIGHT = 9;
    static final int BOARD_COLUMNS = 3;
    static final int BOARD_SPACES = 3;
    static boolean playingAgainstAI;
    static TextArea outputField = new TextArea();
    static JButton[][][] boardButtons = new JButton[BOARD_HEIGHT][BOARD_COLUMNS][BOARD_SPACES];
    static JLabel player1Score = new JLabel("0");
    static JLabel player2Score = new JLabel("0");
    static JButton newGameButton = new JButton("New Game");
    static JButton AIGameButton = new JButton("Play vs. CPU");

    private static JButton leaderboardButton = new JButton("Leaderboard");
    private static JTextField player1Name = new JTextField("Player 1");
    private static JTextField player2Name = new JTextField("Player 2");
    private static final int FRAME_HEIGHT = 700;
    private static final int FRAME_WIDTH = 1200;

    private JFrame frame = new JFrame("Tic-Tac-Toe");
    private JPanel playingBoard = new JPanel(new GridLayout(9, 9));
    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel Player1DisplayPanel = new JPanel(new BorderLayout());
    private JPanel player2DisplayPanel = new JPanel(new BorderLayout());
    private JPanel buttonsPanel = new JPanel(new BorderLayout());
    private JPanel gameActionStartPanel = new JPanel(new BorderLayout());

    UI(){
        super();
        createFrame();
        initialize();
        frame.setVisible(true);
    }

    private void createFrame(){
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void initialize() {
        initializePanel();
        initializeGameBoard();
        initializeStartButton();
        initializeAIButton();
        initializeScoreboard();
        initializeOutputfield();
        addComponentsToPanel();
        frame.add(panel);
    }

    private void addLines(){
        Line line1 = new Line(boardButtons.length/3, 0, boardButtons.length/3, 450);
        Line line2 = new Line(2 * (boardButtons.length)/3, 0, 2 *(boardButtons.length)/3, 450);

        Line line3 = new Line(0, 150, boardButtons.length , 150);
        Line line4 = new Line(0, 300, boardButtons.length , 300);
    }

    private void initializePanel(){
        panel.setPreferredSize(new Dimension(800, 800));
        panel.setVisible(true);
    }
    private void initializeGameBoard(){
        for (int i = 0; i < BOARD_HEIGHT; i++){
            for (int j = 0; j < BOARD_COLUMNS; j++){
                for(int k = 0; k < BOARD_SPACES; k++){
                    initializeGameButton(i, j, k);
                }
            }
        }
    }

    private void initializeScoreboard(){
        Player1DisplayPanel.add(player1Name, BorderLayout.NORTH);
        Player1DisplayPanel.add(player1Score, BorderLayout.CENTER);
        player1Score.setHorizontalAlignment(SwingConstants.CENTER);
        player1Score.setVerticalAlignment(SwingConstants.CENTER);

        Player1DisplayPanel.setPreferredSize(new Dimension(300, 100));
        Player1DisplayPanel.setBorder(BorderFactory.createEmptyBorder(15,10,10,10));
        player2DisplayPanel.setBorder(BorderFactory.createEmptyBorder(15,10,10,10));

        player2DisplayPanel.add(player2Name, BorderLayout.NORTH);
        player2DisplayPanel.add(player2Score, BorderLayout.CENTER);
        player2Score.setHorizontalAlignment(SwingConstants.CENTER);
        player2Score.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(Player1DisplayPanel, BorderLayout.WEST);
        panel.add(player2DisplayPanel, BorderLayout.CENTER);
    }

    private void addComponentsToPanel(){
        buttonsPanel.add(AIGameButton, BorderLayout.WEST);
        buttonsPanel.add(leaderboardButton, BorderLayout.EAST);
        panel.add(playingBoard, BorderLayout.NORTH);
        panel.add(buttonsPanel, BorderLayout.SOUTH);
        panel.add(gameActionStartPanel, BorderLayout.EAST);
        gameActionStartPanel.add(outputField, BorderLayout.NORTH);
        gameActionStartPanel.add(newGameButton, BorderLayout.CENTER);

    }
    private void initializeGameButton(int i, int j, int k){
        boardButtons[i][j][k] = new JButton();
        boardButtons[i][j][k].setText("");
        boardButtons[i][j][k].setVisible(true);
        boardButtons[i][j][k].setPreferredSize(new Dimension(50, 50));
        boardButtons[i][j][k].setBackground(Color.white);
        boardButtons[i][j][k].addActionListener(new myActionListener());
        playingBoard.add(boardButtons[i][j][k]);
    }

    private void initializeStartButton(){
        newGameButton.addActionListener(new myActionListener());
        newGameButton.setPreferredSize(new Dimension(120, 60));
        panel.add(newGameButton, BorderLayout.SOUTH);
    }

    private void initializeOutputfield(){
        outputField.setPreferredSize(new Dimension(500,100));
        outputField.setEditable(false);
    }

    private void initializeAIButton(){
        AIGameButton.addActionListener(new myActionListener());
    }
}
