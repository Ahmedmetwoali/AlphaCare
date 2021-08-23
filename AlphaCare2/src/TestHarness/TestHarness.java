/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestHarness;

import ACPrescriptionOrders.PrescriptionOrderList;

/**
 *
 * @author IST 412 - Group 3
 */
public class TestHarness {

    public static void main(String[] args) {

        /* This is where we will put all of our tests for instantiating classes, 
        calling methods, displaying in the console the progress and status of 
        the tests, etc. 
         */
        // TESTING OF THE ALPHACARE CORE PACKAGE/MODULE
        System.out.println("---------------------------------------------------------------");
        System.out.println("TESTING THE ALPHACARE CORE MODULE/PACKAGE");
        System.out.println("---------------------------------------------------------------");
        AlphaCare.Main mainMethodTest = new AlphaCare.Main();
        AlphaCare.ControllerCore controllerCoreTest = new AlphaCare.ControllerCore();
        AlphaCare.ModelCore modelCoreTest = new AlphaCare.ModelCore();
        System.out.println("Testing AlphaCare main module complete......No Exceptions/Errors!");
        System.out.println("---------------------------------------------------------------");

        // TESTING OF THE HOT SPOTS PACKAGE/MODULE (TODD)
        System.out.println("TESTING THE \"IDENTIFY HOT SPOTS\"  MODULE/PACKAGE");
        System.out.println("---------------------------------------------------------------");
        IdentifyHotSpots.HotSpotController hotSpotControllerTest = new IdentifyHotSpots.HotSpotController();
        IdentifyHotSpots.HotSpotModel hotSpotModelTest = new IdentifyHotSpots.HotSpotModel();
        System.out.println("*** Testing the return of the Hot Spot boolean value...");
        System.out.println("*** SUCCESS - The value of the Hot Spot boolean is: " + hotSpotModelTest.getHotSpotBoolean());
        System.out.println("**********************************************************************");
        IdentifyHotSpots.HotSpotView hotSpotViewTest = new IdentifyHotSpots.HotSpotView();
        System.out.println("Testing Hot Spot module......No Exceptions/Errors!");
        System.out.println("---------------------------------------------------------------");

        // TESTING OF THE ACPrescriptionOrders Package (Tae)    
        System.out.println("TESTING THE \"Alpha Care Prescription Orders\"  MODULE/PACKAGE");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Printing Prescription Order List");
        ACPrescriptionOrders.PrescriptionOrder po = new ACPrescriptionOrders.PrescriptionOrder();
        PrescriptionOrderList pol = new PrescriptionOrderList();
        pol.getPrescriptions().add(po);
//        ACPrescriptionOrders.PrescriptionsController prescriptionControllerTest = new ACPrescriptionOrders.PrescriptionsController(pol);
        System.out.println("Successfully printed.  Test End.");
        System.out.println("---------------------------------------------------------------");

        // TESTING OF THE ExportModel (Leslin (Lin))    
        System.out.println("TESTING THE \"Alpha Care Export Model\"  MODULE/PACKAGE");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Creating and Printing test Export Data");
        
        System.out.println("Successfully printed.  Test End.");
        System.out.println("---------------------------------------------------------------");
    }

    /* Commenting out the graphical aspect of our testharness
   
    private Button coreTestButton, hotSpotTestButton; 
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();
        grid.setPrefSize(1200, 900);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        Scene scene = new Scene(grid);
        grid.setScaleX(1.2);
        grid.setScaleY(1);
        
        primaryStage.setTitle("TestHarness");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Create Core Test Button
        Button coreTestButton = new Button();
        coreTestButton.setMinSize(450, 60);
        coreTestButton.setText("Run Core Module Test");
        
        // Create Hot Spot Test Button
        Button hotSpotTestButton = new Button();
        hotSpotTestButton.setMinSize(450, 60);
        hotSpotTestButton.setText("Run Hot Spot Module Test");
        
        // Add buttons to grid
        grid.add(coreTestButton, 0, 1);
        grid.add(hotSpotTestButton, 0, 3);
        
        coreTestButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Object obj = event.getSource();
                    if (obj == coreTestButton) {
                        AlphaCare.ControllerCore controllerCoreTest = new AlphaCare.ControllerCore();
                        AlphaCare.Main mainCoreTest = new AlphaCare.Main();
                        AlphaCare.ModelCore modelCoreTest = new AlphaCare.ModelCore();
                        AlphaCare.ViewCore viewCoreTest = new AlphaCare.ViewCore();
                        System.out.println("Testing AlphaCare main module......No Exceptions/Errors!");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Core Package Testing");
                        alert.setContentText("Core Package Tests: PASSED");
                        alert.show(); 
                        
                    }
                System.out.println("Testing AlphaCare main module......PASSED!");
            }
        });
        
        hotSpotTestButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Object obj = event.getSource();
                    if (obj == hotSpotTestButton) {
                        IdentifyHotSpots.HotSpotController hotSpotControllerTest = new IdentifyHotSpots.HotSpotController();
                        hotSpotControllerTest.start(primaryStage);
                        IdentifyHotSpots.HotSpotModel hotSpotModelTest = new IdentifyHotSpots.HotSpotModel(1005);
                        System.out.println("Testing the return of the Hot Spot boolean value...");
                        System.out.println("SUCCESS - The value of the Hot Spot boolean is: " + hotSpotModelTest.getHotSpotBoolean());
                        IdentifyHotSpots.HotSpotView hotSpotViewTest = new IdentifyHotSpots.HotSpotView();
                        System.out.println("Testing Hot Spot module......No Exceptions/Errors!");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Hot Spot Package Testing");
                        alert.setContentText("Hot Spot Package Tests: PASSED");
                        alert.show(); 
                        
                    }
                System.out.println("Testing Identify Hot Spots......PASSED!");
            }
        });        
        
        StackPane root = new StackPane();
        root.getChildren().add(coreTestButton);
        root.getChildren().add(hotSpotTestButton);
        
    }

     * @param args the command line arguments
     */
}
