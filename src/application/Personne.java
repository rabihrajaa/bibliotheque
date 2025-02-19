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
public class Personne {
   
    String nomPersonne;
    String prenomPersonne;
    Date dateNaissance;

    public Personne( String nomPersonne, String prenomPersonne, Date dateNaissance) {
        
        this.nomPersonne = nomPersonne;
        this.prenomPersonne = prenomPersonne;
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return "Personne{" + ", nomPersonne=" + nomPersonne + ", prenomPersonne=" + prenomPersonne + ", dateNaissance=" + dateNaissance + '}';
    }
    
    
    
    
    
    
    
    
}
