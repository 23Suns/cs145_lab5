import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PascalsTriangle extends JFrame {
	private static final int CELL_SIZE = 30;
	private static final int CELL_PADDING = 10;
	
	private TitlePanel titlePanel;
	private DetailsPanel detailsPanel;
	private InputPanel inputPanel;

	private JButton continueButton;
	private JButton defaultButton;
	private JButton customButton;
	private JTextField rowsInput;


	public PascalsTriangle() {
		super("Pascal's Triangle Representation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(PascalsTriangle::new);
	}

	private void showMenu() {
		String[] options = {"Continue"}
	}
}