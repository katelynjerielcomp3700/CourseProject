import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PicturesController implements ActionListener {
   private PicturesView picturesView;
   private DataAdapter dataAdapter;
   
   public PicturesController(PicturesView picturesView, DataAdapter dataAdapter) {
     this.dataAdapter = dataAdapter;
     this.picturesView = picturesView;

     picturesView.getBtnSubmit().addActionListener(this);
     picturesView.getBtnView().addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent e) {
        if (e.getSource() == picturesView.getBtnSubmit())
            changePicture();
        else if (e.getSource() == picturesView.getBtnView())
            viewPicture();
   }
   
   public void changePicture() {
      String imageLink = picturesView.getTxtImgLink().getText().trim();
      try {
         picturesView.getPanelImage().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + imageLink)));
         dataAdapter.changePicture(imageLink);
         JOptionPane.showMessageDialog(null, "Profile picture successfully changed!");
      } catch (NullPointerException e) {
         JOptionPane.showMessageDialog(null, "Invalid image link! Try an actual picture in the images folder!");
         return;
      }
   }
   
   public void viewPicture() {
      picturesView.getPanelImage().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + dataAdapter.retrieveImage())));
      picturesView.getBtnView().setVisible(false);
      picturesView.getPanelImage().setVisible(true);
   }
}