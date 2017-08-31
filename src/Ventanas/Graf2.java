/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import javax.swing.JOptionPane;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

/**
 *
 * @author cesar
 */
public class Graf2 {
    double phase = 0;
    double[][] initdata= new double[400][400];
    final XYChart chart;
    final SwingWrapper<XYChart> sw;
    double cont;
    public  Graf2()
    {
      chart = QuickChart.getChart("Monitor", "iteracion", "Memoria", "uso", initdata[0], initdata[1]);
 
    // Show it
     sw= new SwingWrapper<XYChart>(chart);
    sw.displayChart();
    cont=0;
 
    }
    
    public void go(float[] vec) throws InterruptedException
    {
        int i=0;
         while (i<vec.length) {
 
      //Thread.sleep(100);
 
      final double[][] data = getSineData(vec);
 
      chart.updateXYSeries("uso", data[0], data[1], null);
      sw.repaintChart();
      /* if(vec[i] > 85)
        {
        JOptionPane.showMessageDialog(null, "porcentaje de memoria al "+vec[i], "alert", JOptionPane.INFORMATION_MESSAGE);
        //guardar el usuario  y el query
        }*/
      i++;
      
    }
    }
    
    private  double[][] getSineData(float[] phase) {
 
    double[] xData = new double[400];
    double[] yData = new double[400];
    for (int i = 0; i < xData.length; i++) {
      
      xData[i] = cont;
      yData[i] = phase[i];
      cont++;
    }
    return new double[][] { xData, yData };
  }
}

