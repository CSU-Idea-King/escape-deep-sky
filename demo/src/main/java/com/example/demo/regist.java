package com.example.demo;

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


public class regist extends HelloApplication {
    private double xOffset = 0;
    private double yOffset = 0;
    public void start(Stage stage) {


        //AnchorPane anchorPane = new AnchorPane();
        //GridPane grid = new GridPane();
        //BorderPane root = new BorderPane();
        //容器
        Pane pane = new Pane();
        //pane.setPrefWidth(500);
        InputStream inre = getClass().getResourceAsStream("imgs/regist.png");
        Image image = new Image(inre);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(false);

        // 绑定图片视图的宽高属性到舞台的宽高属性，实现自动适应
        imageView.fitWidthProperty().bind(stage.widthProperty());
        imageView.fitHeightProperty().bind(stage.heightProperty());



        //获取子组件集合，将图片加入集合中
        pane.getChildren().add(imageView);


       // 创建“账号：”文本
        Text accountLabel = new Text("账号：");
        accountLabel.setFill(Color.BLACK); // 设置文字颜色为黑色，可以根据需求调整
        accountLabel.setLayoutX(335);
        accountLabel.setLayoutY(260);
        accountLabel.setFont(Font.font(15));
        pane.getChildren().add(accountLabel);
        // 创建输入框
        TextField usernameField = new TextField();
        usernameField.setPromptText("账号");
        usernameField.setLayoutX(385); // 设置 X 坐标位置
        usernameField.setLayoutY(240);
        usernameField.setPrefWidth(190);
        usernameField.setPrefHeight(30);
        usernameField.setStyle("-fx-opacity: 0.7;");

        // 创建“密码：”文本
        Text passwordLabel = new Text("密码：");
        passwordLabel.setFill(Color.BLACK); // 设置文字颜色为黑色，可以根据需求调整
        passwordLabel.setLayoutX(335);
        passwordLabel.setLayoutY(300);
        passwordLabel.setFont(Font.font(15));
        pane.getChildren().add(passwordLabel);
        // 创建输入框
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("密码");
        passwordField.setLayoutX(385); // 设置 X 坐标位置
        passwordField.setLayoutY(280);
        passwordField.setPrefWidth(190);
        passwordField.setPrefHeight(30);
        passwordField.setStyle("-fx-opacity: 0.7;");


        // 创建“确认密码：”文本
        Text confirmLabel = new Text("确认密码：");
        confirmLabel.setFill(Color.BLACK); // 设置文字颜色为黑色，可以根据需求调整
        confirmLabel.setLayoutX(305);
        confirmLabel.setLayoutY(340);
        confirmLabel.setFont(Font.font(15));
        pane.getChildren().add(confirmLabel);
        // 创建输入框
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("确认密码");
        confirmPasswordField.setLayoutX (385); // 设置 X 坐标位置
        confirmPasswordField.setLayoutY (320);
        confirmPasswordField.setPrefWidth (190);
        confirmPasswordField.setPrefHeight (30);
        confirmPasswordField.setStyle("-fx-opacity: 0.7;");

        //创建“验证码”文本
        Text verificationLabel = new Text("验证码：");
        verificationLabel.setFill(Color.BLACK);
        verificationLabel.setLayoutX(320);
        verificationLabel.setLayoutY(380);
        verificationLabel.setFont(Font.font(15));
        pane.getChildren().add(verificationLabel);
        // 创建输入框
        TextField verificationCodeField = new TextField();
        verificationCodeField.setPromptText("验证码");
        verificationCodeField.setLayoutX(385); // 设置 X 坐标位置
        verificationCodeField.setLayoutY(360);
        verificationCodeField.setPrefWidth(190);
        verificationCodeField.setPrefHeight(30);
        verificationCodeField.setStyle("-fx-opacity: 0.7;");

        // 创建垂直布局容器用于放置输入框
       /*VBox inputBoxes = new VBox(10);
        inputBoxes.setPadding(new Insets(20));
        inputBoxes.getChildren().addAll(usernameField, passwordField, confirmPasswordField, verificationCodeField);

        // 将输入框布局容器放置在中间位置
        inputBoxes.setLayoutX(stage.getWidth() / 2 - inputBoxes.getWidth() / 2);
        inputBoxes.setLayoutY(stage.getHeight() / 2 - inputBoxes.getHeight() / 2);*/

        // 将图片和输入框布局添加到主容器
        pane.getChildren().addAll(usernameField, passwordField, confirmPasswordField, verificationCodeField);
        //pane.getChildren().add(inputBoxes);
        //创建场景scene
        Scene scene=new Scene(pane,900,630);

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

        // 创建“点击注册”按钮
        Button registerButton = new Button();
        registerButton.setLayoutX(400); // 居中显示
        registerButton.setLayoutY(385);
        registerButton.setPrefWidth(140);
        registerButton.setPrefHeight(90);
        registerButton.setStyle("-fx-background-color: transparent;");
        registerButton.setStyle("-fx-background-color: transparent; -fx-border-radius: 20;");

        //添加背景图
        InputStream regi=getClass().getResourceAsStream("imgs/plank.png");
        Image regiImage = new Image(regi);
        ImageView imageViewregi= new ImageView (regiImage);
        imageViewregi.setFitWidth(140);
        imageViewregi.setFitHeight(80);

        registerButton.setGraphic(imageViewregi);

        pane.getChildren().add(registerButton);

        // 创建重置按钮
        Button resetButton = new Button();
        resetButton.setPrefWidth(40);
        resetButton.setPrefHeight(40);
        resetButton.setLayoutX(336);
        resetButton.setLayoutY(410);
        // 设置按钮为透明
        resetButton.setStyle("-fx-background-color: transparent;");

        // 添加背景图
        InputStream reset=getClass().getResourceAsStream("imgs/rest.png");
        Image resetImage = new Image(reset);
        ImageView imageViewrest = new ImageView(resetImage);
        imageViewrest.setFitWidth(35);
        imageViewrest.setFitHeight(35);
        resetButton.setGraphic(imageViewrest);
        // 为重置按钮添加事件处理
        resetButton.setOnAction(event -> {
            usernameField.clear();
            passwordField.clear();
            confirmPasswordField.clear();
            verificationCodeField.clear();
        });


        // 创建一个隐藏的文本用于提示
        Text tooltipText = new Text("清 空");
        tooltipText.setFill(Color.RED);
        tooltipText.setVisible(false);
        tooltipText.setFont(Font.font(15)); // 设置字体大小为 14
        pane.getChildren().add(tooltipText);

        // 使用鼠标事件来显示和隐藏提示文字
        resetButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            tooltipText.setLayoutX(345);
            tooltipText.setLayoutY(465);
            tooltipText.setVisible(true);
        });
        resetButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            tooltipText.setVisible(false);
        });
        pane.getChildren().add(resetButton);

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



