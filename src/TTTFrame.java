import javax.swing.*;
import java.awt.*;

public class TTTFrame extends JFrame {
    private final TTTTileButton[][] boardButtons = new TTTTileButton[3][3];
    private final TTTGame game = new TTTGame();

    public TTTFrame() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ----- CENTER PANEL: Game Board -----
        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        Font tileFont = new Font("SansSerif", Font.BOLD, 48);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                TTTTileButton button = new TTTTileButton(row, col);
                button.setFont(tileFont);
                button.addActionListener(e -> {
                    if (button.getText().isEmpty() && !game.isGameOver()) {
                        game.makeMove(button.getRow(), button.getCol());
                        button.setText(game.getCurrentPlayer());

                        if (game.checkWin()) {
                            JOptionPane.showMessageDialog(this,
                                    "Player " + game.getCurrentPlayer() + " wins!",
                                    "Game Over",
                                    JOptionPane.INFORMATION_MESSAGE);
                            game.setGameOver(true);
                        } else if (game.isBoardFull()) {
                            JOptionPane.showMessageDialog(this,
                                    "It's a tie!",
                                    "Game Over",
                                    JOptionPane.INFORMATION_MESSAGE);
                            game.setGameOver(true);
                        } else {
                            game.switchPlayer();
                        }
                    }
                });
                boardButtons[row][col] = button;
                boardPanel.add(button);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        // ----- SOUTH PANEL: Buttons -----
        JPanel controlPanel = new JPanel(new FlowLayout());

        JButton newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        newGameButton.addActionListener(e -> {
            game.resetGame();
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    boardButtons[r][c].setText("");
                }
            }
        });

        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        quitButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to quit?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION
            );
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        controlPanel.add(newGameButton);
        controlPanel.add(quitButton);
        add(controlPanel, BorderLayout.SOUTH);
    }
}
