import java.io.FileWriter;
import java.io.BufferedWriter;

public class TXTReceiptBuilder implements ReceiptBuilder {
   StringBuilder str = new StringBuilder();
   FileWriter fWriter;
   BufferedWriter bWriter;
   
   @Override
   public void setHeader(String storeName, String cashier, String customer, String date) {
      str.append("--------------------------------");
      str.append(System.getProperty("line.separator"));
      str.append(storeName);
      str.append(System.getProperty("line.separator"));
      str.append("Cashier: " + cashier);
      str.append(System.getProperty("line.separator"));
      str.append("Customer: " + customer);
      str.append(System.getProperty("line.separator"));
      str.append("Qty\tProduct\tPrice");
      str.append(System.getProperty("line.separator"));
   }
   
   @Override
   public void setFooter(String totalCost, String totalTax) {
      str.append("--------------------------------");
      str.append(System.getProperty("line.separator"));
      str.append("Total: " + totalCost);
      str.append(System.getProperty("line.separator"));
      str.append("Total Tax: " + totalTax);
      str.append(System.getProperty("line.separator"));
   }
   
   @Override
   public void appendOrderLine(String orderLine) {
      str.append(orderLine);
      str.append(System.getProperty("line.separator"));
   }
   
   public void saveFile() {
       try {
          fWriter = new FileWriter("Receipt.txt");
          bWriter = new BufferedWriter(fWriter);
          bWriter.write(str.toString());
          bWriter.newLine();
          bWriter.close();
       }
       catch (Exception e) {
       }
   }
}