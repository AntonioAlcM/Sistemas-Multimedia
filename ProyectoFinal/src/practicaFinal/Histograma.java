package practicaFinal;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import sm.image.Histogram;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Crea un histograma
 *
 * @author Antonio
 */
public class Histograma extends javax.swing.JInternalFrame {

    Histogram histogram = null;

    /**
     * Crea un objeto
     *
     * @param histogram - Histogrma que deseas representar
     */
    public Histograma(Histogram histogram) {
        this.histogram = histogram;
        initComponents();
        if (histogram.getNumBands() == 1) {
            initBlancoNegro();
        } else if (histogram.getNumBands() == 3) {
            initColor();
        } else {
            initColorAlfa();
        }

    }

    /**
     * Crea tres histograms uno por cada banda de color, es decir crea un
     * gráfico del histograma rojo, verde y azul
     */
    private void initColor() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetG = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetB = new DefaultCategoryDataset();

        int bandas = this.histogram.getNumBands();
        int binds = this.histogram.getNumBins();
        int primerBanda = 0;
        int segundaBanda = 1;
        int terceraBanda = 2;

        String serie = "Número de píxeles";
        for (int j = 0; j < binds; j++) {
            dataset.setValue(this.histogram.getValue(j, primerBanda), serie, " " + Integer.toString(j));
        }
        JFreeChart chart = ChartFactory.createBarChart3D("Histograma Red", null, null,
                dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(new Color(55, 123, 243));
        chart.getTitle().setPaint(Color.WHITE);
        chart.getTitle().setFont(new java.awt.Font("Old English Text MT", 1, 24));
        CategoryPlot p = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) p.getRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        p.setRangeGridlinePaint(Color.BLACK);
        jHistogramaR.add(new ChartPanel(chart));

        for (int j = 0; j < binds; j++) {
            datasetG.setValue(this.histogram.getValue(j, segundaBanda), serie, " " + Integer.toString(j));
        }
        JFreeChart chartG = ChartFactory.createBarChart3D("Histograma Green", null, null,
                datasetG, PlotOrientation.VERTICAL, true, true, false);
        chartG.setBackgroundPaint(new Color(55, 123, 243));
        chartG.getTitle().setPaint(Color.WHITE);
        chartG.getTitle().setFont(new java.awt.Font("Old English Text MT", 1, 24));
        CategoryPlot p1 = chartG.getCategoryPlot();
        BarRenderer renderer1 = (BarRenderer) p1.getRenderer();
        renderer1.setSeriesPaint(0, Color.GREEN);
        p1.setRangeGridlinePaint(Color.BLACK);
        jHistogramaG.add(new ChartPanel(chartG));

        for (int j = 0; j < binds; j++) {
            datasetB.setValue(this.histogram.getValue(j, terceraBanda), serie, " " + Integer.toString(j));
        }
        JFreeChart chartB = ChartFactory.createBarChart3D("Histograma Blue", null, null,
                datasetB, PlotOrientation.VERTICAL, true, true, false);
        chartB.setBackgroundPaint(new Color(55, 123, 243));
        chartB.getTitle().setPaint(Color.WHITE);
        chartB.getTitle().setFont(new java.awt.Font("Old English Text MT", 1, 24));
        CategoryPlot p2 = chartB.getCategoryPlot();
        BarRenderer renderer2 = (BarRenderer) p2.getRenderer();
        renderer2.setSeriesPaint(0, Color.BLUE);
        p2.setRangeGridlinePaint(Color.BLACK);
        jHistogramaB.add(new ChartPanel(chartB));

    }

    /**
     * Crea un gráfico del histograma para las fotos en blanco y negro
     */
    private void initBlancoNegro() {

        // Fuente de Datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int primerBanda = this.histogram.getNumBins();
        String serie = "Number of píxels";
        for (int i = 0; i < primerBanda; i++) {
            dataset.setValue(this.histogram.getValue(i, 0), serie, " " + Integer.toString(i));
        }
        JFreeChart chart = ChartFactory.createBarChart3D("Histograma Gris", null, null,
                dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(new Color(55, 123, 243));
        chart.getTitle().setPaint(Color.WHITE);
        chart.getTitle().setFont(new java.awt.Font("Old English Text MT", 1, 24));
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartPanel chartPanel = new ChartPanel(chart);
        this.jHistogramaGris.add(new ChartPanel(chart));

    }

    /**
     * Crea cuatro histograms uno por cada banda de la imagen, es decir crea un
     * gráfico del histograma rojo, verde, azul y canal alpha
     */
    private void initColorAlfa() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetG = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetB = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetA = new DefaultCategoryDataset();

        int bandas = this.histogram.getNumBands();
        int binds = this.histogram.getNumBins();
        int primerBanda = 0;
        int segundaBanda = 1;
        int terceraBanda = 2;
        int BandaAlfa = 3;

        String serie = "Número de píxeles";
        for (int j = 0; j < binds; j++) {
            dataset.setValue(this.histogram.getValue(j, primerBanda), serie, " " + Integer.toString(j));
        }
        JFreeChart chart = ChartFactory.createBarChart3D("Histograma Red", null, null,
                dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(new Color(55, 123, 243));
        chart.getTitle().setPaint(Color.WHITE);
        chart.getTitle().setFont(new java.awt.Font("Old English Text MT", 1, 24));
        CategoryPlot p = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) p.getRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        p.setRangeGridlinePaint(Color.BLACK);
        jHistogramaR.add(new ChartPanel(chart));

        for (int j = 0; j < binds; j++) {
            datasetG.setValue(this.histogram.getValue(j, segundaBanda), serie, " " + Integer.toString(j));
        }
        JFreeChart chartG = ChartFactory.createBarChart3D("Histograma Green", null, null,
                datasetG, PlotOrientation.VERTICAL, true, true, false);
        chartG.setBackgroundPaint(new Color(55, 123, 243));
        chartG.getTitle().setPaint(Color.WHITE);
        chartG.getTitle().setFont(new java.awt.Font("Old English Text MT", 1, 24));
        CategoryPlot p1 = chartG.getCategoryPlot();
        BarRenderer renderer1 = (BarRenderer) p1.getRenderer();
        renderer1.setSeriesPaint(0, Color.GREEN);
        p1.setRangeGridlinePaint(Color.BLACK);
        jHistogramaG.add(new ChartPanel(chartG));

        for (int j = 0; j < binds; j++) {
            datasetB.setValue(this.histogram.getValue(j, terceraBanda), serie, " " + Integer.toString(j));
        }
        JFreeChart chartB = ChartFactory.createBarChart3D("Histograma Blue", null, null,
                datasetB, PlotOrientation.VERTICAL, true, true, false);
        chartB.setBackgroundPaint(new Color(55, 123, 243));
        chartB.getTitle().setPaint(Color.WHITE);
        chartB.getTitle().setFont(new java.awt.Font("Old English Text MT", 1, 24));
        CategoryPlot p2 = chartB.getCategoryPlot();
        BarRenderer renderer2 = (BarRenderer) p2.getRenderer();
        renderer2.setSeriesPaint(0, Color.BLUE);
        p2.setRangeGridlinePaint(Color.BLACK);
        jHistogramaB.add(new ChartPanel(chartB));

        for (int j = 0; j < binds; j++) {
            datasetA.setValue(this.histogram.getValue(j, BandaAlfa), serie, " " + Integer.toString(j));
        }
        chart = ChartFactory.createBarChart3D("Histograma Alpha", null, null,
                datasetA, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(new Color(55, 123, 243));
        chart.getTitle().setPaint(Color.WHITE);
        chart.getTitle().setFont(new java.awt.Font("Old English Text MT", 1, 24));
        p = chart.getCategoryPlot();
        renderer = (BarRenderer) p.getRenderer();
        renderer.setSeriesPaint(0, Color.GRAY);
        p.setRangeGridlinePaint(Color.BLACK);
        jHistogramaA.add(new ChartPanel(chart));
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
        jPanel1 = new javax.swing.JPanel();
        jHistogramaGris = new javax.swing.JPanel();
        jHistogramaR = new javax.swing.JPanel();
        jHistogramaG = new javax.swing.JPanel();
        jHistogramaB = new javax.swing.JPanel();
        jHistogramaA = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(880, 650));

        jPanel1.setLayout(new java.awt.GridLayout(2, 0, 2, 0));

        jHistogramaGris.setPreferredSize(new java.awt.Dimension(100, 100));
        jHistogramaGris.setLayout(new java.awt.BorderLayout());

        jHistogramaR.setPreferredSize(new java.awt.Dimension(100, 100));
        jHistogramaR.setLayout(new java.awt.BorderLayout());
        jHistogramaGris.add(jHistogramaR, java.awt.BorderLayout.CENTER);

        jPanel1.add(jHistogramaGris);

        jHistogramaG.setPreferredSize(new java.awt.Dimension(100, 100));
        jHistogramaG.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jHistogramaG);

        jHistogramaB.setPreferredSize(new java.awt.Dimension(100, 100));
        jHistogramaB.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jHistogramaB);

        jHistogramaA.setPreferredSize(new java.awt.Dimension(100, 100));
        jHistogramaA.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jHistogramaA);

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jHistogramaA;
    private javax.swing.JPanel jHistogramaB;
    private javax.swing.JPanel jHistogramaG;
    private javax.swing.JPanel jHistogramaGris;
    private javax.swing.JPanel jHistogramaR;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
