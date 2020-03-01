package com.example.retail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retail.model.ItemModel;

public class Middle extends AppCompatActivity {

    private TextView name1;
    private TextView desc1;
    private TextView price;
    private TextView discount;
    private Button explore;
    private Button Add_Cart;
    private Button view_cart;
    private Cart c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);
        final Intent i1=getIntent();
        final ItemModel items=(ItemModel)i1.getSerializableExtra("items");
        name1= findViewById(R.id.name1);
        desc1= findViewById(R.id.desc1);
        price= findViewById(R.id.price1);
        discount= findViewById(R.id.discount1);
        name1.setText(items.getName());
        desc1.setText(items.getDesc());
        price.setText(items.getPrice());
        discount.setText(items.getDiscount());
        explore=findViewById(R.id.Add);
        final ItemModel itemModel = new ItemModel(items.getName(),items.getDesc(),items.getPrice(),items.getDiscount());
        final Intent intent = new Intent(Middle.this,Cart.class);
        intent.putExtra("itemCart",itemModel);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Middle.this,MainActivity.class);
                startActivity(i2);
            }
        });
        final Intent i8=new Intent(Middle.this,Cart.class);
        Add_Cart=findViewById(R.id.Add);
        Add_Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               MainActivity.a.add(items);

            }
        });
        explore=findViewById(R.id.Explore);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(Middle.this,MainActivity.class);
                startActivity(i5);
            }
        });
        view_cart=findViewById(R.id.view_cart);
        view_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(i8);
            }
        });



    }
}



/*
package com.example.retail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retail.model.ItemModel;

public class Middle extends AppCompatActivity {

    private TextView name1;
    private TextView desc1;
    private TextView price;
    private TextView discount;
    private Button explore;
    private Button Add_Cart;
    private Button view_cart;
    private Cart c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);
        final Intent i1=getIntent();
         final ItemModel items=(ItemModel)i1.getSerializableExtra("items");
        name1= findViewById(R.id.name1);
        desc1= findViewById(R.id.desc1);
        price= findViewById(R.id.price1);
        discount= findViewById(R.id.discount1);
        name1.setText(items.getName());
        desc1.setText(items.getDesc());
        price.setText(items.getPrice());
        discount.setText(items.getDiscount());
        explore=findViewById(R.id.Add);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Middle.this,MainActivity.class);
                startActivity(i2);
            }
        });
        final Intent i8=new Intent(Middle.this,Cart.class);
        Add_Cart=findViewById(R.id.Add);
        Add_Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    //c.additems(items.getDesc());
                Toast.makeText(getApplicationContext(),items.getName(),Toast.LENGTH_SHORT).show();

            }
        });
        explore=findViewById(R.id.Explore);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(Middle.this,MainActivity.class);
                startActivity(i5);
            }
        });
        view_cart=findViewById(R.id.view_cart);
                view_cart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(i8);
                    }
                });



    }
}
*/
