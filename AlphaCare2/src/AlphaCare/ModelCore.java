/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlphaCare;

import javafx.scene.text.Text;

/**
 *
 * @author IST 412 - Group 3
 */
public class ModelCore {

    private Text mainHeader;

    public ModelCore() {

        System.out.println("The AlphaCare Core Model class has been instantiated.");

        // Gets the main ALPHACARE header from the AlphaCareHeader class
        mainHeader = AlphaCareHeader.getAlphaCareHeader().getMainHeader();

    }

    public void start() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
