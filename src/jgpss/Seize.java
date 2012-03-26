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
 * A class representing the SEIZE block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Seize extends Bloc {
    private String A;
    
    /** Creates a new instance of Seize
     * @param comentari the comment of the block.
     * @param label the label of the block.
     * @param A the name of the SEIZE.
     */
     public Seize(String comentari, String label, String A) {
        
       this.setId(Constants.idSeize);
       this.setLabel(label);
       this.setComentari(comentari);
    //   this.id_model= id_model;
        this.A = A;
    }

     /**
      * To obtain the name of the SEIZE.
      * @return the name.
      */
     public String getA() {
        return A;
    }

     /**
      * To modify the name of the SEIZE.
      * @param A the nanme.
      */
     public void setA(String A) {
        this.A = A;
    }
    
     
     @Override
     public Bloc execute(Xact tr) {
         Boolean trobat = false;
         int i;
         int pos = 0;
         for (i = 0; (i < getModel().getServers().size()) && !trobat; ++i) {
             Server ser = (Server) getModel().getServers().get(i);
             if (ser.getNom().equals(A)){
                 trobat = true;
                 pos = i;
             }
         }
         if (!trobat) { //El servidor Žs nou, per tant, el creo i l'afegeixo a l'Arraylist
             Server ser = new Server(A, 1);
             getModel().getServers().add(ser);
             //la Xact que ha entrat al Seize continua al segŸent bloc
             return nextBloc(tr);
         }
         else { //El servidor existeix
             Server ser = (Server) getModel().getServers().get(pos);
             if (ser.getOcupat() == 0) { //Si esta desocupat, l'ocupem i anem al seguent bloc
                 ser.setOcupat(1);
                 getModel().getServers().set(pos, ser);
                 return nextBloc(tr);
             }
             else { //Falta fer quan el servidor esta ocupat... Ni idea
                 tr.setBlocked(1);
             }
         }
         return null;
     }
}
