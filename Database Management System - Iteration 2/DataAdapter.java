import java.sql.*;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class DataAdapter {
    private Connection connection;
    private Application app;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    DecimalFormat df = new DecimalFormat("#.00"); 

    public DataAdapter(Connection connection, Application app) {
        this.connection = connection;
        this.app = app;
    }
    
    public String getProductName(int id) {
        try {
            String query = "SELECT * FROM Product WHERE ProductID = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String productName = resultSet.getString(2);
                resultSet.close();
                statement.close();
                return productName;
            }
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return "";
    }
    
    public double checkPrice(int id) {
        try {
            String query = "SELECT * FROM Product WHERE ProductID = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                double price = resultSet.getDouble(3);
                resultSet.close();
                statement.close();
                return price;
            }
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return 0;
    }
    
    public void subtractProductQuantity(int id, double quantity) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE ProductID = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                statement = connection.prepareStatement("UPDATE Product SET Quantity = ? WHERE ProductID = ?");
                statement.setInt(2, id);
                double updatedQty = resultSet.getDouble(4) - quantity;
                statement.setDouble(1, updatedQty);
            }
            statement.execute();
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
    }

    public Product loadProduct(int id) {
        try {
            String query = "SELECT * FROM Product WHERE ProductID = " + id;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Product product = new Product();
                product.setID(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));
                product.setQuantity(resultSet.getDouble(4));
                product.setTaxRate(resultSet.getDouble(5));
                product.setExpirationDate(resultSet.getString(6));
                product.setSupplier(resultSet.getString(7));
                product.setUnit(resultSet.getDouble(8));
                resultSet.close();
                statement.close();

                return product;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }

    public void saveProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE ProductID = ?");
            statement.setInt(1, product.getID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Product SET Name = ?, Price = ?, Quantity = ?, TaxRate = ?, ExpirationDate = ?, Supplier = ?, Unit = ? WHERE ProductID = ?");
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setDouble(3, product.getQuantity());
                statement.setDouble(4, product.getTaxRate());
                statement.setString(5, product.getExpirationDate());
                statement.setString(6, product.getSupplier());
                statement.setDouble(7, product.getUnit());
                statement.setInt(8, product.getID());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                statement.setInt(1, product.getID());
                statement.setString(2, product.getName());
                statement.setDouble(3, product.getPrice());
                statement.setDouble(4, product.getQuantity());
                statement.setDouble(5, product.getTaxRate());
                statement.setString(6, product.getExpirationDate());
                statement.setString(7, product.getSupplier());
                statement.setDouble(8, product.getUnit());
            }
            statement.execute();

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
    }

    
    public void storeOrder(String paymentType, double totalAmount) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                statement = connection.prepareStatement("INSERT INTO Orders VALUES (?, ?, ?, ?, ?)");
                statement.setString(2, paymentType);
                statement.setDouble(3, totalAmount);
                statement.setString(4, new Date().toString());
                statement.setString(5, "Mr. Smith Goods");
            }
            else {
                statement = connection.prepareStatement("INSERT INTO Orders VALUES (?, ?, ?, ?, ?)");
                statement.setInt(1, 2000);
                statement.setString(2, paymentType);
                statement.setDouble(3, totalAmount);
                statement.setString(4, new Date().toString());
                statement.setString(5, "Mr. Smith Goods");
            }
            statement.execute();

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
    }
    
    public User loadUser(int userID) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE UserID = ?");
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("UserID"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
                user.setDisplayName(resultSet.getString("DisplayName"));
                user.setManagerStatus(resultSet.getInt("IsManager"));
                resultSet.close();
                statement.close();

                return user;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }
    
    public void saveUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE UserID = ?");
            statement.setInt(1, user.getUserID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE User SET UserName = ?, DisplayName = ?, Password = ?, IsManager = ? WHERE UserID = ?");
                statement.setString(1, user.getUserName());
                statement.setString(2, user.getDisplayName());
                statement.setString(3, user.getPassword());
                statement.setInt(4, user.getManagerStatus());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO User VALUES (?, ?, ?, ?, ?, ?)");
                statement.setInt(1, user.getUserID());
                statement.setString(2, user.getUserName());
                statement.setString(3, user.getPassword());
                statement.setString(4, user.getDisplayName());
                statement.setInt(5, user.getManagerStatus());
                statement.setString(6, "default.jpg");
            }
            statement.execute();

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
    }
    
    public User loadUser(String userName, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE UserName = ? AND Password = ?");
            statement.setString(1, userName);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("UserID"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
                user.setDisplayName(resultSet.getString("DisplayName"));
                user.setManagerStatus(resultSet.getInt("IsManager"));
                resultSet.close();
                statement.close();

                return user;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }
    
    public String sortReport(String startDate, String endDate, String sortOption) {
        try {
            ArrayList<String> al = new ArrayList<String>();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE Date >= ? AND Date <= ?");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            ResultSet resultSet = statement.executeQuery();
            String reportString = "";
            double total = 0;
            while (resultSet.next()) {
                total += resultSet.getDouble("Amount");
                if (sortOption.compareTo("Amount") == 0)
                {
                  String toAdd = Double.toString(resultSet.getDouble("Amount")) + ","
                     + Integer.toString(resultSet.getInt("OrderID")) + ","
                     + resultSet.getString("Date");
                  al.add(toAdd);
                }
                else if (sortOption.compareTo("Date") == 0)
                {
                  String toAdd = resultSet.getString("Date") + ","
                     + Integer.toString(resultSet.getInt("OrderID")) + ","
                     + Double.toString(resultSet.getDouble("Amount"));
                  al.add(toAdd);
                }
            }
            Collections.sort(al);
            if (sortOption.compareTo("Amount") == 0)
            {
               reportString = "Amount\t\tOrderID\t\tDate\n";
               for (String s : al) {
                   reportString += s.substring(0, s.indexOf(','));
                   s = s.substring(s.indexOf(',') + 1, s.length());
                   reportString += "\t\t" + s.substring(0, s.indexOf(','));
                   s = s.substring(s.indexOf(',') + 1, s.length());
                   reportString += "\t\t" + s.substring(0, s.length()) + "\n";
               }
            }
            else if (sortOption.compareTo("Date") == 0)
            {
               reportString = "Date\t\tOrderID\t\tAmount\n";
               for (String s : al) {
                   reportString += s.substring(0, s.indexOf(','));
                   s = s.substring(s.indexOf(',') + 1, s.length());
                   reportString += "\t\t" + s.substring(0, s.indexOf(','));
                   s = s.substring(s.indexOf(',') + 1, s.length());
                   reportString += "\t\t" + s.substring(0, s.length()) + "\n";
               }
            }
            reportString += "\nTotal Monthly Revenue:\t$" + df.format(total);
            resultSet.close();
            statement.close();
            return reportString;
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return "";
    }
    
    public String loadReport(String startDate, String endDate) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE Date >= ? AND Date <= ?");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            ResultSet resultSet = statement.executeQuery();
            String reportString = "Order ID\t\tAmount\t\tDate\n";
            double total = 0;
            while (resultSet.next()) {
                total += resultSet.getDouble("Amount");
                reportString += Integer.toString(resultSet.getInt("OrderID"))
                     + "\t\t" + Double.toString(resultSet.getDouble("Amount"))
                     + "\t\t" + resultSet.getString("Date") + "\n";
            }
            reportString += "\nTotal Monthly Revenue:\t$" + df.format(total);
            resultSet.close();
            statement.close();
            return reportString;
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return "";
    }
    
    public void changePass(String oldPassword, String newPassword) {
        User currentUser = app.getCurrentUser();
        int userID = currentUser.getUserID();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE UserID = ? AND Password = ?");
            statement.setInt(1, userID);
            statement.setString(2, oldPassword);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                statement = connection.prepareStatement("UPDATE User SET Password = ? WHERE UserID = ? AND Password = ?");
                statement.setString(1, newPassword);
                statement.setInt(2, userID);
                statement.setString(3, oldPassword);
                statement.execute();
                resultSet.close();
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
    }
    
    public String retrieveImage() {
        User currentUser = app.getCurrentUser();
        int userID = currentUser.getUserID();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE UserID = ?");
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String imageReturn = resultSet.getString("PictureName");
                statement.execute();
                resultSet.close();
                statement.close();
                return imageReturn;
            }
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return "default.jpg";
    }
    
    public void changePicture(String imageLink) {
        User currentUser = app.getCurrentUser();
        int userID = currentUser.getUserID();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE UserID = ?");
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                statement = connection.prepareStatement("UPDATE User SET PictureName = ? WHERE UserID = ?");
                statement.setString(1, imageLink);
                statement.setInt(2, userID);
                statement.execute();
                resultSet.close();
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
    }
}
