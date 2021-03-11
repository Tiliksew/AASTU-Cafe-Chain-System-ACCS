package GUI;

import Helpers.Database;
import Helpers.SceneChange;
import Helpers.Validators;
import com.jfoenix.controls.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Arrays;


public class SignUp {

    public VBox getSignUp(Stage primaryStage){
        VBox root = new VBox(10);


        Label lblSignUp = new Label("SignUp");
        lblSignUp.setStyle("-fx-font-size:30;-fx-font-weight:bold;");

        Label lblName = new Label("Full Name");

        lblName.getStyleClass().add("bolds");
        HBox hBoxName = new HBox(50);
        JFXTextField txfYName = new JFXTextField();
        txfYName.setPromptText("Your Name");
        JFXTextField txfFName = new JFXTextField();
        txfFName.setPromptText("Your Father's Name");
        Label lblNameError = new Label("");
        lblNameError.setStyle("-fx-text-fill:red;");
        hBoxName.getChildren().addAll(txfYName,txfFName);
        txfYName.setLabelFloat(true);
        txfYName.setFocusColor(Color.web("#000"));
        txfFName.setLabelFloat(true);
        txfFName.setFocusColor(Color.web("#000"));


        Label lblUsername= new Label("Username");
        lblUsername.getStyleClass().add("bolds");
        JFXTextField txfUsername = new JFXTextField();


        txfUsername.setPromptText("Enter Unique Username");
        txfUsername.setLabelFloat(true);
        txfUsername.setFocusColor(Color.web("#000"));
        Label lblUsernameError = new Label("");
        lblUsernameError.setStyle("-fx-text-fill:red;");

        Label lblPassword= new Label("Password");
        lblPassword.getStyleClass().add("bolds");
        JFXPasswordField txfPassword = new JFXPasswordField();
        txfPassword.setPromptText("Enter Password");
        txfPassword.setLabelFloat(true);
        txfPassword.setFocusColor(Color.web("#000"));
        Label lblPasswordError = new Label("");
        lblPasswordError.setStyle("-fx-text-fill:red;");

        Label lblConfirmPassword= new Label("Confirm Password");
        lblConfirmPassword.getStyleClass().add("bolds");
        JFXPasswordField txfConfirmPassword = new JFXPasswordField();
        txfConfirmPassword.setPromptText("Confirm Password");
        txfConfirmPassword.setLabelFloat(true);
        txfConfirmPassword.setFocusColor(Color.web("#000"));
        Label lblConfirmPasswordError = new Label("");
        lblConfirmPasswordError.setStyle("-fx-text-fill:red;");

        Label lblGender= new Label("Gender");
        lblGender.getStyleClass().add("bolds");
        JFXRadioButton rbMale = new JFXRadioButton("Male");
        JFXRadioButton rbFemale = new JFXRadioButton("Female");
        rbFemale.setSelectedColor(Color.web("#000"));
        rbMale.setSelectedColor(Color.web("#000"));
        ToggleGroup groupGender = new ToggleGroup();
        rbMale.setSelected(true);
        groupGender.getToggles().addAll(rbMale,rbFemale);
        HBox hBoxGender = new HBox(30);
        hBoxGender.getChildren().addAll(rbMale,rbFemale);

        Label lblAddress= new Label("Address");
        lblAddress.getStyleClass().add("bolds");


        HBox hBoxRegister = new HBox();
        JFXButton btnRegister = new JFXButton("Register");


        hBoxRegister.getChildren().add(btnRegister);
        hBoxRegister.setAlignment(Pos.CENTER_RIGHT);
        btnRegister.setStyle("-jfx-button-type:RAISED;-fx-background-color:#616161;-fx-text-fill:#fff;" +
                "-fx-font-weight:bold;-fx-background-radius:50;-fx-pref-width:150;-fx-pref-height:50;");


        // - -------------------------------------- //
        HBox hBoxLogIn = new HBox(3);
        VBox vBoxLogIn = new VBox(5);
        Label lblLogIn = new Label("Already have an account ? ");
        JFXButton btnLogIn = new JFXButton("LogIn");
        btnLogIn.setOnAction(event ->{
            try {
                SceneChange.changeScene(primaryStage,"login");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        btnLogIn.setStyle("-jfx-button-type:RAISED;-fx-background-color:#e8491d;-fx-text-fill:white;-fx-font-weight:bold;-fx-background-radius:50;-fx-pref-width:500;-fx-pref-height:20;");
        vBoxLogIn.getChildren().addAll(lblLogIn,btnLogIn);
        hBoxLogIn.getChildren().add(vBoxLogIn);
        hBoxLogIn.setAlignment(Pos.CENTER);
        vBoxLogIn.setAlignment(Pos.CENTER);

        HBox temp = new HBox();
        temp.getStyleClass().add("food-cart");
        temp.setStyle("-fx-padding:20px 50px;");

        GridPane gridPane = new GridPane();
        temp.getChildren().add(gridPane);
        gridPane.add(lblName,0,0);
        gridPane.add(hBoxName,1,0);
        gridPane.add(lblNameError,1,1);


        gridPane.add(lblUsername,0,2);
        gridPane.add(txfUsername,1,2);
        gridPane.add( lblUsernameError ,1,3);

        gridPane.add(lblPassword,0,4);
        gridPane.add(txfPassword,1,4);
        gridPane.add( lblPasswordError ,1,5);

        gridPane.add(lblConfirmPassword,0,6);
        gridPane.add(txfConfirmPassword,1,6);
        gridPane.add( lblConfirmPasswordError ,1,7);

        gridPane.add(lblGender,0,8);
        gridPane.add(hBoxGender,1,8);

        Label lblAddressError = new Label("");

//        JFXTextField txfAddress = new JFXTextField();
//        txfAddress.setFocusColor(Color.web("#000"));


        JFXComboBox<String> blockNo = new JFXComboBox<>();
        for(int i=1;i<18;i++){
            String text = "";
            if(i<10)text ="0";
            blockNo.getItems().add(text + i);
        }

        blockNo.setPromptText("Block No.");

        JFXComboBox<String> floorNo = new JFXComboBox<>();
        floorNo.getItems().add("G" );
        for(int i=1;i<5;i++)
            floorNo.getItems().add("" + i);
        floorNo.setPromptText("Floor No.");

        JFXComboBox<String> dormNo = new JFXComboBox<>();
        for(int i=1;i<26;i++){
            String text = "";
            if(i<10)text ="0";
            dormNo.getItems().add(text + i);
        }

        dormNo.setPromptText("Dorm No.");

        HBox hBoxAddress = new HBox(10);
        hBoxAddress.getChildren().addAll(blockNo,floorNo,dormNo);

        gridPane.add( lblAddress ,0,9);
        gridPane.add( hBoxAddress ,1,9);

        /*hBoxAddress.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.matches("\\d*")){
                hBoxAddress.setText(newValue.replaceAll("[^\\d]",""));
            }
        });*/



        gridPane.add(lblAddressError,1,10);
        gridPane.add(hBoxRegister,1,11);

        lblAddressError.setStyle("-fx-text-fill:red;");
        gridPane.setHgap(10);
        gridPane.setVgap(22);

        // - -------------------------------- //

        btnRegister.setOnAction(event ->{

            boolean isErrorExist = false;

            if(Validators.checkEmptyField(txfYName.getText())){
                lblNameError.setText("Enter your name");
                isErrorExist = true;
            }
            else if(Validators.checkEmptyField(txfFName.getText())){
                lblNameError.setText("Enter your fathers name");
                isErrorExist = true;
            }else{
                lblNameError.setText("");
            }

            if(Validators.checkEmptyField(txfUsername.getText() )){
                lblUsernameError.setText("Username field is empty");
                isErrorExist = true;
            }else if(Validators.checkUsernameReplication(txfUsername.getText() )){
                lblUsernameError.setText("Username is taken. Try another.");
                isErrorExist = true;
            }else{
                lblUsernameError.setText("");
            }

            if(Validators.checkEmptyField(txfPassword.getText() )){
                lblPasswordError.setText("Password field is empty");
                isErrorExist = true;
            }else if(!Validators.checkPasswordMinLength(txfPassword.getText() )){
                lblPasswordError.setText("Password is too short.");
                isErrorExist = true;
            }else{
                lblPasswordError.setText("");
            }

            if(Validators.checkEmptyField(txfConfirmPassword.getText() )){
                lblConfirmPasswordError.setText("Confirm Password field is empty");
                isErrorExist = true;
            }else if(!txfPassword.getText().equals(txfConfirmPassword.getText())){
                lblConfirmPasswordError.setText("Passwords don't match ");
                isErrorExist = true;
            }else{
                lblConfirmPasswordError.setText("");
            }

            if(blockNo.getValue()==null || floorNo.getValue()==null || dormNo.getValue()==null ){
                lblAddressError.setText("Address is not valid");
                isErrorExist = true;
            }else{
                lblAddressError.setText("");
            }


            if(!isErrorExist) {
                // Create a new user to the database //
                String[] newUser = new String[]{
                        String.valueOf((Database.getCustomerSize())),
                        (txfYName.getText().trim() + " " + txfFName.getText().trim()),
                        txfUsername.getText().trim(),
                        txfPassword.getText(),
                        ((rbMale.isSelected()?"M":"F")),
                        ( blockNo.getValue() + floorNo.getValue() + dormNo.getValue())
                };
                //System.out.println("Result to be wrritten to db \n  => " + Arrays.toString(newUser));
                Database.setCustomer(newUser);
                try {
                    SceneChange.changeScene(primaryStage,"login");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            // end if block
        });


        HBox rootP = new HBox();
        rootP.setAlignment(Pos.CENTER);
        rootP.getChildren().add(temp);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lblSignUp,rootP,hBoxLogIn);



        return root;
    }
}
