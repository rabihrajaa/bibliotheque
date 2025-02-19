/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class TypeMateriel {
  private int idType;	
  private  String libelleType;

    public TypeMateriel(int idType, String libelleType) {
        this.idType = idType;
        this.libelleType = libelleType;
    }

    public int getIdType() {
        return idType;
    }

    public String getLibelleType() {
        return libelleType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public void setLibelleType(String libelleType) {
        this.libelleType = libelleType;
    }


@Override
public String toString() {
    return this.getLibelleType();
}









}
