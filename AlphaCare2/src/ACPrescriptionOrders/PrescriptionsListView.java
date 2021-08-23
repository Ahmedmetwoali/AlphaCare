/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACPrescriptionOrders;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author taekim
 */
public class PrescriptionsListView extends Application {
    
    private PrescriptionRepo presRepo;
    private PrescriptionsController presController;
    private Text presStageText;
    private Button returnHomeButton;
    private Text presHeader;
    private ListView presListView;
    
    /**
     * Creates new form PrescriptionsListUI
     */
    public PrescriptionsListView() {
        this.presRepo = new PrescriptionRepo();
        System.out.println("The Prescriptions ListView class has been instantiated - Test Successful");
        presRepo = new PrescriptionRepo();
        presController = new PrescriptionsController();
    }     
    
    @Override
    public void start(Stage primaryStage) {
    
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPrefSize(1200, 900);
        grid.setVgap(25);
        Scene scene = new Scene(grid);
        grid.setScaleX(1.2);
        grid.setScaleY(1);
        ColumnConstraints column = new ColumnConstraints();
        column.setHalignment(HPos.CENTER);
        grid.getColumnConstraints().add(column);
        
        primaryStage.setTitle("Prescription Orders");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        presHeader = new Text();
        presHeader.setFont(Font.font("Tahoma", FontWeight.NORMAL, 72));
        presHeader.setText("Prescription Orders");
        grid.add(presHeader, 0, 0);
        
        // Create List View
        presListView = new ListView();
        presListView.getItems().add("Name: Tylenol,  Dosage: Tablet 325mg,  DoctorID: Kim, Tae,  PaientID: PID1001,  Priority: LOW ");
        presListView.getItems().add("Name: Advil,  Dosage: Caplet 325mg,  DoctorID: Kristen, Todd,  PaientID: PID1002,  Priority: LOW ");        
        presListView.getItems().add("Name: Ibuprofen,  Dosage: Tablet 500mg,  DoctorID: Mathews, Leslin,  PaientID: PID1003,  Priority: LOW ");
        presListView.getItems().add("Name: Paracetamol,  Dosage: Tablet 500mg,  DoctorID: Mclaughlin, Perry,  PaientID: PID1004,  Priority: MED ");
        presListView.getItems().add("Name: Aspirin,  Dosage: Caplet 325mg,  DoctorID: Gabriel, Selwyn,  PatientID: PID1005,  Priority: LOW ");
        presListView.getItems().add("Name: Morphine,  Dosage: Tablet 20mg,  DoctorID: Metwoali, Ahmed,  PatientID: PID1006,  Priority: HIGH ");    
        presListView.getItems().add("Name: Panadol,  Dosage Capsule 250mg,  DoctorID: Kinyua, Johnson,  PatientID: PID1007,  Priority: LOW "); 
        
        // Create Navigation Button
        returnHomeButton = new Button();
        returnHomeButton.setMinSize(450, 60);
        returnHomeButton.setAlignment(Pos.CENTER);
        returnHomeButton.setText("Main Menu");
        
        // Add components to grid
        grid.add(presListView, 0, 1);
        grid.add(returnHomeButton, 0, 2);

        returnHomeButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Object obj = event.getSource();
                    if (obj == returnHomeButton) {
                        primaryStage.close();
                    }
            }
        });
    }
}
