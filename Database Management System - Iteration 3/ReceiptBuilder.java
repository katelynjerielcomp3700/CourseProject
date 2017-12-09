public interface ReceiptBuilder {
   public void setHeader(String storeName, String cashier, String customer, String date);
   public void appendOrderLine(String orderLine);
   public void setFooter(String totalCost, String totalTax);
   public String toString();
}