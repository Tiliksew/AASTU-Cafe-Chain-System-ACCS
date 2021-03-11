package GUI;

import Helpers.FoodItem;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FoodCard {

    FoodItem foodItem = new FoodItem();
    public FoodCard(FoodItem foodItemInput){
        foodItem.foodId = foodItemInput.foodId;
        foodItem.foodName = foodItemInput.foodName;
        foodItem.foodPrice = foodItemInput.foodPrice;
        foodItem.foodImagePath = foodItemInput.foodImagePath;
        foodItem.cafeAvailable = foodItemInput.cafeAvailable;
        foodItem.foodRating = foodItemInput.foodRating;
    }
    public HBox getFoodCard(){
        VBox root = new VBox(5);
        root.getStyleClass().add("food-cart");
        root.setMaxHeight(200);

        root.setAlignment(Pos.CENTER);

        HBox hBoxHeading = new HBox(50);
        hBoxHeading.setAlignment(Pos.CENTER);
        Label lblFoodName = new Label(foodItem.foodName);
        lblFoodName.setStyle("-fx-font-weight:bold;-fx-font-size:15;");
        Label lblFoodPrice = new Label(foodItem.foodPrice+" ");
        lblFoodPrice.setStyle("-fx-font-weight:bold;-fx-font-size:20;-fx-text-fill:#626262;");

        hBoxHeading.getChildren().addAll(lblFoodName,lblFoodPrice);

        final String path = foodItem.foodImagePath;
        Image imgFood = null;
        try {
            imgFood = new Image(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imgViewFood = new ImageView(imgFood);
        imgViewFood.setFitWidth(100);
        imgViewFood.setFitHeight(100);
        HBox hBoxFoodImage = new HBox();
        hBoxFoodImage.setAlignment(Pos.CENTER);
        hBoxFoodImage.getChildren().add(imgViewFood);

        HBox hBoxRating = new HBox(10);
        hBoxRating.setAlignment(Pos.CENTER);
        Label lblCafeName = new Label(foodItem.cafeAvailable);
        lblCafeName.getStyleClass().add("cafe-name");
        Label lblRating = new Label(foodItem.foodRating+" *");
        lblRating.getStyleClass().add("rating");

        hBoxRating.getChildren().addAll( lblCafeName ,lblRating);

        HBox hBoxBuy = new HBox(10);
        JFXButton btnOrderNow = new JFXButton("Order Now");
        btnOrderNow.setOnAction((e)-> System.out.println("Sign up is clicked!"));
        btnOrderNow.getStyleClass().add("buy");



        JFXButton btnAddToCart = new JFXButton("Add to Cart");
        btnAddToCart.getStyleClass().add("buy");
        btnAddToCart.setOnAction((e)-> System.out.println("Sign up is clicked!"));
//        btnAddToCart.getStyleClass().add("buy");
        hBoxBuy.getChildren().addAll(btnOrderNow,btnAddToCart);

        root.getChildren().addAll(hBoxHeading,hBoxFoodImage,hBoxRating,hBoxBuy);

        HBox root2 = new HBox();
        root2.setPrefSize(200,100);
        root2.setAlignment(Pos.CENTER);
        root2.getChildren().add(root);

        return root2;
    }
}

