import java.sql.*;

public class Application {
    private static Application instance;
    //Data Layer
    private DataAdapter dataAdapter;
    //View Layer
    private LoginScreen loginScreen;
    private MainScreen mainScreen;
    private CheckoutView checkoutView;
    private ManagerView managerView;
    private ProductView productView;
    private UserView userView;
    private SettingsView settingsView;
    private ReportsView reportsView;
    private PicturesView picturesView;
    //Controller Layer
    private ProductController productController;
    private CheckoutController checkoutController;
    private LoginController loginController;
    private UserController userController;
    private ReportsController reportsController;
    //Miscellaneous
    private Connection connection;
    private User currentUser;

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
        dataAdapter = new DataAdapter(connection, this);

        //Creates the various View classes
        mainScreen = new MainScreen();
        loginScreen = new LoginScreen();
        managerView = new ManagerView();
        productView = new ProductView();
        checkoutView = new CheckoutView();
        userView = new UserView();
        settingsView = new SettingsView(dataAdapter);
        reportsView = new ReportsView();
        picturesView = new PicturesView();
         
        loginController = new LoginController(loginScreen, dataAdapter);
        productController = new ProductController(productView, dataAdapter);
        checkoutController = new CheckoutController(checkoutView, dataAdapter);
        userController = new UserController(userView, dataAdapter);
        reportsController = new ReportsController(reportsView, dataAdapter);
    }
    
    public Connection getConnection() {
        return connection;
    }

    //GUI Elements    
    public LoginScreen getLoginScreen() {
        return loginScreen;
    }
    public MainScreen getMainScreen() {
        return mainScreen;
    }
    
    public CheckoutView getCheckoutView() {
         return checkoutView;
    }
    
    public ManagerView getManagerView() {
         return managerView;
    }

    public ProductView getProductView() {
        return productView;
    }
    
    public UserView getUserView() {
        return userView;
    }
    
    public SettingsView getSettingsView() {
        return settingsView;
    }
    
    public ReportsView getReportsView() {
        return reportsView;
    }
    
    public PicturesView getPicturesView() {
        return picturesView;
    }

    //Controller Elements
    public ProductController getProductController() {
        return productController;
    }

    public CheckoutController getCheckoutController() {
        return checkoutController;
    }
    
    public LoginController getLoginController() {
        return loginController;
    }

    //Data Access Layer
    public DataAdapter getDataAdapter() {
        return dataAdapter;
    }
    
    public User getCurrentUser() {
        return currentUser;
    }
    
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
    
    //Main method - instantiate database management system
    public static void main(String[] args) {
        Application.getInstance().getLoginScreen().setVisible(true);
    }
}
