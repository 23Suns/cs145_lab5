import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicalPascalsTriangle extends JFrame {
  private static final int CELL_PADDING = 10;

  private TrianglePanel trianglePanel;
  private JTextField rowsInput;
  private JRadioButton showFormulasButton;
  private JRadioButton customizeButton;
  private ButtonGroup buttonGroup;
  private JPanel contentPanel; 
  
  public GraphicalPascalsTriangle() {
    super("Pascal's Triangle");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 600);
    setLocationRelativeTo(null);

    trianglePanel = new TrianglePanel();
    rowsInput = new JTextField(5);
    rowsInput.setEnabled(false);

    showFormulasButton = new JRadioButton("Show Formula", true);
    customizeButton = new JRadioButton("Customize Size");
    buttonGroup = new ButtonGroup();
    buttonGroup.add(showFormulasButton);
    buttonGroup.add(customizeButton);

    contentPanel = new JPanel(); // Create a content panel
    contentPanel.setLayout(new BorderLayout()); // Set layout manager

    JPanel controlPanel = new JPanel(); // Create a control panel
    controlPanel.add(showFormulasButton);
    controlPanel.add(customizeButton);
    controlPanel.add(new JLabel("Number of rows:"));
    controlPanel.add(rowsInput);
    JButton updateButton = new JButton("Update");
    updateButton.setEnabled(false);
    controlPanel.add(updateButton);

    contentPanel.add(controlPanel, BorderLayout.SOUTH); // Add control panel to bottom
    contentPanel.add(trianglePanel, BorderLayout.CENTER); // Add triangle panel to center

    add(contentPanel, BorderLayout.CENTER); // Add content panel to frame

    setVisible(false); // Initially set the frame as invisible
    showMenu(); // Call new showMainMenu method
	
		showFormulasButton.addActionListener(e -> {
		  trianglePanel.repaint();
		  updateButton.setEnabled(false);
		  rowsInput.setEnabled(false);
		});
	
		customizeButton.addActionListener(e -> {
		  rowsInput.setEnabled(true);
		  updateButton.setEnabled(true);
		});
	
		updateButton.addActionListener(new UpdateButtonListener());
	  }

	public static void main(String[] args) {
		SwingUtilities.invokeLater(GraphicalPascalsTriangle::new);
	}

	private void showMenu() {
		String[] options = { "Continue" };
		JOptionPane.showOptionDialog(this, "Welcome to Pascal's Triangle!",
				"Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		setVisible(true); // Show the frame after menu selection
	}

	private class TrianglePanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int panelWidth = getWidth();
			int fontSize = 16; // Adjust font size as needed
			g.setFont(new Font("Sans Serif", Font.PLAIN, fontSize));

			int y = CELL_PADDING * 2; // Adjust y-coordinate for better positioning

			for (int row = 0; row < 5; row++) {
				String formula = generateFormula(row + 1);
				int textWidth = g.getFontMetrics().stringWidth(formula);
				int startX = (panelWidth - textWidth) / 2;
				g.drawString(formula, startX, y);
				y += fontSize + CELL_PADDING; // Adjust y-coordinate for spacing between formulas
			}
		}

		private String generateFormula(int n) {
			StringBuilder formula = new StringBuilder();
			formula.append("(x+y)^");
			formula.append(n);
			formula.append(" = 1x^");
			formula.append(n);

			for (int i = 1; i < n; i++) {
				formula.append(" + ");
				formula.append(n - i);
				formula.append("x^");
				formula.append(n - i);
				formula.append("y^");
				formula.append(i);
			}

			formula.append(" + 1y^");
			formula.append(n);
			return formula.toString();
		}
	}

	private class UpdateButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		  int numRows;
		  try {
			numRows = Integer.parseInt(rowsInput.getText());
			if (numRows <= 0) {
			  throw new NumberFormatException("Number of rows must be positive");
			}
		  } catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(GraphicalPascalsTriangle.this,
					"Invalid number of rows. Please enter a positive integer.",
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		  }
	
		  // Remove this line if formulas are not needed for dynamic view
		  trianglePanel.removeAll(); 
	
		  trianglePanel = new TrianglePanel(); // Create new panel with user-specified rows
		  add(trianglePanel, BorderLayout.CENTER);
		  trianglePanel.repaint();
		  rowsInput.setEnabled(false); // Disable input after update
		}
	  }
	}
