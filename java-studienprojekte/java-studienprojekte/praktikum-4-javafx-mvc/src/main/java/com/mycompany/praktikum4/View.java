/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lewis
 */
public class View  {

    VBox wurzel = new VBox();
    
    public void buildGUI(Stage stage, Controller c, Model m) throws Exception {
        
        TextField eingabe = new TextField("Eingabe");
        TableView<EBU> table = new TableView();
        ObservableList<String> verkehr = FXCollections.observableArrayList("Güterverkehr", "Personenverkehr", "Beide");
        ComboBox <String> box = new ComboBox<>(verkehr);
        
        TableColumn<EBU,String> untC = new TableColumn("Unternehemen");
        untC.setCellValueFactory(new PropertyValueFactory<>("unternehmen"));
        
        TableColumn<EBU,String> strC = new TableColumn("Straße");
        strC.setCellValueFactory(new PropertyValueFactory<>("strasse"));
        
        TableColumn<EBU,String> plzC = new TableColumn("Plz");
        plzC.setCellValueFactory(new PropertyValueFactory<>("plz"));
        
        TableColumn<EBU,String> ortC = new TableColumn("Ort");
        ortC.setCellValueFactory(new PropertyValueFactory<>("ort"));
        
        TableColumn<EBU,String> gvC = new TableColumn("Güterverkeher");
        gvC.setCellValueFactory(new PropertyValueFactory<>("gv"));
        
        TableColumn<EBU,String> pvC = new TableColumn("Personenverkehr");
        pvC.setCellValueFactory(new PropertyValueFactory<>("pv"));
        
        table.getColumns().addAll(untC,strC,plzC,ortC,gvC,pvC);
        
        wurzel.getChildren().add(eingabe);
        wurzel.getChildren().add(box);
        wurzel.getChildren().add(table);
        
        eingabe.setOnKeyPressed(t -> c.handleSuche(t));
        box.setOnAction(t -> c.handleComboBox(t));
        
        table.setItems(m.getListe());
        
        var scene = new Scene(wurzel, 640, 480);
        stage.setScene(scene);
        stage.show();

    }

    public VBox getWurzel() {
        return wurzel;
    }
    
    
}
