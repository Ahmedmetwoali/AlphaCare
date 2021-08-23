/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputHealthData;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Metwoali
 */
public class DataController {

    private DataModel model;
    private DataInputView view;
    
    public DataController(DataModel model, DataInputView view) {
        this.model = model;
        this.view = view;
        this.view.start(new Stage());
        this.view.getReturnHomeButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (e.getSource() == view.getReturnHomeButton()) {
                    view.getPrimaryStage().close();
                }
            }
        });
        
        this.view.getGenerateReportButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (e.getSource() == view.getGenerateReportButton()) {
                    view.report(new Stage());
                }
            }
        });
        
    }
    
}
                

