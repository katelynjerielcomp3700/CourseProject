import javax.swing.*;

public class ReportsView extends JFrame{
    private JButton btnProduct = new JButton("View Product Report");
    private JButton btnOrder = new JButton("View Order Report");
    
    private JLabel startDate = new JLabel("Start Date: ");
    private JLabel endDate = new JLabel("End Date: ");
    private JTextField txtStartDate = new JTextField(10);
    private JTextField txtEndDate = new JTextField(10);
    private JButton btnSearch = new JButton("Submit Search");
    
    private JTextArea txtReportField = new JTextArea(30, 50);
    
    private JLabel sortPrompt = new JLabel("Sort By:");
    private JButton btnSortId = new JButton("Order ID");
    private JButton btnSortDate = new JButton("Date");
    private JButton btnSortPrice = new JButton("Price");

    public ReportsView() {
        this.setTitle("View Reports");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(700, 700);
        
        //Panel to display user input forms for date info
        JPanel panelDateInput = new JPanel();
        panelDateInput.add(startDate);
        panelDateInput.add(txtStartDate);
        txtStartDate.setHorizontalAlignment(JTextField.RIGHT);
        panelDateInput.add(endDate);
        panelDateInput.add(txtEndDate);
        txtEndDate.setHorizontalAlignment(JTextField.RIGHT);
        panelDateInput.add(btnSearch);
        this.getContentPane().add(panelDateInput);
        
        //Panel to display sorting options
        JPanel panelSortButtons = new JPanel();
        panelSortButtons.add(sortPrompt);
        panelSortButtons.add(btnSortDate);
        panelSortButtons.add(btnSortId);
        panelSortButtons.add(btnSortPrice);
        sortPrompt.setVerticalAlignment(JTextField.CENTER);
        this.getContentPane().add(panelSortButtons);
        
        //Panel to display all items in report
        JPanel panelProductList = new JPanel();
        panelProductList.add(txtReportField);
        this.getContentPane().add(panelProductList);
    }
    
    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnSortDate() {
        return btnSortDate;
    }

    public JButton getBtnSortId() {
        return btnSortId;
    }
    
    public JButton getBtnSortPrice() {
        return btnSortPrice;
    }
    
    public JTextField getTxtStartDate() {
        return txtStartDate;
    }
    
    public JTextField getTxtEndDate() {
        return txtEndDate;
    }
     
    public JTextArea getTxtReportField() {
        return txtReportField;
    }
}
