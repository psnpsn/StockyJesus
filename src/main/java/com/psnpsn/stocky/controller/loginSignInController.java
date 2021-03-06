/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.psnpsn.stocky.MainApp;
import com.psnpsn.stocky.model.User;
import com.psnpsn.stocky.service.UserService;
import com.psnpsn.stocky.utils.StageManager;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author psnpsn
 */
public class loginSignInController {

    @FXML
    private JFXTextField usrTxt;
    @FXML
    private JFXPasswordField pwTxt;
    @FXML
    private JFXButton loginBtn;
    @FXML
    private Label errorMsg;
    
    @FXML
    private AnchorPane anchor;
    
    UserService usrService = MainApp.context.getBean(UserService.class);
    

    @FXML
    void seConnecter(ActionEvent event) {
        String login = usrTxt.getText();
        char[] password = pwTxt.getText().toCharArray();
        User user=usrService.checkLogin(login, password);
        if(user!=null){
            errorMsg.setVisible(false);
            StageManager stager = StageManager.getStageManager();
            stager.setUser(user);
            System.out.println("User: "+stager.getUsername());
            System.out.println("Role: "+stager.getRole());
            stager.Dashboard();
        }
        else{
            errorMsg.setVisible(true);
            errorMsg.setText("Login ou mot de passe incorrecte!");
            System.out.println("USER DOESNT EXIST");
        }
        
    }

    @FXML
    private void signUp(ActionEvent event) {
        try {
            URL signIn = getClass().getResource("/fxml/loginSignUp.fxml");
            AnchorPane anchorpane = FXMLLoader.load(signIn);
            
            anchor.getChildren().clear();
            anchor.getChildren().add(anchorpane);
        } catch (IOException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
