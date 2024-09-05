package com.example.demo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.InputStream;

public class test1 extends Application {
    public void start(Stage stage) {
        // 容器
        Pane pane = new Pane();
        InputStream in = getClass().getResourceAsStream("imgs/regist.png");
        Image image = new Image(in);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(false);

        // 绑定图片视图的宽高属性到舞台的宽高属性，实现自动适应
        imageView.fitWidthProperty().bind(stage.widthProperty());
        imageView.fitHeightProperty().bind(stage.heightProperty());

        // 获取子组件集合，将图片加入集合中
        pane.getChildren().add(imageView);

        // 创建输入框
        TextField usernameField = new TextField();
        usernameField.setPromptText("用户名");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("密码");
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("确认密码");
        TextField verificationCodeField = new TextField();
        verificationCodeField.setPromptText("验证码");

        // 创建垂直布局容器用于放置输入框
        VBox inputBoxes = new VBox(10);

        inputBoxes.setPadding(new Insets(20));
        inputBoxes.getChildren().addAll(usernameField, passwordField, confirmPasswordField, verificationCodeField);

        // 将输入框布局容器放置在中间位置
        inputBoxes.setLayoutX(stage.getWidth() / 2 - inputBoxes.getWidth() / 2);
        inputBoxes.setLayoutY(stage.getHeight() / 2 - inputBoxes.getHeight() / 2);

        // 将输入框布局添加到主容器（应该在图片视图之后添加）
        pane.getChildren().add(inputBoxes);

        // 创建场景
        Scene scene = new Scene(pane, 900, 650);

        stage.setTitle("图片展示");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


