/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 04592828240
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void logar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Calculadora");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("select senha from Usuario where user = :user");
        query.setParameter("user", txtUser.getText());

        try {
            if (query.getSingleResult().equals(txtPass.getText())) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/TelaPrincipal.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 306, 349);
                    Stage stage = new Stage();
                    stage.setTitle("Calculadora");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {

                }
                Stage stage2 = (Stage) txtUser.getScene().getWindow();
                stage2.close();
            } else {
                JOptionPane.showMessageDialog(null, "Autenticação de usuário malsucedida!");
            }
        } catch (NoResultException nre) {
            JOptionPane.showMessageDialog(null, "Autenticação de usuário malsucedida!");
        }
    }
    
    @FXML
    public void cadastro() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/Cadastro.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 330, 263);
            Stage stage = new Stage();
            stage.setTitle("Cadastro");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
