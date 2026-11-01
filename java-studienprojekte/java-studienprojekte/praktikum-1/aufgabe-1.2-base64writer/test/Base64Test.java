/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import praktikum1.pkg2.Base64Writer;

/**
 *
 * @author lewis
 */
public class Base64Test {
    
    public Base64Test() {
    }
    
    

  @Test
  public void writerTest(){
      Writer testee;
        try {
            testee = new Base64Writer(new FileOutputStream("test1.txt"));
            testee.write("123testtest1234");
            testee.flush();
            FileReader in = new FileReader("test1.txt");
            String s = "";
            char c;
            int i;
            while(( i = in.read())!= -1){
                c = (char)i;
                s += c;
            }
        
            System.out.println(s);
            assertTrue(s.equals("MTIzdGVzdHRlc3QxMjM0"));
  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Base64Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Base64Test.class.getName()).log(Level.SEVERE, null, ex);
        }
     
  }
}
