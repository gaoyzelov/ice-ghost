package com.gy.ice.common.views;

import de.felixroske.jfxsupport.SplashScreen;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

/**
 * @author gaoye
 * @date 2021/12/24 14:42
 * @desc 加载页面
 */
@Component
public class LoadingScreen extends SplashScreen {

    private static final String DEFAULT_IMAGE = "/javafx/image/welcome.png";

    public Parent getParent() {
        final ImageView imageView = new ImageView(getClass().getResource(getImagePath()).toExternalForm());
        final ProgressBar splashProgressBar = new ProgressBar();
        splashProgressBar.setPrefWidth(imageView.getImage().getWidth());
        splashProgressBar.getStyleClass().add("progress-bar-primary");
        final VBox vbox = new VBox();
        vbox.getChildren().addAll(imageView, splashProgressBar);
        return vbox;
    }

    @Override
    public String getImagePath() {
        return DEFAULT_IMAGE;
    }
}
