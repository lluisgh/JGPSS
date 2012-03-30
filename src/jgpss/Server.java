/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgpss;

/**
 *
 * @author dgll
 */
public class Server {
    //nom del servidor
    private String nom;
    //si esta ocupat val 1, si no, 0
    private Boolean ocupat;
    
    /**
     * Creadora de la classe
     * @param nom Nom del nou servidor
     * @param ocupat Estat del nou servidor (1: ocupat; 0: desocupat)
     */
    
    public Server (String nom, Boolean ocupat) {
        this.nom = nom;
        this.ocupat = ocupat;
    }
    
    /**
     * Getter del nom del servidor
     * @return El nom del servidor
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Setter del nom del servidor
     * @param nom El nou nom del servidor
     */
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Getter de l'estat actual del servidor
     * @return L'estat actual del servidor
     */
    
    public Boolean getOcupat() {
        return ocupat;
    }
    
     /**
     * Setter de l'estat del servidor
     * @param ocupat El nou estat del servidor
     */
    
    public void setOcupat(Boolean ocupat) {
        this.ocupat = ocupat;
    }
}
