import javax.swing.*;

public class TTTTileButton extends JButton {
    private final int row;
    private final int col;

    public TTTTileButton(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
