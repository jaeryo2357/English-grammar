package com.example.jaery.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Loding extends AppCompatActivity {

    static final String[] LIST_MENU = {"Chap1 is/are","Chap2 is/are 의문문","Chap3 현재 진행","chap4 are you doing","chap5 단순현재","chap6 단순현재 부정문","chap7 Do you...?",
            "chap8 have ,have got","chap9 was,were","chap10 단순동사 과거형","chap11 불규칙 과거형","chap12 didn't did you..?","chap13 과거 진행","chap14 과거","chap15 I used to","chap16 Have you ever..?",
            "chap17 How long have you","chap18 for since aog","chap19 현재완료와 단순과거","chap20 just already yet","chap21 l've lost my key","chap22 is done was done","chap23 is being done has been done"
    ,"chap24 현재 과거시제 be/have/do","chap25 규칙 불규칙 동사"} ;

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

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU) ;

        ListView listview = (ListView) findViewById(R.id.listview1) ;
        listview.setAdapter(adapter) ;


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {


                // get TextView's Text.)
                switch (position)
                {
                    case 0:
                        chap=1;
                        a= new Intent(Loding.this,Chapone.class);

                        break;
                    case 1:
                        chap=2;
                        a= new Intent(Loding.this,Chap2.class);

                        break;
                    case 2:
                        chap=3;
                        a= new Intent(Loding.this,Chap3.class);

                        break;
                    case 3:
                        chap=4;
                        a= new Intent(Loding.this,Chap4.class);

                        break;
                    case 4:
                        chap=5;
                        a= new Intent(Loding.this,Chap5.class);

                        break;
                    case 5:
                        chap=6;
                        a= new Intent(Loding.this,Chap6.class);

                        break;
                    case 6:
                        chap=7;
                        a= new Intent(Loding.this,Chap7.class);

                        break;
                    case 7:
                        chap=8;
                        a= new Intent(Loding.this,Chap8.class);

                        break;
                    case 8:
                        chap=9;
                                a= new Intent(Loding.this,Chap9.class);

                        break;
                    case 9:
                        chap =10;
                        a= new Intent(Loding.this,Chap10.class);

                        break;
                    case 10:
                        chap=11;
                        a= new Intent(Loding.this,Chap11.class);

                        break;
                    case 11:
                        chap=12;
                        a= new Intent(Loding.this,Chap12.class);

                        break;
                    case 12:
                        chap=13;
                        a= new Intent(Loding.this,Chap13.class);

                        break;
                    case 13:
                        chap=14;
                        a= new Intent(Loding.this,MainActivity.class);//1장

                        break;
                    case 14:
                        chap=15;
                        a= new Intent(Loding.this,Chap15.class);//1장

                        break;
                    case 15:
                        chap=16;
                        a= new Intent(Loding.this,Chap16.class);

                        break;
                    case 16:
                        chap=17;
                        a= new Intent(Loding.this,Chap17.class);

                        break;
                    case 17:
                        chap= 18;
                        a= new Intent(Loding.this,Chap18.class);

                        break;
                    case 18:
                        chap=19;
                        a= new Intent(Loding.this,Chap19.class);

                        break;
                    case 19:
                        chap=20;
                        a= new Intent(Loding.this,Chap20.class);

                        break;
                    case 20:
                        chap=21;
                        a= new Intent(Loding.this,Chap21.class);

                        break;
                    case 21:
                        chap=22;
                        a= new Intent(Loding.this,Chap22.class);

                        break;
                    case 22:
                        chap=23;
                        a= new Intent(Loding.this,Chap23.class);

                        break;
                    case 23:
                        chap=24;
                        a= new Intent(Loding.this,Chap24.class);

                        break;
                    case 24:
                        chap=25;
                        a= new Intent(Loding.this,Chap25.class);

                        break;


                        


                }
                index=mDbOpenHelper.find(chap);

                if(index !=-1&&index !=0)
                {
                    AlertDialog.Builder alert_confirm = new AlertDialog.Builder(Loding.this);

                    alert_confirm.setMessage("이어서 하시겠습니까?").setCancelable(false).setPositiveButton("확인",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    a.putExtra("chap",chap);
                                    a.putExtra("ind",index);
                                    startActivity(a);
                                    // 'YES'
                                }
                            }).setNegativeButton("아니오",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // 'No'
                                    mDbOpenHelper.Update(chap,0);
                                    a.putExtra("chap",chap);
                                    a.putExtra("ind",0);
                                    startActivity(a);

                                    return;
                                }
                            });
                    AlertDialog alert = alert_confirm.create();
                    alert.show();


                }
                else {
                    a.putExtra("chap", chap);
                    startActivity(a);
                }

                // TODO : use strText
            }
        }) ;



    }
}
