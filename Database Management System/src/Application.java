import java.sql.*;

public class Application {
    private static Application instance;
    private DataAdapter dataAdapter;
    private ProductView productView;
    private CheckoutView checkoutView;
    private MainScreen mainScreen;
    private ProductController productController;
    private CheckoutController checkoutController;
    private Connection connection;

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }
    
    private Application() {
        //Connects to SQLite database
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:store.db");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("SQLite is not installed. System exits with error!");
            System.exit(1);
        }
        catch (SQLException ex) {
            System.out.println("SQLite database is not ready. System exits with error!");
            System.exit(2);
        }

        //Creates data adapter
        dataAdapter = new DataAdapter(connection);

        //Creates the Product View and Controller
        productView = new ProductView();
        checkoutView = new CheckoutView();

        productController = new ProductController(productView, dataAdapter);
        checkoutController = new CheckoutController(checkoutView, dataAdapter);

        mainScreen = new MainScreen();
    }
    
    public Connection getConnection() {
        return connection;
    }

    //GUI Elements
    public MainScreen getMainScreen() {
        return mainScreen;
    }
    
    public CheckoutView getCheckoutView() {
         return checkoutView;
    }

    public ProductView getProductView() {
        return productView;
    }

    //Controller Elements
    public ProductController getProductController() {
        return productController;
    }

    public CheckoutController getCheckoutController() {
        return checkoutController;
    }

    //Data Access Layer
    public DataAdapter getDataAdapter() {
        return dataAdapter;
    }
    
    public static void main(String[] args) {
        Application.getInstance().getMainScreen().setVisible(true);
    }
}
