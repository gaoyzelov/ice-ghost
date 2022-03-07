package com.gy.ice.common.utils;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.GUIState;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * @author gaoye
 * @date 2021/12/28 14:23
 * @desc JavaFX工具类
 */
public class JavaFxUtils {

    /**
     * 页面跳转
     * @param newView 新的页面
     */
    public static void showView(final Class<? extends AbstractFxmlView> newView) {
        try {
            final AbstractFxmlView view = SpringUtils.getBean(newView);
            Scene scene = new Scene(view.getView());
            scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
            Stage stage = new Stage();
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.setTitle(GUIState.getStage().getTitle());
            stage.getIcons().addAll(GUIState.getStage().getIcons());
            stage.show();
        } catch (Throwable t) {
            showErrorAlert(t);
        }
    }

    private static void showErrorAlert(Throwable throwable) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Oops! An unrecoverable error occurred.\n" +
                "Please contact your software vendor.\n\n" +
                "The application will stop now.\n\n" +
                "Error: " + throwable.getMessage());
        alert.showAndWait().ifPresent(response -> Platform.exit());
    }
}
