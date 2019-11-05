package com.example.jaery.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Loding extends AppCompatActivity {



    private DbOpenHelper mDbOpenHelper;
    private Cursor mCursor;//DB접근
    int chap=1;
    Intent a;
    public int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding);


        mDbOpenHelper=new DbOpenHelper(this);
        mDbOpenHelper.open();


    }
}
