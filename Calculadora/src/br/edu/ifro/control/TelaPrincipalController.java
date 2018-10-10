/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Historico;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField; 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 04592828240
 */
public class TelaPrincipalController implements Initializable {
    @FXML
    private TextField txtNumero1;
    @FXML
    private TextField txtNumero2;
    @FXML
    private TextField txtResultado;
    @FXML
    private TableView<?> tbHistorico;
    
    private String operação;

 
    @FXML
    private void soma(ActionEvent event) {
        Double num1 = Double.parseDouble(txtNumero1.getText());
        Double num2 = Double.parseDouble(txtNumero2.getText());       
        Double resultado = num1 + num2;
                
        txtResultado.setText(resultado.toString()) ;
        operação = "+";
        gravar();
    }
    
    @FXML
    private void subtracao(ActionEvent event) {
        Double num1 = Double.parseDouble(txtNumero1.getText());
        Double num2 = Double.parseDouble(txtNumero2.getText());       
        Double resultado = num1 - num2;
                
        txtResultado.setText(resultado.toString()) ;     
        operação = "-";
        gravar();
    }
    
    @FXML
    private void divisao(ActionEvent event) {
        Double num1 = Double.parseDouble(txtNumero1.getText());
        Double num2 = Double.parseDouble(txtNumero2.getText());       
        Double resultado = num1 / num2;
                
        txtResultado.setText(resultado.toString()) ;
        operação = "/";
        gravar();
    }
    
    @FXML
    private void multiplicacao(ActionEvent event) {
        Double num1 = Double.parseDouble(txtNumero1.getText());
        Double num2 = Double.parseDouble(txtNumero2.getText());       
        Double resultado = num1 * num2;
                
        txtResultado.setText(resultado.toString()) ;
        operação = "*";
        gravar();
    }
    
    @FXML
    public void gravar(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Calculadora");
        EntityManager em = emf.createEntityManager();
        
        Historico historico = new Historico();
        historico.setNum1(Double.parseDouble(txtNumero1.getText()));
        historico.setNum2(Double.parseDouble(txtNumero2.getText()));
        historico.setResult(Double.parseDouble(txtResultado.getText()));
        historico.setOp(operação);
        
        em.getTransaction().begin();
        em.persist(historico);
        em.getTransaction().commit();
        limpar();
        lista();
    }
    
    @FXML
    public void limpar(){
        txtNumero1.clear();
        txtNumero2.clear();
    }
    
    @FXML
    public void lista(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Calculadora");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery ("SELECT a FROM Historico as a");
        List<Historico> historico = query.getResultList();
        ObservableList obHistorico = FXCollections.observableArrayList(historico);
        tbHistorico.setItems(obHistorico);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lista();
    }    
    
}
