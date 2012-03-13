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

import java.io.Serializable;
/**
 * A class representing the XACT's.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Xact implements Serializable{

    //Procés al que pertany la XACT.
    private Proces proces;
    //Bloc en el que es troba la XACT.
    private Bloc bloc;
    //Identificador de la XACT.
    private int ID;
    //Temps en el que s'ha creat
    private float creatTime;
    //Temps en el que es pot moure
    private float moveTime;
    //Prioritat
    private float priority;

    /**
     * To obtain the indentifier of the XACT.
     * @return the identifier of the XACT.
     */
    public int getID() {
        return ID;
    }

    /**
     * To set the indentifier of the XACT.
     * @param id the enw identifier.
     */
    public void setID(int id) {
        ID=id;
    }

    /**
     * To set the block that contains the XACT.
     * @param b the new block.
     */
    void setBloc(Bloc b) {
        bloc=b;
    }

    /**
     * To set the process that contains the XACT.
     * @param p the new process.
     */
    void setProces(Proces p) {
        proces=p;
    }

    /**
     * To obtain the move time of the XACT.
     * @return the moveTime.
     */
    public float getMoveTime() {
        return moveTime;
    }

    /**
     * To set the move time of the XACT.
     * @param moveTime the moveTime to set
     */
    public void setMoveTime(float moveTime) {
        this.moveTime = moveTime;
    }

    /**
     * To obtain the creation time of the XACT.
     * @return the creatTime
     */
    public float getCreatTime() {
        return creatTime;
    }

    /**
     * To modify the creation time of the XACT.
     * @param creatTime the creatTime to set
     */
    public void setCreatTime(float creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * To get the process that contains the XACT.
     * @return the proces
     */
    public Proces getProces() {
        return proces;
    }

    /**
     * To get the block that contains the XACT.
     * @return the bloc.
     */
    public Bloc getBloc() {
        return bloc;
    }

    /**
     * To get the priority of the XACT.
     * @return the priority
     */
    public float getPriority() {
        return priority;
    }

    /**
     * To set the priority of the XACT.
     * @param priority the priority to set
     */
    public void setPriority(float priority) {
        this.priority = priority;
    }
}
