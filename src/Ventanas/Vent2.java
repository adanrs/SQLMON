/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
/**
 *
 * @author cesar
 */
public class Vent2  extends JFrame {
      
       final XYChart chart;
       final SwingWrapper<XYChart> sw;
       
    public Vent2() {
  
    double[][] initdata = getSineData(0);

    // Create Chart
    chart = QuickChart.getChart("Monitor Data Bases", "Time", "Memory", "Use", initdata[0], initdata[1]);

    // Show it
     sw = new SwingWrapper<XYChart>(chart);
    sw.displayChart();
    }
    
    public void go(double aux)
    {
       final double[][] data = getSineData(aux);

      chart.updateXYSeries("Use", data[0], data[1], null);
      sw.repaintChart();
    }
    
      private static double[][] getSineData(double phase) {

    double[] xData = new double[100];
    double[] yData = new double[100];
    for (int i = 0; i < xData.length; i++) {
     
      xData[i] = phase;//eje x
      yData[i] = i;// eje y
    }
    return new double[][] { xData, yData };
  }
}
