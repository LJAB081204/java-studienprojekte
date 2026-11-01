/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum1.Aufgabe1;

/**
 *
 * @author lewis
 */
// Lewis: RuntimeException (unchecked), damit read() keine throws-Klausel braucht und die Signatur von InputStream gleich bleibt
public class NumberTooLargeException extends RuntimeException{

    /**
     * 
     * @param nummer die zu groß ist
     */
    public NumberTooLargeException(int nummer) {
    
    super("Die Zahl " + nummer + " ist zu groß"); //Nachricht zur Exception
    }
}
