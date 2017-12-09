import javax.swing.*;

public class UserView extends JFrame {
    private JTextField txtUserID = new JTextField(10);
    private JTextField txtUserName = new JTextField(30);
    private JTextField txtDisplayName = new JTextField(10);
    private JTextField txtPassword = new JTextField(10);
    private JTextField txtManagerStatus = new JTextField(10);

    private JButton btnLoad = new JButton("Load User Info");
    private JButton btnGenerate = new JButton("Generate Password");
    private JButton btnSave = new JButton("Save User Info");

    public UserView() {
        this.setTitle("User View");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(800, 400);

        JPanel panelUserID = new JPanel();
        panelUserID.add(new JLabel("User ID: "));
        panelUserID.add(txtUserID);
        txtUserID.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelUserID);

        JPanel panelUserName = new JPanel();
        panelUserName.add(new JLabel("User Name: "));
        panelUserName.add(txtUserName);
        this.getContentPane().add(panelUserName);

        JPanel panelUserInfo = new JPanel();
        panelUserInfo.add(new JLabel("Display Name: "));
        panelUserInfo.add(txtDisplayName);
        txtDisplayName.setHorizontalAlignment(JTextField.RIGHT);

        panelUserInfo.add(new JLabel("Password: "));
        panelUserInfo.add(txtPassword);
        txtPassword.setHorizontalAlignment(JTextField.RIGHT);
        
        panelUserInfo.add(new JLabel("Set Manager Status (0 or 1): "));
        panelUserInfo.add(txtManagerStatus);
        txtManagerStatus.setHorizontalAlignment(JTextField.RIGHT);
        
        this.getContentPane().add(panelUserInfo);
        
        JPanel panelButton = new JPanel();
        panelButton.add(btnLoad);
        panelButton.add(btnGenerate);
        panelButton.add(btnSave);
        this.getContentPane().add(panelButton);
    }
    
    public JButton getBtnLoad() {
        return btnLoad;
    }

    public JButton getBtnSave() {
        return btnSave;
    }
    
    public JButton getBtnGenerate() {
        return btnGenerate;
    }
    
    public JTextField getTxtUserID() {
        return txtUserID;
    }
    
    public JTextField getTxtUserName() {
        return txtUserName;
    }
    
    public JTextField getTxtDisplayName() {
        return txtDisplayName;
    }
    
    public JTextField getTxtPassword() {
        return txtPassword;
    }
    
    public JTextField getTxtManagerStatus() {
        return txtManagerStatus;
    }
}
