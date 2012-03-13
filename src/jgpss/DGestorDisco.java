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
import java.io.*;
/**
 * A class representing the disk manager.
 * @author  Pau Fonseca i Casas
 * @author  M.Dolores
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class DGestorDisco implements Serializable
{
   private GestorDeDisco gD;
   private Constants c = new Constants();

   /**
    * A new instance of the manager.
    */
   public DGestorDisco()
   {
      gD = new GestorDeDisco();
   }

    DGestorDisco(Model model) {
        gD = new GestorDeDisco(model);
    }

    void SetModel(Model model){
        gD.setGPSSmodel(model);
    }
   
    /**
     * To save the model.
     * @throws java.lang.Exception
     */
    public void guardar() throws Exception
   {
      try
      {
         gD.guardaObjeto(VarGlobals.bloc, VarGlobals.titol);
      }
      catch (Exception e)
      {
         throw e;
      }
   }
   
    /**
     * To recover an object.
     * @return the object ot be recovered from file.
     * @throws java.lang.Exception
     */
    public Object recuperar() throws Exception
   {
      try
      {
         return gD.recuperaObjeto(VarGlobals.titol);
      }
      catch (Exception e)
      {
         throw e;
      }
   }
   
   /**
    * To save the model.
    * @param url where to save the model
    * @throws java.io.IOException
    */
   public void guardarTxt(String url) throws IOException{
       
   gD.guardarTxt(url);
   }
   /**
    * To recover a model from a text file.
    * @param entrada where is the model.
    * @return 0 if all is ok 1 otherwise.
    */
   public int recuperarTxt(BufferedReader entrada){
       return gD.recuperarTxt(entrada);
   
   }
 
 
 
}
