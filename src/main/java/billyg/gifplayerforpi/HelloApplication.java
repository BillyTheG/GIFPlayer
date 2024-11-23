package billyg.gifplayerforpi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox hbox5 = new HBox();
        VBox VBoxAll = new VBox();



        Image gifs[] = new Image[3];
        gifs[0] = new Image(this.getClass().getResource("/gifs/luffy_0.gif").toExternalForm());
        gifs[1] = new Image(this.getClass().getResource("/gifs/luffy_1.gif").toExternalForm());
        gifs[2] = new Image(this.getClass().getResource("/gifs/luffy_2.gif").toExternalForm());

        ImageView currentGif = new ImageView();

        currentGif.setFitHeight(1800);
        currentGif.setFitWidth(1800);
        currentGif.setPreserveRatio(true);


        Button localLoadButton = new Button("Start!");
        localLoadButton.setOnAction(e -> {
            show(currentGif, gifs, Duration.millis(5000));
        });

        hbox5.getChildren().addAll(currentGif, localLoadButton);

        VBoxAll.getChildren().addAll(hbox5);
        VBoxAll.setSpacing(15);

        Pane pane = new Pane();
        pane.getChildren().add(VBoxAll);

        Scene scene = new Scene(pane, 500, 350);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void show(ImageView view, Image[] gifs, Duration displayDuration) {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        Duration totalDelay = Duration.ZERO;
        for (Image gif : gifs) {
            KeyFrame frame = new KeyFrame(totalDelay, e -> view.setImage(gif));
            timeline.getKeyFrames().add(frame);
            totalDelay = totalDelay.add(displayDuration);
        }
        timeline.getKeyFrames().add(new KeyFrame(totalDelay, e -> view.setImage(null)));

        timeline.play();
    }

    public static void main(String[] args) {
        launch();
    }
}