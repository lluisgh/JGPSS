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

import java.util.*;
import javax.swing.*;

/**
 *
 * @author  M.Dolores
 */
public class PantallaDescripcioBloc extends javax.swing.JDialog {

    /** Creates new form PantallaDescripcioBloc */
    int b;
    //aquesta variable serveix per guardar si volem modificar consultar o crear un bloc
    int queFem = 0;

    public PantallaDescripcioBloc(Bloc bloc, int caso) {
        this.setModal(true);
        initComponents();
        this.setTitle(Constants.tituloNewBloc);
        botoStorage.setVisible(false);
        queFem = caso;
        b = bloc.getId();
        comboOp.setVisible(false);
        pintarBloc(bloc, caso);


    }

    public PantallaDescripcioBloc(String urlbloc, int tipusBloc, String nomBloc) {
        this.setModal(true);
        initComponents();
        this.setTitle(Constants.tituloNewBloc);
        botoStorage.setVisible(false);
        dibuixarBloc(urlbloc);
        b = tipusBloc;
        comboOp.setVisible(false);
        if (tipusBloc == Constants.idGenerate ||
                tipusBloc == Constants.idFunavail) {

            jLabelA.setText(Constants.A);
            jLabelB.setText(Constants.B);
            jLabelC.setText(Constants.C);
            jLabelD.setText(Constants.D);
            jLabelE.setText(Constants.E);
            jLabelF.setText(Constants.F);
        // jLabelG.setText(Constants.tempsEntreArribades);

        } else if (tipusBloc == Constants.idTerminate ||
                tipusBloc == Constants.idRelease ||
                tipusBloc == Constants.idSeize ||
                tipusBloc == Constants.idFavail ||
                tipusBloc == Constants.idAssemble ||
                tipusBloc == Constants.idGather ||
                tipusBloc == Constants.idMatch ||
                tipusBloc == Constants.idPriority) {
            jLabelA.setText(Constants.A);
            TextB.setVisible(false);
            TextC.setVisible(false);
            TextD.setVisible(false);
            TextE.setVisible(false);
            TextF.setVisible(false);
        // TextG.setVisible(false);


        } else if (tipusBloc == Constants.idAdvanced ||
                tipusBloc == Constants.idDepart ||
                tipusBloc == Constants.idQueue ||
                tipusBloc == Constants.idSavevavg ||
                tipusBloc == Constants.idAssign ||
                tipusBloc == Constants.idLoop) {
            jLabelA.setText(Constants.A);
            jLabelB.setText(Constants.B);
            TextC.setVisible(false);
            TextD.setVisible(false);
            TextE.setVisible(false);
            TextF.setVisible(false);
        //  TextG.setVisible(false);

        } else if (tipusBloc == Constants.idSplit) {
            jLabelA.setText(Constants.A);
            jLabelB.setText(Constants.B);
            jLabelC.setText(Constants.C);
            TextD.setVisible(false);
            TextE.setVisible(false);
            TextF.setVisible(false);
        //TextG.setVisible(false);
        } else if (tipusBloc == Constants.idTest) {
            comboOp.setVisible(true);
            comboOp.setModel(new javax.swing.DefaultComboBoxModel(this.generarVectorTest()));
            jLabelX.setText(Constants.X);
            jLabelA.setText(Constants.A);
            jLabelB.setText(Constants.B);
            jLabelC.setText(Constants.C);
            TextD.setVisible(false);
            TextE.setVisible(false);
            TextF.setVisible(false);
        //  TextG.setVisible(false);
        } else if (tipusBloc == Constants.idTransfer) {

            comboOp.setVisible(true);
            comboOp.setModel(new javax.swing.DefaultComboBoxModel(this.generarVectorTransfer()));
            jLabelX.setText(Constants.A);
            jLabelA.setText(Constants.B);
            jLabelB.setText(Constants.C);
            jLabelC.setText(Constants.D);
            TextD.setVisible(false);
            TextE.setVisible(false);
            TextF.setVisible(false);
        //    TextG.setVisible(false);

        } else if (tipusBloc == Constants.idLogic) {
            comboOp.setVisible(true);
            comboOp.setModel(new javax.swing.DefaultComboBoxModel(this.generarVectorLogic()));
            jLabelX.setText(Constants.X);
            jLabelA.setText(Constants.A);
            TextB.setVisible(false);
            TextC.setVisible(false);
            TextD.setVisible(false);
            TextE.setVisible(false);
            TextF.setVisible(false);
        //     TextG.setVisible(false);
        } else if (tipusBloc == Constants.idGate) {
            comboOp.setVisible(true);
            comboOp.setModel(new javax.swing.DefaultComboBoxModel(this.generarVectorGate()));
            jLabelX.setText(Constants.X);
            jLabelA.setText(Constants.A);
            jLabelB.setText(Constants.B);
            TextC.setVisible(false);
            TextD.setVisible(false);
            TextE.setVisible(false);
            TextF.setVisible(false);
        //    TextG.setVisible(false);
        } else if (tipusBloc == Constants.idBuffer) {
            textA.setVisible(false);
            TextB.setVisible(false);
            TextC.setVisible(false);
            TextD.setVisible(false);
            TextE.setVisible(false);
            TextF.setVisible(false);
        //     TextG.setVisible(false);

        }
        //blocs que han de mostrar storage
        else if (tipusBloc == Constants.idEnter ||
                tipusBloc == Constants.idLeave) {

            botoStorage.setVisible(true);
            jLabelA.setText(Constants.A);
            jLabelB.setText(Constants.B);
            TextC.setVisible(false);
            TextD.setVisible(false);
            TextE.setVisible(false);
            TextF.setVisible(false);
            textA.setEnabled(false);
        }
        else if (tipusBloc == Constants.idSavail ||
                tipusBloc == Constants.idSunavail) {

            botoStorage.setVisible(true);
            jLabelA.setText(Constants.A);
            TextB.setVisible(false);
            TextC.setVisible(false);
            TextD.setVisible(false);
            TextE.setVisible(false);
            TextF.setVisible(false);
            textA.setEnabled(false);
        }

    }

    private void pintarBloc(Bloc b, int caso) {

        textDescripcio.setText(b.getComentari());
        jTextFielLabel.setText(b.getLabel());
        if (caso == Constants.ConsultarBloc) {
            botoCancel.setVisible(false);
        }
        switch (b.getId()) {
            case Constants.idGenerate:
                Generate g = (Generate) b;
                jLabelA.setText(Constants.A);
                textA.setText(Float.toString(g.getA()));
                //textA.setCaret(Caret.)
                jLabelB.setText(Constants.B);
                TextB.setText(Float.toString(g.getB()));
                jLabelC.setText(Constants.C);
                TextC.setText(Float.toString(g.getC()));
                jLabelD.setText(Constants.C);
                TextD.setText(Float.toString(g.getD()));
                jLabelE.setText(Constants.E);
                TextE.setText(Float.toString(g.getE()));
                jLabelF.setText(Constants.F);
                TextF.setText(Integer.toString(g.getF()));
                //    jLabelG.setText(Constants.tempsEntreArribades);

                dibuixarBloc(Constants.UrlGenerate);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                    TextC.setEnabled(false);
                    TextE.setEnabled(false);
                    TextD.setEnabled(false);
                    TextF.setEnabled(false);
                //     TextG.setEnabled(false);
                }

                break;
            case Constants.idFunavail:
                Funavail Fun = (Funavail) b;
                jLabelA.setText(Constants.A);
                textA.setText(Float.toString(Fun.getA()));
                //textA.setCaret(Caret.)
                jLabelB.setText(Constants.B);
                TextB.setText(Float.toString(Fun.getB()));
                jLabelC.setText(Constants.C);
                TextC.setText(Float.toString(Fun.getC()));
                jLabelD.setText(Constants.C);
                TextD.setText(Float.toString(Fun.getD()));
                jLabelE.setText(Constants.E);
                TextE.setText(Float.toString(Fun.getE()));
                jLabelF.setText(Constants.F);
                TextF.setText(Integer.toString(Fun.getF()));
                //    jLabelG.setText(Constants.tempsEntreArribades);

                dibuixarBloc(Constants.UrlFunavail);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                    TextC.setEnabled(false);
                    TextE.setEnabled(false);
                    TextD.setEnabled(false);
                    TextF.setEnabled(false);
                //     TextG.setEnabled(false);
                }

                break;

            case Constants.idTerminate:
                jLabelA.setText(Constants.A);
                Terminate t = (Terminate) b;
                textA.setText(Integer.toString(t.getA()));
                TextB.setVisible(false);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //  TextG.setVisible(false);
                dibuixarBloc(Constants.UrlTerminate);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                }
                break;
            case Constants.idRelease:
                jLabelA.setText(Constants.A);
                Release r = (Release) b;
                textA.setText(r.getA());
                TextB.setVisible(false);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //  TextG.setVisible(false);
                dibuixarBloc(Constants.UrlRelease);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);

                }
                break;
            case Constants.idSeize:
                jLabelA.setText(Constants.A);
                Seize s = (Seize) b;
                textA.setText(s.getA());
                TextB.setVisible(false);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //  TextG.setVisible(false);
                dibuixarBloc(Constants.UrlSeize);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                }
                break;
            case Constants.idAdvanced:
                jLabelA.setText(Constants.A);
                jLabelB.setText(Constants.B);
                Advance a = (Advance) b;
                textA.setText(Float.toString(a.getA()));
                TextB.setText(Float.toString(a.getB()));
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //    TextG.setVisible(false);
                dibuixarBloc(Constants.UrlAdvanced);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                }
                break;
            case Constants.idAssign:
                jLabelA.setText(Constants.A);
                jLabelB.setText(Constants.B);
                Assign as = (Assign) b;
                textA.setText(as.getA());
                TextB.setText(Float.toString(as.getB()));
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //    TextG.setVisible(false);
                dibuixarBloc(Constants.UrlAssign);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                }
                break;
            case Constants.idDepart:
                jLabelA.setText(Constants.A);
                jLabelB.setText(Constants.B);
                Depart d = (Depart) b;
                textA.setText(d.getA());
                TextB.setText(Integer.toString(d.getB()));
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //     TextG.setVisible(false);
                dibuixarBloc(Constants.UrlDepart);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                }
                break;
            case Constants.idQueue:
                jLabelA.setText(Constants.A);
                jLabelB.setText(Constants.B);
                Queue q = (Queue) b;
                textA.setText(q.getA());
                TextB.setText(Integer.toString(q.getB()));
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //    TextG.setVisible(false);
                dibuixarBloc(Constants.UrlQueue);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                }
                break;
            case Constants.idEnter:
                jLabelA.setText(Constants.A);
                jLabelB.setText(Constants.B);
                Enter e = (Enter) b;
                textA.setText(e.getA());
                TextB.setText(Integer.toString(e.getB()));
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //     TextG.setVisible(false);
                dibuixarBloc(Constants.UrlEnter);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                } else if (caso == Constants.ModificarBloc) {
                    textA.setEnabled(false);
                    botoStorage.setVisible(true);
                }
                break;
            case Constants.idLeave:
                jLabelA.setText(Constants.A);
                jLabelB.setText(Constants.B);
                Leave l = (Leave) b;
                textA.setText(l.getA());
                TextB.setText(Integer.toString(l.getB()));
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //    TextG.setVisible(false);
                dibuixarBloc(Constants.UrlLeave);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                } else if (caso == Constants.ModificarBloc) {
                    textA.setEnabled(false);
                    botoStorage.setVisible(true);
                }
                break;

            case Constants.idTest:
                comboOp.setVisible(true);
                jLabelA.setText(Constants.A);
                jLabelB.setText(Constants.B);
                jLabelC.setText(Constants.C);
                jLabelX.setText(Constants.X);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //    TextG.setVisible(false);
                Test test = (Test) b;


                comboOp.setModel(new javax.swing.DefaultComboBoxModel(this.generarVectorTest()));
                textA.setText(test.getA());
                TextB.setText(test.getB());
                TextC.setText(test.getC());
                comboOp.setSelectedItem(test.getX());

                dibuixarBloc(Constants.UrlTest);
                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                    TextC.setEnabled(false);
                    comboOp.setEnabled(false);
                }
                break;
            case Constants.idTransfer:
                comboOp.setVisible(true);
                jLabelA.setText(Constants.B);
                jLabelB.setText(Constants.C);
                jLabelC.setText(Constants.D);
                jLabelX.setText(Constants.A);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //     TextG.setVisible(false);
                Transfer transfer = (Transfer) b;


                comboOp.setModel(new javax.swing.DefaultComboBoxModel(this.generarVectorTransfer()));
                textA.setText(transfer.getB());
                TextB.setText(transfer.getC());
                TextC.setText(transfer.getD());
                comboOp.setSelectedItem(transfer.getA());

                dibuixarBloc(Constants.UrlTransfer);
                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                    TextC.setEnabled(false);
                    comboOp.setEnabled(false);
                }

                break;
            case Constants.idLogic:
                comboOp.setVisible(true);
                jLabelA.setText(Constants.A);
                jLabelX.setText(Constants.X);
                TextB.setVisible(false);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //    TextG.setVisible(false);
                Logic log = (Logic) b;


                comboOp.setModel(new javax.swing.DefaultComboBoxModel(this.generarVectorLogic()));
                textA.setText(log.getA());
                comboOp.setSelectedItem(log.getX());

                dibuixarBloc(Constants.UrlLogic);
                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    comboOp.setEnabled(false);
                }
                break;
            case Constants.idGate:
                comboOp.setVisible(true);
                jLabelA.setText(Constants.A);
                jLabelB.setText(Constants.B);
                jLabelX.setText(Constants.X);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //  TextG.setVisible(false);
                Gate gate = (Gate) b;


                comboOp.setModel(new javax.swing.DefaultComboBoxModel(this.generarVectorGate()));
                textA.setText(gate.getA());
                TextB.setText(gate.getB());
                comboOp.setSelectedItem(gate.getX());

                dibuixarBloc(Constants.UrlGate);
                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                    comboOp.setEnabled(false);
                }
                break;
            case Constants.idSavevavg:
                jLabelA.setText(Constants.A);
                jLabelB.setText(Constants.B);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //   TextG.setVisible(false);
                Savevalue sav = (Savevalue) b;
                textA.setText(sav.getA());
                TextB.setText(sav.getB());
                dibuixarBloc(Constants.UrlSavevavg);
                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                }
                break;
            case Constants.idLoop:
                jLabelA.setText(Constants.A);
                jLabelB.setText(Constants.B);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //        TextG.setVisible(false);
                Loop loop = (Loop) b;
                textA.setText(loop.getA());
                TextB.setText(loop.getB());
                dibuixarBloc(Constants.UrlLoop);
                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                }
                break;

            case Constants.idSplit:
                jLabelA.setText(Constants.A);
                jLabelB.setText(Constants.B);
                jLabelC.setText(Constants.C);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //     TextG.setVisible(false);
                Split split = (Split) b;
                textA.setText(Integer.toString(split.getA()));
                TextB.setText(split.getB());
                TextC.setText(split.getC());
                dibuixarBloc(Constants.UrlSplit);
                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                    TextB.setEnabled(false);
                    TextC.setEnabled(false);
                }
                break;

            case Constants.idFavail:
                jLabelA.setText(Constants.A);
                Favail f = (Favail) b;
                textA.setText(Integer.toString(f.getA()));
                TextB.setVisible(false);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //  TextG.setVisible(false);
                dibuixarBloc(Constants.UrlTerminate);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                }
                break;
            case Constants.idSavail:
                jLabelA.setText(Constants.A);
                Savail savail = (Savail) b;
                textA.setText(savail.getA());
                TextB.setVisible(false);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //     TextG.setVisible(false);
                dibuixarBloc(Constants.UrlSavail);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                } else if (caso == Constants.ModificarBloc) {
                    textA.setEnabled(false);
                    botoStorage.setVisible(true);
                }
                break;
            case Constants.idSunavail:
                jLabelA.setText(Constants.A);
                Sunavail sunavail = (Sunavail) b;
                textA.setText(sunavail.getA());
                TextB.setVisible(false);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //     TextG.setVisible(false);
                dibuixarBloc(Constants.UrlSunavail);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                } else if (caso == Constants.ModificarBloc) {
                    textA.setEnabled(false);
                    botoStorage.setVisible(true);
                }
                break;
            case Constants.idAssemble:
                jLabelA.setText(Constants.A);
                Assemble ass = (Assemble) b;
                textA.setText(Integer.toString(ass.getA()));
                TextB.setVisible(false);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //    TextG.setVisible(false);
                dibuixarBloc(Constants.UrlAssemble);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                }
                break;

            case Constants.idGather:
                jLabelA.setText(Constants.A);
                Gather gather = (Gather) b;
                textA.setText(Integer.toString(gather.getA()));
                TextB.setVisible(false);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //   TextG.setVisible(false);
                dibuixarBloc(Constants.UrlGather);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                }
                break;

            case Constants.idMatch:
                jLabelA.setText(Constants.A);
                Match m = (Match) b;
                textA.setText(m.getA());
                TextB.setVisible(false);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //TextG.setVisible(false);
                dibuixarBloc(Constants.UrlMatch);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                }
                break;
            case Constants.idPriority:
                jLabelA.setText(Constants.A);
                Priority pri = (Priority) b;
                textA.setText(Integer.toString(pri.getA()));
                TextB.setVisible(false);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                //  TextG.setVisible(false);
                dibuixarBloc(Constants.UrlPriority);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                }
                break;
            case Constants.idBuffer:
                textA.setVisible(false);
                TextB.setVisible(false);
                TextC.setVisible(false);
                TextD.setVisible(false);
                TextE.setVisible(false);
                TextF.setVisible(false);
                // TextG.setVisible(false);
                dibuixarBloc(Constants.UrlBuffer);

                if (caso == Constants.ConsultarBloc) {
                    textDescripcio.setEnabled(false);
                    jTextFielLabel.setEnabled(false);
                    textA.setEnabled(false);
                }
                break;

            default:
                generarPantallaError(Constants.errorconsultarbloc);
                break;

        }



    }

    private void dibuixarBloc(String url) {

        ImageIcon imagen = new ImageIcon(url);
        jLabel2.setSize(imagen.getIconHeight(), imagen.getIconWidth());
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(url)));

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textDescripcio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textA = new javax.swing.JTextField();
        TextB = new javax.swing.JTextField();
        TextC = new javax.swing.JTextField();
        TextD = new javax.swing.JTextField();
        TextE = new javax.swing.JTextField();
        TextF = new javax.swing.JTextField();
        botoCancel = new javax.swing.JButton();
        botoOK = new javax.swing.JButton();
        jLabelA = new javax.swing.JLabel();
        jLabelB = new javax.swing.JLabel();
        jLabelC = new javax.swing.JLabel();
        jLabelD = new javax.swing.JLabel();
        jLabelE = new javax.swing.JLabel();
        jLabelF = new javax.swing.JLabel();
        botoStorage = new javax.swing.JButton();
        comboOp = new javax.swing.JComboBox();
        jLabelX = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFielLabel = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("BLOC COMMENTS");

        textDescripcio.setText("<<--comment-->>");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setOpaque(true);

        botoCancel.setText("Cancel");
        botoCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoCancelActionPerformed(evt);
            }
        });

        botoOK.setText("OK");
        botoOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoOKActionPerformed(evt);
            }
        });

        jLabelA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        botoStorage.setText("storages...");
        botoStorage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoStorageActionPerformed(evt);
            }
        });

        jLabelX.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("LABEL");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(botoCancel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(botoOK, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabelF, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .add(jLabelE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .add(jLabelD, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabelA, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabelB, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabelC, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabelX, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(TextC, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .add(TextB, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .add(textA, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(comboOp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 31, Short.MAX_VALUE)
                                .add(botoStorage))
                            .add(TextD, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .add(TextE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .add(TextF, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 21, Short.MAX_VALUE)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTextFielLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, textDescripcio, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(32, 32, 32)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(8, 8, 8)
                        .add(jLabel1))
                    .add(textDescripcio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextFielLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabelX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(comboOp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(botoStorage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(8, 8, 8)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLabelA, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(textA, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLabelB, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(TextB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(TextC, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(7, 7, 7)
                        .add(jLabelC, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                .add(3, 3, 3)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabelD, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, TextD, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jLabelE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(TextE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabelF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(TextF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(botoOK)
                    .add(botoCancel))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        VarGlobals.continuar = false;
        setVisible(false);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    private void botoStorageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoStorageActionPerformed
        PantallaStorages descBloc = new PantallaStorages(true);
        descBloc.setLocationRelativeTo(this);

        descBloc.setVisible(true);
        descBloc.dispose();

        if (VarGlobals.continuar) {
            textA.setText(VarGlobals.nomStorageSeleccionat);
        }
    }//GEN-LAST:event_botoStorageActionPerformed

    private void botoCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoCancelActionPerformed

        VarGlobals.continuar = false;
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botoCancelActionPerformed

    private void botoOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoOKActionPerformed
// cogemos la descripci�n
        boolean tancarPantalla = true;
        //bl.setLabel(b);
        //VarGlobals.bloc=bl;
        VarGlobals.continuar = true;
        String strX = "";
        try {
            if (b == Constants.idGenerate) {
                //TODO validar los valores de entrada!!!!!!!
                Generate g;
                comprovarValorsPerDefecte(Constants.idGenerate);

                g = new Generate(textDescripcio.getText(), jTextFielLabel.getText(),
                        Float.valueOf(textA.getText()).floatValue(),
                        Float.valueOf(TextB.getText()).floatValue(),
                        Float.valueOf(TextC.getText()).floatValue(),
                        Float.valueOf(TextD.getText()).floatValue(),
                        Float.valueOf(TextE.getText()).floatValue(),
                        Integer.parseInt(TextF.getText()));

                VarGlobals.bloc = g;
            } else if (b == Constants.idTerminate) {
                Terminate t;
                comprovarValorsPerDefecte(Constants.idTerminate);
                t = new Terminate(textDescripcio.getText(), jTextFielLabel.getText(),
                        Integer.parseInt(textA.getText()));
                VarGlobals.bloc = t;
            } else if (b == Constants.idAdvanced) {
                Advance a;
                comprovarValorsPerDefecte(Constants.idAdvanced);
                a = new Advance(textDescripcio.getText(), jTextFielLabel.getText(),
                        Float.valueOf(textA.getText()).floatValue(),
                        Float.valueOf(TextB.getText()).floatValue());

                VarGlobals.bloc = a;
            } else if (b == Constants.idAssign) {
                Assign as;
                comprovarValorsPerDefecte(Constants.idAssign);
                as = new Assign(textDescripcio.getText(), jTextFielLabel.getText(),
                        textA.getText(),
                        Float.valueOf(TextB.getText()).floatValue());

                VarGlobals.bloc = as;
            } else if (b == Constants.idDepart) {
                Depart d;
                if (!textA.getText().equals("")) {
                    comprovarValorsPerDefecte(Constants.idDepart);
                    d = new Depart(textDescripcio.getText(), jTextFielLabel.getText(),
                            textA.getText(),
                            Integer.parseInt(TextB.getText()));
                    VarGlobals.bloc = d;
                } else {
                    generarPantallaError(Constants.ErrorFaltaA);
                    tancarPantalla = false;
                }
            } else if (b == Constants.idQueue) {
                Queue q;
                if (!textA.getText().equals("")) {
                    comprovarValorsPerDefecte(Constants.idQueue);
                    q = new Queue(textDescripcio.getText(), jTextFielLabel.getText(),
                            textA.getText(),
                            Integer.parseInt(TextB.getText()));
                    VarGlobals.bloc = q;
                } else {
                    generarPantallaError(Constants.ErrorFaltaA);
                    tancarPantalla = false;
                }
            } else if (b == Constants.idEnter) {
                Enter e;
                comprovarValorsPerDefecte(Constants.idEnter);
                if (!textA.getText().equals("")) {
                    e = new Enter(textDescripcio.getText(), jTextFielLabel.getText(),
                            textA.getText(),
                            Integer.parseInt(TextB.getText()));
                    VarGlobals.bloc = e;
                } else {
                    //error pero que no hi ha storage
                    generarPantallaError(Constants.ErrorFaltaStorage);
                    tancarPantalla = false;

                }
            } else if (b == Constants.idLeave) {
                Leave l;
                comprovarValorsPerDefecte(Constants.idLeave);
                if (!textA.getText().equals("")) {
                    l = new Leave(textDescripcio.getText(), jTextFielLabel.getText(),
                            textA.getText(),
                            Integer.parseInt(TextB.getText()));
                    VarGlobals.bloc = l;
                } else {
                    //error pero que no hi ha storage
                    generarPantallaError(Constants.ErrorFaltaStorage);
                    tancarPantalla = false;

                }
            } else if (b == Constants.idRelease) {
                Release r;
                if (!textA.getText().equals("")) {
                    r = new Release(textDescripcio.getText(), jTextFielLabel.getText(),
                            textA.getText());
                    VarGlobals.bloc = r;
                } else {
                    generarPantallaError(Constants.ErrorFaltaA);
                    tancarPantalla = false;
                }
            } else if (b == Constants.idSeize) {
                Seize s;
                if (!textA.getText().equals("")) {
                    s = new Seize(textDescripcio.getText(), jTextFielLabel.getText(),
                            textA.getText());
                    VarGlobals.bloc = s;
                } else {
                    generarPantallaError(Constants.ErrorFaltaA);
                    tancarPantalla = false;
                }
            } else if (b == Constants.idTest) {
                Test t;
                strX = (String) comboOp.getSelectedItem();
                if (!strX.equals("")) {
                    if (!textA.getText().equals("")) {
                        comprovarValorsPerDefecte(Constants.idTest);
                        t = new Test(textDescripcio.getText(), jTextFielLabel.getText(),
                                strX,
                                textA.getText(), TextB.getText(), TextC.getText());
                        VarGlobals.bloc = t;
                    } else {
                        generarPantallaError(Constants.ErrorFaltaA);
                        tancarPantalla = false;
                    }
                } else {
                    generarPantallaError(Constants.ErrorFaltaX);
                    tancarPantalla = false;
                }
            } else if (b == Constants.idTransfer) {
                Transfer transfer;
                strX = (String) comboOp.getSelectedItem();
                if (!strX.equals("")) {
                    comprovarValorsPerDefecte(Constants.idTransfer);
                    transfer = new Transfer(textDescripcio.getText(), jTextFielLabel.getText(),
                            strX,
                            textA.getText(), TextB.getText(), TextC.getText());
                    VarGlobals.bloc = transfer;
                } else {
                    generarPantallaError(Constants.ErrorFaltaA);
                    tancarPantalla = false;
                }

            } else if (b == Constants.idLogic) {
                Logic log;
                if (!textA.getText().equals("")) {
                    log = new Logic(textDescripcio.getText(), jTextFielLabel.getText(),
                            (String) comboOp.getSelectedItem(),
                            textA.getText());
                    VarGlobals.bloc = log;
                } else {
                    generarPantallaError(Constants.ErrorFaltaA);
                    tancarPantalla = false;
                }
            } else if (b == Constants.idGate) {
                Gate gat;
                Transfer transfer;
                strX = (String) comboOp.getSelectedItem();
                if (!strX.equals("")) {
                    if (!textA.getText().equals("")) {
                        gat = new Gate(textDescripcio.getText(), jTextFielLabel.getText(),
                                (String) comboOp.getSelectedItem(),
                                textA.getText(),
                                TextB.getText());
                        VarGlobals.bloc = gat;
                    } else {
                        generarPantallaError(Constants.ErrorFaltaA);
                        tancarPantalla = false;
                    }
                } else {
                    generarPantallaError(Constants.ErrorFaltaX);
                    tancarPantalla = false;
                }
            } else if (b == Constants.idSavevavg) {
                Savevalue sav;
                if (!textA.getText().equals("")) {
                    comprovarValorsPerDefecte(Constants.idSavevavg);
                    sav = new Savevalue(textDescripcio.getText(), jTextFielLabel.getText(),
                            textA.getText(),
                            TextB.getText());

                    VarGlobals.bloc = sav;
                } else {
                    generarPantallaError(Constants.ErrorFaltaA);
                    tancarPantalla = false;
                }
            } else if (b == Constants.idLoop) {
                Loop loop;
                if (!textA.getText().equals("")) {
                    loop = new Loop(textDescripcio.getText(), jTextFielLabel.getText(),
                            textA.getText(),
                            TextB.getText());
                    VarGlobals.bloc = loop;
                } else {
                    generarPantallaError(Constants.ErrorFaltaA);
                    tancarPantalla = false;
                }
            } else if (b == Constants.idSplit) {
                Split split;
                if (!textA.getText().equals("")) {
                    comprovarValorsPerDefecte(Constants.idSplit);
                    split = new Split(textDescripcio.getText(), jTextFielLabel.getText(),
                            Integer.parseInt(textA.getText()),
                            TextB.getText(),
                            TextC.getText());

                    VarGlobals.bloc = split;
                } else {
                    generarPantallaError(Constants.ErrorFaltaA);
                    tancarPantalla = false;
                }

            }
            if (b == Constants.idFunavail) {
                //TODO validar los valores de entrada!!!!!!!
                Funavail f;
                comprovarValorsPerDefecte(Constants.idFunavail);

                f = new Funavail(textDescripcio.getText(), jTextFielLabel.getText(),
                        Float.valueOf(textA.getText()).floatValue(),
                        Float.valueOf(TextB.getText()).floatValue(),
                        Float.valueOf(TextC.getText()).floatValue(),
                        Float.valueOf(TextD.getText()).floatValue(),
                        Float.valueOf(TextE.getText()).floatValue(),
                        Integer.parseInt(TextF.getText()));

                VarGlobals.bloc = f;

            } else if (b == Constants.idSavail) {
                Savail savail;
                if (!textA.getText().equals("")) {
                    savail = new Savail(textDescripcio.getText(), jTextFielLabel.getText(),
                            textA.getText());
                    VarGlobals.bloc = savail;
                } else {
                    //error pero que no hi ha storage
                    generarPantallaError(Constants.ErrorFaltaStorage);
                    tancarPantalla = false;
                }
            } else if (b == Constants.idSunavail) {
                Sunavail sunavail;
                if (!textA.getText().equals("")) {
                    sunavail = new Sunavail(textDescripcio.getText(), jTextFielLabel.getText(),
                            textA.getText());
                    VarGlobals.bloc = sunavail;
                } else {
                    //error pero que no hi ha storage
                    generarPantallaError(Constants.ErrorFaltaStorage);
                    tancarPantalla = false;
                }
            } else if (b == Constants.idAssemble) {
                Assemble ass;
                comprovarValorsPerDefecte(Constants.idAssemble);
                ass = new Assemble(textDescripcio.getText(), jTextFielLabel.getText(),
                        Integer.parseInt(textA.getText()));
                VarGlobals.bloc = ass;
            } else if (b == Constants.idGather) {
                Gather gather;
                comprovarValorsPerDefecte(Constants.idGather);
                gather = new Gather(textDescripcio.getText(), jTextFielLabel.getText(),
                        Integer.parseInt(textA.getText()));
                VarGlobals.bloc = gather;
            } else if (b == Constants.idMatch) {
                Match m;
                if (!textA.getText().equals("")) {
                    m = new Match(textDescripcio.getText(), jTextFielLabel.getText(),
                            textA.getText());
                    VarGlobals.bloc = m;
                } else {
                    generarPantallaError(Constants.ErrorFaltaA);
                    tancarPantalla = false;
                }
            } else if (b == Constants.idBuffer) {
                Buffer buf;
                buf = new Buffer(textDescripcio.getText(), jTextFielLabel.getText());
                VarGlobals.bloc = buf;
            } else if (b == Constants.idPriority) {
                Priority pri;
                comprovarValorsPerDefecte(Constants.idPriority);
                pri = new Priority(textDescripcio.getText(), jTextFielLabel.getText(),
                        Integer.parseInt(textA.getText()));
                VarGlobals.bloc = pri;
            }
        } catch (NumberFormatException nf) {
            //si les dades s�n incorrectes o falten dades
            generarPantallaError(Constants.errorDades);
            tancarPantalla = false;

        }
        if (tancarPantalla) {
            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_botoOKActionPerformed

    private void comprovarValorsPerDefecte(int caso) {

        switch (caso) {
            case Constants.idGenerate:
                if (textA.getText().equals("") || (textA.getText() == null)) {
                    textA.setText("0");
                }
                if (TextB.getText().equals("") || (TextB.getText() == null)) {
                    TextB.setText("0");
                }
                if (TextC.getText().equals("") || (TextC.getText() == null)) {
                    TextC.setText("0");
                }
                if (TextD.getText().equals("") || (TextD.getText() == null)) {
                    TextD.setText("0");
                }
                if (TextE.getText().equals("") || (TextE.getText() == null)) {
                    TextE.setText("0");
                }
                if (TextF.getText().equals("") || (TextF.getText() == null)) {
                    TextF.setText("0");
                }
                /*if(TextG.getText().equals("")||(TextG.getText()==null)){
                TextG.setText("0");
                }*/


                break;

            case Constants.idTerminate:
            case Constants.idAssemble:
            case Constants.idGather:
            case Constants.idPriority:
            case Constants.idSplit:
                if (textA.getText().equals("") || (textA.getText() == null)) {
                    textA.setText("0");
                }
                break;

            case Constants.idAdvanced:
            case Constants.idTest:
                if (textA.getText().equals("") || (textA.getText() == null)) {
                    textA.setText("0");
                }
                if (TextB.getText().equals("") || (TextB.getText() == null)) {
                    TextB.setText("0");
                }
                break;
            case Constants.idQueue:
            case Constants.idDepart:
            case Constants.idEnter:
            case Constants.idLeave:
            case Constants.idSavevavg:
                if (TextB.getText().equals("") || (TextB.getText() == null)) {
                    TextB.setText("0");
                }
                break;
            case Constants.idTransfer:
                if (TextC.getText().equals("") || (TextC.getText() == null)) {
                    TextC.setText("0");
                }
                break;


            default:
                break;
        }

    }

    private void generarPantallaError(String mensage) {
        PantallaError perror = new PantallaError(mensage);
        perror.setLocationRelativeTo(this);

        perror.setVisible(true);
        perror.dispose();


    }

    private Vector generarVectorTest() {

        Vector vTest = new Vector();
        vTest.add("");
        vTest.add(Test.E);
        vTest.add(Test.G);
        vTest.add(Test.GE);
        vTest.add(Test.L);
        vTest.add(Test.LE);
        vTest.add(Test.NE);

        return vTest;


    }

    private Vector generarVectorTransfer() {

        Vector vTransfer = new Vector();
        vTransfer.add("");
        vTransfer.add(Transfer.All);
        vTransfer.add(Transfer.Both);
        vTransfer.add(Transfer.FN);
        vTransfer.add(Transfer.Fraccio);
        vTransfer.add(Transfer.Nombre);
        vTransfer.add(Transfer.P);
        vTransfer.add(Transfer.Pick);
        vTransfer.add(Transfer.SBR);
        vTransfer.add(Transfer.SNA);

        return vTransfer;


    }

    private Vector generarVectorLogic() {

        Vector vLogic = new Vector();
        vLogic.add("");
        vLogic.add(Logic.I);
        vLogic.add(Logic.R);
        vLogic.add(Logic.S);

        return vLogic;
    }

    private Vector generarVectorGate() {

        Vector vGate = new Vector();
        vGate.add("");
        vGate.add(Gate.LS);
        vGate.add(Gate.SF);
        vGate.add(Gate.NU);

        return vGate;


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextB;
    private javax.swing.JTextField TextC;
    private javax.swing.JTextField TextD;
    private javax.swing.JTextField TextE;
    private javax.swing.JTextField TextF;
    private javax.swing.JButton botoCancel;
    private javax.swing.JButton botoOK;
    private javax.swing.JButton botoStorage;
    private javax.swing.JComboBox comboOp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelA;
    private javax.swing.JLabel jLabelB;
    private javax.swing.JLabel jLabelC;
    private javax.swing.JLabel jLabelD;
    private javax.swing.JLabel jLabelE;
    private javax.swing.JLabel jLabelF;
    private javax.swing.JLabel jLabelX;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFielLabel;
    private javax.swing.JTextField textA;
    private javax.swing.JTextField textDescripcio;
    // End of variables declaration//GEN-END:variables
}
