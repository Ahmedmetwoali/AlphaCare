/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExportData;

import java.util.ArrayList;

public class ExportModel {

    //test data - for ExportModel
    private String[] iData = {"12345678", "Example Name",
        "1234 Unknown Drive, Philadelphia, PA 19001", "01/23/45", "Female",
        "Single", "English", "Asian", "Not Hispanic or Latino"};
    private String[] iContact = {"(215)123-4567", "theunknownemail@notfound.net"};
    private String[] iBill = {"Example Name",
        "1234 Unknown Drive, Philadelphia, PA 19001",
        "(215)123-4567", "theunknownemail@notfound.net"};
    private String[] ieContact = {"Emergency Name", "Parent", "(215)334-6678"};

    public ExportModel() {
    }

    //returns patient Data
    public ArrayList<Object> patientData() {
        ArrayList<Object> pData = new ArrayList<Object>();
        pData.add(this.iData);
        pData.add(this.iContact);
        pData.add(this.iBill);
        pData.add(this.ieContact);
        return pData;
    }

}
