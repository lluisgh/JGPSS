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
 * A class representing the PRIORITY block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Priority extends Bloc{
    
    private int A;
    
    /**
     * Creates a new instance of Priority.
     */
    public Priority() {
    }
    /**
     * Creates a new instance of Priority.
     * @param comentari the comment of the block.
     * @param label the label of the block.
     * @param A the priority bigger implies more priority.
     */
    public Priority(String comentari, String label, int A) {
       this.setId(Constants.idPriority);
       this.setLabel(label);
       this.setComentari(comentari);
        this.A = A;
    }
    /**
     * To obtain the priority to be assigned to the XACT that cross the block.
     * @return the priority.
     */
    public int getA() {
        return A;
    }

    /**
     * To set the priority to be assigned to the XACT that cross the block.
     * @param A the new priority.
     */
    public void setA(int A) {
        this.A = A;
    }
    
    @Override
    public Bloc execute(Xact tr) {
        tr.setPriority(A);      //Se li assigna la nova prioritat al bloc.
        return nextBloc(tr);    //Es retorna el següent bloc.
    }
}
