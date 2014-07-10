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
    public String userName;
    public float orientation;
    public float coordinate_x;
    public float coordinate_y;
    public User(String name, float x,float y){
        userName=name;
        coordinate_x=x;
        coordinate_y=y;
    }
}
