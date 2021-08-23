/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IdentifyHotSpots;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Todd Kirsten
 */
public class HotSpotController {
    
    private HotSpotView hotSpotView;
    private HotSpotModel hotSpotModel;
    private Button hotSpotButton, returnHomeButton;
    private Text hotSpotHeader;
    private String enteredZipCode;
    private TextField zipCode;
    private boolean goodZip;
    private Alert alert;
    private Stage primaryStage;
    
    // Method for creating the hot spot controller object
    public HotSpotController() {
        
        System.out.println("The Hot Spot Controller has started - Test Successful");
        
        /* Created a new instance of hotspotmodel and hotspotview and p
            passes an instance of this controller object to hotspotmodel and hotspotview
        */
        hotSpotModel = new HotSpotModel();
        hotSpotModel.setHotSpotController(this);
        hotSpotView = new HotSpotView();
        hotSpotView.setHotSpotController(HotSpotController.this);
        
        // Calls the method that launches the hotspot GUI
        launchHotSpotView();
        
    }
    
    // Launches the hotspotview by instantiating a new stage and calling the hotspotview start method 
    public void launchHotSpotView() {
        
        Stage primaryStage = new Stage();
        setPrimaryStage(primaryStage);
        hotSpotView.start(primaryStage);
        
    }
        
    // The method that will handle all the button events for the buttons within the hotspotview class
    public void buttonListeners(Button hotSpotButton, Button severityButton, Button returnHomeButton, TextField zipCode) {

        System.out.println("THE HOT SPOT CONTROLLER IS GETTING THE ZIPCODE AND BUTTONS");
        
        // Alert prompt for confirming application exit
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Hot Spot Confirmation");
        ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(okButton, noButton);
        
        hotSpotButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Object obj = event.getSource();
                    if (obj == hotSpotButton) {
                        goodZip = true;
                        for(int i = 0; i < zipCode.getText().length(); i++) {
                            char character = zipCode.getText().charAt(i);
                            if(!Character.isDigit(character)) {
                                goodZip = false;
                            }
                        }
                        if(!goodZip || zipCode.getText().length() != 5) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Zip Code");
                                alert.setContentText("You must enter a valid zip code.");
                                alert.show();
                                zipCode.clear();
                        } else {
                            /* This grabs the entered zip code and assigns it to the enteredZipCode variable before
                                clearing the text field on the next line of code--the variable is then used for loading 
                                the proper Google map                             
                            */
                            enteredZipCode = hotSpotView.getZipCode().getText();
                            
                            hotSpotView.getZipCode().clear();
                            if (hotSpotModel.getHotSpotBoolean()) {
                                severityButton.setStyle(hotSpotModel.getSeverityButtonColor());
                                alert.setContentText(hotSpotModel.getHotSpotWarning());
                                alert.showAndWait().ifPresent(type -> {
                                    if (type == okButton) {
                                        String url_open ="https://www.google.com/maps/place/" + enteredZipCode;
                                        try {
                                            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
                                        } catch (IOException ex) {
                                            System.out.println("There was an issue with opening the map.");
                                        }
                                    } else {
                                        alert.close();
                                    }
                                });
                            } else {
                                alert.setContentText(hotSpotModel.getNotHotSpot());
                                severityButton.setStyle(hotSpotModel.getSeverityButtonColor());
                                alert.showAndWait().ifPresent(type -> {
                                    if (type == okButton) {
                                        String url_open ="https://www.google.com/maps/place/" + enteredZipCode;
                                        try {
                                            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
                                        } catch (IOException ex) {
                                            System.out.println("There was an issue with opening the map.");
                                        }
                                    } else {
                                        alert.close();
                                    }
                                });
                            }
                        }
                    }
            }
        });

            returnHomeButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Object obj = event.getSource();
                    if (obj == returnHomeButton) {
                        hotSpotView.getPrimaryStage().close();
//                        controllerCore.start(primaryStage);
                    }
            }
            });
        }

    // Getters and Setters
    public HotSpotView getHotSpotView() {
        return hotSpotView;
    }

    public void setHotSpotView(HotSpotView hotSpotView) {
        this.hotSpotView = hotSpotView;
    }

    public HotSpotModel getHotSpotModel() {
        return hotSpotModel;
    }

    public void setHotSpotModel(HotSpotModel hotSpotModel) {
        this.hotSpotModel = hotSpotModel;
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

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    
    
}
                
