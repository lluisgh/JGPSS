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
* Autor: Francisco G�mez Gonz�lez
* Cluster: 2
* Grupo: 2.2
* Versi�n: 1.0
* Fecha: 04-11-05
*/
import java.util.*;
import java.io.*;

/**
* Clase que escribe y lee de disco objetos serializables.
*/

public class GestorDeDisco
{
    private Model GPSSmodel;

    GestorDeDisco() {
    }

    GestorDeDisco(Model model) {
        GPSSmodel=model;
    }

   /*
   * Explicaci�n de guardaObjeto
   * PRE:-
   * POST: El objeto o se ha guardado en disco con el nombre nomFichero
   * @param o Objeto el cual queremos guardar en disco
   * @param nomFichero Nombre con el cual queremos guardar el objeto
   * @exception FileNotFoundException No se ha podido crear el fichero
   * @exception IOException No se ha podido realizar la entrada/salida
   */
   public void guardaObjeto(Object o, String nomFichero) throws Exception
   {
      try
      {
         ObjectOutputStream oos;
	 oos = new ObjectOutputStream(new FileOutputStream(nomFichero));
		
         oos.writeObject(o);
         oos.close();
      }
      catch(FileNotFoundException fnfe)
      {
         throw new Exception("No se ha podido crear el fichero");
      }  
      catch(IOException ioe)
      {
         throw new Exception("No se ha podido realizar la entrada/salida");
      }
   }

   
   /*
   * Explicaci�n de la recuperaObjeto
   * PRE:-
   * POST: Retorna el objeto recuperado con el nombre nomFichero
   * @param nomFichero Nombre del objeto que queremos recuperar de disco
   * @exception FileNotFoundException No se ha podido crear el fichero
   * @exception IOException No se ha podido realizar la entrada/salida
   * @exception ClassNotFoundException El fichero no contiene una clase valida
   */
   public Object recuperaObjeto(String nomFichero) throws Exception
   {
      try
      {
         ObjectInputStream ois;
         ois = new ObjectInputStream(new FileInputStream(nomFichero));

         return ois.readObject();
      }
      catch(FileNotFoundException fnfe)
      {
         throw new Exception("No se ha podido crear el fichero");
      }
      catch(IOException ioe)
      {
         throw new Exception("No se ha podido realizar la entrada/salida");
      }
      catch(ClassNotFoundException cnfe)
      {
         throw new Exception("El fichero no contiene una clase valida");
      }
   }
   
   public void guardarTxt(String url) throws IOException{
     FileWriter  Guardx=null;
     Guardx=new FileWriter(url);
      Guardx.write(generarTxt());
       Guardx.close(); //Cierra el fichero
   
   }

     private String generarTxt() throws IOException{
       String texto = null;
       Model model=VarGlobals.model;
       StringBuffer textModel = new StringBuffer();
       
       //escriure el titol
       textModel.append(Constants.asterisco);
       textModel.append(Constants.saltoLinea);
       textModel.append(Constants.asterisco);
       textModel.append(Constants.espacio);
       textModel.append(model.getNomModel());
       textModel.append(Constants.saltoLinea);
       textModel.append(Constants.asterisco);
       textModel.append(Constants.espacio);
       textModel.append(model.getDescripModel());
       textModel.append(Constants.saltoLinea);
       textModel.append(Constants.asterisco);
   
       //escrriure els storages
       textModel.append(Constants.saltoLinea);
       ArrayList storages= model.getStorages();
       Storage st;
       for(int j=0;j<storages.size();j++){
           st=(Storage)storages.get(j);
           textModel.append(Constants.saltoLinea);
           textModel.append(st.getNom());
           textModel.append(Constants.espacio);
           textModel.append(Constants.storages);
           textModel.append(Constants.espacio);
           textModel.append(st.getValor());
       }
      //escrire els processos
       
       ArrayList procesos = model.getProces();
       Proces p;
       ArrayList blocs;
       Bloc b;
       
       for(int i = 0; i<procesos.size(); i++){
            p=(Proces) procesos.get(i);
           //descripcio y nom del proces
           textModel.append(Constants.saltoLinea);
           textModel.append(Constants.saltoLinea);
           textModel.append(Constants.asterisco);
           textModel.append(Constants.saltoLinea);
           textModel.append(Constants.asterisco);
           textModel.append(Constants.espacio);
           textModel.append(p.getDescpro());
           textModel.append(Constants.saltoLinea);
           textModel.append(Constants.asterisco);
           
           //blocs
           blocs = p.getBlocs();
           for(int j=0; j<blocs.size(); j++){
              // textModel.append(Constants.saltoLinea);
               textModel.append(Constants.saltoLinea);
               b=(Bloc) blocs.get(j);
               textModel.append(escriurebloc(b));
               
            
           
           }
       }
       return textModel.toString();
   
   }
   
   private String escriurebloc(Bloc b) throws IOException{

       StringBuffer bufBloc = new StringBuffer();
      //segons el bloc escriurem una cosa o una altre
       //bufBloc.append(Constants.cincoEspacios);
       int id = b.getId();
       int espacios;
       bufBloc.append(b.getLabel());
       espacios = Constants.espaisLabel.length()-b.getLabel().length();
       for (int i = 0; i < espacios; i++) {
           bufBloc.append(Constants.espacio);
       }
       switch (id){
           case Constants.idGenerate:
                Generate g= (Generate)b;
                bufBloc.append(Constants.Generate);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Generate.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                //datos
                //A
                bufBloc.append(Float.toString(g.getA()));
                bufBloc.append(Constants.coma);
                bufBloc.append(Float.toString(g.getB()));
                bufBloc.append(Constants.coma);
                bufBloc.append(Float.toString(g.getC()));
                bufBloc.append(Constants.coma);
                bufBloc.append(Float.toString(g.getD()));
                bufBloc.append(Constants.coma);
                bufBloc.append(Float.toString(g.getE()));
                bufBloc.append(Constants.coma);
                bufBloc.append(Integer.toString(g.getF()));

                break;
             case Constants.idFunavail:
                Funavail fun= (Funavail)b;
                bufBloc.append(Constants.Funavail);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Funavail.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                //datos
                //A
                bufBloc.append(Float.toString(fun.getA()));
                bufBloc.append(Constants.coma);
                bufBloc.append(Float.toString(fun.getB()));
                bufBloc.append(Constants.coma);
                bufBloc.append(Float.toString(fun.getC()));
                bufBloc.append(Constants.coma);
                bufBloc.append(Float.toString(fun.getD()));
                bufBloc.append(Constants.coma);
                bufBloc.append(Float.toString(fun.getE()));
                bufBloc.append(Constants.coma);
                bufBloc.append(Integer.toString(fun.getF()));

                break;
           case Constants.idTerminate:
               
                Terminate t= (Terminate)b;
                bufBloc.append(Constants.Terminate);
                //espacios hasta llegas a 16
                 espacios = Constants.numCaractersBloc-Constants.Terminate.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                //datos
                //A
                bufBloc.append(Integer.toString(t.getA()));
                break;
       
       
           case Constants.idAdvanced:
                Advance a= (Advance)b;
                bufBloc.append(Constants.Advanced);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Advanced.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                //datos
                //A
                bufBloc.append(Float.toString(a.getA()));
                bufBloc.append(Constants.coma);
                bufBloc.append(Float.toString(a.getB()));
                break;
            case Constants.idAssign:
                Assign as= (Assign)b;
                bufBloc.append(Constants.Assign);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Assign.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                //datos
                //A
                bufBloc.append(as.getA());
                bufBloc.append(Constants.coma);
                bufBloc.append(Float.toString(as.getB()));
                break;
           case Constants.idDepart:
                Depart d= (Depart)b;
                bufBloc.append(Constants.Depart);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Depart.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                //datos
                //A
                bufBloc.append(d.getA());
                bufBloc.append(Constants.coma);
                bufBloc.append(Integer.toString(d.getB()));
                break;
                
            case Constants.idQueue:
                Queue q= (Queue)b;
                bufBloc.append(Constants.Queue);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Queue.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                //datos
                //A
                bufBloc.append(q.getA());
                bufBloc.append(Constants.coma);
                bufBloc.append(Integer.toString(q.getB()));
               break;
           case Constants.idEnter:
                Enter e= (Enter)b;
                bufBloc.append(Constants.Enter);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Enter.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                //datos
                //A
                bufBloc.append(e.getA());
                bufBloc.append(Constants.coma);
                bufBloc.append(Integer.toString(e.getB()));
               break;
            case Constants.idLeave:
                Leave l= (Leave)b;
                bufBloc.append(Constants.Leave);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Leave.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                //datos
                //A
                bufBloc.append(l.getA());
                bufBloc.append(Constants.coma);
                bufBloc.append(Integer.toString(l.getB()));
               break;
           case Constants.idRelease:
                Release r= (Release)b;
                bufBloc.append(Constants.Release);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Release.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                  bufBloc.append(r.getA());
               break;
           case Constants.idSeize:
                Seize s= (Seize)b;
                bufBloc.append(Constants.Seize);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Seize.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                  bufBloc.append(s.getA());
               break;
               //
            case Constants.idTest:
                Test test = (Test)b;
                bufBloc.append(Constants.Test);
                bufBloc.append(Constants.espacio);
                bufBloc.append(test.getX());
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Test.length()-Constants.espacio.length()-test.getX().length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                
                
                bufBloc.append(test.getA());
                bufBloc.append(Constants.coma);
                bufBloc.append(test.getB());
                bufBloc.append(Constants.coma);
                bufBloc.append(test.getC());

             break;
            case Constants.idTransfer:
                Transfer transf = (Transfer)b;
                bufBloc.append(Constants.Transfer);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Transfer.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                bufBloc.append(transf.getA());
                bufBloc.append(Constants.coma);
                bufBloc.append(transf.getB());
                bufBloc.append(Constants.coma);
                bufBloc.append(transf.getC());
                bufBloc.append(Constants.coma);
                bufBloc.append(transf.getD());
                break;
             case Constants.idLogic:
                Logic log = (Logic)b;
                bufBloc.append(Constants.Logic);
                bufBloc.append(Constants.espacio);
                bufBloc.append(log.getX());
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Logic.length()-Constants.espacio.length()-log.getX().length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                
                bufBloc.append(log.getA());
             break;
            case Constants.idGate:
                Gate gate = (Gate)b;
                bufBloc.append(Constants.Gate);
                bufBloc.append(Constants.espacio);
                bufBloc.append(gate.getX());
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Gate.length()-Constants.espacio.length()-gate.getX().length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                bufBloc.append(gate.getA());
                bufBloc.append(Constants.coma);
                bufBloc.append(gate.getB());
             break;
            case Constants.idSavevavg:
                Savevalue sav = (Savevalue)b;
                bufBloc.append(Constants.Savevavg);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Savevavg.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                bufBloc.append(sav.getA());
                bufBloc.append(Constants.coma);
                bufBloc.append(sav.getB());
             break;
            case Constants.idLoop:
                Loop loop = (Loop)b;
                bufBloc.append(Constants.Loop);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Loop.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                bufBloc.append(loop.getA());
                bufBloc.append(Constants.coma);
                bufBloc.append(loop.getB());
                break;
                
            case Constants.idSplit:
                Split split = (Split)b;
                bufBloc.append(Constants.Split);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Split.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                bufBloc.append(split.getA());
                bufBloc.append(Constants.coma);
                bufBloc.append(split.getB());
                bufBloc.append(Constants.coma);
                bufBloc.append(split.getC());
                break;
               case Constants.idSavail:
                Savail savail = (Savail)b;
                bufBloc.append(Constants.Savail);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Savail.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                bufBloc.append(savail.getA());    
              break;
               case Constants.idSunavail:
                Sunavail sunavail = (Sunavail)b;
                bufBloc.append(Constants.Sunavail);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Sunavail.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                bufBloc.append(sunavail.getA());
              break;
           case Constants.idAssemble:
                Assemble ass = (Assemble)b;
                bufBloc.append(Constants.Assemble);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Assemble.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                bufBloc.append(ass.getA());    
              break;    
              
             case Constants.idGather:
                Gather gather = (Gather)b;
                bufBloc.append(Constants.Gather);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Gather.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                bufBloc.append(gather.getA());    
        
              break;
              
             case Constants.idMatch:
                Match match = (Match)b;
                bufBloc.append(Constants.Match);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Match.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                bufBloc.append(match.getA());    
         
              break;
             case Constants.idPriority:
                Priority pri = (Priority)b;
                bufBloc.append(Constants.Priority);
                //espacios hasta llegas a 16
                espacios = Constants.numCaractersBloc-Constants.Priority.length();
                for(int i=0; i<espacios; i++){
                    bufBloc.append(Constants.espacio);
                }
                bufBloc.append(pri.getA());    
           
              break; 
             case Constants.idBuffer:
                //Buffer buffer = (Buffer)b;
                bufBloc.append(Constants.Buffer);
           
              break;
            //   
           default:
               break;
       }
       //si existeix el comentari
       if(!(b.getComentari().equals(""))&&(b.getComentari()!=null)){
           bufBloc.append(Constants.cincoEspacios);
           bufBloc.append(Constants.puntoycoma);
           bufBloc.append(b.getComentari());
       }
       return bufBloc.toString();
   }
   public int recuperarTxt(BufferedReader entrada){
      return this.txtToModel(entrada);
   }
   
   
    private int txtToModel(BufferedReader entrada) {
        Model m = new Model();
        setGPSSmodel(m);
        ArrayList p = new ArrayList();
        ArrayList storages = new ArrayList();
        ArrayList blocs;
        String nomModel = "";
        String descModel = "";
        String nomProces = "";
        Proces pro;
        Storage stor;
        int xini, yini, xfin, yfin;
        xini = 0;
        yini = xfin = xini;
        yfin = Constants.y;
        int linea = 1;
        String s;
        int cont = 0;
        try {
            while ((s = entrada.readLine()) != null) {
                if ((linea == 1) || (linea == 4)) {
                    if (!s.equals(Constants.asterisco)) {
                        return 1;
                    }
                    linea++;
                } else if (linea == 2) {
                    //nom del model
                    if (!s.substring(0, 1).equals(Constants.asterisco)) {
                        return 1;
                    }
                    nomModel = s.substring(2);
                    linea++;

                } else if (linea == 3) {
                    //descripci� del model
                    if (!s.substring(0, 1).equals(Constants.asterisco)) {
                        return 1;
                    }
                    descModel = s.substring(2);
                    linea++;
                } else {

                    if (s.equals("")) {
                        //nuevo proceso
                        cont = 1;
                        blocs = new ArrayList();
                        /*
                         * tractaStorages == true -> tractar els storages
                         * tractaStorages == false -> tractar els procesos diretament
                         */
                        boolean tractaStorages = true;
                        while ((s = entrada.readLine()) != null) {
                            if (s.equals("") && !tractaStorages) {
                                pro = new Proces(nomProces,getGPSSmodel());
                                //pro.setDescpro(nomProces);
                                pro.setBlocs(blocs);
                                pro.setPosx(xini);
                                pro.setPosy(yini);
                                pro.setFinposx(xfin);
                                pro.setFinposy(yfin);
                                //pro.set
                                p.add(pro);
                                //iniciem nou proces
                                cont = 1;
                                xini = xini + Constants.x;
                                xfin = xini;
                                yini = 0;
                                yfin = Constants.y;

                                blocs = new ArrayList();
                            } else if (s.equals("") && tractaStorages) {
                                cont = 1;
                                tractaStorages = false;
                            } else if (!s.equals("") && tractaStorages) {
                                //si comenza amb un astrisc vol dir que no hi han storages i que estem en un proc�s
                                if (s.equals(Constants.asterisco)) {
                                    tractaStorages = false;
                                } else {
                                    String vStorage[] = s.split(Constants.espacio);
                                    //el primer es el nom de l'storage i el tercer el valor
                                    storages.add(new Storage(vStorage[0], new Integer(vStorage[2]).intValue()));


                                }
                            } else {
                                if ((cont == 2) && !tractaStorages) {
                                    //nom del proces
                                    nomProces = s.substring(2);
                                } else if ((cont > 3) && !tractaStorages) {
                                    //els blocs
                                    blocs.add(crearBloc(s));
                                    yfin = yfin + Constants.y;
                                } else if ((cont == 1) && !tractaStorages && !s.equals(Constants.asterisco)) {
                                    //error al llegir l'artxiu

                                    return 1;
                                }
                                cont++;
                            }

                        // linea++;
                        }
                        pro = new Proces(nomProces,getGPSSmodel());
                        //pro.setDescpro(nomProces);
                        pro.setBlocs(blocs);
                        pro.setPosx(xini);
                        pro.setPosy(yini);
                        pro.setFinposx(xfin);
                        pro.setFinposy(yfin);
                        p.add(pro);
                    }
                }

            }

//            Model m = new Model(nomModel, descModel);
            m.setNomModel(nomModel);
            m.setDescripModel(descModel);
            m.setProces(p);
            m.setStorages(storages);
            VarGlobals.model = m;

        } catch (IOException ioe) {
            return 1;
        }
        return 0;

    }
   private Bloc crearBloc(String s) throws IOException{

       String partBloc;
       String vComentari[]= s.split(Constants.puntoycoma);
       s=vComentari[0];
       String strComentari= "";
       if(vComentari.length>1)
            strComentari= vComentari[1];

       String strLabel= "";
       strLabel=(String) s.subSequence(0,Constants.espaisLabel.length());
       strLabel=strLabel.trim();


       partBloc = s.substring(Constants.espaisLabel.length());
       String cadenas[] = partBloc.split(Constants.espacio);
       //la primera posici� ser� el nom del bloc
       String nomBloc= cadenas[0];
       //l'�ltima pos ser�n els valos
       String strValors= cadenas[cadenas.length-1];
       String valors[] = strValors.split(Constants.coma);
       //segons el nom del bloc
       Bloc b= null;
       if(nomBloc.equals(Constants.Advanced)){
          Advance a = new Advance( 
                  strComentari,strLabel,
                  Float.valueOf(valors[0]).floatValue(), 
                  Float.valueOf(valors[1]).floatValue());
          b=a;
       }
       else if(nomBloc.equals(Constants.Assign)){
          Assign a = new Assign(
                  strComentari,strLabel,
                  valors[0].toString(),
                  Float.valueOf(valors[1]).floatValue());
          b=a;
       }
       else if(nomBloc.equals(Constants.Depart)){
           Depart d = new Depart(
                    strComentari,strLabel,
                    valors[0],
                    Integer.parseInt(valors[1]));
           b=d;
       }
       else if(nomBloc.equals(Constants.Enter)){
           Enter e = new Enter(
                    strComentari,strLabel,
                    valors[0],
                    Integer.parseInt(valors[1]));
           b=e;
       }
       else if(nomBloc.equals(Constants.Generate)){
           
           Generate g = new Generate(
                    strComentari,strLabel,
                    Float.valueOf(valors[0]).floatValue(),
                    Float.valueOf(valors[1]).floatValue(),
                    Float.valueOf(valors[2]).floatValue(),
                    Float.valueOf(valors[3]).floatValue(),
                    Float.valueOf(valors[4]).floatValue(),
                    Integer.parseInt(valors[5]));
           b=g;
       }
       else if(nomBloc.equals(Constants.Leave)){
           Leave l = new Leave(
                    strComentari,strLabel,
                    valors[0],
                    Integer.parseInt(valors[1]));
           b=l;
           
       }
       else if(nomBloc.equals(Constants.Queue)){
           Queue q = new Queue(
                     strComentari,strLabel,
                    valors[0],
                    Integer.parseInt(valors[1]));
           b=q;
       }
       else if(nomBloc.equals(Constants.Release)){
            Release r= new Release(
                    strComentari,strLabel,
                    valors[0]);
            b=r;
       }
       else if(nomBloc.equals(Constants.Seize)){
             Seize se= new Seize(
                     strComentari,strLabel,
                    valors[0]);
            b=se;
           
       }
       else if(nomBloc.equals(Constants.Terminate)){
            Terminate t= new Terminate(
                    strComentari,strLabel,
                    Integer.parseInt(valors[0]));
            b=t;
       }
       else if(nomBloc.equals(Constants.Test)){
           Test test;
           if(valors.length==3){
               test= new Test(
                       strComentari,strLabel,cadenas[1],
                       valors[0],valors[1], valors[2]); 
               b=test;
           }
           else if(valors.length==0){
               test= new Test(
                       strComentari,strLabel,cadenas[1],
                       "","", "");
               b=test;
           }
            if(valors.length==1){
               test= new Test(
                       strComentari,strLabel,cadenas[1],
                       valors[0],"", ""); 
               b=test;
           }
            if(valors.length==2){
               test= new Test(
                       strComentari,strLabel,cadenas[1],
                       valors[0],valors[1], ""); 
               b=test;
           }
           
       }
       else if(nomBloc.equals(Constants.Transfer)){
           Transfer transf= new Transfer(
                   strComentari,strLabel,
                   valors[0], valors[1], valors[2],valors[3]);
           b= transf;
       }
       else if(nomBloc.equals(Constants.Logic)){
           Logic logic= new Logic(
                   strComentari,strLabel, cadenas[1], valors[0]);
           b= logic;
       
       }
       else if(nomBloc.equals(Constants.Gate)){
           Gate gate= new Gate(
                   strComentari,strLabel, cadenas[1], valors[0], valors[1]);
           b= gate;
       }
       else if(nomBloc.equals(Constants.Savevavg)){
           Savevalue sav= new Savevalue(
                   strComentari,strLabel, valors[0], valors[1]);
           b= sav;
       }
       else if (nomBloc.equals(Constants.Loop)){
           Loop loop;
           if(valors.length==2){
               loop = new Loop(
                       strComentari,strLabel, valors[0], valors[1]);
               b=loop;
           }
           else if(valors.length==1){
               loop = new Loop(
                       strComentari,strLabel, valors[0], "");
               b=loop;
           }
            else if(valors.length==0){
               loop = new Loop(
                       strComentari,strLabel, "", "");
               b=loop;
           
           }
       }
       else if(nomBloc.equals(Constants.Split)){
           Split split;
           if(valors.length==3){
               split= new Split(
                       strComentari,strLabel, Integer.parseInt(valors[0]),valors[1], valors[2]);
               b= split;
           }
           else if(valors.length==2){
               split= new Split(
                       strComentari,strLabel, Integer.parseInt(valors[0]),valors[1],"");
               b= split;
           }
           else if(valors.length==1){
               split= new Split(
                       strComentari,strLabel, Integer.parseInt(valors[0]),"","");
               b= split;
           }
           else if(valors.length==2){
               split= new Split(
                       strComentari,strLabel, Integer.parseInt("0"),"","");
               b= split;
           }
           
       }
       else if(nomBloc.equals(Constants.Funavail)){

           Funavail fun = new Funavail(
                    strComentari,strLabel,
                    Float.valueOf(valors[0]).floatValue(),
                    Float.valueOf(valors[1]).floatValue(),
                    Float.valueOf(valors[2]).floatValue(),
                    Float.valueOf(valors[3]).floatValue(),
                    Float.valueOf(valors[4]).floatValue(),
                    Integer.parseInt(valors[5]));
           b=fun;
       }

       else if(nomBloc.equals(Constants.Savail)){
           Savail savail= new Savail(
                   strComentari,strLabel, valors[0]);
           b=savail;
       }
       else if(nomBloc.equals(Constants.Sunavail)){
           Sunavail sunavail= new Sunavail(
                   strComentari,strLabel, valors[0]);
           b=sunavail;
       }
       else if(nomBloc.equals(Constants.Assemble)){
           Assemble ass = new Assemble(
                   strComentari,strLabel, Integer.parseInt(valors[0]));
           b=ass;           
       }
       else if(nomBloc.equals(Constants.Gather)){
           Gather gather = new Gather(
                   strComentari,strLabel, Integer.parseInt(valors[0]));
           b=gather;
       }
       else if(nomBloc.equals(Constants.Match)){
           Match match = new Match(
                   strComentari,strLabel, valors[0]);
           b=match;
       }
       else if(nomBloc.equals(Constants.Buffer)){
           Buffer buffer = new Buffer(
                   strComentari,strLabel);
           b=buffer;
       }
        else if(nomBloc.equals(Constants.Priority)){
           Priority pri = new Priority(
                   strComentari,strLabel, Integer.parseInt(valors[0]));
           b=pri;
       }

       return b;
   }

    /**
     * @return the GPSSmodel
     */
    public Model getGPSSmodel() {
        return GPSSmodel;
    }

    /**
     * @param GPSSmodel the GPSSmodel to set
     */
    public void setGPSSmodel(Model GPSSmodel) {
        this.GPSSmodel = GPSSmodel;
    }
}