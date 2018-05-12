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

public class Chap21 extends AppCompatActivity {

    SoundPool sound;
    TextView Page;
    TextView exam;
    EditText Solution;
    TextView result;
    String English[][]={{"나는 어제 Paula를 봤다.","I saw Paula yesterday."},{"너 일요일 오후에 어디있었니?","Where were you on Sunday afternoon?"},{"우리는 작년에 휴가를 가지 않았다.","We didn't take a vacation last year."},
            {"어젯밤에 뭐했니?","What did you do last night?"},{"나는 집에 있었다.","I stayed at home."},{"윌리엄 셰익스피어는 1564년부터 1616년까지 살았다.","William Shakespeare lived from 1564 to 1616."},
            {"그는 작가였다.","He was a writer."},{"그는 많은 희곡과 시를 썼다.","He wrote many plays and poems."},{"너는 너의 컴퓨터를 언제 샀니?","When did you buy your computer?"},{"앤디는 언제 나갔니?","What time did Andy go out?"},
            {"나는 내 열쇠를 잃어버렸다.(현재완료)","I have lost my key."},{"나는 내 열쇠를 잃어버렸다.(단순과거)","I lost my key."},{"Ben은 집에 갔다.(현재완료)","Ben has gone home."},{"Ben은 집에 갔다.(단순과거)","Ben went home."},
            {"너는 점심을 먹었니?(현재완료)", "Have you had lunch?"},{"너는 점심을 먹었니?(단순과거)","Did you have lunch?"},{"그 편지는 아직 안왔다.(현재완료)","The letter hasn't arrived yet."},{"그 편지는 아직 안왔다.(단순과거)","The letter didn't arrive yet."},
            {"스페인에 가본 적 있니?(일생동안, 지금까지)","Have you ever been to Spain?"},{"작년에 스페인에 갔었니?","Did you go to Spain last year?"},{"내 친구는 작가이다. 그는 많은 책을 썼다.","My friend is a writer. He has written many books."},
            {"우리는 보스턴에 6년동안 살고있다.","We have lived in Boston for six years."},{"우리는 시카고에서 6년간 살았지만, 지금은 보스턴에서 산다.","We lived in Chicago for six years, but now we live in Boston."}};

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
