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
    
    /**
     * Creadora de la Cua
     * @param nom Nom de la nova cua
     * @param nElem Nombre d'elements inicials de la cua
     */
    
    public Cua (String nom, int nElem) {
        this.nom = nom;
        this.nElem = nElem;
    }
    
    /**
     * Getter del nom de la cua
     * @return El nom de la cua
     */
    
    public String getNom() {
        return nom;
    }
    
    /**
     * Setter del nom de la cua
     * @param nom El nou nom de la cua
     */
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Getter del nombre d'elements de la cua
     * @return El nombre d'elements de la cua
     */
    
    public int getNElem() {
        return nElem;
    }
    
    /**
     * Setter del nombre d'elements de la cua
     * @param nElem El nombre d'elements de la cua
     */
    
    public void setNElem(int nElem) {
        this.nElem = nElem;
    }
    
}
