module billyg.gifplayerforpi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens billyg.gifplayerforpi to javafx.fxml;
    exports billyg.gifplayerforpi;
}