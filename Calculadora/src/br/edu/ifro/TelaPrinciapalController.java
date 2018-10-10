/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField; 

/**
 *
 * @author 04592828240
 */
public class TelaPrinciapalController implements Initializable {
    
    @FXML
    private JFXTextField txtNumero1;
    
    @FXML
    private TextField txtNumero2;
        
    @FXML
    private TextField txtResultado;
   
    

    
    @FXML
    private void soma(ActionEvent event) {
        
        Double num1 = Double.parseDouble(txtNumero1.getText());
                Double num2 = Double.parseDouble(txtNumero2.getText());       
                Double resultado = num1+ num2;
                
                txtResultado.setText(resultado.toString()) ;       
     
        
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
