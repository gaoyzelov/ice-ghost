package com.gy.ice.controller;

import com.gy.ice.common.dto.R;
import com.gy.ice.service.SysUserService;
import com.gy.ice.common.utils.JavaFxUtils;
import com.gy.ice.common.views.MainView;
import de.felixroske.jfxsupport.FXMLController;
import de.felixroske.jfxsupport.GUIState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * @author gaoye
 * @date 2021/12/27 10:17
 * @desc
 */
@FXMLController
public class LoginController implements Initializable {

    @Resource
    private SysUserService sysUserService;

    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private Text tips;

    private ResourceBundle resources;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        tfUsername.setText("root");
        pfPassword.setText("admin");
        GUIState.getStage().centerOnScreen();
    }

    @FXML
    public void login(ActionEvent event){
        String username = tfUsername.getText();
        String password = pfPassword.getText();
        if (StringUtils.isBlank(username)){
            showTips("请输入用户名！");
            return;
        }
        if (StringUtils.isBlank(password)){
            showTips("请输入密码！");
            return;
        }
        R<?> res = sysUserService.doLogin(username,password);
        if (res.getState()){
            JavaFxUtils.showView(MainView.class);
            GUIState.getStage().close();
        }else{
            showTips(res.getMsg());
        }
    }

    @FXML
    public void reset(ActionEvent event){
        tfUsername.setText(StringUtils.EMPTY);
        pfPassword.setText(StringUtils.EMPTY);
    }

    private void showTips(String msg){
        tips.setText(msg);
    }
}
