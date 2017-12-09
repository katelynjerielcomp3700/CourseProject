import javax.swing.*;

public class UserView extends JFrame {
    private JTextField txtProductID = new JTextField(10);
    private JTextField txtProductName = new JTextField(30);
    private JTextField txtProductPrice = new JTextField(10);
    private JTextField txtProductQuantity = new JTextField(10);
    private JTextField txtProductTaxRate = new JTextField(10);
    private JTextField txtProductExpirationDate = new JTextField(10);
    private JTextField txtProductSupplier = new JTextField(30);
    private JTextField txtProductUnit = new JTextField(10);

    private JButton btnLoad = new JButton("Load User Info");
    private JButton btnGenerate = new JButton("Generate Password");
    private JButton btnSave = new JButton("Save User Info");

    public UserView() {
        this.setTitle("User View");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(800, 400);

        JPanel panelProductID = new JPanel();
        panelProductID.add(new JLabel("User ID: "));
        panelProductID.add(txtProductID);
        txtProductID.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelProductID);

        JPanel panelProductName = new JPanel();
        panelProductName.add(new JLabel("User Name: "));
        panelProductName.add(txtProductName);
        this.getContentPane().add(panelProductName);

        JPanel panelProductInfo = new JPanel();
        panelProductInfo.add(new JLabel("Display Name: "));
        panelProductInfo.add(txtProductPrice);
        txtProductPrice.setHorizontalAlignment(JTextField.RIGHT);

        panelProductInfo.add(new JLabel("Password: "));
        panelProductInfo.add(txtProductQuantity);
        txtProductQuantity.setHorizontalAlignment(JTextField.RIGHT);
        
        panelProductInfo.add(new JLabel("Set Manager Status: "));
        panelProductInfo.add(txtProductTaxRate);
        txtProductQuantity.setHorizontalAlignment(JTextField.RIGHT);
        
        this.getContentPane().add(panelProductInfo);
        
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
}
