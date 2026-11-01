/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum4;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author lewis
 */
public class Controller {
    
    Model model;
            
    public Controller(Model model){
        this.model = model;
    }
    public void handleSuche(KeyEvent t){
        FilteredList<EBU> liste = (FilteredList)model.getListe();
        TextField tf = (TextField) t.getSource();
        
        String text = tf.getText().toLowerCase();
        
        // Lewis: Predicate wird bei jedem Tastendruck neu gesetzt, die FilteredList aktualisiert die Tabelle live
        liste.setPredicate(ebu -> filterEbu(ebu,text));
    } 
    
    public void handleComboBox(ActionEvent t){
        ComboBox source = (ComboBox) t.getSource();
        FilteredList<EBU> liste = model.getListe();
        String val =(String) source.getValue();
        model.getListe().setPredicate(ebu -> {
            switch(val){
                case "Gueterverkehr":
                    return ebu.getGv().equals("Ja");
                case "Personenverkehr":
                    return ebu.getPv().equals("Ja");
                default :
                    return true;
            }
        });
        
    }
    
    public boolean filterEbu(EBU e,String text){
        if(e.getUnternehmen().toLowerCase().contains(text)|| e.getStrasse().toLowerCase().contains(text)|| e.getPlz().toLowerCase().contains(text)|| e.getOrt().toLowerCase().contains(text)){
            return true;
        }
        return false;
    }
    
    
}
