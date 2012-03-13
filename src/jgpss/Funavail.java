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
 * A class representing the FUNAVAIL block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Funavail extends Bloc{
    //Intergeneration time.
    private float A;
    //Halfrange or Function Modifier.
    private float B;
    //Start delay time.
    private float C;
    //Creation limit.
    private float D;
    //Priority.
    private float E;
    //Not yet used.
    private int F;

    /**
     * Creates a new instance of Funavail
     * @param comentari the comment of the block.
     * @param label the label of the block.
     * @param A the instalation that become unavailable (SEIZE).
     * @param B modality (RE) remover or (CO) continue.
     * @param C label of the block to send the XACT that are in the instalation.
     * @param D parameter that receives the residual time of the XACT.
     * @param E modality (RE) remover of (CO) continue for the PREEMPT XACT's.
     * @param F label to send the PREEMP XACT's.
     */
    public Funavail(String comentari, String label, Float A, Float B, Float C, Float D, Float E, int F) {

        this.setId(Constants.idFunavail);
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.E = E;
        this.F = F;
        this.setLabel(label);
        this.setComentari(comentari);
    }

    /**
     * To obtain the name of the instalation.
     * @return the name of the instaltion.
     */
    public float getA() {
        return A;
    }

    /**
     * To modify the instalation.
     * @param A the new instalation.
     */
    public void setA(float A) {
        this.A = A;
    }

    /**
     * To obtain the modality (RE) remover or (CO) continue.
     * @return modality (RE) remover or (CO) continue..
     */
    public float getB() {
        return B;
    }

    /**
     * To modify the modality (RE) remover or (CO) continue.
     * @param B modality (RE) remover or (CO) continue.
     */
    public void setB(float B) {
        this.B = B;
    }

    /**
     * To obtain label of the block to send the XACT that own the instalation.
     * @return label of the block to send the XACT that are in the instalation
     */
    public float getC() {
        return C;
    }

    /**
     * To change the label of the block to send the XACT that own instalation.
     * @param C the new label.
     */
    public void setC(float C) {
        this.C = C;
    }

    /**
     * The parameter that receives the residual time of the XACT.
     * @return parameter that receives the residual time of the XACT.
     */
    public float getD() {
        return D;
    }

    /**
     * To modify the parameter that receives the residual time of the XACT.
     * @param D the new parameter.
     */
    public void setD(int D) {
        this.D = D;
    }

    /**
     * Modality (RE) remover or (CO) continue for the PREEMPT XACT's
     * @return modality RE or CO for the PREEMPT XACT's.
     */
    public float getE() {
        return E;
    }

    /**
     * To modify the modality RE or CO for the PREEMPT XACT's.
     * @param E the new modality RE or CO.
     */
    public void setE(float E) {
        this.E = E;
    }

    /**
     * The label to send the PREEMP XACT's.
     * @return the label.
     */
    public int getF() {
        return F;
    }

    /**
     * To modify the label to send the PREEMP XACT's.
     * @param F new label to send the PREEMP XACT's.
     */
    public void setF(int F) {
        this.F = F;
    }

    @Override
    public Bloc execute(Xact tr) {
        //TODO
        return nextBloc(tr);
    }
}
