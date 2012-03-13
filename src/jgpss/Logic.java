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
 * A class representing the LOGIC block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Logic extends Bloc{
    
    private String x;
    private String A;
    
    /**
     * Logic SET.
     */
    public static final String S= "S";
    /**
     * Logis RESET.
     */
    public static final String R= "R";
    /**
     * Logic INVERT.
     */
    public static final String I= "I";
    /** 
     * Creates a new instance of Logic.
     */
    public Logic() {
    }
    
    /**
     * Creates a new instance of Logic.
     * @param comentari the comment of the block.
     * @param label the labelofthe block.
     * @param x the type of logic R, S, I.
     * @param A the name of the logic.
     */
    public Logic(String comentari, String label, String x, String A){
       this.setId(Constants.idLogic);
       this.setLabel(label);
       this.setComentari(comentari);
       this.A = A;
       this.x=x;
    }

    /**
     * To obtain the type of logic.
     * @return S, R or I.
     */
    public String getX() {
        return x;
    }

    /**
     * To set the type of logic.
     * @param x the type of logic, R, S or I.
     */
    public void setX(String x) {
        this.x = x;
    }

    /**
     * To obtain the name of thelogic.
     * @return the name.
     */
    public String getA() {
        return A;
    }

    /**
     * To set the name of the logic.
     * @param A the new name.
     */
    public void setA(String A) {
        this.A = A;
    }
       
}
