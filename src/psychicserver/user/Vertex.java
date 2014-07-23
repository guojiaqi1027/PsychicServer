/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package psychicserver.user;

import java.util.ArrayList;
import java.util.List;



/**
 * Vertex class in Graph Algorithm
 * @author GawainGuo
 */
public class Vertex {
    private float coordinate_x;
    private float coordinate_y;
    private ArrayList<Vertex> adjVerticesList;
    /**
     * Constructor of Vertex
     * @param x x-coordinate of vertex
     * @param y y-coordinate 0f vertex
     */
    public Vertex(float x,float y){
        coordinate_x=x;
        coordinate_y=y;
        adjVerticesList=new ArrayList<Vertex>();
    }
    /**
     * Connect V with this vertex
     * Update Arraylist of this and v
     * @param v 
     */
    public void connectVertex(Vertex v){
        v.adjVerticesList.add(this);
        this.adjVerticesList.add(v);
    }
    /**
     * Breath first search in graph
     * @return return the adjVertices list
     */
    public ArrayList BFS(){
        return adjVerticesList;
    }
        
}
class VertexNode{
    public Vertex v;
    //public float 
}
