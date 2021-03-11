package GUI;

import Helpers.Database;
import Helpers.FoodItem;
import Helpers.SceneChange;
import com.jfoenix.controls.JFXBadge;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Home {

    public VBox getHome(Stage primaryStage, String user) throws SQLException {
        VBox root = new VBox(20);

        // Nav bar for the main GUI //
        HBox hBoxNav = new HBox(50);
        final String path = "src/asset/images/fork.png";
        Image img = null;
        try {
            img = new Image(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //
        }
        ImageView imageViewLogo = new ImageView(img);
        imageViewLogo.setFitWidth(50);
        imageViewLogo.setFitHeight(50);
        imageViewLogo.setStyle("-fx-margin:20px 0px");

        Label lblAASTUCafe = new Label("AASTU Cafe Chain System");

        lblAASTUCafe.setStyle("-fx-text-fill:#fff;-fx-font-weight:bold;-fx-font-size:15;-fx-padding:18 0 0 0");

        JFXTextField txfSearchFood = new JFXTextField();
        txfSearchFood.setPromptText("Search Food");
        txfSearchFood.setStyle("-fx-text-fill:#000; -fx-background-color:white;" +
                " -fx-background-radius:5 5 0 0; -fx-padding:9 0 ;");
        txfSearchFood.setFocusColor(Color.web("#616161"));
        txfSearchFood.setPrefColumnCount(20);

        JFXComboBox<String> cBoxFilterBy = new JFXComboBox<>();
        cBoxFilterBy.setPromptText("Filter Items");
        cBoxFilterBy.setFocusColor(Color.web("#616161"));
        cBoxFilterBy.setStyle("-fx-background-color:#fff;-fx-padding:3 0");
        cBoxFilterBy.getItems().addAll("By Food Name","By Price","By Rating");


        JFXButton btnCart = new JFXButton("Cart");
        JFXBadge badge=new JFXBadge(btnCart);
        badge.setText("2");
//        badge.se
//        badge.setStyle("-fx-fill:white;-fx-background-color:#606060");
        btnCart.setStyle("-fx-text-fill:white; ");

        JFXButton btnLogout = new JFXButton("LogOut " + user);
        btnCart.setStyle("-fx-text-fill:#fff; -fx-background-color:#616161");
        btnLogout.setOnAction(event ->{
            try {
                SceneChange.changeScene(primaryStage,"login");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        hBoxNav.getChildren().addAll( imageViewLogo,lblAASTUCafe,txfSearchFood,cBoxFilterBy,btnLogout,badge);
        hBoxNav.setAlignment(Pos.TOP_CENTER);
        hBoxNav.setStyle("-fx-background-color:#e84916;-fx-text-fill:#fff;-fx-padding: 10 0");


        FlowPane r = new FlowPane();
        ScrollPane p = new ScrollPane();
        p.setPrefWidth(800);
        p.setStyle("-fx-padding:0 0 0 100");
        p.setContent(r);
        r.setHgap(50);


        r.setVgap(50);
        r.setAlignment(Pos.CENTER);




//        r.setStyle("-fx-padding:0 0 10 20");
        int indexCount = 1;
        FlowPane hBox = new FlowPane();
        for(int i=1;i<11;i++){
//            hBox.setAlignment(Pos.CENTER);
            hBox.setPrefWidth(1080);
            hBox.setHgap(20);
            // Fetch data from the database //
            String[] ddf = Database.getItem("foods","foodId",i+"",6);
            FoodItem foodItem = new FoodItem();
            foodItem.foodId = ddf[0];
            foodItem.foodName=ddf[1];
            foodItem.foodPrice = ddf[2];
            foodItem.foodImagePath = "src/asset/images/" + ddf[4] + ".png";
            foodItem.cafeAvailable = ddf[3];
            foodItem.foodRating = ddf[5];

            hBox.getChildren().add(new FoodCard(foodItem).getFoodCard());
            if(indexCount==5){
                indexCount = 0;
                r.getChildren().add(hBox);
                hBox = new FlowPane();
            }
            indexCount++;


        }
        indexCount = 1;
        hBox = new FlowPane();
        for(int i=1;i<11;i++){
//            hBox.setAlignment(Pos.CENTER);
            hBox.setPrefWidth(1080);
            hBox.setHgap(20);
            // Fetch data from the database //
            String[] ddf = Database.getItem("foods","foodId",i+"",6);
            FoodItem foodItem = new FoodItem();
            foodItem.foodId = ddf[0];
            foodItem.foodName=ddf[1];
            foodItem.foodPrice = ddf[2];

            foodItem.foodImagePath = "src/asset/images/" + ddf[4] + ".png";
            foodItem.cafeAvailable = ddf[3];
            foodItem.foodRating = ddf[5];

            hBox.getChildren().add(new FoodCard(foodItem).getFoodCard());
            if(indexCount==5){
                indexCount = 0;
                r.getChildren().add(hBox);
                hBox = new FlowPane();
            }
            indexCount++;


        }

        indexCount = 1;
        hBox = new FlowPane();
        for(int i=1;i<11;i++){
//            hBox.setAlignment(Pos.CENTER);
            hBox.setPrefWidth(1080);
            hBox.setHgap(20);
            // Fetch data from the database //
            String[] ddf = Database.getItem("foods","foodId",i+"",6);
            FoodItem foodItem = new FoodItem();
            foodItem.foodId = ddf[0];
            foodItem.foodName=ddf[1];
            foodItem.foodPrice = ddf[2];
            foodItem.foodImagePath = "src/asset/images/" + ddf[4] + ".png";
            foodItem.cafeAvailable = ddf[3];
            foodItem.foodRating = ddf[5];

            hBox.getChildren().add(new FoodCard(foodItem).getFoodCard());
            if(indexCount==5){
                indexCount = 0;
                r.getChildren().add(hBox);
                hBox = new FlowPane();
            }
            indexCount++;

        }

        root.getChildren().addAll(hBoxNav,p);
        return root;
    }
}
