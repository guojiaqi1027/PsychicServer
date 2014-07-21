/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package psychicserver.user;

/**
 *
 * @author GawainGuo
 */
public class User {
    private String userName;
    public float orientation;
    private float coordinate_x;
    private float coordinate_y;
    private float stepLength=1.0f;
    public User(String name){
        userName=name;
    }
    public void initialCoordinate(float x, float y){
        coordinate_x=x;
        coordinate_y=y;
    }
    public void stepDetect(){
        coordinate_x=coordinate_x+stepLength*(float)Math.sin(orientation*Math.PI/180);
        coordinate_y=coordinate_y+stepLength*(float)Math.cos(orientation*Math.PI/180);
    }
    public float getCoordinate_x(){
        return coordinate_x;
    }
    public float getCoordinate_y(){
        return coordinate_y;
    }
    public String getUserName(){
        return userName;
    }
}
