/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jc.model;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author campitos
 */
public class TestProcedimiento {
    public static void main(String args[])throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call guardar_usuario(?,?,?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2,"juan");
        callate.setString(3,"gatuzo07@hotmail.com");
        callate.setFloat(4, 45000);
      
        callate.execute();
        int pk=callate.getInt(1);
        System.out.println("Reistro guardado y el id ingresado es:"+pk);
    }
    
}
