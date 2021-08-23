/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlphaCare;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Todd Kirsten
 */
public class AlphaCareHeader extends Application {

    private Text header;
    
   //create an object of SingleObject
   private static AlphaCareHeader mainHeader = new AlphaCareHeader();

   //make the constructor private so that this class cannot be
   //instantiated
   private AlphaCareHeader(){
   
        header = new Text();
        header.setFont(Font.font("Tahoma", FontWeight.NORMAL, 124));
        header.setFill(Color.CADETBLUE);
        header.setText("ALPHACARE");
   
   }

   //Get the only object available
   public static AlphaCareHeader getAlphaCareHeader(){
      return mainHeader;
   }

   public Text getMainHeader(){
      return header;
   }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
