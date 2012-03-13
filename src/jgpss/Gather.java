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
 * A class representing the GATHER block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Gather extends Bloc{
    
    private int A;
    /** 
     * Creates a new instance of Gather
     */
    public Gather() {
    }
    /**
     * Creates a new instance of Gather
     * @param comentari the coment of the block.
     * @param label the label.
     * @param A the number of XACT to be grouped.
     */
    public Gather(String comentari, String label, int A) {
       this.setId(Constants.idGather);
       this.setLabel(label);
       this.setComentari(comentari);
        this.A = A;
    }
    /**
     * Returns the number of transaction to be syncronized in the Gather.
     * @return the number of XACT's.
     */
    public int getA() {
        return A;
    }

    /**
     * To set the number of transaction to be syncronized in the Gather.
     * @param A the new number.
     */
    public void setA(int A) {
        this.A = A;
    }
    
}
