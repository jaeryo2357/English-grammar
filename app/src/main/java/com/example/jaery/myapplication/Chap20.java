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

public class Chap20 extends AppCompatActivity {

    SoundPool sound;
    TextView Page;
    TextView exam;
    EditText Solution;
    TextView result;
    String English[][] = {{"다이앤과 폴이 여기 있나요?","Are Diane and Paul here?"},{"그들은 막 도착했다.","They have just arrived."},{"배고프니?","Are you hungry?"},{"나는 막 저녁을 먹었다.","I've just had dinner."},
            {"탐 여기있나요?","Is Tom here?"},{"아니요, 죄송하지만, 그는 막 떠났어요.","No, sorry, he's just left."},{"그는 방금 막 떠났다.","He just left."},
            {"다이앤과 폴은 언제오나요?","What time are Diane and Paul coming?"},{"그들은 이미 도착했다.","They've already arrived."},{"아직 9시이지만 애나는 이미 자러갔다.","It's only 9:00 and Anna has already gone to bed."},
            {"존, 여기는 엠마야.","Jon, this is Emma."},{"응, 알아. 우리는 이미 만났어.","Yes, I know. We've already met."},{"우리는 이미 만났다.","We already met."},
            {"그들은 아직 도착하지 않았다.","They haven't arrived yet."},{"제임스는 너가 간다는 것을 알고있니?","Does James know that you're going away?"},{"나는 아직 그에게 말을 안했다.","I haven't told him yet."},
            {"영화는 아직 시작하지 않았다.","The film hasn't started yet."},{"실비아는 새 드레스를 샀지만, 아직 입지 않았다.","Silvia has bought a new dress, but she hasn't worn it yet."},
            {"다이앤과 폴은 아직 도착안했나요?","Have Diane and Paul arrived yet?"},{"다이앤과 폴은 아직 도착안했나요?","Did Diane and Paul arrive yet?"},{"아니, 아직 안왔다. 우리는 아직도 그들을 기다리고있다.","No, not yet. We're still waiting for them."},
            {"니콜은 아직 그녀의 새 일을 시작하지 않았니?","Has Nicole started her new job yet?"},{"니콜은 아직 그녀의 새 일을 시작하지 않았니?","Did Nicole start her new job yet?"},
            {"그녀는 다음주에 시작할 예정이다.","She's starting next week."},{"이것은 내 새 드레스야.","This is my new dress."},{"오, 멋지다. 그거 아직 안 입어봤니?","Oh, it's nice. Have you worn it yet?"}};


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
