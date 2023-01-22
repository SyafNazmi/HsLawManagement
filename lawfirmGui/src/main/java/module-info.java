module model.lawfirmgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens model.lawfirmgui to javafx.fxml;
    exports model.lawfirmgui;
}