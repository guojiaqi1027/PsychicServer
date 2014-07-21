/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package psychicserver.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author GawainGuo
 */
public class TrackingPanel extends JPanel {
    private ArrayList<TrackingPoint> PointArray;
    private BufferedImage trackingImage;

    private int x;
    private int y;
    public TrackingPanel() {
        this.PointArray = new ArrayList<TrackingPoint>();
       this.trackingImage=new BufferedImage(400,200,TYPE_INT_RGB);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d;
        /*
        g.setColor(Color.RED);
        for(int i=0;i<PointArray.size();i++){
            g.drawOval(PointArray.get(i).x, PointArray.get(i).x, 5, 5);
        }
                */
        g2d=trackingImage.createGraphics();
        g2d.setColor(Color.red);
        g2d.drawOval(x, y, 5, 5);
        g2d.fillOval(x, y, 5, 5);
        g.drawImage(trackingImage, 0 , 0, this);
        
    }
    public void updateCoordinate(int x_c,int y_c){
       /* PointArray.add(new TrackingPoint(x_c,y_c));
        System.out.println("ADD"+x_c+" "+y_c);*/
        x=x_c;
        y=y_c;
        repaint();
    }
    public void resetPaint(){
        PointArray=new ArrayList();
    }
}
class TrackingPoint{
    int x;
    int y;
    public TrackingPoint(int x_c,int y_c){
        x=x_c;
        y=y_c;
    }
}
