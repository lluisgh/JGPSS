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
 * A class representing the LOOP block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Loop extends Bloc{
    
    private String A;
    private String B;
    
    
    /** 
     * Creates a new instance of Loop.
     */
    public Loop() {
    }
    /**
     * Creates a new instance of Loop.
     * @param comentari the comment of the block.
     * @param label the labelof the block.
     * @param A the parameter that contains the number of itereation to be done.
     * @param B the label to go if A > 0.
     */
    public Loop(String comentari, String label, String A, String B){
       this.setId(Constants.idLoop);
       this.setLabel(label);
       this.setComentari(comentari);
       this.A = A;
       this.B = B;
    }

     /**
      * To get the parameter that contain the number of iterations.
      * @return the parameter.
      */
     public String getA() {
        return A;
    }

     /**
      * To set the parameter that contains the number of iterations.
      * @param A the new parameter.
      */
     public void setA(String A) {
        this.A = A;
    }

     /**
      * To get the labet to jump if A>0.
      * @return the label.
      */
     public String getB() {
        return B;
    }

    /**
     * To set the label to jump if A>0.
     * @param B the new label.
     */
    public void setB(String B) {
        this.B = B;
    }
        
}
