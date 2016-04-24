/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rasp;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author vbarrera
 */
public class Graficas extends Principal{

    int n1;
    int n2;
    final XYSeries Seriep1 = new XYSeries("Pulsos Ch #1");
    final XYSeries Seriep2 = new XYSeries("Pulsos Ch #2");
    final XYSeriesCollection Coleccion = new XYSeriesCollection();
    final XYSeriesCollection Coleccionp2 = new XYSeriesCollection();
    JFreeChart Graficap1;
    JFreeChart Graficap2;

    public Graficas(JPanel panel) {
        this.n1 = n1;
        this.n2 = n2;
        
    }

}
