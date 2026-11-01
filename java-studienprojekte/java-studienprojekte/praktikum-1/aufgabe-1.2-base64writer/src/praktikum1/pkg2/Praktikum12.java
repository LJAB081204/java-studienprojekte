/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praktikum1.pkg2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lewis
 */
public class Praktikum12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Writer out = new Base64Writer(new FileOutputStream("test.txt"));
            out.write("123testtest1234");
            out.flush();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Praktikum12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Praktikum12.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
