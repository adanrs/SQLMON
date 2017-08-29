/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmon;

import Ventanas.SwingWorkerRealTime;
import javax.swing.JOptionPane;
import sqlmon.conexion.Conexion;
import paneles.PanelMonitor;
/**
 *
 * @author adan-
 */
public class SQLMON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        double aux=0;
        //si quiere ver un consumo hagalo con true...
        SwingWorkerRealTime vent= new SwingWorkerRealTime();
        vent.init();
        
        while(true)
        {
            
        //System.out.println("----------------"+i+"-------------------");
        Conexion c = new Conexion();
        c.conectar();
        //aqui hay que modificar el query ya que ocupamos informacion adicional revise el queri de monitor_memory es el que deberia ir aqui.
       aux= c.executeQuery("select POOL, Round(bytes/1024/1024,0) Free_Memory_In_MB From V$sgastat Where Name Like '%free memory%'");
        //estos valores son los que hay que pasar de 0 a 100% y de ahi pasarlos al grafico.
        System.out.println("----------------------------------------");
        vent.go(aux);
        if(aux > 85){
        JOptionPane.showMessageDialog(null, "porcentaje de memoria al "+aux, "alert", JOptionPane.INFORMATION_MESSAGE);
        }
         
       
        }
    
        
        
      // c.executeQuery("SELECT * FROM   v$sga_dynamic_free_memory");
//        c.executeQuery2("SELECT BYTES AS d FROM V$SGAINFO WHERE NAME = 'Fixed SGA Size'"); 
    

        
    }
    
}
