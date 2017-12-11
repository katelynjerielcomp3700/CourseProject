import java.net.*;
import java.io.*;
import java.sql.*;

import com.google.gson.Gson;

public class StoreServer extends Thread {
    protected Socket clientSocket;
    protected DataAdapter dataAdapter;
    private Gson gson = new Gson();     // JSON parser from Google

    private StoreServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            Class.forName("org.sqlite.JDBC");  // connect to its local database
            dataAdapter = new DataAdapter(DriverManager.getConnection("jdbc:sqlite:store.db"));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        start();
    }

    private Object processRequest(ClientRequest request) throws Exception {
        if (request.getCommand().equals("GET User"))
            return dataAdapter.loadUser(Integer.parseInt(request.getData()));

        if (request.getCommand().equals("PUT User")) {
            User user = gson.fromJson(request.getData(), User.class);
            return "OK";
        }

        return null;
    }

    public void run() {
        System.out.println("New communication thread started for client socket " + clientSocket.getInetAddress() + " at " + System.currentTimeMillis());

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while (true) {
                String json = in.readLine();
                if (json == null) break;

                ClientRequest request = gson.fromJson(json, ClientRequest.class);   // convert JSON text into a Request object

                if (request.getCommand().equals("BYE")) break;

                String response = gson.toJson(processRequest(request));             // process the request...
                out.println(response); // write response as JSON back to client
            }
            System.out.println("Connection closed for client from " + clientSocket.getInetAddress());
            out.close();
            in.close();
            clientSocket.close();

        } catch (Exception e) {
            System.err.println("Problem with Communication Server" + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("Server Socket created!");
        while (true) {
            System.out.println("Waiting for a new connection...");
            new StoreServer(serverSocket.accept()); // if there is a client connecting
//            thread.start(); // then make a new Server thread and run it
        }
    }

} 

