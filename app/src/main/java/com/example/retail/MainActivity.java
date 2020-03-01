package com.example.retail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.retail.model.ItemModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     private Button scan;
     public static TextView welcome;


    public static ArrayList<ItemModel> a=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scan=findViewById(R.id.scan);
        welcome=findViewById(R.id.welcome);
        scan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                 Intent i=new Intent(MainActivity.this,qrscanner.class);
                 startActivity(i);
            }

        });

    }
    public void additem(ItemModel e3)
    {
        a.add(e3);
    }

}
