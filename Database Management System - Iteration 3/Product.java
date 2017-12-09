public class Product {
    private int ID;
    private String name;
    private double price;
    private double quantity;
    private double taxRate;
    private String expirationDate;
    private String supplier;
    private double unit;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    public double getTaxRate() {
        return taxRate;
    }
    
    public void setTaxRate(double taxRate)
    {
        this.taxRate = taxRate;
    }
    
    public String getExpirationDate() {
        return expirationDate;
    }
    
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    public String getSupplier() {
        return supplier;
    }
    
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    public double getUnit() {
        return unit;
    }
    
    public void setUnit(double unit) {
        this.unit = unit;
    }
}
