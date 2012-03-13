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
 * A class representing the SPLIT block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Split extends Bloc{
    
    private int A;
    private String B;
    private String C;
    
    /** 
     * Creates a new instance of Split
     */
    public Split() {
    }
    /**
     * Creates a new instance of Split.
     * @param comentari the comment of the block.
     * @param label the label of the block.
     * @param A the number of new XACT's to be created.
     * @param B the label for the new XATC's.
     * @param C the serial parameter.
     */
    public Split(String comentari, String label, int A, String B, String C){
       this.setId(Constants.idSplit);
       this.setLabel(label);
       this.setComentari(comentari);
       this.A = A;
       this.B = B;
       this.C=C;
    }

    /**
     * To obtain the number of XACT's to be created.
     * @return the number.
     */
    public int getA() {
        return A;
    }

    /**
     * To set the number of XACT's to be created.
     * @param A the new number.
     */
    public void setA(int A) {
        this.A = A;
    }

    /**
     * To obtain the label for the XACT's to be created.
     * @return the label.
     */
    public String getB() {
        return B;
    }

    /**
     * To set the label for the XACT's to be created.
     * @param B te new label.
     */
    public void setB(String B) {
        this.B = B;
    }

    /**
     * To obtain the serial parameter for the XACT's to be created.
     * @return the serial parameter.
     */
    public String getC() {
        return C;
    }

    /**
     * To set the serial parameter for the XACT's to be created.
     * @param C the new serial parameter.
     */
    public void setC(String C) {
        this.C = C;
    }
    
}
