<<<<<<< HEAD
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener{
   private LoginScreen loginScreen;
   private DataAdapter dataAdapter;
   
   public LoginController(LoginScreen loginScreen, DataAdapter dataAdapter) {
      this.loginScreen = loginScreen;
      this.dataAdapter = dataAdapter;
      this.loginScreen.getBtnLogin().addActionListener(this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == loginScreen.getBtnLogin()) {
         String username = loginScreen.getTxtUserName().getText().trim();
         String password = String.valueOf(loginScreen.getTxtPassword().getPassword());
                  
         User user = dataAdapter.loadUser(username, password);
         
         if (user == null) {
            JOptionPane.showMessageDialog(null, "Incorrect username/password combination!");
         }
         else {
            Application.getInstance().setCurrentUser(user);
            this.loginScreen.setVisible(false);
            Application.getInstance().getMainScreen().setVisible(true);
         }
      }  
   }
=======
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener{
   private LoginScreen loginScreen;
   private DataAdapter dataAdapter;
   
   public LoginController(LoginScreen loginScreen, DataAdapter dataAdapter) {
      this.loginScreen = loginScreen;
      this.dataAdapter = dataAdapter;
      this.loginScreen.getBtnLogin().addActionListener(this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == loginScreen.getBtnLogin()) {
         String username = loginScreen.getTxtUserName().getText().trim();
         String password = String.valueOf(loginScreen.getTxtPassword().getPassword());
                  
         User user = dataAdapter.loadUser(username, password);
         
         if (user == null) {
            JOptionPane.showMessageDialog(null, "Incorrect username/password combination!");
         }
         else {
            Application.getInstance().setCurrentUser(user);
            this.loginScreen.setVisible(false);
            Application.getInstance().getMainScreen().setVisible(true);
         }
      }  
   }
>>>>>>> da6291cf0ffdc5ffc13f30fcea53a7aea06a242f
}