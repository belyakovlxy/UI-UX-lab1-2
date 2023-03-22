module com.example.phone {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.phone to javafx.fxml;
    exports com.example.phone;
}