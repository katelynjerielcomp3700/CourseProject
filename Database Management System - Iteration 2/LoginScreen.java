import javax.swing.*;

public class LoginScreen extends JFrame {
   private JTextField txtUserName = new JTextField(10);
   private JPasswordField txtPassword = new JPasswordField(10);
   private JButton btnLogin = new JButton("Login");
   
   public JButton getBtnLogin() {
      return btnLogin;
   }
   
   public JTextField getTxtUserName() {
      return txtUserName;
   }
   
   public JPasswordField getTxtPassword(){
      return txtPassword;
   }
   
   public LoginScreen() {
      this.setSize(300, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
      
      this.getContentPane().add(new JLabel("Mr. Smith Store Management System"));
      
      JPanel panelUserName = new JPanel();
      panelUserName.add(new JLabel("Username:"));
      panelUserName.add(txtUserName);
      this.getContentPane().add(panelUserName);
      
      JPanel panelPassword = new JPanel();
      panelPassword.add(new JLabel("Password:"));
      panelPassword.add(txtPassword);
      this.getContentPane().add(panelPassword);
      
      this.getContentPane().add(btnLogin);
   }

}