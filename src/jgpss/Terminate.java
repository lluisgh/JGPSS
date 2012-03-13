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
 * A class representing the TERMINATE block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Terminate extends Bloc {
    
    private int A;
    
    /** Creates a new instance of Terminate
     * @param comentari the comment of the block.
     * @param A the number to decrement to the TC each time a XACT cross the block.
     * @param label the label of the block.
     */
    public Terminate(String comentari, String label, int A) {
       this.setId(Constants.idTerminate);
       this.setLabel(label);
       this.setComentari(comentari);
      // this.id_model= id_model;
        this.A = A;
    }

    /**
     * To obtain the number to decrement to the TC each time a XACT cross the block.
     * @return the number.
     */
    public int getA() {
        return A;
    }

    /**
     * To set the number to decrement to the TC each time a XACT cross the block.
     * @param A the new number.
     */
    public void setA(int A) {
        this.A = A;
    }
    
}
