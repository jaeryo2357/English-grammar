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

public class Chap19 extends AppCompatActivity {

    SoundPool sound;
    TextView Page;
    TextView exam;
    EditText Solution;
    TextView result;
    String English[][] = {{"그의 차는 지저분하다.","His car is dirty."},{"그는 차를 닦고 있다.","He is washing his car."},{"그는 세차를 마쳤다.","He has washed his car."},
            {"그들은 집에 있다.","They are at home."},{"그들은 외출하고 있다.","They are going out."},{"그들은 외출했다.","They have gone out."},
            {"여권을 잃어버렸어.","I've lost my passport."},{"레베카는 어딨니?","Where's Rebecca?"},{"그녀는 자러갔다.","She's gone to bed."},
            {"내일이 레이첼 생일인데 아직 선물을 못 샀어.","It's Rachel's birthday tomorrow, and I haven't bought her a present."},{"밥은 휴가를 떠났다.","Bob is away on vacation."},{"오, 그는 어디로 갔나요?","Oh, Where has he gone?"},
            {"우리 형을 만났나요? 아니면 내가 당신을 소개해야하나요?","Have you met my brother, or should I introduce you?"},{"나는 대학 다닐 때는 타자가 무척 느렸는데 지금은 빨라졌다.","I was a very slow typist in college, but I've gotten faster."},
            {"너 열쇠는 어딨니?","Where's your key?"},{"잃어버렸다.","I've lost it."},{"잃어버렸다.","I lost it."},{"피터 여기있나요?","Is Peter here?"},{"집에 갔어요.","He's gone home."},{"집에 갔어요.","He went home."},
            {"우리는 새 차를 샀다.","We've bought a new car."},{"우리는 새 차를 샀다.","We bought a new car."},{"나는 어제 열쇠를 잃어버렸다.","I lost my key yesterday."},{"우리는 지난주에 새 차를 샀다.","We bougth a new car last week."}};

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
