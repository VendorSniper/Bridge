package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.Bid;

/**
 * Created by Adam on 1/21/2016.
 */
public class ScoreStage {
    private static StackPane stackPane;
    private static Scene scene;
    private static Stage stage = new Stage ( );
    private static Image win;
    private static Image lose;

    public static int display(int score, Bid contractBid) {
        win = MenuStage.getImage ("StephCurry", "gif");
        lose = MenuStage.getImage ("Denied", "gif");
        Image image = score > 0 ? win : lose;
        Label label = new Label (contractBid.lsdirection + ": " + score + " Points");
        label.setFont (Font.font ("Verdana", 100));
        label.setTextFill (Color.WHITE);
        label.setAlignment (Pos.CENTER);
        Button exit = new Button (contractBid.lsdirection + (score > 0 ? " wins!" : " loses!"));
        exit.setOnAction (event -> stage.close ( ));
        HBox hBox = new HBox (100);
        hBox.getChildren ( ).addAll (label, exit);
        hBox.setAlignment (Pos.CENTER);
        stackPane = new StackPane (hBox);
        stackPane.setAlignment (Pos.CENTER);
        stackPane.setBackground (new Background (new BackgroundImage (image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        scene = new Scene (stackPane);
        stage.setScene (scene);
        stage.initStyle (StageStyle.TRANSPARENT);
        stage.showAndWait ( );
        return score;
    }
}
