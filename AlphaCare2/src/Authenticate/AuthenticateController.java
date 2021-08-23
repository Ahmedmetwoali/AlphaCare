package Authenticate;

import java.util.HashMap;

public class AuthenticateController {

    private static HashMap<String, String> user1 = new HashMap<>();
    private AuthenticateView authView;

    public AuthenticateController() {
    }

    public void start() {
        this.authView = new AuthenticateView();
    }

    /**
     * @return the authView
     */
    public AuthenticateView getAuthView() {
        return authView;
    }

}
