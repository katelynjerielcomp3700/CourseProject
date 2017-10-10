import javax.swing.*;
import java.awt.*;

public class ViewLayer extends JFrame {
   
   public static void main(String[] args) {
      /*JFrame contentPane = new JFrame("DBMSGUI");
      //Sets up grid for buttons
      contentPane.setLayout(new GridLayout(1, 2));
      JButton button1 = new JButton("Check Out Order");
      JButton button2 = new JButton("Access Product Database");
      //Changes display settings of menu buttons
      button1.setPreferredSize(new Dimension(500, 200));
      button2.setPreferredSize(new Dimension(500, 200));
      button1.setFont(new Font("", 0, 30));
      button2.setFont(new Font("", 0, 30));
      //Adds buttons to grid layout
      contentPane.add(button1);
      contentPane.add(button2);
      //Adjusts settings for JFrame
      contentPane.pack();
      contentPane.setVisible(true);
      contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
      
      JFrame contentPane = new JFrame("DBMSGUI");
      contentPane.setLayout(new GridLayout(8, 2));
      //Instantiating all form elements
      JLabel productName = new JLabel("Product Name");
      JTextField nameField = new JTextField();
      JLabel productID = new JLabel("Product ID");
      JTextField idField = new JTextField();
      JLabel quantity = new JLabel("Quantity");
      JTextField quantityField = new JTextField();
      JLabel price = new JLabel("Price");
      JTextField priceField = new JTextField();
      JLabel taxRate = new JLabel("Tax Rate");
      JTextField taxField = new JTextField();
      JLabel expirationDate = new JLabel("Expiration Date");
      JTextField expirationField = new JTextField();
      JLabel supplier = new JLabel("Supplier");
      JTextField supplierField = new JTextField();
      JLabel unit = new JLabel("Unit");
      JTextField unitField = new JTextField();
      JButton saveButton = new JButton("Save");
      //Adds all form elements to GUI
      contentPane.add(productName);
      contentPane.add(nameField);
      contentPane.add(productID);
      contentPane.add(idField);
      contentPane.add(quantity);
      contentPane.add(quantityField);
      contentPane.add(price);
      contentPane.add(priceField);
      contentPane.add(taxRate);
      contentPane.add(taxField);
      contentPane.add(expirationDate);
      contentPane.add(expirationField);
      contentPane.add(supplier);
      contentPane.add(supplierField);
      contentPane.add(unit);
      contentPane.add(unitField);
      //Adjusts settings for JFrame
      contentPane.pack();
      contentPane.setVisible(true);
      contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public class ScreenView {
   }
   
   public class Form {
   
      public Form() {
      }
   }
   
   public class Image {
   }
   
   public class Button {
   }
   
   public class TableView {
   }
}

