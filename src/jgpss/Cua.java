/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgpss;

/**
 *
 * @author dgll
 */
public class Cua {
    //nom de la cua
    private String nom;
    //nombre d'elements a la Queue
    private int nElem;
    
    public Cua (String nom, int nElem) {
        this.nom = nom;
        this.nElem = nElem;
    }
    
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getNElem() {
        return nElem;
    }
    
    public void setNElem(int nElem) {
        this.nElem = nElem;
    }
    
}
