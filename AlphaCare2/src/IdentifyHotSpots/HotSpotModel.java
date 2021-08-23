/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IdentifyHotSpots;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Todd Kirsten
 */
public class HotSpotModel {
   
    private HotSpotController hotSpotController;
    private int population, infected, zipCode, zipCodeLength;
    private double infectedPercentage;
    private boolean hotspot, goodZip;
    private Text hotSpotStageText, hotSpotBooleanText;
    private String primaryStageTitle, hotSpotWarning, notHotSpot, hotSpotResult, mapErrorMsg;
    private String zipCodePrompt, zipCodeAlert, hotSpotButton, severityButton, severityButtonColor, returnHomeButton;
    private String zipCodeTitle, zipCodeWarning, zipCodeString;
    
    public HotSpotModel() {
        
        System.out.println("The Hot Spot Model class has been instantiated - Test Successful");
        
        hotSpotController = getHotSpotController();
        
        primaryStageTitle = "Identify Hot Spots";
        mapErrorMsg = "There was an issue with opening the map.";
        zipCodePrompt = "Enter 5-Digit Zip Code";
        hotSpotButton = "Check Hot Spot Status";
        severityButton = "Hot Spot Severity";
        returnHomeButton = "Main Menu";
        zipCodeTitle = "Zip Code Warning";
        zipCodeWarning = "You must enter a valid 5-digit zip code.";
        hotSpotResult = "Hot Spot Result";
    
        setSeverityButtonColor("-fx-background-color: #ffffff; ");
        
    }

        /* Loops through each character thast was entered in the zip code field
            and check to see if it's an integer or not
        */
    public boolean zipCodeCheck() {
        goodZip = true;
        for(int i = 0; i < getZipCodeLength(); i++) {
            char character = getZipCodeString().charAt(i);
            if(!Character.isDigit(character)) {
                goodZip = false;
            }
        }    
        return goodZip;
    }

    // Simulates a population for a zip code
    public int getPopulation() {

        population = (int) Math.round(Math.random() * 100000);

        return population;

    }

    // This is simulating a pull of a dataset and set a boolean based on a threshold of ill individuals
    public boolean getHotSpotBoolean() {
        
        // Calls the population method to simulate the zip code's population
        population = getPopulation();

        // Generates a random # based on the randomly generated population
        infected = (int) Math.round(Math.random() * population);
        infectedPercentage = (infected / (float)population) * 100;
        setSeverityLevel(infectedPercentage);
            
        hotSpotWarning = "THIS AREA IS A HOT SPOT.\nThere are " + infected + " infected individuals out of a population of " + population + " individuals.\nThis is an infected percentage of " + String.format("%.2f",infectedPercentage) + "%. \n\nShow location on map?";
        notHotSpot = "This area is not a hot spot.\nThere are " + infected + " infected individuals out of a population of " + population + " individuals..\nThis is an infected percentage of " +  String.format("%.2f",infectedPercentage) + "%. \n\nShow location on map?";

        // Prints out to the system for testing purposes
        System.out.println("Population: " + population);
        System.out.println("Infected: " + infected);
        System.out.println("Infected Percentage: " + infectedPercentage);

        if (infectedPercentage > 50.00) {
            hotspot = true;
        } else {
            hotspot = false;
        }

        return hotspot;
    }

    // Sets the text for the hot spot module
    public Text setHotSpotText() {

    hotSpotStageText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
    hotSpotStageText.setText("Identify Hot Spots");

    return hotSpotStageText;
    }

    // Sets the text based on the hot spot boolean
    public Text setHotSpotBoolean() {

    hotSpotBooleanText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
    getHotSpotBoolean();
    if (getHotSpotBoolean()) {
        hotSpotBooleanText.setText("HOT SPOT DETECTED.");
    } else {
        hotSpotBooleanText.setText("This location is not a hot spot.");
    }

    return hotSpotBooleanText;

    }

    // Sets the background color of the severity button based on infected percentage
    public void setSeverityLevel(double infectedPercentage) {

        if(infectedPercentage >= 75.00) {
            setSeverityButtonColor("-fx-background-color: #FF0000;");
        } else if (infectedPercentage >= 65.00 && infectedPercentage < 75.00) {
            setSeverityButtonColor("-fx-background-color: #ff8000;");
        } else if (infectedPercentage >= 50.00 && infectedPercentage < 65.00) {
            setSeverityButtonColor("-fx-background-color: #faf323;");
        } else {
            setSeverityButtonColor("-fx-background-color: #4bf542;");
        }

    }
    
    // Getters and Setters
    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public boolean isHotspot() {
        return hotspot;
    }

    public void setHotspot(boolean hotspot) {
        this.hotspot = hotspot;
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

    public String getZipCodeAlert() {
        return zipCodeAlert;
    }

    public void setZipCodeAlert(String zipCodeAlert) {
        this.zipCodeAlert = zipCodeAlert;
    }

    public String getHotSpotButton() {
        return hotSpotButton;
    }

    public void setHotSpotButton(String hotSpotButton) {
        this.hotSpotButton = hotSpotButton;
    }

    public String getReturnHomeButton() {
        return returnHomeButton;
    }

    public void setReturnHomeButton(String returnHomeButton) {
        this.returnHomeButton = returnHomeButton;
    }

    public String getZipCodePrompt() {
        return zipCodePrompt;
    }

    public void setZipCodePrompt(String zipCodePrompt) {
        this.zipCodePrompt = zipCodePrompt;
    }

    public String getPrimaryStageTitle() {
        return primaryStageTitle;
    }

    public void setPrimaryStageTitle(String pimaryStageTitle) {
        this.primaryStageTitle = pimaryStageTitle;
    }

    public String getHotSpotWarning() {
        return hotSpotWarning;
    }

    public void setHotSpotWarning(String hotSpotWarning) {
        this.hotSpotWarning = hotSpotWarning;
    }

    public String getNotHotSpot() {
        return notHotSpot;
    }

    public void setNotHotSpot(String notHotSpot) {
        this.notHotSpot = notHotSpot;
    }

    public String getMapErrorMsg() {
        return mapErrorMsg;
    }

    public void setMapErrorMsg(String mapErrorMsg) {
        this.mapErrorMsg = mapErrorMsg;
    }

    public String getZipCodeTitle() {
        return zipCodeTitle;
    }

    public void setZipCodeTitle(String zipCodeTitle) {
        this.zipCodeTitle = zipCodeTitle;
    }

    public String getZipCodeWarning() {
        return zipCodeWarning;
    }

    public void setZipCodeWarning(String zipCodeWarning) {
        this.zipCodeWarning = zipCodeWarning;
    }

    public String getHotSpotResult() {
        return hotSpotResult;
    }

    public void setHotSpotResult(String hotSpotResult) {
        this.hotSpotResult = hotSpotResult;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getZipCodeLength() {
        return zipCodeLength;
    }

    public void setZipCodeLength(int zipCodeLength) {
        this.zipCodeLength = zipCodeLength;
    }

    public boolean isGoodZip() {
        return goodZip;
    }

    public void setGoodZip(boolean goodZip) {
        this.goodZip = goodZip;
    }

    public String getZipCodeString() {
        return zipCodeString;
    }

    public void setZipCodeString(String zipCodeString) {
        this.zipCodeString = zipCodeString;
    }

    public HotSpotController getHotSpotController() {
        return hotSpotController;
    }

    public void setHotSpotController(HotSpotController hotSpotController) {
        this.hotSpotController = hotSpotController;
    }

    public String getSeverityButton() {
        return severityButton;
    }

    public void setSeverityButton(String severityButton) {
        this.severityButton = severityButton;
    }

    public String getSeverityButtonColor() {
        return severityButtonColor;
    }

    public void setSeverityButtonColor(String severityButtonColor) {
        this.severityButtonColor = severityButtonColor;
    }
    
        
}
