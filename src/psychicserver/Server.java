/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package psychicserver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author GawainGuo
 */
public class Server {
    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in=null;
    private PrintWriter out=null;
    public Server(int p){
        port=p;
    }
    public void startServer() throws IOException{
        serverSocket=new ServerSocket(port);
    }
    public void buildUpConnection() throws IOException{
        System.out.println("SERVER_STARTBUILDUP");
        clientSocket=new Socket();
        System.out.println("SERVER_SOCKETSTART");
        clientSocket=serverSocket.accept();
        System.out.println("SERVER_CONNECTED");
        in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out=new PrintWriter(clientSocket.getOutputStream());
    }
    public String receiveMessage() throws IOException{
        String message;
        //ReceiveThread receive=new ReceiveThread(clientSocket);
        message=in.readLine();
        return message;
        
    }
    public String sendMessage(String m) throws IOException{
        out.println(m);
        out.flush();
        //SendThread send=new SendThread(clientSocket,m);
        return m;
        
    }
    public void closeSocket() throws IOException{
        clientSocket.close();
    }
    public void closeServer() throws IOException{
        serverSocket.close();
    }
    public String getClientIP(){
        return clientSocket.getInetAddress().getHostAddress();
    }
    public String getServerIP() throws UnknownHostException{
        return InetAddress.getLocalHost().getHostAddress();
    }
}

/*
class ReceiveThread implements Runnable{
    private Socket client;
    private BufferedReader in=null;
    private String message=null;
    public ReceiveThread(Socket c){
        client=c;
    }
    public String getMessage(){
        return message;
    }
    @Override
    public void run() {

        try {
            in=new BufferedReader(new InputStreamReader(client.getInputStream()));
            message=in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ReceiveThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
class SendThread implements Runnable{
    private Socket client;
    private PrintWriter out=null;
    private String message=null;
    public SendThread(Socket c,String m){
        client=c;
        message=m;
    }
    public String getMessage(){
        return message;
    }
    @Override
    public void run() {
        try {
            out=new PrintWriter(client.getOutputStream());
            out.println(message);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(SendThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}*/
