package com.example.demo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;


public class Loading extends HelloApplication {
    public void start(Stage stage) {
        //容器
        Pane pane = new Pane();
        InputStream in = getClass().getResourceAsStream("imgs/back.png");
        Image image = new Image(in);
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        imageView.setX(50);
        imageView.setY(50);
        imageView.setPreserveRatio(true);

        //获取子组件集合，将图片加入集合中
        pane.getChildren().add(imageView);

        //创建场景scene
        Scene scene=new Scene(pane,500,500);

        stage.setTitle("图片展示");
        stage.setScene(scene);
        stage.show();
    }
public static void main(String[] args) {
        launch(args);
}
}
