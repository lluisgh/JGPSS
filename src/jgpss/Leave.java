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
 * A class representing the LEAVE block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Leave extends Bloc{
    private String A;
    private int B;
    
    /**
     * Creates a new instance of Leave
     * @param comentari the comment of the block.
     * @param label the label of the block.
     * @param A the name of the STORAGE.
     * @param B the number of instances of the STORAGE to free.
     */
    public Leave( String comentari, String label, String A, int B) {
        
       this.setId(Constants.idLeave);
       this.setLabel(label);
       this.setComentari(comentari);
        this.A = A;
        this.B = B;
    }
    

    /**
     * To obtain the name of the STORAGE.
     * @return the name of the STORAGE.
     */
    public String getA() {
        return A;
    }

    /**
     * To modify the name of the STORAGE.
     * @param A the new name of the STORAGE.
     */
    public void setA(String A) {
        this.A = A;
    }

    /**
     * To get the number of instances of the STORAGE to free.
     * @return the number of instances of the STORAGE to free.
     */
    public int getB() {
        return B;
    }

    /**
     * To modify the number of instances of the STORAGE to free.
     * @param B the new number of instances of the STORAGE to free.
     */
    public void setB(int B) {
        this.B = B;
    }
    
    @Override
    //TODO comentar
    public Bloc execute(Xact tr) throws Exception {
        if (getModel().getStorages().containsKey(A)) {              //Si existeix l'Storage A
            Storage s = (Storage) getModel().getStorages().get(A);  //Obtenim l'Storage A
            Map o = s.getOcupants();                                //Obtenim el map que guarda quines transaccions estan ocupant el servidor
            Integer auxID = tr.getID();                             //Obtenim l'ID de la transacció.
            if (o.containsKey(auxID)) {                             //Si la transacció està dins el map d'ocupants:
                Integer ocs = (Integer) o.get(auxID);               //Obtenim el nombre d'instàncies del servidor que té capturades la transacció (ocs).
                if (B <= ocs) {                                     //Si el nombre d'instàncies que volem alliberar és menor que ocs:
                    if (B == ocs) o.remove(tr.getID());             //Si estem alliberant totes les insàncies que ocupava tr, l'eliminem del map d'ocupants,
                    else o.put(tr.getID(), ocs - B));               //sinó restem B al nombre d'instàncies ocupades per tr al map d'ocuopants.    
                    s.setLliures(s.getLliures() + B);               //Incrementem en B el nombre d'instàncies lliures del servidor. 
                }
                //Si el nombre d'instàncies que volem alliberar és major que les que havíem ocupat, llancem una excepció.
                else throw new Exception("No hi ha " + B + "instàncies del servidor capturades per la transacció actual.");
            }
            //Si la transacció no havia capturat cap instància del servidor i, per tant, no es troba al map d'ocupants d'aquest; llancem una excpeció.
            else throw new Exception("La transacció actual no ha capturat cap instància del servidor.");
        }
        
        return nextBloc(tr); //Retornem el següent bloc.
    }
    
}
