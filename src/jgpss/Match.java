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
 * A class representing the MATCH block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Match extends Bloc {
    
    private String A;
    /**
     * Creates a new instance of Match.
     */
    public Match() {
    }
    /**
     * Creates a new instance of Match.
     * @param comentari the comment of the block.
     * @param label the label of the block.
     * @param A the number of transactions to be "matched".
     */
    public Match(String comentari, String label, String A) {
       this.setId(Constants.idMatch);
       this.setLabel(label);
       this.setComentari(comentari);
        this.A = A;
    }
   /**
    * To obtain the number of transaction to be "matched".
    * @return number of XACT's.
    */
   public String getA() {
        return A;
    }

    /**
     * To set the number of transactions to be "matched".
     * @param A the new number.
     */
    public void setA(String A) {
        this.A = A;
    } 
}
