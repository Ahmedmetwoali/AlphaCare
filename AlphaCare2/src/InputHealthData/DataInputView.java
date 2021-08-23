 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputHealthData;

/**
 *
 * @author Ahmed Metwoali
 */

import AlphaCare.AlphaCareHeader;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DataInputView extends Application {
    private Text inputDataHeader = new Text("Please Fill Patient Information");;
    private Scene scene;
    private DataModel dataModel = new DataModel();
    private DataController dataController;
    //private Text hotSpotStageText, hotSpotBooleanText;
    //private AlphaCare.ControllerCore controllerCore;
    private Button generateReportButton, returnHomeButton;
    private Text mainHeader, generateReportHeader, txtName, txtDOB, txtID, txtComments, reportHeader;
    private TextField patientNameField , patientDOBField , patientID , doctorCommentField;
    private Stage primaryStage;
    private Stage reportStage = new Stage();
    
    public DataInputView (Stage stage) {
        this.primaryStage = stage;
        

        setPrimaryStage(primaryStage);

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setPrefSize(1200, 900);
            grid.setVgap(25);
            scene = new Scene(grid);
            grid.setScaleX(1.2);
            grid.setScaleY(1);
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.CENTER);
            grid.getColumnConstraints().add(column);

            primaryStage.setTitle("Input Health Data");
            primaryStage.setScene(scene);
            primaryStage.show();

            mainHeader = AlphaCareHeader.getAlphaCareHeader().getMainHeader();
            grid.add(mainHeader, 0, 0);

            generateReportHeader = new Text();
            generateReportHeader.setFont(Font.font("Tahoma", FontWeight.NORMAL, 48));
            generateReportHeader.setText("Input Health Data");
            grid.add(generateReportHeader, 0, 2);

            // Create Patient Name Text Field
            patientNameField = new TextField();
            patientNameField.setFocusTraversable(false);
            //patientNameField.setAlignment(Pos.CENTER);
            patientNameField.setPromptText("Enter Patient Name");
            patientNameField.isEditable();
            
            // Create Patient DOB Text Field
            patientDOBField = new TextField();
            patientDOBField.setFocusTraversable(false);
            //patientDOBField.setAlignment(Pos.CENTER);
            patientDOBField.setPromptText("Enter Patient DOB");
            
            // Create Patient ID Text Field
            patientID = new TextField();
            patientID.setFocusTraversable(false);
            //patientID.setAlignment(Pos.CENTER);
            patientID.setPromptText("Enter Patient ID");
            
            // Create Doctor Comment Text Field
            doctorCommentField = new TextField();
            doctorCommentField.setFocusTraversable(false);
            //doctorCommentField.setAlignment(Pos.CENTER);
            doctorCommentField.setPromptText("Enter Doctor comments");
            
            txtName = new Text();
            
            txtDOB = new Text();
            
            txtID = new Text();
            
            txtComments = new Text();
            
            reportHeader = new Text();
            reportHeader.setFont(Font.font("Tahoma", FontWeight.NORMAL, 48));
            reportHeader.setText("Report Generated");
            
            

            // Create Generate Report button
            generateReportButton = new Button();
            generateReportButton.setMinSize(450, 60);
            //generateReportButton.setAlignment(Pos.CENTER);
            generateReportButton.setText("Generate Report");

   

            // Create return home button
            returnHomeButton = new Button();
            returnHomeButton.setMinSize(450, 60);
            //returnHomeButton.setAlignment(Pos.CENTER);
            returnHomeButton.setText("Go Back");


            // Add components to grid
            grid.add(patientNameField, 0, 3);
            grid.add(patientDOBField, 0, 4);
            grid.add(patientID, 0, 5);
            grid.add(doctorCommentField, 0, 6);
            grid.add(generateReportButton, 0, 7);
            grid.add(returnHomeButton, 0, 8);

            //dataController = getDataController();
            //dataController.buttonListeners(generateReportButton, returnHomeButton);
            
           
        
    }

    public void report(Stage reportStage) {
        GridPane newGrid = new GridPane();
        Scene gReport = new Scene(newGrid);
        newGrid.setPrefSize(1200, 900);
        newGrid.setAlignment(Pos.TOP_CENTER);
        newGrid.setVgap(10);
        newGrid.setHgap(10);
        newGrid.setScaleX(1.2);
        newGrid.setScaleY(1);
        reportStage.setScene(gReport);
        reportStage.show();
        
        txtID.setText(patientID.getText());
        txtName.setText(patientNameField.getText());
        txtDOB.setText(patientDOBField.getText());
        txtComments.setText(doctorCommentField.getText());
        
        newGrid.add(txtID, 0, 2);
        newGrid.add(txtName, 0, 3);
        newGrid.add(txtDOB, 0, 4);
        newGrid.add(txtComments, 0, 5);
        newGrid.add(reportHeader, 0, 0);
        
    }

    @Override
        public void start(Stage primaryStage) {

            
        }
   

    public DataController getDataController() {
        return dataController;
    }

    public void setDataController (DataController dataController) {
        this.dataController = dataController;
    }

   
    public Button getReturnHomeButton() {
        return returnHomeButton;
    }

    public void setReturnHomeButton(Button returnHomeButton) {
        this.returnHomeButton = returnHomeButton;
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

  

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Button getGenerateReportButton() {
        return generateReportButton;
    }

    public void setGenerateReportButton(Button generateReportButton) {
        this.generateReportButton = generateReportButton;
    }
    
    
        }
        
   

