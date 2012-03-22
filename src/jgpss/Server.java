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
    private int ocupat;
    
    public Server (String nom, int ocupat) {
        this.nom = nom;
        this.ocupat = ocupat;
    }
    
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getOcupat() {
        return ocupat;
    }
    
    public void setOcupat(int ocupat) {
        this.ocupat = ocupat;
    }
}
