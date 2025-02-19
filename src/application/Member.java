/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class Member extends Personne{
   
    int idUser;
    String login;
    String email;
    String cin;

    public Member(int idUser, String login, String email, String cin, String nomPersonne, String prenomPersonne, Date dateNaissance) {
        super( nomPersonne, prenomPersonne, dateNaissance);
        this.idUser = idUser;
        this.login = login;
        this.email = email;
        this.cin = cin;
    }  

    @Override
    public String toString() {
        return super.toString()+ "Member{" + "idUser=" + idUser + ", login=" + login + ",email=" + email + ", cin=" + cin + '}';
    }

   
    
}
