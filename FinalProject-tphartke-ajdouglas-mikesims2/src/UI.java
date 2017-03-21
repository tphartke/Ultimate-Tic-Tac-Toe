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
    static TextArea outputField = new TextArea();

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
        panel.setPreferredSize(new Dimension(800, 800));
        panel.setVisible(true);
        initializeGameBoard();
        initializeStartButton();
        panel.add(playingBoard, BorderLayout.NORTH);
        outputField.setEditable(false);
        panel.add(outputField);
        frame.add(panel);
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
        newGameButton.setPreferredSize(new Dimension(120, 60));
        panel.add(newGameButton, BorderLayout.SOUTH);
    }
}
