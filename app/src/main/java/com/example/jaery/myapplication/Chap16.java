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

public class Chap16 extends AppCompatActivity {

    SoundPool sound;
    TextView Page;
    TextView exam;
    TextView result;
    EditText Solution;
    String English[][] = {{"멕시코시티에 가본 적 있어요?","Have you been to Mexico City?"},{"네, 여러 번 가봤어요.","Yes, I have. Many times."},
            {"일본에는 가본 적 있어요?","Have you ever been to Japan?"},{"아니요, 일본에는 한번도 가본 적 없어요.","No, I've never been to Japan."},
            {"프랑스에 가본 적 있어요?","Have you ever been to France?"},{"우리는 캐나다에는 가본 적 있지만, 알래스카에는 가본 적이 없다.","We've been to Canada, but we haven't been to Alaska."},
            {"메리는 재미있는 사람이다.","Mary is an interesting person."},{"그녀는 여러 가지 직업을 가져봤고 여러 곳에서 살아봤다.","She has had many different jobs and has lived in many places."},
            {"나는 전에 그 여자를 본 적이 있지만, 어디서 봤는지는 기억안난다.","I've seen that woman before, but I can't remember where."},{"브라질이 월드컵에서 몇 번이나 우승했니?","How many times has Brazil won the World Cup?"},
            {"이 책 읽어 봤어요?","Have you read this book?"},{"네, 두 번 읽었어요.","Yes, I've read it twice."},{"앤은 호주에 가본 적 있나요?","Has Ann ever been to Australia?"},{"네, 한번이요.","Yes, once."},
            {"골프를 쳐보신 적이 있나요?","Have you ever played golf?"},{"예, 많습니다.","Yes, I play a lot."},{"내 누이는 비행기를 타고 여행한 적이 한번도 없다.","My sister has never traveled by plane."},
            {"나는 한번도 말을 타본 적이 없다.","I've never ridden a horse."},{"저 남자는 누구에요?","Who is that man?"},{"저도 몰라요. 저는 전에 그를 본 적이 한번도 없어요.","I don't know. I've never seen him before."}};
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
