/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author adan-
 */

import java.util.LinkedList;
import java.util.List;
 
import javax.swing.SwingWorker;
 
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
 
/**
 * Creates a real-time chart using SwingWorker
 */
public class SwingWorkerRealTime {
 
  MySwingWorker mySwingWorker;
  SwingWrapper<XYChart> sw;
  XYChart chart;
  double valor;
 

  public void init()
  {
       // Create Chart
    chart = QuickChart.getChart("Monitor Data Base", "time", "Memory", "uso", new double[] { 0 }, new double[] { 0 });
    chart.getStyler().setXAxisTicksVisible(false);
    sw = new SwingWrapper<XYChart>(chart);
    sw.displayChart();
  }
  
 //uno
  // donde se actualiza la ventana 
  public void go(double val) { 

      valor=val;
     mySwingWorker = new MySwingWorker();
    mySwingWorker.execute();
    
    
    
  }
 
  private class MySwingWorker extends SwingWorker<Boolean, double[]> {
 
    LinkedList<Double> fifo = new LinkedList<Double>();
 
    public MySwingWorker() {
 
      fifo.add(0.0);
    }
 
    //dos
    // pinta los valores en la grafica 
    @Override
    protected Boolean doInBackground() throws Exception {
  
      
      
        fifo.add(fifo.get(fifo.size()- 1) + valor);// valor de la memoria libre

        if (fifo.size() > 500) {
          fifo.removeFirst();
        }
 
        double[] array = new double[fifo.size()];
        for (int i = 0; i < fifo.size(); i++) {
          array[i] = fifo.get(i);
        }
        publish(array);
 
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          // eat it. caught when interrupt is called
          System.out.println("MySwingWorker shut down.");
        }
       
           
 
      return true;
    }
 
    @Override
    protected void process(List<double[]> chunks) {
 
     
 
      double[] mostRecentDataSet = chunks.get(chunks.size() - 1);
 
      chart.updateXYSeries("uso", null, mostRecentDataSet, null);
      sw.repaintChart();
 
      long start = System.currentTimeMillis();
      long duration = System.currentTimeMillis() - start;
      try {
        Thread.sleep(40 - duration); // 40 ms ==> 25fps
        // Thread.sleep(400 - duration); // 40 ms ==> 2.5fps
      } catch (InterruptedException e) {
      }
 
    }
  }
}