package Helpers;

import GUI.Home;
import GUI.LogIn;
import GUI.SignUp;
import GUI.Welcome;
import javafx.stage.Stage;

import java.sql.SQLException;

public class SceneChange {
    public static void changeScene(Stage primaryStage, String root) throws SQLException {

        switch (root){
            case "welcome":primaryStage.getScene().setRoot(new Welcome().getWelcome(primaryStage));break;
            case "login":primaryStage.getScene().setRoot(new LogIn().getLogIn(primaryStage));break;
            case "signup":primaryStage.getScene().setRoot(new SignUp().getSignUp(primaryStage));break;
            default:
                System.out.println("Error: root not found");
        }
    }
    public static void changeScene(Stage primaryStage,String user ,String root) throws SQLException {
        primaryStage.getScene().setRoot( new Home().getHome(primaryStage,user));
    }
}
