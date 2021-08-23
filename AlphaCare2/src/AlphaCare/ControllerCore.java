/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlphaCare;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
//For Alerts
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

/**
 *
 * @author IST 412 - Group 3
 */
public class ControllerCore extends Application {

    private IdentifyHotSpots.HotSpotController hotSpotController;
    private ACPrescriptionOrders.PrescriptionsListView prescriptionListUI;
    private ACPrescriptionOrders.PrescriptionsController prescriptionController;
    private ViewCore vCore = new ViewCore();
    private ModelCore mCore = new ModelCore();
    private boolean login = true;


    /*
            Here is where we can instantiate/create an object for each module (e.g., prescription functionality)
     */
    public ControllerCore() {
        System.out.println("The AlphaCare Core Controller has started - Test Successful");
    }

    public void start(Stage primaryStage) {

        //anything that uses .show() last has highest priority
        if (login) {
            primaryStage.setTitle("AlphaCare - Login");
            Authenticate.AuthenticateController authController = new Authenticate.AuthenticateController();
            try {
                authController.start();
                primaryStage.setScene(authController.getAuthView().getAuthScene());
                authController.getAuthView().getLoginButton().setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        if (event.getSource() == authController.getAuthView().getLoginButton()) {
                            System.out.println("We're done here");
                            if (authController.getAuthView().getUser1().containsKey(authController.getAuthView().getUsernameField().getText()) && authController.getAuthView().getUser1().containsValue(authController.getAuthView().getPasswordField().getText())) {
                                primaryStage.setTitle("AlphaCare");
                                primaryStage.setScene(vCore.getMainScene());
                                login = false;
                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Incorrect username/password");
                                alert.setContentText("Please try again");
                                alert.show();
                                authController.getAuthView().getUsernameField().clear();
                                authController.getAuthView().getPasswordField().clear();
                            }
                        }
                    }
                });
            } catch (Exception ex) {
                System.out.println("Login Error\n" + ex);
            }
        }

        primaryStage.show();
        this.vCore.start();

        this.vCore.getInputHealthDataButton().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Object obj = event.getSource();
                if (obj == vCore.getInputHealthDataButton()) {
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Health Data");
//                    alert.setContentText("You have clicked the Data Input button.");
//                    alert.show();
                    InputHealthData.DataModel dataModel = new InputHealthData.DataModel();
                    InputHealthData.DataInputView dataInputView = new InputHealthData.DataInputView(new Stage());
                    InputHealthData.DataController dataController = new InputHealthData.DataController(dataModel, dataInputView);

                }
            }
        });
        
        this.vCore.getExportDataButton().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if (e.getSource() == vCore.getExportDataButton()) {
                    ExportData.ExportController c = new ExportData.ExportController();
                    c.start();
                    primaryStage.setTitle("AlphaCare - Export Data");
                    primaryStage.setScene(c.getV().getExpoScene());
                    c.getV().getMainExit().setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            if (e.getSource() == c.getV().getMainExit()) {
                                primaryStage.setTitle("AlphaCare");
                                primaryStage.setScene(vCore.getMainScene());
                            }
                        }
                    });
                }
            }
        });


        this.vCore.getIdentifyHotSpotsButton().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Object obj = event.getSource();
                if (obj == vCore.getIdentifyHotSpotsButton()) {
                    hotSpotController = new IdentifyHotSpots.HotSpotController();
                }
            }
        });

        this.vCore.getPrescriptionsButton().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Object obj = event.getSource();
                if (obj == vCore.getPrescriptionsButton()) {
                    prescriptionListUI = new ACPrescriptionOrders.PrescriptionsListView();
                    prescriptionListUI.start(new Stage());
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Prescriptions");
//                    alert.setContentText("You have clicked the Prescriptions button.");
//                    alert.show();
                }
            }
        });

        // Alert prompt for confirming application exit
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setContentText("Are you sure you want to exit?");
        ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(okButton, noButton);

        this.vCore.getExitButton().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Object obj = event.getSource();
                if (obj == vCore.getExitButton()) {
                    alert.showAndWait().ifPresent(type -> {
                        if (type == okButton) {
                            primaryStage.close();
                        } else if (type == noButton) {
                        }
                    });
                }
                System.out.println("Exit clicked");
            }
        });

    }
}
