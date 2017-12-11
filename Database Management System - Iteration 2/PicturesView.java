<<<<<<< HEAD
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PicturesView extends JFrame {
=======
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PicturesView extends JFrame {
   private JButton btnView = new JButton("View Current Picture");
   private JLabel panelImage = new JLabel();
   private JTextField txtImgLink = new JTextField(10);
   private JButton btnSubmit = new JButton("Submit");
   
   public PicturesView() {
      this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
      this.setSize(600, 500);
      
      //Sets title information for the content pane
      JLabel title = new JLabel("Manage Profile Pictures");
      title.setFont(new Font("Sans Serif", Font.BOLD, 24));
      JPanel panelTitle = new JPanel();
      panelTitle.add(title);
      this.getContentPane().add(panelTitle);
      
      JPanel panelCurrentImage = new JPanel();
      panelCurrentImage.add(new JLabel("Current Profile Picture:"));
      panelCurrentImage.add(btnView);
      panelCurrentImage.add(panelImage);
      panelImage.setVisible(false);
      this.getContentPane().add(panelCurrentImage);
      
      JPanel panelInput = new JPanel();
      panelInput.add(new JLabel("Enter Image Name:"));
      panelInput.add(txtImgLink);
      panelInput.add(btnSubmit);
      this.getContentPane().add(panelInput);
      
      JPanel panelInfo = new JPanel();
      panelInfo.add(new JLabel("NOTE: To use a profile picture, please ensure the image is in the images directory."));
      this.getContentPane().add(panelInfo);
   }
   
   public JButton getBtnView() {
      return btnView;
   }
   
   public JTextField getTxtImgLink() {
      return txtImgLink;
   }
   
   public JButton getBtnSubmit() {
      return btnSubmit;
   }
   
   public JLabel getPanelImage() {
      return panelImage;
   }
>>>>>>> da6291cf0ffdc5ffc13f30fcea53a7aea06a242f
}