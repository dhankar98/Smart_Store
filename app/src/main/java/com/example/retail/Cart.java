package com.example.retail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.retail.model.ItemModel;
import com.example.retail.ui.DatabaseHelper;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    DatabaseHelper dbhelper1;
    public static ArrayList<ItemModel> a1;
    ListView listview1;
   private Button Payments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        listview1=(ListView)findViewById(R.id.listview);

        dbhelper1=new DatabaseHelper(this);
        Intent i9=getIntent();

        a1=dbhelper1.getAllData();



        Mylistadapter adapter=new Mylistadapter(this,a1);
        listview1.setAdapter(adapter);
        Payments=(Button)findViewById(R.id.new_payments);
        Payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      Intent i10=new Intent(Cart.this,Upi_payment.class);
                startActivity(i10);
            }
        });
    }
    public void addcart(ItemModel itemModel){
        a1.add(itemModel);
    }

}








/*
package com.example.retail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.retail.model.ItemModel;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    public static ArrayList<ItemModel> a1;
    ListView listview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        listview1=(ListView)findViewById(R.id.listview);
       a1=new ArrayList<ItemModel>();
        Intent i9=getIntent();


        ItemModel item10=new ItemModel("ds","sda","q","ee");
        a1.add(item10);

       Mylistadapter adapter=new Mylistadapter(this,a1);
       listview1.setAdapter(adapter);








    }
    public  void additems(String e1)
    {
        Toast.makeText(getApplicationContext(),e1,Toast.LENGTH_SHORT).show();
    }

}
*/
