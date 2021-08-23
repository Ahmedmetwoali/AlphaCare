/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACPrescriptionOrders;

import java.util.ArrayList;
//import javafx.application.Application;
//import javafx.stage.Stage;

/**
 *
 * @author taekim
 */
public class PrescriptionsController {

    public static void main(String[] args) {
      PrescriptionRepo prescriptionRepo = new PrescriptionRepo();

      for(Iterator iter = prescriptionRepo.getIterator(); iter.hasNext();){
         String info = (String)iter.next();
         System.out.println(info);
      } 	
   }
    
    /*
    PrescriptionOrderList preOrdList;
    PrescriptionsListUI prescriptionsListUI;
    
    public PrescriptionsController(PrescriptionOrderList pol) {
        // prescriptionsListUI = new PrescriptionsListUI();
        preOrdList = pol;
        
        //print prescriptions
        System.out.println(pol.getPrescriptions());
    }
    
    /*
    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

}
