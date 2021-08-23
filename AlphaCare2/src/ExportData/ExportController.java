/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExportData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author FairyPawn
 */
public class ExportController {

    private ExportModel m = new ExportModel();
    private ExportView v = new ExportView();

    public ExportController() {
    }

    public void start() {
        this.v.expoSetup();
        this.v.getInnerExit().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (e.getSource() == v.getInnerExit()) {
                    v.getpRecord().close();
                }
            }
        });
        this.v.getSaveAs().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (e.getSource() == v.getSaveAs()) {
                    FileChooser fc = new FileChooser();

                    //Set file types to txt only
                    //How it started
//                    FileChooser.ExtensionFilter exFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
//                    exFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
                    //Optimized
                    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt"));
                    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Microsoft Word 97-2003 Document (*.doc)", "*.doc"));
                    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Microsoft Word Document (*.docx)", "*.docx"));
                    //Format failed
//                    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Format (*.pdf)", "*.pdf"));

                    File file = fc.showSaveDialog(new Stage());

                    if (file != null) {
                        try {
                            PrintWriter write = new PrintWriter(file);
                            write.println(v.getTheExport());
                            write.close();
                        } catch (FileNotFoundException fx) {
                            System.out.println("Try statement failed to save file - line 49");
                        }
                    }
                }
            }
        });
        this.v.getOptions().get(0).setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (e.getSource() == v.getOptions().get(0)) {
                    v.patientData(m.patientData());
                    v.patientRecord();
                }
            }
        });

        //For ControllerCore
//                    ExportData.ExportController c = new ExportData.ExportController();
//                    c.start();
//                    primaryStage.setTitle("AlphaCare - Export Data");
//                    primaryStage.setScene(c.getV().getExpoScene());
//                    c.getV().getMainExit().setOnAction(new EventHandler<ActionEvent>() {
//                        public void handle(ActionEvent e) {
//                            if (e.getSource() == c.getV().getMainExit()) {
//                                primaryStage.setTitle("AlphaCare");
//                                primaryStage.setScene(scene);
//                            }
//                        }
//                    });
    }

    /**
     * @return the m
     */
    public ExportModel getM() {
        return m;
    }

    /**
     * @return the v
     */
    public ExportView getV() {
        return v;
    }
}
