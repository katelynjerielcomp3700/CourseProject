import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {

    private JButton btnCheckout = new JButton("Checkout");
    private JButton btnManage = new JButton("Manage Products");

    public MainScreen() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);

        btnManage.setPreferredSize(new Dimension(160, 60));
        btnCheckout.setPreferredSize(new Dimension(160, 60));

        JLabel title = new JLabel("Mr. Smith Store Management System");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelButton = new JPanel();
        panelButton.add(btnCheckout);
        panelButton.add(btnManage);

        this.getContentPane().add(panelButton);
        
        btnCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getCheckoutView().setVisible(true);
            }
        });
        
        btnManage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getProductView().setVisible(true);
            }
        });
    }
}
