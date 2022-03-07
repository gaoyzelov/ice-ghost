package com.gy.ice.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author gaoye
 * @date 2021/12/24 14:23
 * @desc
 */
@FXMLController
public class MainController implements Initializable {

    @FXML
    private WebView webView;

    private ResourceBundle resources;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        webView.getEngine().load("http://localhost:6789/index.html");
    }
}
