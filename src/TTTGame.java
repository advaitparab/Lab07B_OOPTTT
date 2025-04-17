public class TTTGame {
    private final String[][] board = new String[3][3];
    private String currentPlayer = "X";
    private boolean gameOver = false;

    public void makeMove(int row, int col) {
        if (board[row][col] == null) {
            board[row][col] = currentPlayer;
        }
    }

    public boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (currentPlayer.equals(board[i][0]) &&
                    currentPlayer.equals(board[i][1]) &&
                    currentPlayer.equals(board[i][2])) return true;

            if (currentPlayer.equals(board[0][i]) &&
                    currentPlayer.equals(board[1][i]) &&
                    currentPlayer.equals(board[2][i])) return true;
        }

        // Check diagonals
        if (currentPlayer.equals(board[0][0]) &&
                currentPlayer.equals(board[1][1]) &&
                currentPlayer.equals(board[2][2])) return true;

        return currentPlayer.equals(board[0][2]) &&
                currentPlayer.equals(board[1][1]) &&
                currentPlayer.equals(board[2][0]);
    }

    public boolean isBoardFull() {
        for (String[] row : board)
            for (String cell : row)
                if (cell == null) return false;
        return true;
    }

    public void resetGame() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = null;
        currentPlayer = "X";
        gameOver = false;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean value) {
        gameOver = value;
    }
}
