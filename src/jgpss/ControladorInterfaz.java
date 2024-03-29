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
import java.awt.*;
import javax.swing.*;


/**
 *
 * @author  M.Dolores
 */
public class ControladorInterfaz extends javax.swing.JFrame implements Serializable {

    /** Creates new form ControladorInterfaz */
    public ControladorInterfaz() {
        initComponents();
        //comencem amb els menus de guardar desactivats
        //aquests s'activaran quan hi hagi un modelm creat
        SaveAs.setEnabled(false);
        SaveModel.setEnabled(false);
        storages.setEnabled(false);
        modelm.setEnabled(false);
        Ampervariables.setEnabled(false);
        Matrix.setEnabled(false);
        Functions.setEnabled(false);
        Initial.setEnabled(false);
        Configuration.setEnabled(false);
        Run.setEnabled(false);
        Step.setEnabled(false);
        //s'inicialitza a fals pq encara no hem guardat cap modelm
        VarGlobals.esGuardat = false;
        VarGlobals.esModificat = false;
        this.setTitle(Constants.tituloPrincipal);

    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ObrirModel = new javax.swing.JMenuItem();
        NewModel = new javax.swing.JMenuItem();
        SaveModel = new javax.swing.JMenuItem();
        SaveAs = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        modelm = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        storages = new javax.swing.JMenuItem();
        Functions = new javax.swing.JMenuItem();
        Matrix = new javax.swing.JMenuItem();
        Initial = new javax.swing.JMenuItem();
        Ampervariables = new javax.swing.JMenuItem();
        Simulation = new javax.swing.JMenu();
        Configuration = new javax.swing.JMenuItem();
        Run = new javax.swing.JMenuItem();
        Step = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        HelpContents = new javax.swing.JMenuItem();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jMenu1.setText("File");

        ObrirModel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Package.png"))); // NOI18N
        ObrirModel.setText("Open Model");
        ObrirModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObrirModelActionPerformed(evt);
            }
        });
        jMenu1.add(ObrirModel);

        NewModel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Note.png"))); // NOI18N
        NewModel.setText("New Model");
        NewModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewModelActionPerformed(evt);
            }
        });
        NewModel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewModelMouseClicked(evt);
            }
        });
        jMenu1.add(NewModel);

        SaveModel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save2.GIF"))); // NOI18N
        SaveModel.setText("Save Model");
        SaveModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveModelActionPerformed(evt);
            }
        });
        jMenu1.add(SaveModel);

        SaveAs.setText("        Save Model As");
        SaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAsActionPerformed(evt);
            }
        });
        jMenu1.add(SaveAs);

        Exit.setText("        Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu1.add(Exit);

        jMenuBar1.add(jMenu1);

        Edit.setText("Edit");

        modelm.setText("Model");
        modelm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelmActionPerformed(evt);
            }
        });
        Edit.add(modelm);
        Edit.add(jSeparator1);

        storages.setText("Storages");
        storages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storagesActionPerformed(evt);
            }
        });
        Edit.add(storages);

        Functions.setText("Functions");
        Functions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FunctionsActionPerformed(evt);
            }
        });
        Edit.add(Functions);

        Matrix.setText("Matrix");
        Matrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatrixActionPerformed(evt);
            }
        });
        Edit.add(Matrix);

        Initial.setText("Initial");
        Initial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InitialActionPerformed(evt);
            }
        });
        Edit.add(Initial);

        Ampervariables.setText("Ampervariables");
        Ampervariables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmpervariablesActionPerformed(evt);
            }
        });
        Edit.add(Ampervariables);

        jMenuBar1.add(Edit);

        Simulation.setText("Simulation");

        Configuration.setText("Configuration");
        Configuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigurationActionPerformed(evt);
            }
        });
        Simulation.add(Configuration);

        Run.setText("Run");
        Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunActionPerformed(evt);
            }
        });
        Simulation.add(Run);

        Step.setText("Step");
        Step.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StepActionPerformed(evt);
            }
        });
        Simulation.add(Step);

        jMenuBar1.add(Simulation);

        Help.setText("Help");

        HelpContents.setText("Help contents");
        HelpContents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpContentsActionPerformed(evt);
            }
        });
        Help.add(HelpContents);

        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        Help.add(about);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 738, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 570, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
           
          PantallaAbout pa = new PantallaAbout();
          pa.setLocationRelativeTo(this);
          pa.setVisible(true);
          pa.dispose();
    }//GEN-LAST:event_aboutActionPerformed

    private void HelpContentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpContentsActionPerformed

          PantallaAjuda pa = new PantallaAjuda();
          pa.setLocationRelativeTo(this);
          pa.setVisible(true);
          pa.dispose();
    }//GEN-LAST:event_HelpContentsActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
  if((VarGlobals.model!=null)&&(VarGlobals.esModificat)){
        int sel=mostrarDialogo(Constants.guardar, Constants.salir,Constants.SalirAplicacion, Constants.caution);

                            if ( sel != 0 )
                            {
                                    setVisible(false);
                                    dispose();
                                    //return;
                            }
                            else{
                                if (VarGlobals.urlGuardar!=null){
                                    guardar();
                                }
                                else{
                                    guardarComo();
                                }
                            }
           }
  //tancar la pantalla principal
    setVisible(false);
    dispose();
 
    }//GEN-LAST:event_ExitActionPerformed

    private void modelmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelmActionPerformed

        PantallaOpenNewModel  pOpenModel = new PantallaOpenNewModel(VarGlobals.model.getNomModel(), VarGlobals.model.getDescripModel());
        pOpenModel.setLocationRelativeTo(this);
        pOpenModel.setVisible(true);
        pOpenModel.dispose();
}//GEN-LAST:event_modelmActionPerformed

    private void storagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storagesActionPerformed

        PantallaStorages descBloc = new PantallaStorages(false);
           descBloc.setLocationRelativeTo(this);
        
           descBloc.setVisible(true);
           descBloc.dispose();
    }//GEN-LAST:event_storagesActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    private void ObrirModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObrirModelActionPerformed
  if(VarGlobals.model!=null){
            int sel=mostrarDialogo(Constants.Si, Constants.cancel,Constants.Seguro, Constants.caution);
            if (sel==0){
                if(VarGlobals.esModificat){
                    sel=mostrarDialogo(Constants.guardar, Constants.cancel,Constants.SalirAplicacion, Constants.caution);
                      if ( sel != 0 )
                                    {
                                         abrirModel();
                                    }
                      else{
                        guardarModel();
                        abrirModel();
                      }
                }
                else{
                    abrirModel();
                
                }
            }
            else return;
        }
        else{
            abrirModel();
        
        }

    }//GEN-LAST:event_ObrirModelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      if((VarGlobals.model!=null)&&(VarGlobals.esModificat)){
        int sel=mostrarDialogo(Constants.guardar, Constants.salir,Constants.SalirAplicacion, Constants.caution);

                            if ( sel != 0 )
                            {
                                    return;
                            }
                            else{
                                if (VarGlobals.urlGuardar!=null){
                                    guardar();
                                }
                                else{
                                    guardarComo();
                                }
                            }
           }
    }//GEN-LAST:event_formWindowClosing
    private int mostrarDialogo(String opcion1, String opcion2, String mensaje, String titulo){
    int sel = 0;
    
    Object[] options = {
                                    opcion1,
                                    opcion2
                            };

                            sel = javax.swing.JOptionPane.showOptionDialog(
                                    frame,
                                   mensaje,
                                    titulo,
                               javax.swing.JOptionPane.DEFAULT_OPTION,
                               javax.swing.JOptionPane.WARNING_MESSAGE,
                                    null,
                                    options, options[0]
                            );
    return sel;

}
    private void SaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveAsActionPerformed
    
     guardarComo();
        
    }//GEN-LAST:event_SaveAsActionPerformed

    private void SaveModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveModelActionPerformed
        guardarModel();
    }//GEN-LAST:event_SaveModelActionPerformed

    private void guardarModel(){
      //si no se ha guardado antes hacemos un guardar como
        if(!VarGlobals.esGuardat){
            guardarComo();
        }
        else{
        //simplemente guardar en la ruta
           guardar();
        }
    }
    private void NewModelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewModelMouseClicked
// TODO add your handling code here:
      
    }//GEN-LAST:event_NewModelMouseClicked

    private void NewModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewModelActionPerformed

        if(VarGlobals.model!=null){
            int sel=mostrarDialogo(Constants.Si, Constants.cancel,Constants.Seguro, Constants.caution);
            if (sel==0){
                if(VarGlobals.esModificat){
                    sel=mostrarDialogo(Constants.guardar, Constants.cancel,Constants.SalirAplicacion, Constants.caution);
                      if ( sel != 0 )
                                    {
                                         mostrarNewModel();
                                    }
                      else{
                        guardarModel();
                        mostrarNewModel();
                      }
                }
                else{
                    mostrarNewModel();
                
                }
            }
            else return;
        }
        else{
            mostrarNewModel();
        
        }
    }//GEN-LAST:event_NewModelActionPerformed

    private void RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunActionPerformed

        //TODO: you must complete the execution of this part of the code.
        //mostrarDialogo("Ok", "Cancel", "This optinon is not implemented. Refer the JGPSS manual.", "Warning");
        Model model = VarGlobals.model;
        if (model==null) return;

        model.TC=VarGlobals.TC;
        model.execute(false);
}//GEN-LAST:event_RunActionPerformed

    private void ConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigurationActionPerformed
        
        //TODO: you must complete the execution of this part of the code.
        //mostrarDialogo("Ok", "Cancel", "This optinon is not implemented. Refer the JGPSS manual.", "Warning");

        PantallaConfiguration Pant = new PantallaConfiguration(this, true);
        Pant.setLocationRelativeTo(this);
        Pant.setVisible(true);
        //Pant.dispose();
    }//GEN-LAST:event_ConfigurationActionPerformed

    private void FunctionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FunctionsActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_FunctionsActionPerformed

    private void MatrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatrixActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_MatrixActionPerformed

    private void InitialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InitialActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_InitialActionPerformed

    private void StepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StepActionPerformed
        
        //TODO: you must complete the execution of this part of the code.
        mostrarDialogo("Ok", "Cancel", "This optinon is not implemented. Refer the JGPSS manual.", "Warning");

        //Es crea la nova pantalla.
        PantallaRun Pant=new PantallaRun(this,true);
        Pant.setLocationRelativeTo(this);
        Pant.setVisible(true);

        Model model = VarGlobals.model;
        if (model==null) return;

        model.TC=VarGlobals.TC;
        model.execute(true);

        //S'asigna el model a executar a la pantalla de simulaci� de pas a pas.
        Pant.model=model;
    }//GEN-LAST:event_StepActionPerformed

    private void AmpervariablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmpervariablesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmpervariablesActionPerformed
 
    
    private void mostrarNewModel(){
    //buidar les variables globals, ja que comencem un modelm nou
        
        VarGlobals.limpiarGlobales();
        
// cridem a la Pantalla per crear un nou modelm
        PantallaOpenNewModel  pOpenModel = new PantallaOpenNewModel();
        pOpenModel.setLocationRelativeTo(this);
        pOpenModel.setVisible(true);
        pOpenModel.dispose();

        if (VarGlobals.continuar) {
            VarGlobals.esModificat = true;
            this.getContentPane().removeAll();
            SaveAs.setEnabled(true);
            SaveModel.setEnabled(true);
            storages.setEnabled(true);
            modelm.setEnabled(true);
            Ampervariables.setEnabled(true);
            Matrix.setEnabled(true);
            Functions.setEnabled(true);
            Initial.setEnabled(true);
            Configuration.setEnabled(true);
            Run.setEnabled(true);
            Step.setEnabled(true);

            PanelModelGpss jp = new PanelModelGpss();
            this.obrirJPanel(jp);

        }
    }
    
    private void obrirJPanel(javax.swing.JPanel jp){
     this.getContentPane().removeAll();
     jp.setSize(730,520);
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        pack();
    }
       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 try
                 {
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                   UIManager.put("JButton.background", Color.white);
                 }
                 catch(Exception e){}
                new ControladorInterfaz().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Ampervariables;
    private javax.swing.JMenuItem Configuration;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem Functions;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem HelpContents;
    private javax.swing.JMenuItem Initial;
    private javax.swing.JMenuItem Matrix;
    private javax.swing.JMenuItem NewModel;
    private javax.swing.JMenuItem ObrirModel;
    private javax.swing.JMenuItem Run;
    private javax.swing.JMenuItem SaveAs;
    private javax.swing.JMenuItem SaveModel;
    private javax.swing.JMenu Simulation;
    private javax.swing.JMenuItem Step;
    private javax.swing.JMenuItem about;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem modelm;
    private javax.swing.JMenuItem storages;
    // End of variables declaration//GEN-END:variables
    private JFrame frame;
    
    
    private void guardarComo(){
    try{
        //System.getProperty("user.dir") Abre el JFileChooser donde esta el ejecutable
          JFileChooser fc=new JFileChooser(System.getProperty("user.dir"));
          //filtrar per arxius txt
          FileFilterTxt filter = new FileFilterTxt();   
          fc.setFileFilter(filter);
          fc.setDialogType(JFileChooser.SAVE_DIALOG);
          fc.showSaveDialog(this); //Muestra el di�logo
          File Guardar =fc.getSelectedFile();
          if(Guardar !=null){
            VarGlobals.urlGuardar = fc.getSelectedFile().getAbsolutePath();
            if (new File(VarGlobals.urlGuardar).exists()){
                int sel =mostrarDialogo(Constants.sobreescribir,Constants.cancel,
                                Constants.elarchivo +
				Constants.saltoLinea +
				VarGlobals.urlGuardar +
				Constants.saltoLinea+
				Constants.archivoexiste,
                                Constants.caution
                        );
               

			if ( sel != 0 )
			{
				return;
			}
                        else{
                            VarGlobals.esModificat = false;
                            VarGlobals.esGuardat = true;
                            guardar();
                            return;
                        }
            }
            //mirar si l'artxiu t� extensi� .txt
            String nomFile =Guardar.getName();
            String extensio="";
            if(nomFile.length()>3)
                extensio= nomFile.substring(nomFile.length()-4);
            
            if(!extensio.equals(Constants.extensio)){       
                VarGlobals.dg.guardarTxt(Guardar+Constants.extensio);
                VarGlobals.urlGuardar+=Constants.extensio;
            }else{
                 VarGlobals.dg.guardarTxt(Guardar.getName());
            }
           
            VarGlobals.esModificat = false;
            VarGlobals.esGuardat = true;
           }
         }
         catch(IOException ioe){
         generarPantallaError(Constants.errortxt);
        } 
    
    }
    
    private void guardar(){
     try{
             VarGlobals.dg.guardarTxt(VarGlobals.urlGuardar);
             VarGlobals.esModificat=false;
            }
            catch(IOException ioe){
                generarPantallaError(Constants.errortxt);
        } 
    }
    private void abrirModel(){
        VarGlobals.Abrir=true;
      //  try{
        //System.getProperty("user.dir") Abre el JFileChooser donde esta el ejecutable
          JFileChooser fc=new JFileChooser(System.getProperty("user.dir"));
          //filtrar per arxius txt
          FileFilterTxt filter = new FileFilterTxt();   
          fc.setFileFilter(filter);
          int sel =fc.showOpenDialog(this); //Muestra el di�logo
          if(sel==0){
           try{
            File f = new File( fc.getSelectedFile().getAbsolutePath() );
            BufferedReader entrada = new BufferedReader( new FileReader( f ) );
            if ( f.exists() ){
               // try{
                  if( VarGlobals.dg.recuperarTxt(entrada)==0){
                       //abrir el panel
                       VarGlobals.urlGuardar = fc.getSelectedFile().getAbsolutePath();
                       VarGlobals.esGuardat= true;
                        //obrim el panel
                        SaveAs.setEnabled(true);
                        SaveModel.setEnabled(true);
                        storages.setEnabled(true);
                        modelm.setEnabled(true);
                        Ampervariables.setEnabled(true);
                        Matrix.setEnabled(true);
                        Functions.setEnabled(true);
                        Initial.setEnabled(true);
                        Configuration.setEnabled(true);
                        Run.setEnabled(true);
                        Step.setEnabled(true);
                // cridem a la Pantalla per crear un nou modelm

                        PanelModelGpss jp = new PanelModelGpss();
                        this.obrirJPanel(jp);
                        


                  }
                  else
                      generarPantallaError(Constants.errorRecuperar);
            }
            else{
                //no se ha podido leer? archivo vac�o
            }
           }
           catch(java.io.FileNotFoundException fnfex) {
                generarPantallaError(Constants.errorInterno+fnfex.toString());
 
            }
          }
          else return;
           
         }
     
    private void generarPantallaError(String mensage){
            PantallaError perror= new PantallaError(mensage);
            perror.setLocationRelativeTo(this);
        
             perror.setVisible(true);
             perror.dispose();
    
    
    }
    
    
   
}


