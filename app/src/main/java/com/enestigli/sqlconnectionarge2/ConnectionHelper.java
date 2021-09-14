package com.enestigli.sqlconnectionarge2;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {

    Connection connection ;
    String ip,port,db,un,pass;

    @SuppressLint("NewApi")
    public Connection connection(){
        ip="DESKTOP-4GBOEMR";
        port="1433";
        db="Personel";
        un="Deneme";
        pass="";

        StrictMode.ThreadPolicy tpolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tpolicy);

        Connection con = null;
        String ConnectionURL =null;
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL ="jdbc:jtds:sqlserver://"+ip+":"+port+";"+"DatabaseName="+db+";user="+un+";password="+pass+";";
            con = DriverManager.getConnection(ConnectionURL);
        }
        catch (Exception ex){
            Log.e("Eroor :",ex.getMessage());

        }
        return con ;
    }

}
