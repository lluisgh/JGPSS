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

/**
 * A class representing the STORAGES definitions.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Storage {
    
    private String nom;
    private int valor;
    /** Creates a new instance of Storage */
    public Storage() {
    }
    /**
     * Creates a new instance of Storage
     * @param nom the name of the STORAGE.
     * @param valor the number of instances.
     */
    public Storage(String nom, int valor){
        this.nom=nom;
        this.valor=valor;
    }

    /**
     * To obtain the name of the STORAGE.
     * @return the name.
     */
    public String getNom() {
        return nom;
    }

    /**
     * To set the name of the STORAGE.
     * @param nom the new name.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * To get the number of instances.
     * @return the number,
     */
    public int getValor() {
        return valor;
    }

    /**
     * To set the number of instances.
     * @param valor the new number.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
