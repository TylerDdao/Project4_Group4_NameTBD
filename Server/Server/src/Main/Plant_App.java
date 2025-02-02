package Main;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Plant_App extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel mainPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plant_App frame = new Plant_App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Plant_App() {
		setTitle("Multi-page Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 840, 700);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);
        
        String url = "jdbc:mysql://localhost:3306/project4"; // Replace with your DB info
        String user = "root"; // Replace with your DB username
        String password = "Nam@326389"; // Replace with your DB password
        
        DatabaseHandler db = new DatabaseHandler();
        Vector<Plant>plants = new Vector<>();
        
		db.SetUpConnection(url, user, password);
		db.ConnectDatabase();
        
        plants = db.FetchPlantsList();

        // Initialize the CardLayout and main panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        contentPane.add(mainPanel, BorderLayout.CENTER);

        // Add pages to the CardLayout
//        mainPanel.add(new Page1(mainPanel, cardLayout), "Page 1");
//        mainPanel.add(new Page2(mainPanel, cardLayout), "Page 2");
//        mainPanel.add(new Page3(mainPanel, cardLayout), "Page 3");
        mainPanel.add(new Log_in(mainPanel, cardLayout), "Log In");
        mainPanel.add(new Sign_up(mainPanel, cardLayout), "Sign Up");
	}

}
