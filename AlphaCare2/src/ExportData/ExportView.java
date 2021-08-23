/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExportData;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class ExportView {

    private Button mainExit = new Button("Go Back");
    private ArrayList<Button> options = new ArrayList<>();
    private Scene expoScene;
    private Scene innerExpo;
    private GridPane grid = new GridPane();
    private Stage pRecord = new Stage();
    private Button saveAs = new Button("Save As..");
    private Button innerExit = new Button("Cancel");
    private Text theExport = new Text();
    private Integer total;

    //data fields
    private String[] pInfo = {"Patient #", "Name: ",
        "Address", "Date of Birth: ", "Sex: ", "Martial Status: ",
        "Language: ", "Race: ", "Ethnicity: "};
    private String[] contact = {"Phone: ", "Email: "};
    private String[] billInfo = {"Name: ", "Address", "Phone: ", "Email: "};
    private String[] eContact = {"Name: ", "Relationship to Patient: ", "Phone: "};

    //test data - from ExportModel
    private String[] iData;
    private String[] iContact;
    private String[] iBill;
    private String[] ieContact;

    public ExportView() {
    }

    //ExportData view layout
    public void expoSetup() {
        this.grid.setPrefSize(1200, 900);
        this.grid.setAlignment(Pos.TOP_CENTER);
        this.grid.setVgap(10);
        this.grid.setHgap(10);
        this.grid.setScaleX(1.2);
        this.grid.setScaleY(1);
        this.expoScene = new Scene(grid);
        header();
        options();
    }

    //ExportData header
    public void header() {
        Text title = new Text("What do you need to export?");
        title.setFont(new Font("Tahoma", 48));
        this.grid.add(title, 0, 0);
        Text title3 = new Text("AlphaCare Powered by ATZ Healthcare");
        title.setFont(new Font("Tahoma", 48));
        this.grid.add(title3, 0, 1);
    }

    //Options in ExportData
    public void options() {
        for (int i = 0; i < 1; i++) {
            this.options.add(new Button());
            this.options.get(i).setMinSize(450, 60);
        }
        this.options.get(0).setText("Patient Record");
//        this.options.get(1).setText("Medication History");
//        this.options.get(2).setText("Health Report");
//        this.options.get(3).setText("Current HotSpot Summary");
        for (int i = 0; i < this.options.size(); i++) {
            this.grid.add(this.options.get(i), 0, i + 2);
        }
        this.grid.add(this.mainExit, 3, this.options.size() + 2);
    }

    public void patientData(ArrayList<Object> pData) {
        this.iData = (String[]) pData.get(0);
        this.iContact = (String[]) pData.get(1);
        this.iBill = (String[]) pData.get(2);
        this.ieContact = (String[]) pData.get(3);
    }

    public void patientRecord() {
        GridPane newGrid = new GridPane();
        newGrid.setPrefSize(1200, 900);
        newGrid.setAlignment(Pos.TOP_CENTER);
        newGrid.setVgap(10);
        newGrid.setHgap(10);
        newGrid.setScaleX(1.2);
        newGrid.setScaleY(1);
        this.innerExpo = new Scene(newGrid);
        this.pRecord.setScene(this.innerExpo);

        //Information Holder
        ArrayList<Text> details = new ArrayList<>();

        //Patient ID Header
        Text pID = new Text(this.pInfo[0] + this.iData[0]);
        this.theExport.setText(pID.getText());
        pID.setFont(Font.font("Tahoma", 32));
        details.add(pID);
        newGrid.add(details.get(0), 0, 0);

        //Patient Info
        for (int i = 1; i < this.pInfo.length; i++) {
            details.add(new Text(this.pInfo[i] + this.iData[i]));
            this.theExport.setText(this.theExport.getText() + "\n" + details.get(i).getText());
            newGrid.add(details.get(i), 0, i);
        }
        int count = this.total = details.size();

        //Contact Info Header
        Text cHeader = new Text("Contact Information");
        this.theExport.setText(this.theExport.getText() + "\n");   //Controlled Spacing
        this.theExport.setText(this.theExport.getText() + "\n" + cHeader.getText());
        cHeader.setFont(Font.font("Tahoma", 24));
        newGrid.add(cHeader, 0, count);
        count = ++count;

        //Contact Info
        for (int i = 0; i < this.contact.length; i++) {
            details.add(new Text(this.contact[i] + this.iContact[i]));
            this.theExport.setText(this.theExport.getText() + "\n" + details.get(i + this.total).getText());
            newGrid.add(details.get(i + this.total), 0, i + count);
        }
        this.total = details.size();
        count = details.size() + 1;

        //Billing Info Header
        Text billHeader = new Text("Billing Information");
        this.theExport.setText(this.theExport.getText() + "\n");   //Controlled Spacing
        this.theExport.setText(this.theExport.getText() + "\n" + billHeader.getText());
        billHeader.setFont(Font.font("Tahoma", 24));
        newGrid.add(billHeader, 0, count);
        count = ++count;

        //Billing Info
        for (int i = 0; i < this.billInfo.length; i++) {
            details.add(new Text(this.billInfo[i] + this.iBill[i]));
            this.theExport.setText(this.theExport.getText() + "\n" + details.get(i + this.total).getText());
            newGrid.add(details.get(i + this.total), 0, i + count);
        }
        this.total = details.size();
        count = details.size() + 2;

        //Emergency Contact Header
        Text ecHeader = new Text("Emergency Contact");
        this.theExport.setText(this.theExport.getText() + "\n");   //Controlled Spacing
        this.theExport.setText(this.theExport.getText() + "\n" + ecHeader.getText());
        ecHeader.setFont(Font.font("Tahoma", 24));
        newGrid.add(ecHeader, 0, count);
        count = ++count;

        //Emergency Contact
        for (int i = 0; i < this.eContact.length; i++) {
            details.add(new Text(this.eContact[i] + this.ieContact[i]));
            this.theExport.setText(this.theExport.getText() + "\n" + details.get(i + this.total).getText());
            newGrid.add(details.get(i + this.total), 0, i + count);
        }
//Testing ExportData
//        newGrid.add(this.theExport, 0, 0);

        //Buttons and Title
        newGrid.add(this.saveAs, 2, 14);
        newGrid.add(this.innerExit, 3, 14);
        this.pRecord.setTitle("AlphaCare - Export Data: Patient Information Preview");
        this.pRecord.show();
    }

    /**
     * @return the expoScene
     */
    public Scene getExpoScene() {
        return this.expoScene;
    }

    /**
     * @return the options
     */
    public ArrayList<Button> getOptions() {
        return options;
    }

    /**
     * @return the innerExpo
     */
    public Scene getInnerExpo() {
        return innerExpo;
    }

    /**
     * @return the mainExit
     */
    public Button getMainExit() {
        return mainExit;
    }

    /**
     * @return the innerExit
     */
    public Button getInnerExit() {
        return innerExit;
    }

    /**
     * @return the pRecord
     */
    public Stage getpRecord() {
        return pRecord;
    }

    /**
     * @return the saveAs
     */
    public Button getSaveAs() {
        return saveAs;
    }

    /**
     * @return the theExport
     */
    public Text getTheExport() {
        return theExport;
    }

}
