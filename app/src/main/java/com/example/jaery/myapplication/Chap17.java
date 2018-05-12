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

public class Chap17 extends AppCompatActivity {


    TextView Page;
    TextView exam;
    EditText Solution;
    TextView result;
    String English[][] = {{"제인은 브라질로 휴가를 갔다.", "Jane is on vacation in Brazil."}, {"그녀는 지금 그곳에 있다.", "She is there now."}, {"그녀는 월요일에 브라질에 도착했다.", "She arrived in Brazil on Monday."},
            {"오늘은 목요일이다.", "Today is Thursday."}, {"제인은 브라질에 얼마나 있었는가?", "How long has she been in Brazil?"}, {"그녀는 월요일부터 브라질에 있었다.", "She has been in Brazil since Monday."},
            {"그녀는 사흘 동안 브라질에 있었다.", "She has been in Brazil for three days."}, {"댄과 케이트는 결혼했다.", "Dan and Kate are married."}, {"그들은 결혼한 지 5년 됐다.", "They have been married for five years."},
            {"결혼하셨어요?", "Are you married?"}, {"결혼하신 지 얼마나 되셨어요?", "How long have you been married?"}, {"당신은 리사를 아시나요?", "Do you know Lisa?"}, {"그녀를 아신 지 얼마나 됐습니까?", "How long have you known her?"},
            {"베라는 브라질리아에 산다.", "Vera lives in Brasilia."}, {"그녀가 브라질리아에 산 지 얼마나 됐습니까?", "How long has she lived in Brasilia?"}, {"나는 차가 있습니다.", "I have a car."},
            {"차를 가진 지 얼마나 됐습니까?", "How long have you had your car?"}, {"4월부터 가지고 있었습니다.", "I've had it since April."}, {"나는 독어를 공부하고 있습니다.", "I'm studying German."},
            {"독어를 공부한 지 얼마나 됐습니까?", "How long have you been studying German?"}, {"2년째 공부하고 있습니다.", "I've been studying German for two years."},
            {"데이비드는 TV를 보고 있다.", "David is watching TV."}, {"그가 TV를 본 지 얼마나 됐습니까?", "How long has he been watching TV?"},
            {"그는 5시부터 TV를 보고있습니다.", "He has been watching TV since 5:00."}, {"비가오고 있다.", "It's raining."}, {"비가 하루종일 오고 있다.", "It has been raining all day."}};

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
