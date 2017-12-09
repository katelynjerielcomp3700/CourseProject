import com.google.gson.Gson;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RemoteDataAdapter implements IDataAccess {

    private PrintWriter outStream;
    private BufferedReader inStream;
    private Socket socket;
    private Gson gson = new Gson();

    public RemoteDataAdapter(String hostName, int portNumber) {
        try {
            socket = new Socket(hostName, portNumber);
            outStream = new PrintWriter(socket.getOutputStream(), true);
            inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public User loadUser(String username, String password) {
        try {
            ClientRequest request = new ClientRequest("GET Product", String.valueOf(username));
            outStream.println(gson.toJson(request));
            String serverAnswer = inStream.readLine();
            return gson.fromJson(serverAnswer, User.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public boolean saveUser(User user) {
        try {
            ClientRequest request = new ClientRequest("PUT User", gson.toJson(user));
            outStream.println(gson.toJson(request));

            String serverAnswer = inStream.readLine();
            if (serverAnswer.equals("ERROR"))
                return false;
            else
                return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }


}
