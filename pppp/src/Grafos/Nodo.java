/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CORE I5 6TA
 */
public class Nodo {
   
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    private int x, y, contador;

    public int getContador() {
        return contador;
    }

    public String getNombre() {
        return nombre;
    }
    private final String nombre;
 public static final int distancia = 56;



  
    public Nodo(int x, int y, String nombre, int cont) {
        this.x = x;
        this.y = y;
   this.nombre = nombre;
this.contador = cont;

        }

 

   

   public void paint(Graphics g) {
       Ellipse2D.Double circle = new Ellipse2D.Double(this.x-distancia/2, this.y - distancia/2, distancia, distancia);
       Graphics2D g1= (Graphics2D) g;
     g1.setColor(Color.cyan);
         g1.draw(circle);
             g1.setColor(Color.black);
         g1.drawString(nombre, this.x , this.y);
//        g1.setColor(Color.cyan);
//        g1.fillOval(this.x-distancia/4, this.y + distancia/3, distancia, distancia);

       
                   
                }
    
}
