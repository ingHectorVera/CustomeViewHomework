package com.example.hectorvera.customeviewhomework;

import android.graphics.Color;
import android.graphics.Typeface;
import android.net.sip.SipAudioCall;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch sFont;
    NewTextView txtView;
    Button plusOne, minusOne;
    RadioGroup rColor;
    int count = 8;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sFont = ((Switch) findViewById(R.id.sFont));
        txtView = ((NewTextView) findViewById(R.id.txtView));
        plusOne = ((Button) findViewById(R.id.plusOne));
        minusOne = ((Button) findViewById(R.id.minusOne));
        rColor = ((RadioGroup) findViewById(R.id.rColor));

        txtView.setNewSize(count);
        updateSize();

        sFont.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    txtView.setTypeface(Typeface.DEFAULT_BOLD);
                    txtView.setText("It is on");
                }else {
                    txtView.setTypeface(Typeface.DEFAULT);
                    txtView.setText("It is off");
                }
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.minusOne:
                        count--;
                        updateSize();
                        break;
                    case R.id.plusOne:
                        count++;
                        updateSize();
                        break;
                    default:
                        break;
                }
            }
        };

        rColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.black:
                        txtView.setTextColor(Color.BLACK);
                        break;
                    case R.id.blue:
                        txtView.setTextColor(Color.BLUE);
                        break;
                    case R.id.green:
                        txtView.setTextColor(Color.GREEN);
                        break;
                    case R.id.red:
                        txtView.setTextColor(Color.RED);
                        break;
                    default:
                        break;
                }
            }
        });

        minusOne.setOnClickListener(listener);
        plusOne.setOnClickListener(listener);
    }

    private void updateSize() {
        if(count == 8){
            minusOne.setEnabled(false);
        }else if(count == 82){
            plusOne.setEnabled(false);
        }else if(count > 8 && count < 82){
            minusOne.setEnabled(true);
            plusOne.setEnabled(true);
        }
        txtView.setNewSize(count);
        txtView.setTextSize(count);
    }

}
