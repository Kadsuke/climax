module com.climax {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.climax to javafx.fxml;
    exports com.climax to javafx.graphics, javafx.fxml;
    opens com.climax.controller to javafx.fxml;
    requires java.xml;
  //  exports com.climax; 
    requires com.fasterxml.jackson.databind;
    requires javafx.fxmlEmpty;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires javafx.baseEmpty;
    requires javafx.base;
    exports com.climax.controller;
    requires de.jensd.fx.glyphs.fontawesome;

}
