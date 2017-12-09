import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController implements ActionListener {
    private UserView userView;
    private DataAdapter dataAdapter; //to save and load product information
   
    public UserController(UserView userView, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.userView = userView;
   
        userView.getBtnLoad().addActionListener(this);
        userView.getBtnGenerate().addActionListener(this);
        userView.getBtnSave().addActionListener(this);
    }
   
   public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userView.getBtnLoad())
            loadUser();
        else if (e.getSource() == userView.getBtnSave())
            saveUser();
        else if (e.getSource() == userView.getBtnGenerate())
            generatePassword();
   }
   
   public void loadUser() {
   }
   
   public void saveUser() {
   }
   
   public void generatePassword() {
        String defaultPassword = "password1";
        saveUser();
   }
}