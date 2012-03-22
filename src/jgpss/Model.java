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
    //array containing the storages.
    private ArrayList storages;
    //Future and Current Event List.
    private ArrayList CEC;
    private ArrayList FEC;
    //array amb els servidors
    private ArrayList servers;
    //array amb les cues
    private ArrayList cues;
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
        this.setStorages(new ArrayList());
        CEC=new ArrayList();
        FEC=new ArrayList();
        servers = new ArrayList();
    }

    /**
     * To obtaint the CEC.
     * @return the CEC.
     */
    public ArrayList getCEC() {
        return CEC;
    }

    /**
     * To obtain the FEC.
     * @return
     */
    public ArrayList getFEC() {
        return FEC;
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
    public ArrayList getServers() {
        return servers;
    }

    /**
     * To set the array list containing the SERVERS.
     * @param servers the new arraylist.
     */
    public void setServers(ArrayList servers) {
        this.servers = servers;
    }
    
    /**
     * To obtain the array list containing the CUES.
     * @return the arraylist.
     */
    public ArrayList getCues() {
        return cues;
    }

    /**
     * To set the array list containing the CUES.
     * @param cues the new arraylist.
     */
    public void setCues(ArrayList cues) {
        this.cues = cues;
    }
    
    /**
     * To obtain the array list containing the STORAGES.
     * @return the arraylist.
     */
    public ArrayList getStorages() {
        return storages;
    }

    /**
     * To set the array list containing the STORAGES.
     * @param storages the new arraylist.
     */
    public void setStorages(ArrayList storages) {
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

    
    
    
    /* Aquí el que s'ha de fer és transformar la transparència 138 (que farà servir les dues següents a jgpss
     * i posar-ho tan a executeAll com a executeStep.
     */
    
    /**
     * To execute the simulation model.
     */
    void executeAll() {
        Xact xact;
        int acaba = 0;
        //Simulation engine loop.
        while (TC > 0) {
            //SCAN PHASE
            while (!CEC.isEmpty()) { //Mentre hi hagi transaccions a la CEC, les fem avançar tan com podem
                xact = (Xact) CEC.get(0); //Agafem la primera
                CEC.remove(0); 
                //Moure aquesta xact el maxim que es pugui
                while (xact.getBloc().execute(xact) != null) {
                }
                if (TC <= 0) {
                    System.out.println("TC igual o menys de 0");
                    acaba = 1;
                    break;
                }
            }
            if (acaba == 0) {
                xact = (Xact) FEC.get(0);
                relativeClock = xact.getMoveTime();
                int i = 0;
                CEC.add(i, xact);
                ++i;
                FEC.remove(0);
                while ((!FEC.isEmpty() && ((Xact) FEC.get(0)).getMoveTime() == relativeClock)) {
                    CEC.add(i++, (Xact) FEC.get(0));
                    FEC.remove(0);

                }
                //TODO 1: First XACT.
                //TODO 2: Move the XACT as far as we can.
                //TODO 3: Look for other NOW XACT.
                //TODO 4: CLOCK UPDATE PHASE
                //TODO 5: Move the Xacts of the FEC to the CEC.
                //TODO 6: Goto TODO 1.
            }
        }
        System.out.println("END");
        
    }

    /**
     * To execute a single step of the simulation model.
     * Executes untin a new CLOCK UPDATE PHASE.
     */
    void executeStep() {
        Xact xact;
        //Motor central de simulaciÛ.
        int acaba = 0;
        if (TC > 0) {
             while (!CEC.isEmpty()) { //Mentre hi hagi transaccions a la CEC, les fem avançar tan com podem
                xact = (Xact) CEC.get(0); //Agafem la primera
                CEC.remove(0); 
                //Moure aquesta xact el maxim que es pugui
                while (xact.getBloc().execute(xact) != null) {
                }
                if (TC <= 0) {
                    System.out.println("TC igual o menys de 0");
                    acaba = 1;
                    break;
                }
            }
            if (acaba == 0) {
                xact = (Xact) FEC.get(0);
                relativeClock = xact.getMoveTime();
                int i = 0;
                CEC.add(i, xact);
                ++i;
                FEC.remove(0);
                while ((!FEC.isEmpty() && ((Xact) FEC.get(0)).getMoveTime() == relativeClock)) {
                    CEC.add(i++, (Xact) FEC.get(0));
                    FEC.remove(0);

                }
                //TODO 1: First XACT.
                //TODO 2: Move the XACT as far as we can.
                //TODO 3: Look for other NOW XACT.
                //TODO 4: CLOCK UPDATE PHASE
                //TODO 5: Move the Xacts of the FEC to the CEC.
                //TODO 6: Goto TODO 1.
            }
        }    
    }
}
