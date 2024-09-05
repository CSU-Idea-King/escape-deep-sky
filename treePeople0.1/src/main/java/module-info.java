module com.treepeople.treepeople {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.treepeople.treepeople to javafx.fxml;
    opens com.treepeople.treepeople.game to javafx.fxml;
    exports com.treepeople.treepeople;
    exports com.treepeople.treepeople.game;
}