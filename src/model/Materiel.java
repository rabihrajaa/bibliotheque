package model;

import java.util.logging.Logger;

public class Materiel {
private int idCat;
private int idMat;
private int idType;
private int idPersonne;
private String nomMat;
private String photoMat;
private String descriptionMat;
public int Emprunt;


    public Materiel(int idCat, int idMat, int idType, int idPersonne, String nomMat, String photoMat, String descriptionMat) {
        this.idCat = idCat;
        this.idMat = idMat;
        this.idType = idType;
        this.idPersonne = idPersonne;
        this.nomMat = nomMat;
        this.photoMat = photoMat;
        this.descriptionMat = descriptionMat;
    }

    public Materiel() {
    }


    public int getIdCat() {
        return idCat;
    }

    public int getIdMat() {
        return idMat;
    }

    public int getIdType() {
        return idType;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public String getNomMat() {
        return nomMat;
    }

    public String getPhotoMat() {
        return photoMat;
    }

    public String getDescriptionMat() {
        return descriptionMat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public void setNomMat(String nomMat) {
        this.nomMat = nomMat;
    }

    public void setPhotoMat(String photoMat) {
        this.photoMat = photoMat;
    }

    public void setDescriptionMat(String descriptionMat) {
        this.descriptionMat = descriptionMat;
    }





}
