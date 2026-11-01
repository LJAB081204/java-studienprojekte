/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum4;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
 *
 * @author lewis
 */
public class Model {
    
    private final ObservableList<EBU> liste = FXCollections.observableArrayList();
    private final FilteredList<EBU> flist = new FilteredList<>(liste,p-> true);
    InputStream stream;
    
    public List<EBU> dateiLaden(File f){
        
        try {
            stream = new BufferedInputStream(new FileInputStream(f));
            byte[] b;
            int c;
            int index = 0;
            while((c = stream.read()) != 10){}
            b = stream.readAllBytes();
            
            
            while(index < b.length){
                while((c = stream.read()) != 10){
                    String s = "";
                    String unternehmen = "";
                    String strasse = "";
                    String plz = "";
                    String ort = "";
                    String gv = "";
                    String pv = "";
                    
                    for(int i = 0; i<6; i++){
                        while(c != ';'){
                            s += c;
                            index++;
                        }
                        index++;
                        switch(i){
                            case 0:
                                unternehmen = s;
                                break;
                            case 1:
                                strasse = s;
                                break;
                            case 2:
                                plz = s;
                                break;
                            case 3:
                                ort = s;
                                break;
                            case 4:
                                gv = s;
                                break;
                            case 5:
                                pv = s;
                        }
                    }
                    liste.add(new EBU(unternehmen, strasse, plz, ort, gv, pv));
                }
            }
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return liste;
    }
    
    public void perReader(File file) throws IOException {        
        try (var in = new BufferedReader(new FileReader(file))) {
            in.readLine();
            
              liste.setAll(in.lines().map(line -> line.split(";")).map(l -> new EBU(l[0], l[1], l[2], l[3], l[4], l[5])).collect(Collectors.toList()));
              
        }
    }

    public FilteredList<EBU> getListe() {
        
        return flist;
    }
    
}
