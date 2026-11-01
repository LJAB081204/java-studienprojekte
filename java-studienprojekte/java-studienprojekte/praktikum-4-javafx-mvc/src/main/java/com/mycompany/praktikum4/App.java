package com.mycompany.praktikum4;

import java.io.File;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        View view = new View();
        Model m = new Model();
        File file = new File("evu_brd_gekuerzt.csv");
        m.perReader(file);
        Controller c = new Controller(m);
        view.buildGUI(stage,c,m);
       
   
        
    }

    public static void main(String[] args) {
                
        launch();
    }
    
    

}