import javax.swing.JPanel;
import java.awt.GridLayout;

public class TTTBoard extends JPanel {
    private TTTTileButton[][] tiles = new TTTTileButton[3][3];
    private TTTGame game;

    public TTTBoard(TTTGame game) {
        this.game = game;
        setLayout(new GridLayout(3, 3));
        initializeTiles();
    }

    private void initializeTiles() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                TTTTileButton tile = new TTTTileButton(i, j);
                tile.addActionListener(e -> game.makeMove(tile));
                tiles[i][j] = tile;
                add(tile);
            }
        }
    }

    public void resetBoard() {
        for (TTTTileButton[] row : tiles)
            for (TTTTileButton tile : row)
                tile.setText("");
    }

    public String getTileText(int row, int col) {
        return tiles[row][col].getText();
    }

    public void setTileText(int row, int col, String text) {
        tiles[row][col].setText(text);
    }
}
