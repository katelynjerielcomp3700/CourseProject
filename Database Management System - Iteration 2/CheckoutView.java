import javax.swing.*;

public class CheckoutView extends JFrame{
    private JLabel IDLabel = new JLabel("Product ID: ");
    private JLabel qtyLabel = new JLabel("Quantity: ");
    private JLabel totalAmountLabel = new JLabel("Total Amount: ");
    private JTextField txtProductID = new JTextField(10);
    private JTextField txtProductQty = new JTextField(10);
    
    private JTextArea txtAmount = new JTextArea(1, 10);
    
    private JTextArea txtProductList = new JTextArea(30, 50);
    
    private JButton btnScan = new JButton("Scan Product");
    private JButton btnFinish = new JButton("Finish & Pay");
    
    private JLabel paymentPrompt = new JLabel("Select Your Payment Type");
    private JButton btnCash = new JButton("Cash");
    private JButton btnCredit = new JButton("Credit");
    private JButton btnDebit = new JButton("Debit");
    private JButton btnCheck = new JButton("Check");

    public CheckoutView() {
        this.setTitle("Checkout View");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(700, 700);
        
        //Panel to display user input forms for product info
        JPanel panelOrderInput = new JPanel();
        panelOrderInput.add(IDLabel);
        panelOrderInput.add(txtProductID);
        txtProductID.setHorizontalAlignment(JTextField.RIGHT);
        panelOrderInput.add(qtyLabel);
        panelOrderInput.add(txtProductQty);
        txtProductID.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelOrderInput);
        
        //Panel to display checkout buttons
        JPanel panelScanButtons = new JPanel();
        panelScanButtons.add(btnScan);
        panelScanButtons.add(btnFinish);
        this.getContentPane().add(panelScanButtons);
        
        //Panel to display all products in order
        JPanel panelProductList = new JPanel();
        panelProductList.add(txtProductList);
        this.getContentPane().add(panelProductList);
        
        //Panel to display total amount of order
        JPanel panelAmount = new JPanel();
        panelAmount.add(totalAmountLabel);
        txtAmount.setText("0.00");
        panelAmount.add(txtAmount);
        this.getContentPane().add(panelAmount);
    }
    
    public void switchInterface() {
        //Hides other existing buttons and features
        IDLabel.setVisible(false);
        qtyLabel.setVisible(false);
        txtProductID.setVisible(false);
        txtProductQty.setVisible(false);
        btnScan.setVisible(false);
        btnFinish.setVisible(false);
        txtProductList.setVisible(false);
        //Panel to display payment options buttons
        JPanel panelPayButtons = new JPanel();
        panelPayButtons.add(paymentPrompt);
        panelPayButtons.add(btnCash);
        panelPayButtons.add(btnCredit);
        panelPayButtons.add(btnDebit);
        panelPayButtons.add(btnCheck);
        paymentPrompt.setVerticalAlignment(JTextField.CENTER);
        this.getContentPane().add(panelPayButtons);
    }
    
    public JButton getBtnScan() {
        return btnScan;
    }
    
    public JButton getBtnFinish() {
        return btnFinish;
    }

    public JButton getBtnCash() {
        return btnCash;
    }

    public JButton getBtnCredit() {
        return btnCredit;
    }
    
    public JButton getBtnDebit() {
        return btnDebit;
    }
    
    public JButton getBtnCheck() {
        return btnCheck;
    }
    
    public JTextField getTxtProductID() {
        return txtProductID;
    }
    
    public JTextField getTxtProductQty() {
        return txtProductQty;
    }

    public JTextArea getTxtAmount() {
        return txtAmount;
    }
     
    public JTextArea getTxtProductList() {
        return txtProductList;
    }
}
