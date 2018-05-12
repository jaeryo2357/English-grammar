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

public class Chap23 extends AppCompatActivity {

    SoundPool sound;
    TextView Page;
    TextView exam;
    EditText Solution;
    TextView result;
    String English[][] = {{"내 차는 차고에 있다. 그것은 수리중이다.","My car is at the garage. It is being repaired."},{"공원 건너편에서 새 집들이 지어지고 있다.","Some new houses are being built across from the park."},
                    {"사무실은 지금 청소되고있다.","The office is being cleaned right now."},{"사무실은 매일 청소된다.","The office is cleaned every day."},{"미국에서, 풋볼경기는 보통 주말마다 한다, 하지만 다음주에는 큰 경기가 없다.","In the United Stated, football games are usually played on weekends, but no big games are being played next week."},
                    {"내 열쇠는 도난당했다.","My key has been stolen."},{"난 파티에 안 가. 초대를 안 받았어.","I'm not going to the party. I haven't been invited."},{"이 셔츠는 빨래가 된 거니?","Has this shirt been washed?"},
                    {"그 방은 더이상 더럽지않다.","The room isn't dirty any more."},{"그 방은 어제 청소됬다.","The room was cleaned yesterday,"},{"나는 내 열쇠를 찾을 수 없다. 내 생각에 도난당한 거 같다.","I can't find my keys. I think they've been stolen."},
                    {"내 열쇠들은 지난 주에 도난당했다.","My keys were stolen last week."}};


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
