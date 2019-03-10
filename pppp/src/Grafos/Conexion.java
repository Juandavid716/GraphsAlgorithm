/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.Graphics;

/**
 *
 * @author CORE I5 6TA
 */
public class Conexion {
    private int x1,y1,x2,y2;
private String nombre;

    public boolean isSw() {
        return sw;
    }

    public void setSw(boolean sw) {
        this.sw = sw;
    }
public boolean sw;

    public boolean isSw2() {
        return sw2;
    }

    public void setSw2(boolean sw2) {
        this.sw2 = sw2;
    }
public boolean sw2;
    public String getNombre() {
        return nombre;
    }
    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public Conexion(int x1, int y1, int x2, int y2, String nombre, boolean sw, boolean sw2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.nombre = nombre;
        this.sw = sw;
    }
    public void paint(Graphics g){
    g.drawLine(x1, y1, x2, y2);
    if(x1 > x2 && y1 > y2){
    g.drawString(nombre, x1-Math.abs((x1-x2)/2), y1-Math.abs((y1-y2)/2));
    }
    if(x1 < x2 && y1 < y2){
    g.drawString(nombre, x2-Math.abs((x1-x2)/2), y2-Math.abs((y1-y2)/2));
    }
    if(x1 > x2 && y1 < y2){
    g.drawString(nombre, x1-Math.abs((x1-x2)/2), y2-Math.abs((y1-y2)/2));
    }
    if(x1 < x2 && y1 > y2){
    g.drawString(nombre, x2-Math.abs((x1-x2)/2), y1-Math.abs((y1-y2)/2));
    }
    }
    public void pintar(Graphics g){
    g.drawLine(x1, x1, x2, x1);
    }
}
