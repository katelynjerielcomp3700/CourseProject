import java.sql.*;
import java.util.Date;
import java.time.format.DateTimeFormatter;
public class DataAdapter {
    private Connection connection;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public DataAdapter(Connection connection) {
        this.connection = connection;
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
    
    public String loadReport(String startDate, String endDate) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE Date >= ? AND Date <= ?");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            ResultSet resultSet = statement.executeQuery();
            String reportString = "";
            while (resultSet.next()) {
                reportString += Integer.toString(resultSet.getInt("OrderID"))
                     + "\t" + Double.toString(resultSet.getDouble("Amount"))
                     + "\t" + resultSet.getString("Date") + "\n";
            }
            resultSet.close();
            statement.close();
            System.out.println(reportString);
            return reportString;
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return "";
    }
}
