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
 * A class representing the GATE block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Gate  extends Bloc {
       
    private String x;
    private String A;
    private String B;

    /**
     * GATE U
     */
    public static final String U = "U";
    /**
     * GATE NU
     */
    public static final String NU = "NU";
    /**
     * GATE SF
     */
    public static final String SF = "SF";
    /**
     * GATE SNF
     */
    public static final String SNF = "SNF";
     /**
     * GATE SE
     */
    public static final String SE = "SE";
    /**
     * GATE SNE
     */
    public static final String SNE = "SNE";
    /**
     * GATE LR
     */
    public static final String LR = "LR";
    /**
     * GATE LS
     */
    public static final String LS = "LS";

    /** 
     * Creates a new instance of Gate
     */
    public Gate() {
    }
    /**
     *
     * @param comentari
     * @param label
     * @param x Type of GATE.
     * @param A Instalation analized.
     * @param B label to send the XACT if the GATE is closed.
     */
    public Gate(String comentari, String label, String x, String A, String B) {
        this.setId(Constants.idGate);
       this.setLabel(label);
       this.setComentari(comentari);
        this.A = A;
        this.B = B;
        this.x=x;
    }

    /**
     * To obtain the type of GATE.
     * @return the type.
     */
    public String getX() {
        return x;
    }

    /**
     * To set the type of the GATE.
     * @param x the new type.
     */
    public void setX(String x) {
        this.x = x;
    }

    /**
     * To get the instalation analized.
     * @return the name.
     */
    public String getA() {
        return A;
    }

    /**
     * To set the instalation analized.
     * @param A the new name.
     */
    public void setA(String A) {
        this.A = A;
    }

    /**
     * To obtain the label of the alternative (if the gate is closed).
     * @return the label.
     */
    public String getB() {
        return B;
    }

    /**
     * To set the label of the alternative (if the gate is closed).
     * @param B the new label.
     */
    public void setB(String B) {
        this.B = B;
    }
    
}
