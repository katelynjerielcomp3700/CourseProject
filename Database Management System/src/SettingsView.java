import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsView extends JFrame {
    private JButton btnPassword = new JButton("Change Password");
    private JButton btnPicture = new JButton("Change Profile Picture");
    
    private JPasswordField txtOldPass = new JPasswordField(10);
    private JPasswordField txtNewPass = new JPasswordField(10);
    private JButton btnCancel = new JButton("Cancel");
    private JButton btnSavePass = new JButton("Submit Changes");

    public SettingsView() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(600, 500);

        btnPassword.setPreferredSize(new Dimension(200, 60));
        btnPicture.setPreferredSize(new Dimension(200, 60));

        //Sets title information for the content pane
        JLabel title = new JLabel("Update User Profile");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);
         
        //Adds all the user options menu buttons to the JPanel
        JPanel panelButton = new JPanel();
        panelButton.add(btnPassword);
        panelButton.add(btnPicture);
        
        //Adds the JPanel to the content pane
        this.getContentPane().add(panelButton);
        
        btnPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel panelPassChange = new JPanel();
                panelPassChange.add(new JLabel("Old Password:"));
                panelPassChange.add(txtOldPass);
                panelPassChange.add(new JLabel("New Password:"));
                panelPassChange.add(txtNewPass);
                //this.getContentPane().add(panelPassChange);
            }
        });
        
        btnPicture.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getPicturesView().setVisible(true);
            }
        });
    }
    
    public JButton getBtnPassword() {
        return btnPassword;
    }
    
    public JButton getBtnPicture() {
        return btnPicture;
    }
    
    public JButton getBtnCancel() {
        return btnCancel;
    }
    
    public JButton getBtnSavePass() {
        return btnSavePass;
    }
}