import javax.swing.*;
import java.awt.*;
import java.awt.TextArea;

class UI extends JFrame {
    private JFrame frame = new JFrame("Tic-Tac-Toe");
    static JButton[][] boardButtons = new JButton[3][3];
    static JButton newGameButton = new JButton("New Game");
    private static final int FRAME_HEIGHT = 500;
    private static final int FRAME_WIDTH = 500;
    private JPanel playingBoard = new JPanel(new GridLayout(3, 3));
    private JPanel panel = new JPanel(new BorderLayout());
    static TextArea outputField = new TextArea();

    UI(){
        super();
        createFrame();
        initialize();
    }

    private void createFrame(){
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void initialize() {
        panel.setPreferredSize(new Dimension(450, 450));
        panel.setVisible(true);
        initializeGameBoard();
        initializeStartButton();
        panel.add(playingBoard, BorderLayout.NORTH);
        outputField.setEditable(false);
        panel.add(outputField);
        frame.add(panel);
    }

    private void initializeGameBoard(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                boardButtons[i][j] = new JButton();
                boardButtons[i][j].setText("");
                boardButtons[i][j].setVisible(true);
                boardButtons[i][j].setPreferredSize(new Dimension(150, 100));

                playingBoard.add(boardButtons[i][j]);
                boardButtons[i][j].addActionListener(new myActionListener());
            }
        }
    }

    private void initializeStartButton(){
        newGameButton.addActionListener(new myActionListener());
        newGameButton.setPreferredSize(new Dimension(150, 75));
        panel.add(newGameButton, BorderLayout.SOUTH);
    }
}
