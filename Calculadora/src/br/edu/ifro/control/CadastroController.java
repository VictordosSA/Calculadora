/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 04592828240
 */
public class CadastroController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    private PasswordField txtPass1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cadastro(ActionEvent event) {
        if (! txtUser.getText().trim().equals("") || txtPass.getText().trim().equals("") || txtPass1.getText().trim().equals("")) {
            if (txtPass.getText().equals(txtPass1.getText())) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("Calculadora");
                EntityManager em = emf.createEntityManager();

                Usuario user = new Usuario();
                user.setUser(txtUser.getText());
                user.setSenha(txtPass.getText());

                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();

                JOptionPane.showMessageDialog(null, "Cadastro bem sucedido!");

                Stage stage2 = (Stage) txtUser.getScene().getWindow();
                stage2.close();
            } else {
                JOptionPane.showMessageDialog(null, "As senhas precisam estar iguais!");
                txtPass.clear();
                txtPass1.clear();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchidos!");
        }
    }

}
