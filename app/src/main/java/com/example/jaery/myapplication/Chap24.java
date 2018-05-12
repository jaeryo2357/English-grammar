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

public class Chap24 extends AppCompatActivity {

    SoundPool sound;
    TextView Page;
    TextView exam;
    EditText Solution;
    TextView result;
    String English[][]=
            {{"제발 조용히 좀 해. 나 지금 일하고 있어.","Please be quiet. I'm working."},{"지금 비가 안 온다.","It isn't raining right now."},{"오늘밤 일정은 무엇인가요?","What are you doing tonight?"},{"오늘밤 뭐할꺼야?","What would you like to do tonight?"},
                    {"그녀가 도착했을 때, 나는 일하고 있었다.","I was working when she arrived."},{"비가 오고 있지 않았기 때문에, 우리는 우산이 필요 없었다.","It wasn't raining, so we didn't need an umbrella."},
                    {"3시에 뭐하고 있었니?","What were you doing at 3:00?"},{"이 사무실들은 매일 청소되는 건 아니다.","These offices aren't cleaned every day,"},{"유리창이 어떻게 깨졌니?","How was the window broken?"},
                    {"탐은 한번도 말을 타 본 적이 없다.","Tom has never ridden a horse."},{"Kate는 남미에 가본 적이 없다.","Kate hasn't been to South America."},{"폴과 니콜은 어디로 가버렸니?","Where have Paul and Nicole gone?"},
                    {"나는 커피를 좋아하지만, 차는 안좋아한다.","I like coffee, but I don't like tea."},{"크리스는 그다지 자주 외출하지 않는다.","Chris doesn't go out very often."},{"보통 주말마다 뭐해?","What do you usually do on weekends?"},
                    {"실비아는 혼자 사니?","Dose Silvia live alone?"},{"나는 어제 TV를 보지 않았다.","I didn't watch TV yesterday."},{"지난 주에 비가 안왔다.","It didn't rain last week."},{"폴과 니콜은 몇시에 나갔니?","What time did Paul and Nicole go out?"}};


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
