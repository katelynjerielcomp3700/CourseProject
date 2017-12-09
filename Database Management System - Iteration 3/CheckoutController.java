import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DecimalFormat;

public class CheckoutController implements ActionListener {
    private CheckoutView checkoutView;
    private DataAdapter dataAdapter;
    DecimalFormat df = new DecimalFormat("#.00"); 

    public CheckoutController(CheckoutView checkoutView, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.checkoutView = checkoutView;
        
        checkoutView.getBtnScan().addActionListener(this);
        checkoutView.getBtnFinish().addActionListener(this);
        checkoutView.getBtnCash().addActionListener(this);
        checkoutView.getBtnCredit().addActionListener(this);
        checkoutView.getBtnDebit().addActionListener(this);
        checkoutView.getBtnCheck().addActionListener(this);
        checkoutView.getBtnReceiptTxt().addActionListener(this);
        checkoutView.getBtnReceiptHtm().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkoutView.getBtnScan())
            scanProduct();
        else if (e.getSource() == checkoutView.getBtnFinish())
            finishAndPay();
        else if (e.getSource() == checkoutView.getBtnCash())
        {
            dataAdapter.storeOrder("Cash", Double.parseDouble(checkoutView.getTxtAmount().getText()));
            checkoutView.setVisible(false);
        }   
        else if (e.getSource() == checkoutView.getBtnCredit())
        {
            dataAdapter.storeOrder("Credit", Double.parseDouble(checkoutView.getTxtAmount().getText()));
            checkoutView.setVisible(false);
        }   
        else if (e.getSource() == checkoutView.getBtnDebit())
        {
            dataAdapter.storeOrder("Debit", Double.parseDouble(checkoutView.getTxtAmount().getText()));
            checkoutView.setVisible(false);
        }   
        else if (e.getSource() == checkoutView.getBtnCheck())
        {  
            dataAdapter.storeOrder("Check", Double.parseDouble(checkoutView.getTxtAmount().getText()));
            checkoutView.setVisible(false);
        }
        else if (e.getSource() == checkoutView.getBtnReceiptTxt())
        {
            generateTxtReceipt();
        }
        else if (e.getSource() == checkoutView.getBtnReceiptHtm())
        {
            generateHtmlReceipt();
        }
    }
    
    public void scanProduct() {
        int productID = Integer.parseInt(checkoutView.getTxtProductID().getText());
        int productQty = Integer.parseInt(checkoutView.getTxtProductQty().getText());
        double currentTotalCost = Double.parseDouble(checkoutView.getTxtAmount().getText());
        double productPrice = dataAdapter.checkPrice(productID);
        //Calculate total cost of product by quantity of checkout
        double totalProductCost = productQty * productPrice;
        //Add product cost to current total of checkout order
        double newTotalCost = currentTotalCost + totalProductCost;
        //Update checkout order cost
        checkoutView.getTxtAmount().setText(Double.toString(newTotalCost));
        //Reset input fields
        checkoutView.getTxtProductID().setText("");
        checkoutView.getTxtProductQty().setText("");
        //Update checkout order list
        String orderLine = checkoutView.getTxtProductList().getText();
        orderLine += productQty + "x" + "\t" + dataAdapter.getProductName(productID)
                  + "\t" + totalProductCost + System.getProperty("line.separator");
        checkoutView.getTxtProductList().setText(orderLine);
    }
    
    public void finishAndPay() {
        checkoutView.switchInterface();
    }
    
    public void generateTxtReceipt() {
        TXTReceiptBuilder rb = new TXTReceiptBuilder();
        String totalAmount = checkoutView.getTxtAmount().getText().toString();
        double totalAmountNum = Double.parseDouble(totalAmount);
        double taxRate = totalAmountNum * 0.09;
        df.format(taxRate);
        String taxRateString = Double.toString(taxRate);
        rb.setHeader("Mr. Smith Goods", "Jeff Smith",
            dataAdapter.getCurrentUser().getDisplayName(), new Date().toString());
        rb.appendOrderLine(checkoutView.getTxtProductList().getText().toString());
        rb.setFooter("$" + totalAmount, "$" + taxRateString);
        rb.saveFile();
    }
    
    public void generateHtmlReceipt() {
        HTMLReceiptBuilder rb = new HTMLReceiptBuilder();
        String totalAmount = checkoutView.getTxtAmount().getText().toString();
        double totalAmountNum = Double.parseDouble(totalAmount);
        double taxRate = totalAmountNum * 0.09;
        df.format(taxRate);
        String taxRateString = Double.toString(taxRate);
        rb.setHeader("Mr. Smith Goods", "Jeff Smith",
            dataAdapter.getCurrentUser().getDisplayName(), new Date().toString());
        rb.appendOrderLine(checkoutView.getTxtProductList().getText().toString());
        rb.setFooter("$" + totalAmount, "$" + taxRateString);
        rb.saveFile();
    }
}