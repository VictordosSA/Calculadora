/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 04592828240
 */
@Entity
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double num1;
    private double num2;
    private String op;
    private double result;

    public Integer getId_His() {
        return id;
    }

    public void setId_His(Integer id_His) {
        this.id = id_His;
    }

    public double getNum1_His() {
        return num1;
    }

    public void setNum1_His(double num1_His) {
        this.num1 = num1_His;
    }

    public double getNum2_His() {
        return num2;
    }

    public void setNum2_His(double num2_His) {
        this.num2 = num2_His;
    }

    public String getOp_His() {
        return op;
    }

    public void setOp_His(String op_His) {
        this.op = op_His;
    }

    public double getResult_His() {
        return result;
    }

    public void setResult_His(double result_His) {
        this.result = result_His;
    }

}
