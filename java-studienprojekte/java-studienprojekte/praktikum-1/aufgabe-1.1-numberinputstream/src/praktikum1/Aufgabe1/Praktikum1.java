/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praktikum1.Aufgabe1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lewis
 */
public class Praktikum1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        try (NumberInputStream in2 = new NumberInputStream(new FileReader(args[0]))){
            System.out.println(in2.read());
            System.out.println(in2.read());
            System.out.println(in2.read());
            System.out.println(in2.read());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Praktikum1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Praktikum1.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

}
