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
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class representing the model elements.
 * @author Pau Fonseca i Casas
 * @version 1
 * @see     <a href="http://www-eio.upc.es/~Pau/index.php?q=node/28">Project website</a>
 * @serialData
 */
public class Model implements Serializable {
    
    private String nomModel;
    private String DescripModel;
    //private int id;
    //array of processes. Contains process objects
    private ArrayList proces;
    //map containing the storages.
    private Map storages;
    //Future and Current Event List.
    private PriorityQueue<Xact> CEC;
    private PriorityQueue<Xact> FEC;
    //Blocked Event Chain
    private LinkedList<Xact> BEC;
    //array amb els servidors
    private Map servers;
    //array amb les cues
    private Map cues;
    /**
     * The transaction counter.
     */
    public int TC;
    /**
     * Identifier for the XACT created until the moment.
     */
    public int idxact;
    /**
     * Absolute simulation clock.
     */
    public float absoluteClock;
    /**
     * Relative simulation clock.
     */
    public float relativeClock;
    /**
     * The GNA of the model.
     */
    public GNA MyRandom=new GNA();

    /**
     * Creates a new instance of Model.
     */
    Model() {
        //inicialitzem a una array buida ja que no tenim encara processos
        this.setProces(new ArrayList());
        this.setStorages(new HashMap());
        Comparator<Xact> CECCmp = new PriorityComparator();
        Comparator<Xact> FECCmp = new TimeComparator();
        CEC = new PriorityQueue<Xact>(10, CECCmp);
        FEC = new PriorityQueue<Xact>(10, FECCmp);
        BEC = new LinkedList<Xact>();
        this.setServers(new HashMap());
        this.setCues(new HashMap());
    }

    /**
     * To obtaint the CEC.
     * @return the CEC.
     */
    public PriorityQueue<Xact> getCEC() {
        return CEC;
    }

    /**
     * To obtain the FEC.
     * @return
     */
    public PriorityQueue<Xact> getFEC() {
        return FEC;
    }

    /**
     * To obtain the BEC.
     * @return
     */
    public LinkedList<Xact> getBEC() {
        return BEC;
    }

    
    /**
     * To obtain the processes (now an arraylist).
     * @return
     */
    public ArrayList getProces() {
        return proces;
    }

    /**
     * To set the proceses (now an arraylist).
     * @param proces
     */
    public void setProces(ArrayList proces) {
        this.proces = proces;
    }

    /**
     * To obtain the name of the model.
     * @return the name.
     */
    public String getNomModel() {
        return nomModel;
    }

    /**
     * To set the name of the model.
     * @param nomModel the new name.
     */
    public void setNomModel(String nomModel) {
        this.nomModel = nomModel;
    }

    /**
     * To obtain the description of the model.
     * @return the description.
     */
    public String getDescripModel() {
        return DescripModel;
    }

    /**
     * To set the description of the model.
     * @param DescripModel the description.
     */
    public void setDescripModel(String DescripModel) {
        this.DescripModel = DescripModel;
    }

    /**
     * To obtain the array list containing the SERVERS.
     * @return the arraylist.
     */
    public Map getServers() {
        return servers;
    }

    /**
     * To set the array list containing the SERVERS.
     * @param servers the new arraylist.
     */
    public void setServers(HashMap servers) {
        this.servers = servers;
    }
    
    /**
     * To obtain the array list containing the CUES.
     * @return the arraylist.
     */
    public Map getCues() {
        return cues;
    }

    /**
     * To set the array list containing the CUES.
     * @param cues the new arraylist.
     */
    public void setCues(HashMap cues) {
        this.cues = cues;
    }
    
    /**
     * To obtain the map containing the STORAGES.
     * @return the map.
     */
    public Map getStorages() {
        return storages;
    }

    /**
     * To set the map containing the STORAGES.
     * @param storages the new map.
     */
    public void setStorages(Map storages) {
        this.storages = storages;
    }

    /**
     * To initialize the GENERATE block.
     * This method can be used as a template for other initialization procedures.
     */
    void InitializeGenerateBocs(){
        for (int j = 0; j < proces.size(); j++) {
            Proces p = (Proces) proces.get(j);

            for (int k = 0; k < p.getBlocs().size(); k++) {
                Bloc b = ((Bloc) (p.getBlocs().get(k)));
                if (b.getId()==Constants.idGenerate) {
                    ((Generate)b).execute(null);
                }
            }
        }
    }

    /**
     * To execute the simulation model.
     * @param b if true we execute the simulation step by step.
     */
    void execute(boolean b) {
        relativeClock=0;
        absoluteClock=0;
        InitializeGenerateBocs();
        if(!b) executeAll();
        else executeStep();
    }

private void passarBECaCEC() {
    while (!BEC.isEmpty()) CEC.add(BEC.poll());
}
    



private void imprimirInfoFinal() {
    System.out.println("A la CEC hi ha " + CEC.size() + "transaccions.");
    while (!CEC.isEmpty()) {
        System.out.println("Transacci� de la CEC que volia executar el bloc amb id " + CEC.poll().getBloc().getId());
    }
    System.out.println("A la FEC hi ha " + FEC.size() + "transaccions.");
    while (!CEC.isEmpty()) {
        System.out.println("Transacci� de la FEC que volia executar el bloc amb id " + FEC.poll().getBloc().getId());
    }
    System.out.println("A la BEC hi ha " + BEC.size() + "transaccions.");
    while (!CEC.isEmpty()) {
        System.out.println("Transacci� de la BEC que volia executar el bloc amb id " + BEC.poll().getBloc().getId());
    }
    System.out.println("Cues:");
    Iterator entries = cues.entrySet().iterator();
    while (entries.hasNext()) {
        Cua q = (Cua) ((Entry) entries.next()).getValue();
        System.out.println(q.getNom() + ": " + q.getNElem() + "transaccions.");
    }
    
    System.out.println("Storages:");
    entries = storages.entrySet().iterator();
    while (entries.hasNext()) {
        Storage s = (Storage) ((Entry) entries.next()).getValue();
        System.out.println(s.getNom() + ": " + s.getOcupants().size()
                + "transaccions amb un total de " + (s.getValor() - s.getLliures()) + "inst�ncies capturades.");
    }

    System.out.println("Servidors:");
    entries = servers.entrySet().iterator();
    while (entries.hasNext()) {
        Server s = (Server) ((Entry) entries.next()).getValue();
        System.out.print(s.getNom() + ": ");
        if (s.getOcupat()) System.out.println("ocupat.");
        else System.out.println("lliure.");
    }

    //TODO dir qu� hi ha en cada cua, storage i servidor. B�sicament crec que �s rec�rrer el map i imprimir el nom i la qtt de transaccions que t�
}



    
    /* Aqu� el que s'ha de fer �s transformar la transpar�ncia 138 (que far� servir les dues seg�ents a jgpss
     * i posar-ho tan a executeAll com a executeStep.
     */
    
private void executeGeneric() throws Exception{
            //TODO 1: First XACT.
            //TODO 2: Move the XACT as far as we can.
            //TODO 3: Look for other NOW XACT.
            //TODO 4: CLOCK UPDATE PHASE
            //TODO 5: Move the Xacts of the FEC to the CEC.
            //TODO 6: Goto TODO 1.
    boolean acaba = false;
    boolean excepcio = false;
    Xact xact;    
    while (!CEC.isEmpty()) {//Mentre hi hagi transaccions a la CEC, les fem avan�ar tan com podem
        xact = CEC.poll(); //Agafem la primera i la treiem de la CEC
        while (xact.getBloc().execute(xact) != null); //Moure aquesta xact el maxim que es pugui
        if (TC <= 0) {
            acaba = true;
            break;
        }
        if (xact.getBlocked()) {
            BEC.add(xact);
        }    
    }
    if (!acaba) {
        if (!FEC.isEmpty()) {
            xact = FEC.poll();
            relativeClock = xact.getMoveTime();
            CEC.add(xact);
            while ((!FEC.isEmpty() && (FEC.peek()).getMoveTime() == relativeClock)) {
                CEC.add(FEC.poll());
            }
        }
    }
    else {
        imprimirInfoFinal();
    }
}
    
    /**
     * To execute the simulation model.
     */
    void executeAll() {
        //Simulation engine loop.
        while (TC > 0) {
            System.out.println("Volta del bucle de executeAll amb TC: " + TC); 
            passarBECaCEC();
            try {
                executeGeneric();
            } catch (Exception ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("END");        
    }

    /**
     * To execute a single step of the simulation model.
     * Executes untin a new CLOCK UPDATE PHASE.
     */
    @SuppressWarnings("empty-statement")
    void executeStep(){
       if (TC > 0) {
           passarBECaCEC();
            try {
                executeGeneric();
            } catch (Exception ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }
}
