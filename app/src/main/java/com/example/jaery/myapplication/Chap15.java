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

public class Chap15 extends AppCompatActivity {

    SoundPool sound;
    TextView Page;
    TextView exam;
    TextView result;
    EditText Solution;
    String English[][] = {{"Dave는 전에 공장에서 일했다. 이제 그는 수퍼마켓에서 일한다.","Dave used to work in a factory. Now he works in a supermarket."},{"그는 전에 공장에서 일했지만 이제는 거기서 일하지 않는다.","Dave used to work in a factory."},
            {"내가 어렸을때, 초콜릿을 좋아했다.","When I was a child, I used to like chocolate."},{"나는 많은 책을 읽었지만, 요즘엔 많이 안읽는다.","I used to read a lot of books, but I don't read much these days."},
            {"Liz는 지금은 머리가 짧지만, 매우 길었었다.","Liz has short hair now, but it used to be very long."},{"전에 그들은 우리와 같은 거리에 살아서 우리는 그들을 자주 봤다. 하지만 요즘은 자주 못 본다."},
            {"헬렌은 전에는 피아노를 가지고 있었지만, 몇 년 전에 팔아치웠다.","Helan used to have a piano, but she sold it a few years ago."},{"내가 어렸을 때, 나는 토마토를 싫어했다.","When I was a child, I didn't use to like tomatoes."},
            {"여기에 오기전에 너는 어디에 살았니?","Where did you use to live before you came here?"},{"나는 테니스를 쳤었다. 요즘에 나는 골프를 친다.","I used to play tennis. These days I play golf."},{"우리는 보통 일찍 일어난다.","We usually get up early."}};

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
