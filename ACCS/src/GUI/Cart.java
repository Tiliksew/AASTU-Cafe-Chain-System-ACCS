package GUI;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Cart {

    public VBox getCart(){

        VBox root = new VBox(50);

        HBox hBoxBack = new HBox();
        hBoxBack.setAlignment(Pos.TOP_LEFT);
        JFXButton btnBack = new JFXButton("<");
        btnBack.setStyle("-fx-font-size:18;-fx-margin:0 50;-fx-text-fill:#fff;-fx-background-color:#616161;-fx-font-weight:bold;");
        hBoxBack.getChildren().add(btnBack);

        VBox vBoxBill = new VBox(5);
        GridPane gp = new GridPane();


        // bill headers //
        Label lblItems = new Label("Items");
        Label lblQty = new Label("Quantity");
        Label lblPrice = new Label("Price");

        gp.add(lblItems,0,0);
        gp.add(lblQty,1,0);
        gp.add(lblPrice,2,0);

        // food columns
        // start //
        FoodInfo[] foodOrderInfo = getFoodOrderInfo();
        for(int i=0;i<foodOrderInfo.length;i++) {
            HBox hBoxFood = new HBox(5);
            JFXButton btnDec = new JFXButton("-");
            btnDec.setStyle("-fx-text-fill:#fff;-fx-background-color:#8c8c8c");
            Label lblFoodName = new Label(foodOrderInfo[i].foodName);
            JFXButton btnInc = new JFXButton("+");
            btnInc.setStyle("-fx-text-fill:#fff;-fx-background-color:#8c8c8c");
            hBoxFood.getChildren().addAll(btnDec, btnInc,lblFoodName);
            Label lblFoodQty = new Label(foodOrderInfo[i].foodQty+" X");
            Label lblFoodPrice = new Label(foodOrderInfo[i].foodPrice + " Birr");
            gp.add(hBoxFood,0,i+1);
            gp.add(lblFoodQty,1,i+1);
            gp.add(lblFoodPrice,2,i+1);
        }
        // End one line //



        gp.setHgap(50);
        gp.setVgap(45);

        vBoxBill.getChildren().add(gp);
        vBoxBill.setAlignment(Pos.CENTER);
        HBox hBoxBill = new HBox();
        hBoxBill.setAlignment(Pos.CENTER);
        hBoxBill.getChildren().add(vBoxBill);




        // Buttons //


        HBox hBoxTotal = new HBox();
        Label lblTotal = new Label("Total: ");
        lblTotal.setStyle("-fx-font-size:18; -fx-font-weight:bold;");
        Label lblTotalBirr = new Label("74 Birr");
        lblTotalBirr.setStyle("-fx-font-size:25; -fx-font-weight:bold;-fx-text-fill:#e84916");
        hBoxTotal.getChildren().addAll(lblTotal,lblTotalBirr);
        hBoxTotal.setAlignment(Pos.CENTER);

        HBox hBoxOrder = new HBox(30);
        JFXButton btnClearCart = new JFXButton("Clear Cart");
        /*btnClearCart.getStyleClass().add("big-buttons");
        btnClearCart.setId("btn-log-in");*/
        btnClearCart.setStyle(" -jfx-button-type:RAISED;" +
                "    -fx-text-fill:#fff;" +
                "    -fx-font-weight:bold;" +
                "    -fx-background-radius:50;" +
                "    -fx-pref-width:100;" +
                "    -fx-pref-height:30;" +
                "    -fx-background-color:#616161;");

        JFXButton btnOrder = new JFXButton("Order");
        /*btnClearCart.getStyleClass().add("big-buttons");
        btnClearCart.setId("btn-log-in");*/
        btnOrder.setStyle(" -jfx-button-type:RAISED;" +
                "    -fx-text-fill:#fff;" +
                "    -fx-font-weight:bold;" +
                "    -fx-background-radius:50;" +
                "    -fx-pref-width:100;" +
                "    -fx-pref-height:30;" +
                "    -fx-background-color:#e8491d;");

        hBoxOrder.getChildren().addAll(btnClearCart,btnOrder);
        hBoxOrder.setAlignment(Pos.CENTER);
        root.getChildren().addAll(hBoxBack,hBoxBill,hBoxTotal,hBoxOrder);

        return root;
    }

    private FoodInfo[] getFoodOrderInfo(){

        // Start Pseudo DB //
        final String[][] fo = new String[][]{
                {"Fifer","3","18"},
                {"Beyayenet","3","15"},
                {"Pasta","2","25"},
                {"Erteb","5","20"},
                {"Foll","2","30"},
        };

        final int ORDER_COUNT = fo.length;
        // End Pseudo DB //

        FoodInfo[] foodInfo = new FoodInfo[ORDER_COUNT];

        for(int i=0;i<ORDER_COUNT;i++)
            foodInfo[i] = new FoodInfo(fo[i][0],Integer.parseInt(fo[i][1]),Float.parseFloat(fo[i][2]));

        return foodInfo;
    }
    public class FoodInfo{
        String foodName;
        int foodQty;
        float foodPrice;
        public FoodInfo(String foodName,int foodQty, float foodPrice){
            this.foodName = foodName;
            this.foodQty = foodQty;
            this.foodPrice = foodPrice;
        }
    }
}

