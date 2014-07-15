/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package psychicserver.user;

import java.util.StringTokenizer;
import psychicserver.PsychicServer;

/**
 *
 * @author GawainGuo
 */
public class MessageProcess {
    public static String processMessage(String msg){
        StringTokenizer str=new StringTokenizer(msg,"#");
        String type=str.nextToken();
        switch(type){
            case "LOGIN":
                String username=str.nextToken();
                PsychicServer.mUser=new User(username);
                return "true";
            case "INI":
                float x=Float.valueOf(str.nextToken());
                float y=Float.valueOf(str.nextToken());
                PsychicServer.mUser.initialCoordinate(x, y);
                return null;
            case "ORI":
                float orientation=Float.valueOf(str.nextToken());
                if(PsychicServer.mUser!=null){
                PsychicServer.mUser.orientation=orientation;
                }
                return null;
            case "STEP":
            {
                int stepDetect=Integer.valueOf(str.nextToken());
                if(stepDetect==1){
                    PsychicServer.mUser.stepDetect();
                }
                return null;
            }
            default:return "false";  
        }
    }
}
