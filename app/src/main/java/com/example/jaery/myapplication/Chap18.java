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

public class Chap18 extends AppCompatActivity {

    SoundPool sound;
    TextView Page;
    TextView exam;
    EditText Solution;
    TextView result;

    String English[][] = {{"리차드는 캐나다에 6개월동안 있다.","Richard has been in Canade for six months."},{"리차드는 1월부터 지금까지 캐나다에 있다.","Richard has been in Canada since January."},
            {"우리는 2시간 동안 기다리고있다.","We've been waiting for two hours."},{"우리는 9시부터 지금까지 기다리고있다.","We've been waiting since 9:00."},
            {"나는 오랫동안 시카고에서 살았다.","I've lived in Chicago for a long time."},{"나는 10살 떄부터 시카고에서 살았다.","I've lived in Chicago since I was 10 years old."},
            {"수잔은 3달 전에 새로운 일을 시작했다.","Susan started her new job three weeks ago."},{"탐은 언제 떠났나요?","When did Tom leave?"},{"10분 전이요.","Ten minutes ago."},
            {"나는 한시간 전에 저녁을 먹었다.","I had dinner an hour ago."},{"100년 전 삶은 매우 달랐다.","Life was very different a hundred years ago."},
            {"제인은 브라질에 언제 도착했나요?","When did Jane arrive in Brazil?"},{"그녀는 사흘 전에 브라질에 도착했습니다.","She arrived in Brazil three days ago."},
            {"그녀는 브라질에 얼마 동안 있었나요?","How long has she been in Brazil?"},{"그녀는 사흘 동안 브라질에 있었습니다.","She has been in Brazil for three days."}};

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
