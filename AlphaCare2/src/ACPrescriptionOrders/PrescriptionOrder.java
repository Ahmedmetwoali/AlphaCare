/**
 * Project:
 * Course: IST 412 Sec 01
 * @author Selwyn Gabriel, Tae Dong Kim, Todd Kirsten, Leslin Mathews, Perry, Mclaughlin, Ahmed Metwoali
 * Date Developed: Jun 9, 2021
 * Last Date Changed:
 * Revision:
 */
package ACPrescriptionOrders;

/**
 *
 * @author taekim
 */
public class PrescriptionOrder {
    private String medication;
    private String doctorID;
    private String patientID;
    private String dosage;
    private String priority;

    /**
     *
     * @param medication
     * @param doctorID
     * @param patientID
     * @param dosage
     * @param priority
     */
    public PrescriptionOrder(String medication, String doctorID, String patientID, String dosage, String priority) {
        this.medication = medication;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.dosage = dosage;
        this.priority = priority;
    }

    /**
     * 
     */
    public PrescriptionOrder() {
        this.medication = "N/A";
        this.doctorID = "-1";
        this.patientID = "-1";
        this.dosage = "-1";
        this.priority = "-1";
    }

    /**
     *
     * @return The entire prescription order as a string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrescriptionOrder{medication=").append(medication);
        sb.append(", doctorID=").append(doctorID);
        sb.append(", patientID=").append(patientID);
        sb.append(", dosage=").append(dosage);
        sb.append(", priority=").append(priority);
        sb.append('}');
        return sb.toString();
    }

    /**
     *
     * @return The prescription with medication and dosage
     */
    public String getPrescription() {
        return medication + dosage;
    }
    
    /**
     *
     * @return The medication requested with order
     */
    public String getMedication() {
        return medication;
    }

    /**
     *
     * @param medication Sets the medication for the order
     */
    public void setMedication(String medication) {
        this.medication = medication;
    }

    /**
     *
     * @return The requesting doctor's ID
     */
    public String getDoctorID() {
        return doctorID;
    }

    /**
     *
     * @param doctorID Sets the doctorID of the requesting doctor
     */
    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    /**
     *
     * @return The patient's ID number
     */
    public String getPatientID() {
        return patientID;
    }

    /**
     *
     * @param patientID Sets the patientID number
     */
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    /**
     *
     * @return The dosage of the prescription order
     */
    public String getDosage() {
        return dosage;
    }

    /**
     *
     * @param dosage Sets the dosage of the prescription order
     */
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    /**
     *
     * @return The priority of the prescription order
     */
    public String getPriority() {
        return priority;
    }

    /**
     *
     * @param priority Sets the priority of the prescription order
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }
       
}
