import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.*;

public class ViewLayer extends JFrame {
   
   public static void main(String[] args) {
      JFrame contentPane = new JFrame("FrameDemo");
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
      contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public class ScreenView {
   }
   
   public class Form {
   }
   
   public class Image {
   }
   
   public class Button {
   }
   
   public class TableView {
   }
}

