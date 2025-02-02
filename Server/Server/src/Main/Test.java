package Main;

import java.awt.*;
import javax.swing.*;

public class Test extends JFrame {

    private static final long serialVersionUID = 1L;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Test frame = new Test();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame with three pages.
     */
    public Test() {
        setTitle("Multi-Page Navigation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 840, 700);
        getContentPane().setLayout(new CardLayout(0, 0));

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        getContentPane().add(mainPanel, "name_12263576575600");

        // Page 1
        JPanel panel1 = createPage("Page 1", "Go to Page 2", "Go to Page 3", "Page2", "Page3");
        mainPanel.add(panel1, "Page1");

        // Page 2
        JPanel panel2 = createPage("Page 2", "Go to Page 1", "Go to Page 3", "Page1", "Page3");
        mainPanel.add(panel2, "Page2");

        // Page 3
        JPanel panel3 = createPage("Page 3", "Go to Page 1", "Go to Page 2", "Page1", "Page2");
        mainPanel.add(panel3, "Page3");

        cardLayout.show(mainPanel, "Page1"); // Show Page 1 by default
    }

    /**
     * Create a page with navigation buttons.
     */
    private JPanel createPage(String title, String btn1Text, String btn2Text, String target1, String target2) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setLayout(null);

        JButton btn1 = new JButton(btn1Text);
        btn1.setBounds(120, 100, 200, 30);
        btn1.addActionListener(e -> cardLayout.show(mainPanel, target1));
        panel.add(btn1);

        JButton btn2 = new JButton(btn2Text);
        btn2.setForeground(new Color(0, 0, 255));
        btn2.setBackground(Color.blue);
        btn2.setBounds(120, 141, 300, 30);
        btn2.addActionListener(e -> cardLayout.show(mainPanel, target2));
        panel.add(btn2);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\baona\\OneDrive - Conestoga College\\School\\24-25\\WINTER 25\\Project 4\\Project 4\\Server\\Server\\src\\images\\image1.jpg"));
        lblNewLabel.setBounds(137, 217, 46, 14);
        panel.add(lblNewLabel);

        return panel;
    }
}
