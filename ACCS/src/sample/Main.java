package sample;

import GUI.*;
import Helpers.Database;
import Helpers.FoodItem;
import com.jfoenix.controls.*;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws SQLException {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));




//        FoodItem foodItem = new FoodItem();
//        foodItem.foodId = 1;
//        foodItem.foodName="Menchet";
//        foodItem.foodPrice = 28;
//        foodItem.foodImagePath = "src/asset/images/ruze.png";
//        foodItem.cafeAvailable = "Kebenesh";
//        foodItem.foodRating = 4.8f;

//        Scene scene = new Scene( new FoodCard(foodItem).getFoodCard(), 850, 700);
//        JFXDecorator decorator=new JFXDecorator(primaryStage,new Text(""));
//
//        decorator.setCustomMaximize(true);





        Scene scene = new Scene( new Welcome().getWelcome(primaryStage) , 1080, 720);


        //scrollBar.setLayoutX(scene.getWidth()-scrollBar.getWidth());
        /*
        scrollBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                r.setLayoutY(-newValue.doubleValue() );
            }
        });
        */

        primaryStage.setScene(scene);


        scene.getStylesheets().add("./asset/styles/main.css");
        primaryStage.setTitle("AASTU cafe chain system");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMinWidth(1050);
        primaryStage.setMinHeight(710);
        primaryStage.setMaximized(true);

    }


    public static void main(String[] args) {
        launch(args);
    }
}

