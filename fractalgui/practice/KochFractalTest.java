package fractalgui.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KochFractalTest extends JPanel implements ActionListener {

	private KochFractal k;
	private static final int MAX_ITERATIONS = 10;
	private int currentIteration = 0;
	private JButton increaseButton;

	public KochFractalTest() {
		setPreferredSize(new Dimension(600, 600));
		k = new KochFractal(getWidth() / 2.0, getHeight() / 3.0, getWidth() - getWidth() / 5.0, getHeight() / 3.0);

		increaseButton = new JButton("Increase Depth");
		increaseButton.addActionListener(this);
		add(increaseButton);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		k.draw(g, currentIteration);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == increaseButton && currentIteration < MAX_ITERATIONS) {
			currentIteration++;
			repaint();
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Koch Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new KochFractalTest());
		frame.pack();
		frame.setVisible(true);
	}
}