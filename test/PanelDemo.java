package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelDemo extends JFrame implements ActionListener {

    private JButton continueButton;
    private JPanel titlePanel, option1Panel, option2Panel, option3Panel;
    private CardLayout cardLayout;

    public PanelDemo() {
        super("Title Screen Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create CardLayout for managing multiple panels
        cardLayout = new CardLayout();
        setLayout(cardLayout); // Set CardLayout as the layout manager

        // Create Title Panel
        titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Welcome to the Application!");
        continueButton = new JButton("Continue");
        continueButton.addActionListener(this); // Register "this" as listener
        titlePanel.add(titleLabel);
        titlePanel.add(continueButton);

        // Create Option Panels with exit buttons (replace content with your options)
        option1Panel = createOptionPanel("Option 1");
        option2Panel = createOptionPanel("Option 2");
        option3Panel = createOptionPanel("Option 3");

        // Add all panels to the frame with names for CardLayout
        add(titlePanel);
        add(option1Panel, "option1");
        add(option2Panel, "option2");
        add(option3Panel, "option3");

        setVisible(true);
    }

    private JPanel createOptionPanel(String optionName) {
        JPanel panel = new JPanel();
        JLabel optionLabel = new JLabel(optionName + " Content"); // Replace with actual content
        JButton exitButton = new JButton("Exit " + optionName);
        exitButton.addActionListener(this); // Register "this" as listener for exit buttons
        panel.add(optionLabel);
        panel.add(exitButton);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continueButton) {
            // Transition to first option panel using CardLayout
            cardLayout.show(getContentPane(), "option1");
        } else {
            // Handle exit buttons from option panels
            String sourcePanel = ((JButton) e.getSource()).getText().split(" ")[1];
            cardLayout.show(getContentPane(), "titlePanel"); // Go back to title panel
        }
    }

    public static void main(String[] args) {
        new PanelDemo();
    }
}
