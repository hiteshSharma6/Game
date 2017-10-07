import javax.swing.JFrame;

public class Launcher extends JFrame {
	Board board = new Board();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Launcher frame = new Launcher();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Launcher() {
		this.getContentPane().setLayout(null);
		this.getContentPane().add(board);
		setTitle("SPACE ATTACK");
		setSize(GameConstants.BOARD_WIDTH, GameConstants.BOARD_HEIGHT + 25);
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
