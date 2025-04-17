public class TTTLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TTTFrame frame = new TTTFrame();
            frame.setVisible(true);
        });
    }
}
