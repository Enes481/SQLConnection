package com.enestigli.sqlconnectionarge2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    Connection connect;
    String ConnectionResult="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getDatatoTextView(View v){
        TextView textView = findViewById(R.id.txt_name);
        TextView textVie2 = findViewById(R.id.txt_personel_no);

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connection();
            if(connect!=null){
                String query = "select * from calisanlar";
                Statement smt = connect.createStatement();
                ResultSet rs = smt.executeQuery(query);
                while(rs.next()){
                    textView.setText(rs.getString(0));
                    textVie2.setText(rs.getString(2));

                }
            }
        }
        catch (Exception ex){
            Log.e("ERROR:",ex.getMessage());
        }

    }
}