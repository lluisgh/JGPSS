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
 * A class representing the ADVANCE GPSS block.
 * @author  Pau Fonseca i Casas
 * @author  M.Dolores
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Advance extends Bloc{
    
    private float A;
    private float B;
    /** Creates a new instance of ADVANCE.
     * @param comentari the comment of the ADVANCE block.
     * @param label the label of the block.
     * @param A the A parameter value of the block.
     * @param B the B parameter value of the block.
     */
    public Advance(String comentari, String label, Float A, Float B) {
        
       this.setId(Constants.idAdvanced);
       this.setLabel(label);
       this.setComentari(comentari);
    //   this.id_model= id_model;
        this.A = A;
        this.B = B;
    }

    /**
     * Allows to obtain the value of the A parameter.
     * @return the value of the A parameter.
     */
    public float getA() {
        return A;
    }

    /**
     * Allows to set the value of the B parameter.
     * @param A the value for the A parameter of the ADVANCE.
     */
    public void setA(float A) {
        this.A = A;
    }

    /**
     * Allows to obtain the value of the B parameter.
     * @return the value of the B parameter.
     */
    public float getB() {
        return B;
    }

    /**
     * Allows to set the value of the A parameter.
     * @param B the value for the B parameter of the ADVANCE.
     */
    public void setB(float B) {
        this.B = B;
    }

    /**
     * The method that executes the block.
     * @param tr the transaction that cross the block.
     * @return this method returns the next block of the transaction active. NULL
     * if is removed from the CEC (ADVANCE, TERMINATE, or bloqued situation).
     */
    @Override
    public Bloc execute(Xact tr) {
        //Adding a new transaction to the FEC.
        System.out.println("Bloc Advance: el model te el relativeClock = " + getModel().relativeClock); 
        tr.setMoveTime(getModel().relativeClock+getModel().MyRandom.Uniform(A, B));
        nextBloc(tr);
        getModel().getFEC().add(tr);
        System.out.println("Bloc Advance: la Xact te MoveTime = " + tr.getMoveTime()); 
        return null;
    }
}
