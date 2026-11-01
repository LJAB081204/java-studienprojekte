/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum1.Aufgabe1;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lewis Ashton-Braun
 */
public class NumberInputStream extends InputStream { //subklasse von InputStream

    private final Reader r;                     // finale variable

    /**
     * 
     * @param r uebergebener reader
     */
    public NumberInputStream(Reader r) {

        this.r = r;
    }

    /**
     * 
     * @return die eingelesenen Ziffern bis zum nächsten Whitespace als String zurück
     */
    @Override
    public int read() {

        int n;
        char c;
        String s = "";

        try {
            while ((n = r.read()) != -1) { // lesen des InputStreams
                c = (char) n;
                if (Character.isWhitespace(c)) { //white space abfrage
                    break;
                }

                s += c;     // Sringbildung
                if ("".equals(s)) { 
                    read();}

                }

            }catch (IOException ex) {
            Logger.getLogger(NumberInputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
            // Lewis: Grenzwert 255, weil ein Byte in einem Stream nur 0 bis 255 darstellen kann
            if (Integer.parseInt(s) > 255) {
                throw new NumberTooLargeException(Integer.parseInt(s));
            }

            return Integer.parseInt(s);
        }
    }
