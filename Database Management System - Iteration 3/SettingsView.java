import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsView extends JFrame {
    private DataAdapter dataAdapter;
    private JButton btnPassword = new JButton("Change Password");
    private JButton btnPicture = new JButton("Change Profile Picture");
    
    private JPasswordField txtOldPass = new JPasswordField(10);
    private JPasswordField txtNewPass = new JPasswordField(10);
    private JButton btnCancel = new JButton("Cancel");
    private JButton btnSavePass = new JButton("Submit Changes");

    public SettingsView(DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
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
        
        //Adds password fields to the content pane
        JPanel panelPassChange = new JPanel();
        panelPassChange.add(new JLabel("Old Password:"));
        panelPassChange.add(txtOldPass);
        panelPassChange.add(new JLabel("New Password:"));
        panelPassChange.add(txtNewPass);
        panelPassChange.add(btnSavePass);
        this.getContentPane().add(panelPassChange);
        panelPassChange.setVisible(false);
        
        btnPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPassChange.setVisible(true);
            }
        });
        
        btnPicture.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getPicturesView().setVisible(true);
            }
        });
        
        btnSavePass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataAdapter.changePass(String.valueOf(txtOldPass.getPassword()), String.valueOf(txtNewPass.getPassword()));
                panelPassChange.setVisible(false);
                JOptionPane.showMessageDialog(null, "Password successfully changed!");
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