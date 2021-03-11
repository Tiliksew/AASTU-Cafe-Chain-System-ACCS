package GUI;

import Helpers.Database;
import Helpers.SceneChange;
import Helpers.Validators;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class LogIn {

    public VBox getLogIn(Stage primaryStage){

        VBox root = new VBox(50);


        Label lblSignUp = new Label("LogIn");
        lblSignUp.setStyle("-fx-font-size:30;-fx-font-weight:bold;");


        Label lblUsername= new Label("Username");
        lblUsername.getStyleClass().add("bolds");
        JFXTextField txfUsername = new JFXTextField();
        txfUsername.setStyle("-fx-font-weight:bold;");
        txfUsername.setPromptText("Enter Your Username");
        txfUsername.setPrefColumnCount(25);
        txfUsername.setLabelFloat(true);
        txfUsername.setFocusColor(Color.web("#000"));
        Label lblUsernameError = new Label("");
        lblUsernameError.setStyle("-fx-text-fill:red;");

        Label lblPassword= new Label("Password");
        lblPassword.getStyleClass().add("bolds");



        VBox hBoxPassword = new VBox(8);
        JFXTextField txfPassword = new JFXTextField();
        txfPassword.setStyle("-fx-font-weight:bold;");
        JFXCheckBox checkBox = new JFXCheckBox("Show password");
        AtomicBoolean isPasswordVisible = new AtomicBoolean(false);
        AtomicReference<String> storePass = new AtomicReference<>("");

//        txfPassword.setOnKeyPressed(e->{
//            storePass.set(  e.getText()  + storePass.get() );
//            if(isPasswordVisible.get()){
//                // we are going to make the pass field visible //
//                txfPassword.setText(storePass.get());
//                System.out.println("Show Password" + storePass.get());
//
//            }else{
//                // we are going to hide the password //
//                StringBuilder asterisks = new StringBuilder();
//                for(int i=0;i<txfPassword.getLength();i++){
//                    asterisks.append("*");
//                }
//                txfPassword.setText(asterisks.toString());
//                System.out.println("Hide Password");
//
//            }
//        });

        checkBox.setOnAction((e)-> isPasswordVisible.set(!isPasswordVisible.get()));


        checkBox.setCheckedColor(Color.web("#000"));

        hBoxPassword.getChildren().addAll(txfPassword,checkBox);
        txfPassword.setPromptText("Enter Password");
        txfPassword.setLabelFloat(true);
        txfPassword.setFocusColor(Color.web("#000"));
        Label lblPasswordError = new Label("");
        lblPasswordError.setStyle("-fx-text-fill:red;");


        HBox hBoxLogIn = new HBox();
        JFXButton btnLogIn = new JFXButton("LogIn");
        btnLogIn.setOnAction(event ->{
            boolean isErrorExist = false;
            if(Validators.checkEmptyField(txfUsername.getText() )){
                lblUsernameError.setText("Username field is empty");
                isErrorExist = true;
            }else {
                try {
                    if(Database.searchItem("customers","username",txfUsername.getText().trim())==-1){
                        lblUsernameError.setText("Username not found!");
                        isErrorExist = true;
                    }else{
                        lblUsernameError.setText("");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(Validators.checkEmptyField(txfPassword.getText() )){
                lblPasswordError.setText("Username field is empty");
                isErrorExist = true;
            }


            if(!isErrorExist){
                try {
                    if(Database.checkLogInAttempt(
                            txfUsername.getText().trim(),
                            txfPassword.getText())
                    ){
                        SceneChange.changeScene(primaryStage,txfUsername.getText().trim(),"home");
                    }else{
                        // set error //
                        lblPasswordError.setText("Wrong Password! Try Again!");

                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        });


        hBoxLogIn.getChildren().add(btnLogIn);
        hBoxLogIn.setAlignment(Pos.CENTER_RIGHT);
        btnLogIn.setStyle("-jfx-button-type:RAISED;-fx-background-color:#616161;-fx-text-fill:#fff;" +
                "-fx-font-weight:bold;-fx-background-radius:50;-fx-pref-width:150;-fx-pref-height:50;");


        // - -------------------------------------- //

        HBox hBoxSignUp = new HBox(3);
        VBox vBoxSignUp = new VBox(5);
        Label lblLogIn = new Label("Create new account ");
        JFXButton btnSignUp = new JFXButton("SignUp");
        btnSignUp.setOnAction(event ->{
            try {
                SceneChange.changeScene(primaryStage,"signup");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        btnSignUp.setStyle("-jfx-button-type:RAISED;-fx-background-color:#e8491d;-fx-text-fill:white;-fx-font-weight:bold;-fx-background-radius:50;-fx-pref-width:500;-fx-pref-height:20;");
        vBoxSignUp.getChildren().addAll(lblLogIn,btnSignUp);
        hBoxSignUp.getChildren().add(vBoxSignUp);
        hBoxSignUp.setAlignment(Pos.CENTER);
        vBoxSignUp.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();

        gridPane.add(lblUsername,0,2);
        gridPane.add(txfUsername,1,2);
        gridPane.add( lblUsernameError ,1,3);

        gridPane.add(lblPassword,0,4);
        gridPane.add(hBoxPassword,1,4);
        gridPane.add( lblPasswordError ,1,5);


        gridPane.add(hBoxLogIn,1,6);
        gridPane.setHgap(10);
        gridPane.setVgap(22);

        // - -------------------------------- //


        HBox rootP = new HBox();
        rootP.getStyleClass().add("food-cart");
        rootP.setMaxWidth(600);
        rootP.setMaxHeight(400);

        rootP.setAlignment(Pos.CENTER);
        rootP.getChildren().add(gridPane);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lblSignUp,rootP,hBoxSignUp);


        return root;
    }
}
