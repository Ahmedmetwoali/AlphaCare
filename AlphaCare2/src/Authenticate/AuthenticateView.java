package Authenticate;

import java.util.HashMap;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class AuthenticateView {

    private Button loginButton = new Button("Login");

    private Text logInHeader = new Text("Please enter your credentials");;
    private TextField usernameField;
    private TextField passwordField;
    private Scene authScene;

    private HashMap<String, String> user1 = new HashMap<>();

    public AuthenticateView() {

        //Username, Password
        user1.put("Happy123", "Qwerty321");
        //For testing only
//        user1.put("", "");

        GridPane grid = new GridPane();

        grid.setPrefSize(1200, 900);
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setScaleX(1.2);
        grid.setScaleY(1);
        this.authScene = new Scene(grid);

        logInHeader.setFont(Font.font("Tahoma", FontWeight.NORMAL, 56));
        grid.add(logInHeader, 0, 0);

        // Create userName Text Field
        usernameField = new TextField();
        usernameField.setFocusTraversable(false);
        usernameField.setAlignment(Pos.CENTER);
        usernameField.setPromptText("Enter your Username");

        // Create password Text Field
        passwordField = new TextField();
        passwordField.setFocusTraversable(false);
        passwordField.setAlignment(Pos.CENTER);
        passwordField.setPromptText("Enter Password");

        // Create Login button
        this.loginButton.setMinSize(710, 60);
        this.loginButton.setAlignment(Pos.CENTER);

        // Add components to grid
        grid.add(usernameField, 0, 1);
        grid.add(passwordField, 0, 2);
        grid.add(this.loginButton, 0, 3);

    }

    /**
     * @return the loginButton
     */
    public Button getLoginButton() {
        return loginButton;
    }

    /**
     * @return the user1
     */
    public HashMap<String, String> getUser1() {
        return user1;
    }

    /**
     * @param aUser1 the user1 to set
     */
    public void setUser1(HashMap<String, String> aUser1) {
        user1 = aUser1;
    }

    /**
     * @return the usernameField
     */
    public TextField getUsernameField() {
        return usernameField;
    }

    /**
     * @return the passwordField
     */
    public TextField getPasswordField() {
        return passwordField;
    }

    /**
     * @return the authScene
     */
    public Scene getAuthScene() {
        return authScene;
    }

}
