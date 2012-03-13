/**
 * Software end-user license agreement.
 *
 * The LICENSE.TXT containing the license is located in the JGPSS project.
 * License.txt can be downloaded here:
 * href="http://www-eio.upc.es/~Pau/index.php?q=node/28
 *
 * NOTICE TO THE USER: BY COPYING, INSTALLING OR USING THIS SOFTWARE OR PART OF
 * THIS SOFTWARE, YOU AGREE TO THE   TERMS AND CONDITIONS OF THE LICENSE AGREEMENT
 * AS IF IT WERE A WRITTEN AGREEMENT NEGOTIATED AND SIGNED BY YOU. THE LICENSE
 * AGREEMENT IS ENFORCEABLE AGAINST YOU AND ANY OTHER LEGAL PERSON ACTING ON YOUR
 * BEHALF.
 * IF, AFTER READING THE TERMS AND CONDITIONS HEREIN, YOU DO NOT AGREE TO THEM,
 * YOU MAY NOT INSTALL THIS SOFTWARE ON YOUR COMPUTER.
 * UPC IS THE OWNER OF ALL THE INTELLECTUAL PROPERTY OF THE SOFTWARE AND ONLY
 * AUTHORIZES YOU TO USE THE SOFTWARE IN ACCORDANCE WITH THE TERMS SET OUT IN
 * THE LICENSE AGREEMENT.
 */

package jgpss;
/*
 * Proces.java
 *
 * Created on 28 de diciembre de 2006, 12:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.*;
/**
 * A class representing the process to be followed by the entities.
 * @author Pau Fonseca i Casas
 * @autor  Mª Dolores
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Proces implements Serializable{
    //arraylist de blocs
    private ArrayList blocs;
    //Model al que pertany el procés
    private Model GPSSmodel;
    //Descripció del procés.
    private String descpro;
    //Variables per representació
    private int posx;
    private int posy;
    private int finposx;
    private int finposy;

    /** 
     * Creates a new instance of Proces
     * @param Descripcio description of the process.
     * @param model the model of the process.
     */
    public Proces(String Descripcio, Model model) {
        this.setDescpro(Descripcio);
        this.GPSSmodel=model;
        this.setBlocs(new ArrayList());
    }

    /**
     * To obtain the description of the process.
     * @return the description.
     */
    public String getDescpro() {
        return descpro;
    }

    /**
     * To set the description of the process.
     * @param descpro the new description of the process.
     */
    public void setDescpro(String descpro) {
        this.descpro = descpro;
    }


    /**
     * The blocks of the process.
     * @return the listof blocks that belongs to the process.
     */
    public ArrayList getBlocs() {
        return blocs;
    }

    /**
     * The X position of the proces in the layout.
     * @return the X position.
     */
    public int getPosx() {
        return posx;
    }

    /**
     * The Y position of the proces in the layout.
     * @return the Y position.
     */
    public int getPosy() {
        return posy;
    }

    /**
     * To set the array containing the blocks of the process.
     * @param blocs the new array.
     */
    public void setBlocs(ArrayList blocs) {
        for (int i=0; i<blocs.size();i++) {
            ((Bloc)blocs.get(i)).setProces(this);
            ((Bloc)blocs.get(i)).setModel(GPSSmodel);
            ((Bloc)blocs.get(i)).setPos(i);
        }
        this.blocs = blocs;
    }

    /**
     * To set the X position of the proces in the layout.
     * @param posx the new X porsition.
     */
    public void setPosx(int posx) {
        this.posx = posx;
    }

    /**
     * To set the Y position of the proces in the layout.
     * @param posy the new Y position.
     */
    public void setPosy(int posy) {
        this.posy = posy;
    }

    /**
     * To obtain the final X position of the process in the layout.
     * @return the final X position.
     */
    public int getFinposx() {
        return finposx;
    }

    /**
     * To set the final X position of the process in the layout.
     * @param finposx the new final X position.
     */
    public void setFinposx(int finposx) {
        this.finposx = finposx;
    }

    /**
     * To obtain the final Y position of the process in the layout.
     * @return the final Y position.
     */
    public int getFinposy() {
        return finposy;
    }

    /**
     * To set the final Y position of the process in the layout.
     * @param finposy the new final Y position.
     */
    public void setFinposy(int finposy) {
        this.finposy = finposy;
    }
 
}
