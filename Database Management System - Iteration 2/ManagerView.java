import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerView extends JFrame {
    private JButton btnProducts = new JButton("Manage Products");
    private JButton btnUsers = new JButton("Manage Users");
    private JButton btnReports = new JButton("View Reports");

    public ManagerView() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(600, 500);

        btnProducts.setPreferredSize(new Dimension(160, 60));
        btnUsers.setPreferredSize(new Dimension(160, 60));
        btnReports.setPreferredSize(new Dimension(160, 60));

        //Sets title information for the content pane
        JLabel title = new JLabel("Update User Profile");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);
         
        //Adds all the user options menu buttons to the JPanel
        JPanel panelButton = new JPanel();
        panelButton.add(btnProducts);
        panelButton.add(btnUsers);
        panelButton.add(btnReports);
        
        //Adds the JPanel to the content pane
        this.getContentPane().add(panelButton);
        
        //Adds functionality to menu buttons
        btnProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getProductView().setVisible(true);
            }
        });
        
        btnUsers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getUserView().setVisible(true);
            }
        });
        
        btnReports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getReportsView().setVisible(true);
            }
        });
    }
}