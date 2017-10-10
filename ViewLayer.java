import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class ViewLayer extends JFrame {
   
   public static void main(String[] args) {
      JFrame frame = new JFrame("FrameDemo");
      JLabel emptyLabel = new JLabel();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
      frame.setSize(1200, 800);
      //frame.pack();
      frame.setVisible(true);
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

