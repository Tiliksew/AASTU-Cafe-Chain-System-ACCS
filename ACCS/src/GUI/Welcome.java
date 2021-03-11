package GUI;

import Helpers.SceneChange;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Welcome {


    public VBox getWelcome(Stage primaryStage){
        VBox root = new VBox(30);
        root.setAlignment(Pos.CENTER);
        HBox hb_header = new HBox();
        hb_header.setAlignment(Pos.TOP_CENTER);
        VBox vb_header = new VBox(8);
        vb_header.setAlignment(Pos.TOP_CENTER);
        Label lblAASTU = new Label("AASTU");
        lblAASTU.setStyle("-fx-font-size: 3em; -fx-font-weight: bold;");
        Label lblCafe = new Label("Cafe Chain System");
        lblCafe.setStyle("-fx-font-size: 2em; -fx-text-fill: #777");
        hb_header.getChildren().add(vb_header);
        vb_header.getChildren().addAll(lblAASTU,lblCafe);


        final String path = "src/asset/images/fork.png";
        Image img = null;
        try {
            img = new Image(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //
        }
        ImageView imageViewLogo = new ImageView(img);
        imageViewLogo.setFitWidth(200);
        imageViewLogo.setFitHeight(200);
        imageViewLogo.setStyle("-fx-margin:20px 0px");


        HBox hBoxAccount = new HBox(30);
        hBoxAccount.setAlignment(Pos.TOP_CENTER);
        VBox vBoxSignUp = new VBox(8);


        VBox vBoxLogIn = new VBox(8);
        JFXButton btnLogIn = new JFXButton("LogIn");


        Label lblLogIn = new Label("Already have an account ? ");
        lblLogIn.setStyle("-fx-font-weight:bold; -fx-text-fill:#e8491d;");
        btnLogIn.getStyleClass().add("big-buttons");
        btnLogIn.setId("btn-log-in");
        btnLogIn.setOnAction(event ->{
            try {
                SceneChange.changeScene(primaryStage,"login");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        vBoxLogIn.getChildren().addAll(lblLogIn,btnLogIn);
        vBoxLogIn.setAlignment(Pos.CENTER);


        JFXButton btnSignUp = new JFXButton("SignUp");
        btnSignUp.getStyleClass().add("big-buttons");
        btnSignUp.setId("btn-sign-up");
        Label lblSignUp = new Label("New User ?");

        btnSignUp.setOnAction(event ->{
            try {
                SceneChange.changeScene(primaryStage,"signup");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        lblSignUp.setStyle("-fx-font-weight:bold; -fx-text-fill:#e8491d;");
        vBoxSignUp.getChildren().addAll(lblSignUp,btnSignUp);
        vBoxSignUp.setAlignment(Pos.CENTER);


        hBoxAccount.getChildren().addAll(vBoxLogIn,vBoxSignUp);

        root.getChildren().addAll(hb_header,imageViewLogo,hBoxAccount);

        return root;
    }
}
