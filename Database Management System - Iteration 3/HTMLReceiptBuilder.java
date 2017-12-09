import java.io.FileWriter;
import java.io.BufferedWriter;

public class HTMLReceiptBuilder implements ReceiptBuilder {
   StringBuilder str = new StringBuilder();
   FileWriter fWriter;
   BufferedWriter bWriter;
   
   @Override
   public void setHeader(String storeName, String cashier, String customer, String date) {
      str.append("--------------------------------<br>");
      str.append(storeName + "<br>");
      str.append("Cashier: " + cashier + "<br>");
      str.append("Customer: " + customer + "<br>");
      str.append("Qty     Product     Price<br>");
   }
   
   @Override
   public void setFooter(String totalCost, String totalTax) {
      str.append("--------------------------------<br>");
      str.append("Total: " + totalCost + "<br>");
      str.append("Total Tax: " + totalTax + "<br>");
   }
   
   @Override
   public void appendOrderLine(String orderLine) {
      str.append(orderLine + "<br>");
   }
   
   public void saveFile() {
       try {
          fWriter = new FileWriter("Receipt.html");
          bWriter = new BufferedWriter(fWriter);
          bWriter.write("<span>" + str.toString() + "</span>");
          bWriter.newLine();
          bWriter.close();
       }
       catch (Exception e) {
       }
   }
}