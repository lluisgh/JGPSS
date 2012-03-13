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
 * A class representing the TRANSFER block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Transfer extends Bloc{

    private String A;
    private String B;
    private String C;
    private String D;
    /**
     * String identifying Both TRANSFERs.
     */
    public static final String Both = "Both";
    /**
     * String identifying All TRANSFERs.
     */
    public static final String All = "All";
    /**
     * String identifying Pick TRANSFERs.
     */
    public static final String Pick = "Pick";
    /**
     * String identifying FN TRANSFERs.
     */
    public static final String FN = "FN";
    /**
     * String identifying P TRANSFERs.
     */
    public static final String P = "P";
    /**
     * String identifying SBR TRANSFERs.
     */
    public static final String SBR = "SBR";
    /**
     * String identifying Fraction TRANSFERs.
     */
    public static final String Fraccio = "Fraction";
    /**
     * String identifying Number TRANSFERs.
     */
    public static final String Nombre = "Number";
    /**
     * String identifying Nul TRANSFERs.
     */
    public static final String SNA = "Nul";
    
    /** 
     * Creates a new instance of Transfer.
     */
    public Transfer() {
    }
    
    /**
     * Creates a new instance of Transfer.
     * @param comentari the comment of the block.
     * @param label the label of the block.
     * @param A The type of the transfer (zero parameter).
     * @param B the first parameter (depends on the type of transfer).
     * @param C the second parameter (depends on the type of transfer).
     * @param D the third parameter (depends on the type of transfer).
     */
    public Transfer(String comentari, String label, String A, String B, String C, String D){
        this.setId(Constants.idTransfer);
       this.setLabel(label);
       this.setComentari(comentari);
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        
    }

    /**
     * To get the zero parameter (type of the transfer).
     * @return the parameter.
     */
    public String getA() {
        return A;
    }

    /**
     * To set the zero parameter (type of the transfer).
     * @param A the new parameter.
     */
    public void setA(String A) {
        this.A = A;
    }

    /**
     * To get the first parameter.
     * @return the parameter.
     */
    public String getB() {
        return B;
    }

    /**
     * To set the first parameter.
     * @param B the new parameter.
     */
    public void setB(String B) {
        this.B = B;
    }

    /**
     * To get the second parameter.
     * @return the parameter.
     */
    public String getC() {
        return C;
    }

    /**
     * To set the second parameter.
     * @param C the new parameter.
     */
    public void setC(String C) {
        this.C = C;
    }

    /**
     * To get the third parameter.
     * @return the parameter.
     */
    public String getD() {
        return D;
    }

    /**
     * To set the third parameter.
     * @param D the new parameter.
     */
    public void setD(String D) {
        this.D = D;
    }
    
}
