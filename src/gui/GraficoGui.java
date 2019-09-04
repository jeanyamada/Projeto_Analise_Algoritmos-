/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author jean
 */
public class GraficoGui extends javax.swing.JFrame {
    private JFreeChart graf ;
    /**
     * Creates new form Grafico
     */
    public GraficoGui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jMenu1.setText("File");

        jMenuItem1.setText("salvar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:        
        
        JFileChooser fileChooser = new JFileChooser();
    
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            OutputStream arquivo = null;
            try {
                arquivo = new FileOutputStream(fileChooser.getSelectedFile());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GraficoGui.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ChartUtilities.writeChartAsPNG(arquivo,graf, 550, 400);
            } catch (IOException ex) {
                Logger.getLogger(GraficoGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public CategoryDataset createDataset(JTable jTable) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable.getModel();
        
        for(int i = 0;i < jTable.getRowCount(); i++){
            
            String metodo = (String) defaultTableModel.getValueAt(i,0);
            int quantElemento = Integer.parseInt((String) defaultTableModel.getValueAt(i,1));
            String tempoNano =  (String) defaultTableModel.getValueAt(i,2);
            dataset.addValue(quantElemento,metodo,tempoNano);
        }        

        return dataset;
    }

    public void criaGrafico(JTable jTable) {

        CategoryDataset cds = createDataset(jTable);

        String titulo = "Gráfico";

        graf = ChartFactory.createLineChart3D(titulo,"Tempo nano (n)","Quantidade Elementos", cds, PlotOrientation.VERTICAL,true,true,true);
        
        ChartPanel myChartPanel = new ChartPanel(graf, true);

        myChartPanel.setSize(jPanel2.getWidth(), jPanel2.getHeight());

        myChartPanel.setVisible(true);

        jPanel2.removeAll();

        jPanel2.add(myChartPanel);

        jPanel2.revalidate();

        jPanel2.repaint();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
