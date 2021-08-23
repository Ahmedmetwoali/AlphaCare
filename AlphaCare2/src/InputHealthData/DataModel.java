/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputHealthData;

import IdentifyHotSpots.HotSpotController;

/**
 *
 * @author Ahmed Metwoali
 */
public class DataModel {
    
      private String patientName;
    private String doctorName;
    private String patientDOB;
    private String patientID;
    private String doctorComments;
    private DataController dataController;

    

            
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(String patientDOB) {
        this.patientDOB = patientDOB;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }


    public String getDoctorComments() {
        return doctorComments;
    }

    public void setDoctorComments(String doctorComments) {
        this.doctorComments = doctorComments;
    }
public DataController getDataController() {
        return dataController;
    }

    public void setDataController (DataController dataController) {
        this.dataController = dataController;
    }


}
