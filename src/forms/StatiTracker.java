/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import entities.GPSTracker;
import entities.Position;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import service.GPSTrackerService;
import service.PositionService;
import service.VehiculeService;

/**
 *
 * @author DELL
 */
public class StatiTracker extends javax.swing.JInternalFrame {
 private GPSTrackerService ts;
 private PositionService ps;
  private VehiculeService vs;
    /**
     * Creates new form StatiTracker
     */
    public StatiTracker() {
        ts = new GPSTrackerService();
        initComponents();
        loadTrackers();
        
    }
    
    private void loadTrackers() {
        for (GPSTracker t : ts.findAll()) {
            listeTrackers.addItem(t);
        }
    }

    private static StatiTracker instane;
    public static StatiTracker getInstane() {
		if(instane == null)
                	instane = new StatiTracker();
		return instane;
	}
    
    
    public StatiTracker(GPSTracker t) {
        ps = new PositionService();
        ts = new GPSTrackerService();
        vs = new VehiculeService();
        // Create Dataset  
        CategoryDataset dataset = createDataset(t);

        //Create chart  
        JFreeChart chart = ChartFactory.createBarChart(
                "le tracker : " + t.getSimNumber(), //Chart Title  
                "par annee", // Category axis  
                "nombre de positions", // Value axis  
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new java.awt.Dimension(500, 500));
        setIconifiable(true);
        setContentPane(panel);
        setClosable(true);
        setMaximizable(true);
        pack();
    }
    
    private CategoryDataset createDataset(GPSTracker t) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Date date = new GregorianCalendar().getTime();
        for (Position p : ps.findAll()) {
            if (p.getDate().before(date)) {
                date = p.getDate();
                System.out.println(date);
            }
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int M = calendar.get(Calendar.YEAR );
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.setTime(new Date());

        for (int i = M-1; i <= ((calendar.get(Calendar.YEAR)) + 1); i++) {
            //Date seek1 = (new GregorianCalendar(2021, i,1)).getTime();
            //Date seek2 = (new GregorianCalendar(2021,i + 1,1)).getTime();
            Date seek1 = (new GregorianCalendar(i, 1,1)).getTime();
            Date seek2 = (new GregorianCalendar(i + 1,1,1)).getTime();
            dataset.addValue(ps.findPositionsBetweenDates(t, seek1, seek2).size(), "Positions", Integer.toString(i));

        }
        return dataset;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        listeTrackers = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setText("Afficher les statistique");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("    choisir un tracker");

        listeTrackers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeTrackersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(listeTrackers, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(listeTrackers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listeTrackersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeTrackersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listeTrackersActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Component source = (Component) evt.getSource();
        Main frame = (Main) SwingUtilities.windowForComponent(source);

        StatiTracker c;
            c = new StatiTracker((GPSTracker) listeTrackers.getSelectedItem());
            frame.getDesktopPane().add(c);
            c.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox listeTrackers;
    // End of variables declaration//GEN-END:variables
}
