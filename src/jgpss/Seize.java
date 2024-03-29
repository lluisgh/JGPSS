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
         Server ser;
         if (getModel().getServers().containsKey(A)) { //El server existeix
             ser = (Server) getModel().getServers().get(A);
             if (!ser.getOcupat()) { //Si esta desocupat, l'ocupem
                 ser.setOcupat(true);
                 System.out.println("Bloc Release: El servidor " + ser.getNom() + " passa a estar ocupat."); 
                 tr.setBlocked(false); // Ens assegurem que la transacci� est� marcada com a no bloquejada
                 return nextBloc(tr); // Retornem el seg�ent bloc de la transacci�
             }
             else { //El server est� ocupat, aix� que bloquegem la transacci�
                 tr.setBlocked(true);
                 System.out.println("Bloc Release: La Xact passa a estar bloquejada.");
             }
         }
         else { //El server no existeix, per tant, el creem i l'afegim al map de Servers
             ser = new Server(A, true);
             getModel().getServers().put(A, ser);
             tr.setBlocked(false);// Ens assegurem que la transacci� est� marcada com a no bloquejada
             System.out.println("Bloc Release: El servidor " + ser.getNom() + " es crea i passa a estar ocupat.");
             return nextBloc(tr);
         }
         return null; //Retornem null perqu� la transacci� si arriba aqu� �s que est� bloquejada i, per tant, no ha d'avan�ar m�s
     }
}
