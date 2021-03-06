/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import entities.Position;
import entities.Vehicule;
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
import service.VehiculeGPSTrackerService;
import service.VehiculeService;

/**
 *
 * @author DELL
 */
public class StatiVehicule extends javax.swing.JInternalFrame {
private GPSTrackerService ts;
 private PositionService ps;
  private VehiculeService vs;
  private VehiculeGPSTrackerService vgs;
    /**
     * Creates new form StatiVehicule
     */
    public StatiVehicule() {
        vs=new VehiculeService();
        initComponents();
        loadVehicules();
    }

    private void loadVehicules() {
        for (Vehicule v : vs.findAll()) {
            listevehicules.addItem(v);
        }
    }
    private static StatiVehicule instane;
    public static StatiVehicule getInstane() {
		if(instane == null)
                	instane = new StatiVehicule();
		return instane;
	}
    
    public StatiVehicule(Vehicule v) {
        ps = new PositionService();
        ts = new GPSTrackerService();
        vs = new VehiculeService();
        // Create Dataset  
        CategoryDataset dataset = createDataset(v);

        //Create chart  
        JFreeChart chart = ChartFactory.createBarChart(
                "le vehicule avec le matricule :" + v.getMatricule(), //Chart Title  
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
    
    private CategoryDataset createDataset(Vehicule t) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //dataset.addValue(10, "Positions renvoyer", "1910");
        ps = new PositionService();
        ts = new GPSTrackerService();
        vs = new VehiculeService();
        vgs = new VehiculeGPSTrackerService();

       Date date = new GregorianCalendar().getTime();
        for (Position p : ps.findAll()) {
            if (p.getDate().before(date)) {
                date = p.getDate();
                System.out.println(date);
            }
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int M = calendar.get(Calendar.YEAR);
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.setTime(new Date());

        for (int i = M-1; i <= ((calendar.get(Calendar.YEAR)) + 1); i++) {
            Date seek1 = (new GregorianCalendar(i, 1, 1, 0, 0)).getTime();
            Date seek2 = (new GregorianCalendar(i + 1, 1, 1, 0, 0)).getTime();

            dataset.addValue(vgs.findGPSTrackersBetweenDates(t, seek1, seek2).size(), "Positions", Integer.toString(i));

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

        listevehicules = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("choisier un  vehicule");

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setText("Afficher les statistique");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(listevehicules, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(listevehicules, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Component source = (Component) evt.getSource();
        Main frame = (Main) SwingUtilities.windowForComponent(source);

        StatiVehicule c;
            c = new StatiVehicule((Vehicule) listevehicules.getSelectedItem());
            frame.getDesktopPane().add(c);
            c.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox listevehicules;
    // End of variables declaration//GEN-END:variables
}
