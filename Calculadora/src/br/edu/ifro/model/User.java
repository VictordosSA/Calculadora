/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 04592828240
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_User;
    private String use_User;
    private String s_User;

    public Integer getId_User() {
        return id_User;
    }

    public void setId_User(Integer id_User) {
        this.id_User = id_User;
    }

    public String getUse_User() {
        return use_User;
    }

    public void setUse_User(String use_User) {
        this.use_User = use_User;
    }

    public String getS_User() {
        return s_User;
    }

    public void setS_User(String s_User) {
        this.s_User = s_User;
    }

}
