/**
 * Project:
 * Course: IST 412 Sec 01
 * @author Selwyn Gabriel, Tae Dong Kim, Todd Kirsten, Leslin Mathews, Perry, Mclaughlin, Ahmed Metwoali
 * Date Developed: Jun 9, 2021
 * Last Date Changed:
 * Revision:
 */
package ACPrescriptionOrders;

import java.util.ArrayList;

/**
 *
 * @author taekim
 */
public class PrescriptionOrderList {
    
    private ArrayList <PrescriptionOrder> prescriptions;
    
    /**
     *
     */
    public PrescriptionOrderList() {
        prescriptions = new ArrayList<>();
        
    }

    /**
     *
     * @return The list or prescription orders
     */
    public ArrayList <PrescriptionOrder> getPrescriptions() {
        return prescriptions;
    }

    /**
     *
     * @param prescriptions Set the list of prescription orders
     */
    public void setPrescriptions(ArrayList <PrescriptionOrder> prescriptions) {
        this.prescriptions = prescriptions;
    }
    
    /**
     *
     * @return A prioritized list of prescription orders
     */
    public ArrayList <PrescriptionOrder> sortByPriority() {
        ArrayList<PrescriptionOrder> prioritizedList = null;
        return prioritizedList;
    }
}
