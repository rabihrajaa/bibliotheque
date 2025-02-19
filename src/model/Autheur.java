/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Autheur extends Personne {
    private String descreption ;

    public Autheur(int idPersonne, String nomPersonne, String prenomPersonne) {
        super(idPersonne, nomPersonne, prenomPersonne);
    }

    public Autheur(String descreption, int idPersonne, String nomPersonne, String prenomPersonne, Date dateNaissance) {
        super(idPersonne, nomPersonne, prenomPersonne, dateNaissance);
        this.descreption = descreption;
    }

  

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

 


    

 
   

  


    
    
    
    
}
