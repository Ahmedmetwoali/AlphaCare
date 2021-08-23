/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IdentifyHotSpots;

import AlphaCare.AlphaCareHeader;
import AlphaCare.ControllerCore;
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

/**
 *
 * @author Todd Kirsten
 */
public class HotSpotView extends Application {
    
    private HotSpotModel hotSpotModel;
    private HotSpotController hotSpotController;
    private Text hotSpotStageText, hotSpotBooleanText;
    private AlphaCare.ControllerCore controllerCore;
    private Button hotSpotButton, severityButton, returnHomeButton;
    private Text mainHeader, hotSpotHeader;
    private TextField zipCode;
    private boolean goodZip;
    private Stage primaryStage;
    private Scene scene;
    
    // This is the method that will create the hot spot view object
    public HotSpotView() {

        System.out.println("The Hot Spot View class has been instantiated - Test Successful");
        hotSpotModel = new HotSpotModel();
        
    }    

    // Gets the view displayed to the user
@Override
    public void start(Stage primaryStage) {
    
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
        
        primaryStage.setTitle("Identify Hot Spots");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        mainHeader = AlphaCareHeader.getAlphaCareHeader().getMainHeader();
        grid.add(mainHeader, 0, 0);
        
        hotSpotHeader = new Text();
        hotSpotHeader.setFont(Font.font("Tahoma", FontWeight.NORMAL, 48));
        hotSpotHeader.setText(hotSpotModel.getPrimaryStageTitle());
        grid.add(hotSpotHeader, 0, 2);
        
        // Create Zip Code Text Field
        zipCode = new TextField();
        zipCode.setFocusTraversable(false);
        zipCode.setAlignment(Pos.CENTER);
        zipCode.setPromptText(hotSpotModel.getZipCodePrompt());
        
        // Create check for Hot Spot button
        hotSpotButton = new Button();
        hotSpotButton.setMinSize(450, 60);
        hotSpotButton.setAlignment(Pos.CENTER);
        hotSpotButton.setText(hotSpotModel.getHotSpotButton());
        
        // Create severity level button
        severityButton = new Button();
        severityButton.isDisabled();
        severityButton.setMinSize(450, 60);
        severityButton.setAlignment(Pos.CENTER);
        severityButton.setText(hotSpotModel.getSeverityButton());
        severityButton.setStyle(hotSpotModel.getSeverityButtonColor());

        // Create return home button
        returnHomeButton = new Button();
        returnHomeButton.setMinSize(450, 60);
        returnHomeButton.setAlignment(Pos.CENTER);
        returnHomeButton.setText(hotSpotModel.getReturnHomeButton());
        
        
        // Add components to grid
        grid.add(zipCode, 0, 3);
        grid.add(hotSpotButton, 0, 4);
        grid.add(severityButton, 0, 5);
        grid.add(returnHomeButton, 0, 7);

        hotSpotController = getHotSpotController();
        hotSpotController.buttonListeners(hotSpotButton, severityButton, returnHomeButton, zipCode);
    }

    // Getters and Setters
    public HotSpotModel getHotSpotModel() {
        return hotSpotModel;
    }

    public void setHotSpotModel(HotSpotModel hotSpotModel) {
        this.hotSpotModel = hotSpotModel;
    }

    public HotSpotController getHotSpotController() {
        return hotSpotController;
    }

    public void setHotSpotController(HotSpotController hotSpotController) {
        this.hotSpotController = hotSpotController;
    }

    public Text getHotSpotStageText() {
        return hotSpotStageText;
    }

    public void setHotSpotStageText(Text hotSpotStageText) {
        this.hotSpotStageText = hotSpotStageText;
    }

    public Text getHotSpotBooleanText() {
        return hotSpotBooleanText;
    }

    public void setHotSpotBooleanText(Text hotSpotBooleanText) {
        this.hotSpotBooleanText = hotSpotBooleanText;
    }

    public ControllerCore getControllerCore() {
        return controllerCore;
    }

    public void setControllerCore(ControllerCore controllerCore) {
        this.controllerCore = controllerCore;
    }

    public Button getHotSpotButton() {
        return hotSpotButton;
    }

    public void setHotSpotButton(Button hotSpotButton) {
        this.hotSpotButton = hotSpotButton;
    }

    public Button getReturnHomeButton() {
        return returnHomeButton;
    }

    public void setReturnHomeButton(Button returnHomeButton) {
        this.returnHomeButton = returnHomeButton;
    }

    public Text getMainHeader() {
        return mainHeader;
    }

    public void setMainHeader(Text mainHeader) {
        this.mainHeader = mainHeader;
    }

    public Text getHotSpotHeader() {
        return hotSpotHeader;
    }

    public void setHotSpotHeader(Text hotSpotHeader) {
        this.hotSpotHeader = hotSpotHeader;
    }

    public TextField getZipCode() {
        return zipCode;
    }

    public void setZipCode(TextField zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isGoodZip() {
        return goodZip;
    }

    public void setGoodZip(boolean goodZip) {
        this.goodZip = goodZip;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Button getSeverityButton() {
        return severityButton;
    }

    public void setSeverityButton(Button severityButton) {
        this.severityButton = severityButton;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
       
}
