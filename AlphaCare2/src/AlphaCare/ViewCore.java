/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlphaCare;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author IST 412 - Group 3
 */
public class ViewCore {

    private Scene mainScene;
    private Button exportDataButton, identifyHotSpotsButton, prescriptionsButton, exitButton,inputHealthDataButton;
    private Text welcomeTxt = new Text("Welcome to AlphaCare"), AlphaCareHeader = new Text("ALPHACARE");

    public ViewCore() {
    }

//    @Override
    public void start() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools |

        //Basic scene layout
        GridPane grid = new GridPane();
        grid.setPrefSize(1200, 900);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        this.mainScene = new Scene(grid);
        grid.setScaleX(1.2);
        grid.setScaleY(1);
        ColumnConstraints column = new ColumnConstraints();
        column.setHalignment(HPos.CENTER);
        grid.getColumnConstraints().add(column);

        //Setting main header style and adding to the grid
        mainHeaderStyle();
        grid.add(this.AlphaCareHeader, 0, 0);
        grid.add(this.welcomeTxt, 0, 1);

        // Create buttons
        inputHealthDataButton = new Button("Data Input");
        exportDataButton = new Button("Export Data");
        identifyHotSpotsButton = new Button("Identify Hot Spots");
        prescriptionsButton = new Button("Prescriptions");
        exitButton = new Button("Exit AlphaCare");

        //Button sizes
        exportDataButton.setMinSize(450, 60);
        identifyHotSpotsButton.setMinSize(450, 60);
        prescriptionsButton.setMinSize(450, 60);
        inputHealthDataButton.setMinSize(450, 60);
        exitButton.setMinSize(450, 60);

        // Add buttons to grid
        grid.add(inputHealthDataButton, 0, 4);
        grid.add(exportDataButton, 0, 6);
        grid.add(identifyHotSpotsButton, 0, 8);
        grid.add(prescriptionsButton, 0, 10); 
        grid.add(exitButton, 0, 14);
    }

    public void mainHeaderStyle() {
        this.AlphaCareHeader.setFont(Font.font("Tahoma", FontWeight.NORMAL, 124));
        this.AlphaCareHeader.setFill(Color.CADETBLUE);
        this.welcomeTxt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 48));
    }

    /**
     * @return the mainScene
     */
    public Scene getMainScene() {
        return mainScene;
    }

    /**
     * @return the exportDataButton
     */
    public Button getExportDataButton() {
        return exportDataButton;
    }

   

    /**
     * @return the identifyHotSpotsButton
     */
    public Button getIdentifyHotSpotsButton() {
        return identifyHotSpotsButton;
    }

    /**
     * @return the prescriptionsButton
     */
    public Button getPrescriptionsButton() {
        return prescriptionsButton;
    }
    
    /**
     * @return the inputHealthDataButton
     */
    public Button getInputHealthDataButton() {
        return inputHealthDataButton;
    }

    /**
     * @return the exitButton
     */
    public Button getExitButton() {
        return exitButton;
    }

    /**
     * @return the AlphaCareHeader
     */
    public Text getAlphaCareHeader() {
        return AlphaCareHeader;
    }
}
