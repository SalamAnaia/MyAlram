package com.example.myalram;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker ;
    EditText editText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = (TimePicker)findViewById(R.id.tp);
        editText = (EditText) findViewById(R.id.editText3);
        final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(),RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));
        Timer t = new Timer();

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (editText.getText().toString().equals(alram()))

                    r.play();

                else
                    r.stop();
            }
        },0,10000);
    }
   public String alram()
   {
       Integer alramHour=timePicker.getCurrentHour();
       Integer alramMinute=timePicker.getCurrentMinute();
       String alram1;
       if(alramHour>12)
       {
           alramHour-=12;
           alram1 = alramHour.toString().concat(":").concat(alramMinute.toString().concat(" PM"));


       }
       else
           alram1 = alramHour.toString().concat(":").concat(alramMinute.toString().concat(" AM"));
       return alram1;
   }
}
