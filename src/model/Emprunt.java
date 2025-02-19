/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Emprunt {
   private int  idPersonne  ;       
   private int  idUser ;          
   private int idCat  ;         
   private int idMat  ;         
   private int idEmprunt  ;
   private Date dureeEmprunt ;     
  private Date dateRetour    ;      

    public Emprunt() {
    }

    public Emprunt(int idPersonne, int idUser, int idCat, int idMat, int idEmprunt, Date dureeEmprunt, Date dateRetour) {
        this.idPersonne = idPersonne;
        this.idUser = idUser;
        this.idCat = idCat;
        this.idMat = idMat;
        this.idEmprunt = idEmprunt;
        this.dureeEmprunt = dureeEmprunt;
        this.dateRetour = dateRetour;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }

    public void setIdEmprunt(int idEmprunt) {
        this.idEmprunt = idEmprunt;
    }

    public void setDureeEmprunt(Date dureeEmprunt) {
        this.dureeEmprunt = dureeEmprunt;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdCat() {
        return idCat;
    }

    public int getIdMat() {
        return idMat;
    }

    public int getIdEmprunt() {
        return idEmprunt;
    }

    public Date getDureeEmprunt() {
        return dureeEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }
    
  
}
