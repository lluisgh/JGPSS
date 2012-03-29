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

import java.util.Map;

/**
 * A class representing the ENTER block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Enter extends Bloc {
    private String A;
    private int B;
    
    /** Creates a new instance of Enter
     * @param comentari the comment of the block.
     * @param label the block label.
     * @param A the name of the storage.
     * @param B the number of instances needed.
     */
     public Enter(String comentari, String label, String A, int B) {
        
       this.setId(Constants.idEnter);
       this.setLabel(label);
       this.setComentari(comentari);
        this.A = A;
        this.B = B;
    }

     /**
      * To obtain the name of the storage
      * @return the name of the storage.
      */
     public String getA() {
        return A;
    }

    /**
     * To set the name of the storage.
     * @param A the new name of the storage to catch.
     */
    public void setA(String A) {
        this.A = A;
    }

    /**
     * To obtain the number of instances needed.
     * @return the number of instance needed.
     */
    public int getB() {
        return B;
    }

    /**
     * Set method for the number of instances.
     * @param B the number of instances needed.
     */
    public void setB(int B) {
        this.B = B;
    }
    
    @Override
    public Bloc execute(Xact tr) throws Exception {
        if (getModel().getStorages().containsKey(A)) {              //Si existeix l'Storage A
            Storage s = (Storage) getModel().getStorages().get(A);  //Obtenim l'Storage A
            if (s.getLliures() >= B) {                              //Si hi ha prou inst�ncies del servidor A disponibles
                s.setLliures(s.getLliures() - B);                   //El nombre d'inst�ncies lliures es redueix en B.
                Map o = s.getOcupants();                            //Obtenim el map que guarda quines transaccions estan ocupant el servidor
                if (o.containsKey(tr.getID())) o.put(tr.getID(), o.get(tr.getID() + B)); //Si la transacci� actual es troba al map, incrementem en B
                                                                                         //el nombre d'inst�ncies del servidor ocupades per aquesta
                else s.getOcupants().put(tr.getID(), B);            //Sin�, afegim la transacci� al map d'ocupant amb B inst�ncies ocupadem
            }
            else {                                                  //Si no hi ha prou inst�ncies lliures del servidor A
                tr.setBlocked(true);                                //Posem la transacci� a blocked.
                return null;                                        //Retornem null
            }
        }
        throw new Exception("No existeix cap Storage de nom " + A + "."); //Si no existeix l'Storage A, es llen�a la corresponent excepci�
    }
    
}
