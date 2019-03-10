/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author CORE I5 6TA
 */
public class Validacion {
    public Boolean SoloNumeros(String ca) {
        int sw =0;
     String x = "0123456789";
        for (int i = 0; i < x.length(); i++) {
         
            for (int j = 0; j < ca.length(); j++) {
                 if(x.substring(i,i+1).equals(ca.substring(j, j+1))){
             sw++;
            }
            }
           
        }
        if(sw==ca.length()){
        return true;
        }
        return false;
    }
}
