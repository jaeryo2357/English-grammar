package com.example.jaery.myapplication;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Chap22 extends AppCompatActivity {

    SoundPool sound;
    TextView Page;
    TextView exam;
    EditText Solution;
    TextView result;
    String English[][] = {{"버터는 우유로 만들어진다.","Butter is made from milk."},{"오렌지는 한국으로 수입된다.","Oranges are imported into Korea."},{"이 방들은 얼마나 자주 청소되나요?","How often these rooms are cleaned?"},
                    {"나는 파티에 초대되는 법이 없다.","I am never invited to parties."},{"이 집은 100년 전에 지어졌다.","This house was built 100 years ago."},{"전화는 언제 발명되었습니까?","When was the telephone invented?"},
                    {"우리는 지난주에 그 파티에 초대되지 않았다.","We weren't invited to the party last week."},{"그 사고로 부상당한 사람이 있었습니까?","Was anybody injured in the accident?"},{"네, 두 사람이 병원으로 실려 갔어요.","Yes, two people were taken to the hospital."},
                    {"나는 콜롬비아에서 1989년에 태어났다.","I was born in Colombia in 1989."},{"어디서 태어나셨나요?","Where were you born?"},{"카이로에서요.","In Cairo."},{"전화기는 알렉산더 그레이엄 벨에 의해 1876년에 발명되었다.","The telephone was invented by Alexander Graham Bell in 1876."},
                    {"며칠 전 나는 개한테 물렸다.","I was bitten by a dog a few days ago."},{"이 그림들이 좋니? 그것들은 내 친구중 한명이 그렸어.","Do you like these paintings? They were painted by a friend of mine."}};


    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chap17);


        index=0;
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
        if(English[index][1].equals(Solution.getText().toString()))
        {
            if(index+1<English.length) {
                index++;
                exam.setText(English[index][0]);
                Page.setText((index + 1) + "/" + English.length);
                result.setText(English[index][1]);

                Solution.setText("");
            }
            else
                finish();
        }
    }
}
