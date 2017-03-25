import javafx.scene.shape.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.TextArea;

class UI extends JFrame {
    static int BOARD_HEIGHT = 9;
    static int BOARD_COLUMNS = 3;
    static final int BOARD_SPACES = 3;
    private JFrame frame = new JFrame("Tic-Tac-Toe");
    static JButton[][][] boardButtons = new JButton[BOARD_HEIGHT][BOARD_COLUMNS][BOARD_SPACES];
    static JButton newGameButton = new JButton("New Game");
    private static final int FRAME_HEIGHT = 700;
    private static final int FRAME_WIDTH = 1200;
    private JPanel playingBoard = new JPanel(new GridLayout(9, 9));
    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel Player1DisplayPanel = new JPanel(new BorderLayout());
    private JPanel player2DisplayPanel = new JPanel(new BorderLayout());
    private JPanel buttonsPanel = new JPanel(new BorderLayout());
    private JPanel gameActionStartPanel = new JPanel(new BorderLayout());
    private static JButton leaderboardButton = new JButton("Leaderboard");
    private static JButton GameFormatButton = new JButton("Ultimate TicTacToe");
    static TextArea outputField = new TextArea();
    static JButton AIGameButton = new JButton("Play vs. CPU");
    private static JLabel player1Name = new JLabel("Player 1");
    private static JLabel player2Name = new JLabel("Player 2");


    UI(){
        super();
        createFrame();
        initialize();
        frame.setVisible(true);
    }

    private void createFrame(){
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void initialize() {
        panel.setPreferredSize(new Dimension(800, 800));

        panel.setVisible(true);
        initializeGameBoard();
        initializeStartButton();

        buttonsPanel.add(AIGameButton, BorderLayout.WEST);
        buttonsPanel.add(leaderboardButton, BorderLayout.CENTER);
        buttonsPanel.add(GameFormatButton, BorderLayout.EAST);
        panel.add(playingBoard, BorderLayout.NORTH);
        panel.add(buttonsPanel, BorderLayout.SOUTH);

        Player1DisplayPanel.add(player1Name);
        player2DisplayPanel.add(player2Name);
        panel.add(Player1DisplayPanel, BorderLayout.WEST);
        panel.add(player2DisplayPanel, BorderLayout.CENTER);

        outputField.setPreferredSize(new Dimension(500,100));
        gameActionStartPanel.add(outputField, BorderLayout.NORTH);
        gameActionStartPanel.add(newGameButton, BorderLayout.CENTER);
        panel.add(gameActionStartPanel, BorderLayout.EAST);

        outputField.setEditable(false);
        frame.add(panel);
    }

    private void addLines(){
        Line line1 = new Line(boardButtons.length/3, 0, boardButtons.length/3, 450);
        Line line2 = new Line(2 * (boardButtons.length)/3, 0, 2 *(boardButtons.length)/3, 450);

        Line line3 = new Line(0, 150, boardButtons.length , 150);
        Line line4 = new Line(0, 300, boardButtons.length , 300);


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
        newGameButton.setPreferredSize(new Dimension(120, 80));
    }
}
