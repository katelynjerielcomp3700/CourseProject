import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {

    private JButton btnCheckout = new JButton("Checkout");
    private JButton btnSettings = new JButton("Update Profile");
    private JButton btnManager = new JButton("Manager Features");

    public MainScreen() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);

        btnManager.setPreferredSize(new Dimension(160, 60));
        btnCheckout.setPreferredSize(new Dimension(160, 60));
        btnSettings.setPreferredSize(new Dimension(160, 60));

        //Sets title information for the content pane
        JLabel title = new JLabel("Mr. Smith Store Management System");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);
         
        //Adds all the main menu buttons to the JPanel
        JPanel panelButton = new JPanel();
        panelButton.add(btnCheckout);
        panelButton.add(btnSettings);
        panelButton.add(btnManager);
        
        //Adds the JPanel to the content pane
        this.getContentPane().add(panelButton);
        
        btnCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getCheckoutView().setVisible(true);
            }
        });
        
        btnManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getManagerView().setVisible(true);
            }
        });
        
        btnSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getSettingsView().setVisible(true);
            }
        });
    }
}