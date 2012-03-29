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

import java.util.ArrayList;


/**
 * A class representing the TEST block.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Test extends Bloc{
    
    //Relation operator
    private String x;
    //Parameters.
    private String A;
    private String B;
    private String C;
    /**
     * String to identify the E test.
     */
    public static final String E = "E";
    /**
     * String to identify the G test.
     */
    public static final String G = "G";
    /**
     * String to identify the GE test.
     */
    public static final String GE = "GE";
    /**
     * String to identify the L test.
     */
    public static final String L = "L";
    /**
     * String to identify the LE test.
     */
    public static final String LE = "LE";
    /**
     * String to identify the NE test.
     */
    public static final String NE = "NE";
    
    /** 
     * Creates a new instance of Test
     */
    public Test() {
    }
    
    /**
     * Creates a new instance of Test.
     * @param comentari the comment of the block.
     * @param label the label of the block.
     * @param x the type of TEST.
     * @param A the value to compare.
     * @param B the reference.
     * @param C te label to jump if false.
     */
    public Test(String comentari, String label, String x, String A, String B, String C) {

       this.setId(Constants.idTest);
       this.setLabel(label);
       this.setComentari(comentari);
    //   this.id_model= id_model;
        this.A = A;
        this.B = B;
        this.C = C;
        this.x=x;
    }

    /**
     * To obtain the type of test.
     * @return the type of test (G, NE, LE,...)
     */
    public String getX() {
        return x;
    }

    /**
     * To set the type of thest.
     * @param x the new type of test.
     */
    public void setX(String x) {
        this.x = x;
    }

    /**
     * To obtain first parameter.
     * @return
     */
    public String getA() {
        return A;
    }

    /**
     * To set the first parameter.
     * @param A the new parameter.
     */
    public void setA(String A) {
        this.A = A;
    }

    /**
     * To obtain second parameter.
     * @return the second parameter.
     */
    public String getB() {
        return B;
    }

    /**
     * To set the second parameter.
     * @param B the new parameter.
     */
    public void setB(String B) {
        this.B = B;
    }

    /**
     * To obtain the label
     * @return the label.
     */
    public String getC() {
        return C;
    }

    /**
     * To set the label.
     * @param C the new label.
     */
    public void setC(String C) {
        this.C = C;
    }
    
    @Override
    public Bloc execute(Xact tr) throws Exception {
        Boolean condicio = false;
        
        //TODO això sobra, SNAs
        Float value = Float.parseFloat(A);
        Float reference = Float.parseFloat(B);
        
        /**
         * En cada tipus de condició, s'avalua aquesta i es guarda al booleà condició
         */
        if (x.equals(E)) condicio = value == reference;         
        else if (x.equals(NE)) condicio = value != reference;
        else if (x.equals(LE)) condicio = value <= reference;
        else if (x.equals(GE)) condicio = value >= reference;
        else if (x.equals(L)) condicio = value < reference;
        else if (x.equals(G)) condicio = value > reference;
        
        
        if (C.equals("")) {                     //Com no s'ha especficat l'operand C, el mode de treball és el condicional.
            if (condicio) return nextBloc(tr);  //Si és compleix la condició, avança al següent bloc,
            else {                              //sinó:
                tr.setBlocked(true);            //indiquem que la transacció està bloquejada
                return null;                    //retornem null
            }
        }
        else {                                  // Sí s'ha especificat C.
            if (condicio) return nextBloc(tr);  //Si és compleix la condició, avança al següent bloc,
            else {                              //sinó:
                ArrayList<Bloc> blocs = getProces().getBlocs(); //obtenim tots els blocs
                for (Bloc b : blocs) {          //iterem sobre els blocs
                    if (b.getLabel().equals(C)) {   //si és el bloc que busquem:
                        tr.setBloc(b);          //el posem com a bloc actual de tr
                        return b;               //i el retornem.
                    }
                }
            }
        }
        //Si s'ha arribat a aquesta línia vol dir que no hi ha cap bloc amb l'etiqueta C i llencem l'excepció.
        throw new Exception("No hi ha cap bloc amb label" + C + ".");
    }
}

