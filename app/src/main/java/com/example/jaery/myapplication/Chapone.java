package com.example.jaery.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Chapone extends AppCompatActivity {

    SoundPool sound;
    TextView Page;
    TextView exam;
    EditText Solution;
    TextView result;
    String English[][]={{"제 이름은 리사입니다.","My name is Lisa"},
            {"미국인이고 시카고 출신이에요",	"I'm American.I'm from Chicago"},
            {"결혼은 안했어요","I am not married"},
            {"저는 예술에 관심이 있어요",	"I am interested in art"}
            ,{"가장 좋아하는 색깔은 파란색이에요","My favorite color is blue"},
            {"우리 형은 개를 무서워해요", "My brother is afraid of dogs"},
            {"당신 열쇠들은 탁자 위에 있어요","Your keys are on the table"},
            {"추워요. 창문좀 닫아 주실래요?"	,"I'm cold. could you close the window please?"}
            ,{"그는 아파서 누웠다.","He is sick in bed."}
            ,{"오늘은 화창했지만 덥진 않았다."	,"It is sunny today. but it isn't warm"}};
    int index;

    private DbOpenHelper mDbOpenHelper;
    private Cursor mCursor;//DB접근
    Intent intent;

    int chap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chap17);


        intent=getIntent();
        mDbOpenHelper=new DbOpenHelper(this);
        mDbOpenHelper.open();

        chap=intent.getIntExtra("chap",1);
       index=intent.getIntExtra("ind",0);


        Page=(TextView)findViewById(R.id.page);
        Page.setText((index+1)+"/"+English.length);
        exam=(TextView)findViewById(R.id.Hangle);
        result=(TextView)findViewById(R.id.result);

        exam.setText(English[index][0]);
        result.setText(English[0][1]);


        Button b=(Button)findViewById(R.id.Bhint);
        b.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if(action==motionEvent.ACTION_DOWN)
                    result.setVisibility(View.VISIBLE);
                else if(action==motionEvent.ACTION_UP)
                    result.setVisibility(View.INVISIBLE);
                return true;
            }
        });


        Button a=(Button)findViewById(R.id.pass);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Check();
            }
        });
        Solution=(EditText)findViewById(R.id.English);

        Solution.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    default:
                       Check();
                        break;
                }
                return true;
            }
        });

    }

    void Check(){
        int chk;
        if(English[index][1].equals(Solution.getText().toString()))
        {
            if(index+1<English.length) {
                index++;
                exam.setText(English[index][0]);
                Page.setText((index + 1) + "/" + English.length);
                result.setText(English[index][1]);

                Solution.setText("");

                chk=mDbOpenHelper.find(chap);
                if(chk!=-1)
                    mDbOpenHelper.Update(chap,index);
                else//현재 DB에 chap1에 정보가 없는 상황
                    mDbOpenHelper.insert(chap,index);

            }
            else
                finish();
        }
    }
}
