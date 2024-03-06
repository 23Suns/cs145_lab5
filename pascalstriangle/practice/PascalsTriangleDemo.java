package pascalstriangle.practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PascalsTriangleDemo extends JFrame {
	// private static final int CELL_SIZE = 30;
	// private static final int CELL_PADDING = 10;
	
	// private TitlePanel titlePanel;
	// private DetailsPanel detailsPanel;
	// private InputPanel inputPanel;

	// private JButton continueButton;
	// private JButton defaultButton;
	// private JButton customButton;
	// private JTextField rowsInput;

	final static String EQUATION = "Equation";
	final static String CUSTOM = "Demonstration";

	private JPanel viewPanel = new JPanel();

	public PascalsTriangleDemo() throws HeadlessException {
		super("Pascals Triangle Demo");
		createGUI();
	}

	private void createGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setJMenuBar(createMenu());
		setSize(800, 600);
		setLocationRelativeTo(null);
	}

	// private JButton continueButton;
	// private JPanel titlePanel, formulaPanel, customPanel;
	// private CardLayout cardLayout;

	// public PascalsTriangleDemo() {
	// 	super("Pascal Triangle Generator");
	// 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// 	setSize(800, 600);
	// 	setLocationRelativeTo(null);

	// 	cardLayout = new CardLayout();
	// 	setLayout(cardLayout);
	// }

	// private JPanel createTitle() {
	// 	JPanel panel = new JPanel();
	// 	JLable titleLabel = new JLabel("Menu Options");
	// }

	// public static void main(String[] args) {
	// 	SwingUtilities.invokeLater(PascalsTriangle::new);
	// }
}