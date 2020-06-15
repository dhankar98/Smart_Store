package com.example.retail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.retail.model.ItemModel;
import com.google.zxing.Result;

import java.io.Serializable;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import me.dm7.barcodescanner.zxing.ZXingScannerView.ResultHandler;
public class qrscanner extends AppCompatActivity implements ResultHandler, Serializable {

    ItemModel item=new ItemModel();
    ZXingScannerView Scannerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Scannerview=new ZXingScannerView(this);
        setContentView(Scannerview);
    }

    @Override
    public void handleResult(Result result) {
        ProcessRawResult(result.getText());

        Intent qr=new Intent(qrscanner.this,Middle.class);
        qr.putExtra("items",item);
        startActivity(qr);
        onBackPressed();

    }

    private void ProcessRawResult(String text) {


        String[] tokens=text.split("@");

        item.setName(tokens[0]);
        item.setDesc(tokens[1]);
        item.setPrice(tokens[2]);
        item.setDiscount(tokens[3]);




    }

    @Override
    protected void onPause() {
        super.onPause();
        Scannerview.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Scannerview.setResultHandler(this);
        Scannerview.startCamera();
    }
}




















/*
package com.example.retail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.retail.model.ItemModel;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import me.dm7.barcodescanner.zxing.ZXingScannerView.ResultHandler;
public class qrscanner extends AppCompatActivity implements ResultHandler {

    ItemModel item=new ItemModel();
    ZXingScannerView Scannerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Scannerview=new ZXingScannerView(this);
        setContentView(Scannerview);
    }

    @Override
    public void handleResult(Result result) {
               ProcessRawResult(result.getText());
        MainActivity.welcome.setText(result.getText());
        Intent qr=new Intent(qrscanner.this,Middle.class);
        qr.putExtra("items",item);
        startActivity(qr);
        onBackPressed();

    }

    private void ProcessRawResult(String text) {


            String[] tokens=text.split("@");

            item.setName(tokens[0]);
            item.setDesc(tokens[1]);
            item.setPrice(tokens[2]);
            item.setDiscount(tokens[3]);




    }

    @Override
    protected void onPause() {
        super.onPause();
        Scannerview.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Scannerview.setResultHandler(this);
        Scannerview.startCamera();
    }
}
*/
