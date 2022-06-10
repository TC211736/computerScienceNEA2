module com.example.computersciencenea {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires slick.util;
    requires org.lwjgl;
    requires org.lwjgl.glfw;
    requires org.lwjgl.opengl;


    opens com.example.computersciencenea to javafx.fxml;
    exports com.example.computersciencenea;
}