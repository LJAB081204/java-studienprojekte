/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum4;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author lewis
 */
public class EBU {
    private final StringProperty unternehmen;
    private final StringProperty strasse;
    private final StringProperty plz;
    private final StringProperty ort;
    private final StringProperty gv;
    private final StringProperty pv;
    
    public EBU(String unternehmen, String strasse, String plz, String ort, String gv, String pv){
        this.unternehmen = new SimpleStringProperty(unternehmen);
        this.strasse = new SimpleStringProperty(strasse);
        this.plz = new SimpleStringProperty(plz);
        this.ort = new SimpleStringProperty(ort);
        this.gv = new SimpleStringProperty(gv);
        this.pv = new SimpleStringProperty(pv);
    }

    public String getUnternehmen(){
        return unternehmen.get();
    }  
    
    public String getStrasse(){
        return strasse.get();
    } 
    
    public String getPlz(){
        return plz.get();
    } 
    
    public String getOrt(){
        return ort.get();
    } 
    
    public String getGv(){
        return gv.get();
    } 
    
    public String getPv(){
        return pv.get();
    } 
    
    
    
    
}
