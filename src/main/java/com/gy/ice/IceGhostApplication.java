package com.gy.ice;

import com.gy.ice.common.views.LoadingScreen;
import com.gy.ice.common.views.LoginView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Collections;

@Slf4j
@SpringBootApplication
@MapperScan("com.gy.ice.dao")
public class IceGhostApplication extends AbstractJavaFxApplicationSupport{

    public static void main(String[] args) {
        launch(IceGhostApplication.class, LoginView.class, new LoadingScreen(),args);
    }

    @Override
    public void beforeShowingSplash(Stage splashStage) {
        super.beforeShowingSplash(splashStage);
        splashStage.getScene().getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
    }



    @Override
    @SuppressWarnings("all")
    public Collection<Image> loadDefaultIcons() {
        //设置图标
        return Collections.singletonList(new Image(getClass().getResource("/javafx/image/icon.png").toExternalForm()));
    }
}
