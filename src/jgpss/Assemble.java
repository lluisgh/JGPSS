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
 * A class representing the ASSEMBLE GPSS block.
 * @author  Pau Fonseca i Casas
 * @author  M.Dolores
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Assemble extends Bloc {
    
    private int A;
    /** Creates a new instance of Assemble */
    public Assemble() {
    }
    /**
     * Creates a new instance of an ASSEMBLE block.
     * @param comentari the comment of the ASSEMBLE block
     * @param label the label of the block.
     * @param A the A parameter value of the block.
     */
    public Assemble( String comentari, String label, int A) {
       this.setId(Constants.idAssemble);
       this.setLabel(label);
       this.setComentari(comentari);
        this.A = A;
    }
    /**
     * Allows to obtain the value of the A parameter.
     * @return the value of the A parameter.
     */
    public int getA() {
        return A;
    }

    /**
     * Allows to set the value of the B parameter.
     * @param A the value for the A parameter of the ASSEMBLE.
     */
    public void setA(int A) {
        this.A = A;
    }
}
