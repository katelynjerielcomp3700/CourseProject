import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutController implements ActionListener {
    private CheckoutView checkoutView;
    private DataAdapter dataAdapter;

    public CheckoutController(CheckoutView checkoutView, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.checkoutView = checkoutView;
        
        checkoutView.getBtnScan().addActionListener(this);
        checkoutView.getBtnFinish().addActionListener(this);
        checkoutView.getBtnCash().addActionListener(this);
        checkoutView.getBtnCredit().addActionListener(this);
        checkoutView.getBtnDebit().addActionListener(this);
        checkoutView.getBtnCheck().addActionListener(this);
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
                  + "\t" + totalProductCost + "\n";
        checkoutView.getTxtProductList().setText(orderLine);
    }
    
    public void finishAndPay() {
        checkoutView.switchInterface();
    }
}