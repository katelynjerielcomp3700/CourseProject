<<<<<<< HEAD
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
      int userID = 0;
        try {
            userID = Integer.parseInt(userView.getTxtUserID().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid user ID! Please provide a valid user ID!");
            return;
        }

        User user = dataAdapter.loadUser(userID);

        if (user == null) {
            JOptionPane.showMessageDialog(null, "This user ID does not exist in the database!");
            return;
        }

        userView.getTxtUserName().setText(user.getUserName());
        userView.getTxtDisplayName().setText(user.getDisplayName());
        userView.getTxtPassword().setText(user.getPassword());
        userView.getTxtManagerStatus().setText(String.valueOf(user.getManagerStatus()));
   }
   
   public void saveUser() {
        int userID;
        try {
            userID = Integer.parseInt(userView.getTxtUserID().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid user ID! Please provide a valid product ID!");
            return;
        }

        String userName = userView.getTxtUserName().getText().trim();

        if (userName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid product name! Please provide a non-empty product name!");
            return;
        }
        
        String displayName = userView.getTxtDisplayName().getText().trim();

        if (displayName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid product name! Please provide a non-empty product name!");
            return;
        }
        
        String password = userView.getTxtPassword().getText().trim();

        if (password.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid product name! Please provide a non-empty product name!");
            return;
        }
        
        int managerStatus;
        try {
            managerStatus = Integer.parseInt(userView.getTxtManagerStatus().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product unit! Please provide a valid product unit!");
            return;
        }

        // Done all validations! Make an object for this product!
        User user = new User();
        user.setUserID(userID);
        user.setUserName(userName);
        user.setDisplayName(displayName);
        user.setPassword(password);
        user.setManagerStatus(managerStatus);

        // Store the product to the database
        dataAdapter.saveUser(user);
   }
   
   public void generatePassword() {
        String defaultPassword = "password1";
        userView.getTxtPassword().setText(defaultPassword);
   }
=======
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
      int userID = 0;
        try {
            userID = Integer.parseInt(userView.getTxtUserID().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid user ID! Please provide a valid user ID!");
            return;
        }

        User user = dataAdapter.loadUser(userID);

        if (user == null) {
            JOptionPane.showMessageDialog(null, "This user ID does not exist in the database!");
            return;
        }

        userView.getTxtUserName().setText(user.getUserName());
        userView.getTxtDisplayName().setText(user.getDisplayName());
        userView.getTxtPassword().setText(user.getPassword());
        userView.getTxtManagerStatus().setText(String.valueOf(user.getManagerStatus()));
   }
   
   public void saveUser() {
        int userID;
        try {
            userID = Integer.parseInt(userView.getTxtUserID().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid user ID! Please provide a valid product ID!");
            return;
        }

        String userName = userView.getTxtUserName().getText().trim();

        if (userName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid product name! Please provide a non-empty product name!");
            return;
        }
        
        String displayName = userView.getTxtDisplayName().getText().trim();

        if (displayName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid product name! Please provide a non-empty product name!");
            return;
        }
        
        String password = userView.getTxtPassword().getText().trim();

        if (password.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid product name! Please provide a non-empty product name!");
            return;
        }
        
        int managerStatus;
        try {
            managerStatus = Integer.parseInt(userView.getTxtManagerStatus().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product unit! Please provide a valid product unit!");
            return;
        }

        User user = new User();
        user.setUserID(userID);
        user.setUserName(userName);
        user.setDisplayName(displayName);
        user.setPassword(password);
        user.setManagerStatus(managerStatus);

        dataAdapter.saveUser(user);
   }
   
   public void generatePassword() {
        String defaultPassword = "password1";
        userView.getTxtPassword().setText(defaultPassword);
   }
>>>>>>> da6291cf0ffdc5ffc13f30fcea53a7aea06a242f
}