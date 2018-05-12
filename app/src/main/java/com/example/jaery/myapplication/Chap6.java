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

public class Chap6 extends AppCompatActivity {

    SoundPool sound;
    TextView Page;
    TextView exam;
    TextView result;
    EditText Solution;
    String English[][] = {{"우리는 텔레비전을 자주 보지 않아요.","We don't watch television very often."},
            {"비는 자주 내리지 않는다.","It doesn't rain very often."},
            {"나는 많은 사람들을 알지 못한다.","I don't know many people"},
            {"Fred는 나를 싫어한다.",	"Fred doesn't like me"}};
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
