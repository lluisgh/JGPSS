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
 * A class representing the GENERATE block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Generate extends Bloc{
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

    private float creationLimitNumber;
    private boolean creationLimit;
    
    /**
     * Creates a new instance of Generate.
     * @param comentari the coment of te block.
     * @param label the label of the block.
     * @param A intergeneration time.
     * @param B halfrange or function modifier.
     * @param C start delay time.
     * @param D creation limit.
     * @param E priority.
     * @param F if 0 the parameter C is ignored.
     */
    public Generate(String comentari, String label, Float A, Float B, Float C, Float D, Float E, int F) {
      
        this.setId(Constants.idGenerate);
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.E = E;
        this.F = F;
        this.setLabel(label);
        this.setComentari(comentari);
        creationLimitNumber=D;
        if(D>0)creationLimit=true;
    }

    /**
     * To obtain the intergeneration time.
     * @return the intergeneration time.
     */
    public float getA() {
        return A;
    }

    /**
     * To set the intergeneration time.
     * @param A the new intergeneration time.
     */
    public void setA(float A) {
        this.A = A;
    }

    /**
     * To obtain the halfrange or function modifier.
     * @return the halfrange or function modifier.
     */
    public float getB() {
        return B;
    }

    /**
     * To set a new halfrange or function modifier.
     * @param B the new halfrange or function modifier.
     */
    public void setB(float B) {
        this.B = B;
    }

    /**
     * To get the start delay time
     * @return the start delay time
     */
    public float getC() {
        return C;
    }

    /**
     * To set a new start delay time
     * @param C the new start delay time
     */
    public void setC(float C) {
        this.C = C;
    }

    /**
     * To get the creation limit.
     * @return the creation limit.
     */
    public float getD() {
        return D;
    }

    /**
     * To set the creation limit.
     * @param D the new creation limit.
     */
    public void setD(int D) {
        this.D = D;
    }

    /**
     * To get the priority
     * @return the priority
     */
    public float getE() {
        return E;
    }

    /**
     * To set the priority
     * @param E the new priority
     */
    public void setE(float E) {
        this.E = E;
    }

    /**
     * To know if the parameter C is used in the generations.
     * @return 0 if parameter C is not used.
     */
    public int getF() {
        return F;
    }

    /**
     * To define if the parameter C is used.
     * @param F 0 if we whant to ignore the C parameter.
     */
    public void setF(int F) {
        this.F = F;
    }

    @Override
    public Bloc execute(Xact tr) {
        //Afegim la següent transacció a la FEC.
        if ((creationLimit && creationLimitNumber > 0) || !creationLimit) {
            Xact xact;
            xact = new Xact();
            xact.setBloc(this);
            xact.setProces(getProces());
            xact.setCreatTime(getModel().relativeClock);
            xact.setPriority(E);
            //We use the F parameter to determine if the C parameter
            //is valid
            if (getModel().relativeClock == 0 && F > 0) {
                xact.setMoveTime(C);
            } else {
                xact.setMoveTime(getModel().relativeClock+getModel().MyRandom.Uniform(A, B));
            }
            getModel().idxact++;
            xact.setID(getModel().idxact);
            getModel().getFEC().add(xact);
            creationLimitNumber--;
            System.out.println("Generate DONE.");
        } else {
            System.out.println("Creation limit reached.");
        }
        //La xact que ha entrat en el GENERATE continua al següent bloc.
        return nextBloc(tr);
    }
}
