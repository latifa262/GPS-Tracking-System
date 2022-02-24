/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import entities.GPSTracker;
import entities.Vehicule;
import entities.VehiculeGPSTracker;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.GPSTrackerService;
import service.VehiculeGPSTrackerService;
import service.VehiculeService;


/**
 *
 * @author DELL
 */
public class VehiculegpstrackerForm extends javax.swing.JInternalFrame {
private GPSTrackerService ts;
private VehiculeService vs;
private DefaultTableModel model;
private VehiculeGPSTrackerService vgp;
private static int id;
    /**
     * Creates new form VehiculegpstrackerForm
     */
    public VehiculegpstrackerForm() {
        initComponents();
        ts = new GPSTrackerService();
        vs = new VehiculeService();
        vgp = new VehiculeGPSTrackerService();
        model = (DefaultTableModel) listevehiculetracker.getModel();
        loadVehicules();
        loadTrackers();
        loadVgptracker();
    }
      private void loadTrackers() {
         // listeTrackers.addItem("none");
        for (GPSTracker t : ts.findAll()) {
            listeTrackers.addItem(t);
        }
    }
      
      private void loadVehicules() {
        for (Vehicule v : vs.findAll()) {
            listevehicules.addItem(v);
    }
      }
       private void loadVgptracker() {
        model.setRowCount(0);
        for (VehiculeGPSTracker vgps : vgp.findAll()) {
            model.addRow(new Object[]{
                vgps.getId(),
                vgps.getDateDebut(),
                vgps.getDateFin(),
                vgps.getVehicule(),
                vgps.getGpsTracker(),
            });

        }
    }
       private static VehiculegpstrackerForm instane;
    public static VehiculegpstrackerForm getInstane() {
		if(instane == null)
                	instane = new VehiculegpstrackerForm();
		return instane;
	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        listevehicules = new javax.swing.JComboBox();
        listeTrackers = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listevehiculetracker = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("VehiculeGPSTracker"));

        jLabel1.setText("Vehicule");

        jLabel2.setText("GPSTracker");

        listevehicules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listevehiculesActionPerformed(evt);
            }
        });

        listeTrackers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeTrackersActionPerformed(evt);
            }
        });

        jButton1.setText("Affecter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Désaffecter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jButton1)
                .addGap(50, 50, 50)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listevehicules, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listeTrackers, 0, 164, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listevehicules, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(listeTrackers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listevehiculetracker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Datedebut", "Datefin", "Vehicule", "GPSTracker"
            }
        ));
        listevehiculetracker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listevehiculetrackerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listevehiculetracker);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Vehicule vehicule = (Vehicule) listevehicules.getSelectedItem();
        GPSTracker gps = (GPSTracker) listeTrackers.getSelectedItem();
         int reponse;
       for (VehiculeGPSTracker v : vgp.findAll())
        {
            if(((v.getGpsTracker().getId() == gps.getId()) || (v.getVehicule().getId() == vehicule.getId())) &  (v.getDateFin() == null)){
             reponse = JOptionPane.showConfirmDialog(this, "déja affecter ?,  voulez vous vraiment procéder  ?");
            if (!(reponse == 0)){ return;}
            else { v.setDateFin(new Date());
                  vgp.update(v);
                loadVgptracker();}
        }
        }
        
            
        if (vgp.create(new VehiculeGPSTracker(new Date(), gps, vehicule))) {
            JOptionPane.showMessageDialog(this, "affecter avec succee");
           loadVgptracker();
                    }
                    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listevehiculetrackerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listevehiculetrackerMouseClicked
        // TODO add your handling code here:
        // id = Integer.parseInt(model.getValueAt(listevehiculetracker.getSelectedRow(), 0).toString());
         
    }//GEN-LAST:event_listevehiculetrackerMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Vehicule vehicule = (Vehicule) listevehicules.getSelectedItem();
        GPSTracker gps = (GPSTracker) listeTrackers.getSelectedItem();
         int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment dissocier cette vehicule ?");
         if (reponse == 0) {
             for(VehiculeGPSTracker x : vgp.findAll()){
                 if(vehicule.getId()==(x.getVehicule().getId()) && x.getDateFin()==null){
                x.setDateFin(new Date());
                vgp.update(x);}
                loadVgptracker();
             }
         JOptionPane.showMessageDialog(this, "desaffecter avec succee");}
            
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void listeTrackersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeTrackersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listeTrackersActionPerformed

    private void listevehiculesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listevehiculesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listevehiculesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox listeTrackers;
    private javax.swing.JComboBox listevehicules;
    private javax.swing.JTable listevehiculetracker;
    // End of variables declaration//GEN-END:variables
}