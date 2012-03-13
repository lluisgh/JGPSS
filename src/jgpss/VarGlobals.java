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
 * A class representing the gloval variables of the model.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class VarGlobals implements Serializable {
    /**
     * The title of the current model.
     */
    public static String titol;
    /**
     * The description of the current model.
     */
    public static String Descripcio;
    /**
     * Contains the URL of the website that host the JGPSS project.
     */
    public static String url;
    /**
     * Needed to know if we are continuing in the edition or execution of the model.
     */
    public static boolean continuar;
     /**
      * Varialbe that contains the last selected block.
      */
     public static Bloc bloc;
     /**
      * The variable containing the model.
      */
     public static Model model;
     /**
      * url to save the file.
      */
     public static String urlGuardar;
    /**
     * To know if we are opening a model or not.
     */
    public static boolean Abrir;
    /**
     * To know if the model has been saved.
     */
    public static boolean esGuardat;
    /**
     * To know if the model has been modified.
     */
    public static boolean esModificat;
    /**
     * Name of the selected STORAGE.
     */
    public static String nomStorageSeleccionat;
   
    /**
     * Disc manegament variables.
     */
    public static DGestorDisco dg= new DGestorDisco(model);
    /**
     * Transaction counter.
     */
    static int TC;
    /** 
     * Creates a new instance of VarGlobals.
     */
    public VarGlobals() {
    }

    /**
     * To clean the global variables.
     */
    public static void limpiarGlobales(){
    //posar les variables netes
        titol= null;
        //strBloc= null;
        Descripcio= null;
        url= null;
        bloc= null;
        model= null;
        urlGuardar= null;
        esGuardat = false;
        Abrir=false;
        //idNumBloc =0;
    }
}
