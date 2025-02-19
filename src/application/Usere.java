/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.Date;
import model.Personne;

/**
 *
 * @author DELL
 */
public class Usere extends Personne  {

   private String login   ;         
    private String password ;        
    private String email ;              
    private String cin  ;            

    public Usere(String login, String password, String email, String cin, String nomPersonne, String prenomPersonne, Date dateNaissance) {
        super(nomPersonne, prenomPersonne, dateNaissance);
        this.login = login;
        this.password = password;
        this.email = email;
        this.cin = cin;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Override
    public String toString() {
        return "Usere{" + "login=" + login + ", password=" + password + ", email=" + email + ", cin=" + cin + '}';
    }
  
}
