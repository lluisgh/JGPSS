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
 * A class representing the ASSIGN GPSS block.
 * @author  Pau Fonseca i Casas
 * @author  M.Dolores
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Bloc{
   
    private int id;
    private String label;
    private String comentari;
   // protected String id_model;
    private int posx;
    private int posy;
    private Model model;
    private Proces proces;
    //Indica quina es la posició del bloc en el procés
    //Útil per poder trobar el següent.
    private int pos;
  //  private int idNum;
    
    /** Creates a new instance of Bloc 
    public Bloc(int id, String label, String comentari, String id_model) {
        this.id = id;
        this.label=label;
        this.comentari=comentari;
        this.id_model= id_model;
     }*/
    public Bloc(){}

    /**
     * To obtain the indentifier of the bloc.
     * An integuer defined in Constants.java
     * @see Constants.java
     * @return block identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * To set the id of the block.
     * @param id the new block id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * To obtain the label of the block.
     * @return the block label.
     */
    public String getLabel() {
        return label;
    }

    /**
     * To set the label of the block.
     * @param label the new label.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * To obtain the comment of the block.
     * @return the comment.
     */
    public String getComentari() {
        return comentari;
    }

    /**
     * To set the comment of the block.
     * @param comentari the new comment.
     */
    public void setComentari(String comentari) {
        this.comentari = comentari;
    }

/*    public String getId_model() {
        return id_model;
    }

    public void setId_model(String id_model) {
        this.id_model = id_model;
    }
  */  

    /**
     * To obtain the position X of the block. Useful to implement a graphical
     * representation movement of the XACT's.
     * @return the X position of the block.
     */
    public int getPosx() {
        return posx;
    }

    /**
     * To set the X position of the block.
     * @param posx the new X position.
     */
    public void setPosx(int posx) {
        this.posx = posx;
    }

    /**
     * To obtain the position Y of the block. Useful to implement a graphical
     * representation movement of the XACT's.
     * @return the Y position of the block.
     */
    public int getPosy() {
        return posy;
    }

    /**
     * To set the Y position of the block.
     * @param posy the new Y position.
     */
    public void setPosy(int posy) {
        this.posy = posy;
    }

   /* public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }*/

    /**
     * To execute the block. Must be implemented in each block.
     * @param tr the current XACT (that cross the block).
     * @return return NULL if no more blocs can be executed now. The next block
     * otherwise.
     */
    public Bloc execute(Xact tr) throws Exception {
        return null;
    }

    /**
     * Allows to obtanin thenext block in the current process of the XACT.
     * Modifies the current block of the XACT.
     * @param tr the XACT to update it's current block.
     * @return the next block to be executed.
     */
    public Bloc nextBloc(Xact tr){
        if(tr!=null){
            Bloc nextBloc=tr.getBloc();
            Proces pr=tr.getProces();
            ArrayList bls=pr.getBlocs();
            int mida=bls.size();
            int posicio=nextBloc.getPos()+1;
            if(posicio<mida) nextBloc=(Bloc)bls.get(posicio);
            else nextBloc=null;

            tr.setBloc(nextBloc);

            return nextBloc;
        }
        else return null;
    }
    /**
     * Allows to obtai the model of the block.
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * To modify the model.
     * @param model the model to set.
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Toobtain the process of the block.
     * @return the proces.
     */
    public Proces getProces() {
        return proces;
    }

    /**
     * To modify the process of the blok.
     * @param proces the proces to set
     */
    public void setProces(Proces proces) {
        this.proces = proces;
    }

    /**
     * To obtain the positio in the process ofthe block.
     * @return the position.
     */
    public int getPos() {
        return pos;
    }

    /**
     * To set the position of the block in the process.
     * @param pos the new position.
     */
    public void setPos(int pos) {
        this.pos = pos;
    }
}
