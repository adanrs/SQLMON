/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmon;

import sqlmon.conexion.Conexion;

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
        
        Conexion c = new Conexion();
        c.conectar();
        c.executeQuery("select POOL, Round(bytes/1024/1024,0) Free_Memory_In_MB From V$sgastat Where Name Like '%free memory%'");

        
        
      //  c.executeQuery("SELECT * FROM   v$sga_dynamic_free_memory");
        ///c.executeQuery2("SELECT BYTES AS d FROM V$SGAINFO WHERE NAME = 'Fixed SGA Size'"); 
    }
    
}