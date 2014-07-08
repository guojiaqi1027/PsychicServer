/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package psychicserver;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import psychicserver.UI.PsychicUI;
/**
 *
 * @author GawainGuo
 */

public class PsychicServer {
public static void main(String[] args) throws IOException {
        PsychicUI ui=new PsychicUI();
        System.out.println("MAIN_AFTERUI");
        Connection connection=new Connection(ui);
        connection.run();
    }
    
}
class Connection implements Runnable{
    private PsychicUI ui;
    private String returnMessage="Return";
    public Connection(PsychicUI u){
        ui=u;
    }
    @Override
    public void run() {
        while(true){
            if(ui.isStarted){
                System.out.println("MAIN_CONNECTION_ISSTARTED");
                try {
               System.out.println("MAIN_CONNECTION_WAIT");  
               System.out.println("MAIN_CONNECTION_IP "+ui.psychicServer.getServerIP());  
               ui.psychicServer.buildUpConnection();
               System.out.println("MAIN_CONNECTION_CONNECTED");
               ui.appendText("Connected from "+ui.psychicServer.getClientIP());
               ui.appendText(" ");
               ui.setClientText(ui.psychicServer.getClientIP());
               ui.appendText("Message Receive:");
               ui.appendText(ui.psychicServer.receiveMessage());
               ui.appendText("From: "+ui.psychicServer.getClientIP());
               ui.appendText(" ");
               ui.appendText("Message Send:");
               ui.appendText(ui.psychicServer.sendMessage(returnMessage));
               ui.appendText("To: "+ui.psychicServer.getClientIP());
               ui.appendText(" ");
               ui.psychicServer.closeSocket();
           } catch (IOException ex) {
               Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
           }
            }
            else{
                System.out.println("MAIN_CONNECTION_NOTSTARTED");
            }
        }
         
    }
}