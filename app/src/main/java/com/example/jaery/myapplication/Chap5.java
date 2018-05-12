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

public class Chap5 extends AppCompatActivity {

    SoundPool sound;
    TextView Page;
    TextView exam;
    TextView result;
    EditText Solution;
    String English[][] ={{"그는 아이스크림을 좋아한다","He likes ice cream"},
            {"내 형제는 은행에서 일한다.",	"My brother works in a bank."},
            {"그녀는 매일 집에서 점심을 먹는다.","She has lunch at home every day"},
            {"그는 7:30에 시작하고 밤 8시에 끝냈다.","He starts at 7:30 and finishes at 8:00 at night"},
            {"지구는 태양을 돈다.","The earth goes around the sun"},
            {"우리는 자유시간에 여러 가지 다양한 것들을 한다.",	"We do a lot of different things in out free time."},
            {"병원을 짓는 데는 돈이 많이 든다.","It costs a lot of money to build a hospital"},
            {"나는 절대 아침을 먹지 않는다.",	"I never eat breakfast"},
            {"나는 때로는 걸어서 직장에 간다.","I sometimes walk to work"},
            {"우리는 주말에 곧잘 늦잠을 잔다.","We often sleep late on weekends"}};
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
