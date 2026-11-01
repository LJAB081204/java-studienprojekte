/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum1.pkg2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lewis ashton-braun
 */
public class Base64Writer extends java.io.OutputStreamWriter {

    public OutputStream out;

    /**
     * 
     * @param out der übergebene OutputStream
     */
    public Base64Writer(OutputStream out) {
        super(out);
        this.out = out;
    }

//    @Override
//    public void write(char[] cbuf, int off, int len){
//        Base64.getEncoder().wrap(out);
//        byte [] c = new byte[len];
//        
//        for(int i = 0;i<cbuf.length; i++){
//            c[i] =(byte) cbuf[i];
//        }
//        try {
//            out.write(c, off, len);
//        } catch (IOException ex) {
//            Logger.getLogger(Base64Writer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        }
//    
//   
//    
//        
//    @Override 
//    public void write(int c){
//        Base64.getEncoder().wrap(out);
//        try {
//            out.write(c);
//        } catch (IOException ex) {
//            Logger.getLogger(Base64Writer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    @Override
//    public void write(String str,int off, int len){
//        Base64.getEncoder().wrap(out);
//        byte[]b = str.getBytes();
//        try {
//            out.write(b, off, len);
//        } catch (IOException ex) {
//            Logger.getLogger(Base64Writer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    /**
     * 
     * @param str String der Base64-Verschlüsselt werden soll
     */
    @Override
    public void write(String str){
        // Lewis: wrap() kodiert alle Bytes, die in output geschrieben werden, direkt als Base64 und leitet sie an out weiter
        OutputStream output = Base64.getEncoder().wrap(out); //encodet den Stream in Base64 Codierung
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
            output.write(bytes);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Base64Writer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Base64Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }

