import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.DriverManager;

public class ProxyDataAdapter implements IDataAccess {
    String hostName;
    int portNumber;

    private DataAdapter getLocalDataAdapter() {
        if (localDataAdapter == null) {
            try {
                localDataAdapter = new DataAdapter(DriverManager.getConnection("jdbc:sqlite:store.db"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return localDataAdapter;
    }

    private RemoteDataAdapter getRemoteDataAdapter() {
        if (remoteDataAdapter == null)
            System.out.println("Need access to remote data server!!!!");
           System.out.println("Attemping to connect to host " + hostName + " on port " + portNumber);

        remoteDataAdapter = new RemoteDataAdapter(hostName, portNumber);
        return remoteDataAdapter;
    }

    DataAdapter localDataAdapter = null;
    RemoteDataAdapter remoteDataAdapter = null;

    public ProxyDataAdapter(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }


    public User loadUser(String username, String password) {
        User user;
        user = getLocalDataAdapter().loadUser(username, password);
        if (user == null) {
            user = getRemoteDataAdapter().loadUser(username, password);
            if (user != null)
                localDataAdapter.saveUser(user);
        }
        return user;
    }

    public boolean saveUser(User user) {
        return getRemoteDataAdapter().saveUser(user);
    }
}
