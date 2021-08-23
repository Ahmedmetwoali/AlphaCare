/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACPrescriptionOrders;

/**
 *
 * @author taekim
 */
public class PrescriptionRepo extends Container {
    public String prescriptions[] = {   "Name: Tylenol, Dosage: Tablet 325mg, DoctorID: Kim, Jinny, PaientID: PID1001, Priority: LOW " ,
                                        "Name: Advil, Dosage: Caplet 325mg, DoctorID: Kim, Jinny , PaientID: PID1002, Priority: LOW " ,
                                        "Name: Ibuprofen, Dosage: Tablet 500mg, DoctorID: Kim, Jinny, PaientID: PID1003, Priority: LOW " , 
                                        "Name: Paracetamol, Dosage: Tablet 500mg, DoctorID: Kim, Jinny, PaientID: PID1004, Priority: MED " , 
                                        "Name: Aspirin, Dosage: Caplet 325mg, DoctorID: Kim, Jinny, PaientID: PID1005, Priority: LOW " , 
                                        "Name: Morphine, Dosage: Tablet 20mg, DoctorID: Kim, Jinny, PaientID: PID1006, Priority: HIGH "};

       @Override
       public Iterator getIterator() {
          return new NameIterator();
       }

       private class NameIterator extends Iterator {

          int index;

          @Override
          public boolean hasNext() {

             if(index < prescriptions.length){
                return true;
             }
             return false;
          }

          @Override
          public Object next() {

             if(this.hasNext()){
                return prescriptions[index++];
             }
             return null;
          }		
       }    
}
