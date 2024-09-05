package com.example.demo;
import com.example.demo.regist;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;


public class login extends HelloApplication {
    private double xOffset = 0;
    private double yOffset = 0;
    public void start(Stage stage) {


        //AnchorPane anchorPane = new AnchorPane();
        //GridPane grid = new GridPane();
        //BorderPane root = new BorderPane();
        //容器
        Pane pane = new Pane();
        //pane.setPrefWidth(500);
        InputStream in = getClass().getResourceAsStream("imgs/login.jpg");
        Image image = new Image(in);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(false);

        // 绑定图片视图的宽高属性到舞台的宽高属性，实现自动适应
        imageView.fitWidthProperty().bind(stage.widthProperty());
        imageView.fitHeightProperty().bind(stage.heightProperty());

        //获取子组件集合，将图片加入集合中
        pane.getChildren().add(imageView);


        //创建舞台
        Scene scene=new Scene(pane,900,630);
        pane.setStyle("-fx-background-radius: 20px;");

        // 创建退出按钮
        Button closeButton = new Button("X");
        closeButton.setPrefWidth(38);
        closeButton.setPrefHeight(28);
        closeButton.setLayoutX(862);
        closeButton.setLayoutY(0);
        closeButton.setOnAction(event -> stage.close());
        // 设置鼠标进入时的事件处理，变为红色
        closeButton.setOnMouseEntered(event -> {
            closeButton.setStyle("-fx-background-color: red;");
        });
        // 设置鼠标离开时的事件处理，恢复默认样式
        closeButton.setOnMouseExited(event -> {
            closeButton.setStyle(null);
        });
        // 设置按钮的透明度为 0.5
        closeButton.setOpacity(0.7);


        // 创建缩小按钮
        Button minimizeButton = new Button();
        minimizeButton.setPrefWidth(38);
        minimizeButton.setPrefHeight(28);
        minimizeButton.setLayoutX(824);
        minimizeButton.setLayoutY(0);
        minimizeButton.setOnAction(event -> stage.setIconified(true));
        // 设置鼠标进入时的事件处理
        minimizeButton.setOnMouseEntered(event -> {
            minimizeButton.setStyle("-fx-background-color: gray;");
        });
        // 设置鼠标离开时的事件处理
        minimizeButton.setOnMouseExited(event -> {
            minimizeButton.setStyle(null);
        });
        InputStream mini=getClass().getResourceAsStream("imgs/mini.png");
        Image miniImage = new Image(mini);
        ImageView imageViewmini= new ImageView(miniImage);
        imageViewmini.setFitWidth(20);
        imageViewmini.setFitHeight(20);
        minimizeButton.setGraphic(imageViewmini);
        minimizeButton.setText(null);
        // 设置按钮的透明度为 0.5
        minimizeButton.setOpacity(0.7);

        pane.getChildren().add(minimizeButton);
        pane.getChildren().add(closeButton);



        // 创建“注册”按钮
        Button registButton = new Button();
        registButton.setLayoutX(382); // 可以根据需要调整位置，这里先与登录按钮位置相同
        registButton.setLayoutY(342); // 设置不同的纵坐标位置
        registButton.setPrefWidth(140);
        registButton.setPrefHeight(90);
        registButton.setStyle("-fx-background-color: transparent; -fx-border-radius: 20;");
        // 设置按钮文字
        registButton.setText("Regist");
        registButton.setStyle(registButton.getStyle() + " -fx-text-fill:rgb(252,207,26); -fx-font-weight: bold; -fx-font-size: 26;");
        // 添加鼠标悬浮效果
        registButton.setOnMouseEntered(event -> {
            registButton.setStyle(registButton.getStyle() + " -fx-effect: dropshadow(gaussian, rgba(255,255,255,0.4), 20, 0.5, 0, 0);");
        });
        registButton.setOnMouseExited(event -> {
            registButton.setStyle(registButton.getStyle().replace("-fx-effect: dropshadow(gaussian, rgba(255,255,255,0.4), 20, 0.5, 0, 0);", ""));
        });
      // 添加点击事件处理，关闭当前窗口并打开注册窗口
        registButton.setOnAction(event -> {
            stage.close();
            Stage registStage = new Stage();
            regist registApp = new regist();
            registApp.start(registStage);
        });
        pane.getChildren().add(registButton);



        // 创建“登录”按钮
        Button loginButton = new Button();
        loginButton.setLayoutX(382); // 居中显示
        loginButton.setLayoutY(452);
        loginButton.setPrefWidth(140);
        loginButton.setPrefHeight(90);
        loginButton.setStyle("-fx-background-color: transparent;");
        loginButton.setStyle("-fx-background-color: transparent; -fx-border-radius: 20;");
        // 设置按钮文字
        loginButton.setText("Login");
        loginButton.setStyle(loginButton.getStyle() + " -fx-text-fill:rgb(252,207,26); -fx-font-weight: bold; -fx-font-size: 26;");
        // 添加鼠标悬浮效果
        loginButton.setOnMouseEntered(event -> {
            loginButton.setStyle(loginButton.getStyle() + " -fx-effect: dropshadow(gaussian, rgba(255,255,255,0.4), 20, 0.5, 0, 0);");
        });
        loginButton.setOnMouseExited(event -> {
            loginButton.setStyle(loginButton.getStyle().replace("-fx-effect: dropshadow(gaussian, rgba(255,255,255,0.4), 20, 0.5, 0, 0);", ""));
        });
        pane.getChildren().add(loginButton);


        //创建场景
        stage.setTitle("regist");

        stage.initStyle(StageStyle.TRANSPARENT); // 去掉窗口边框
        stage.setScene(scene);
        stage.show();



        // 为窗口添加鼠标拖拽事件处理
        pane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        pane.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });


        // 修改处：设置窗口不可调整大小
        stage.setResizable(false);

    }

    public static void main(String[] args) {
        launch(args);
    }
}