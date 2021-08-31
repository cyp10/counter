package android.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView Counter;
Button startb,stopb;
Handler customhandler=new Handler();
int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Counter=(TextView)findViewById(R.id.countertext);
        startb=(Button)findViewById(R.id.strtb);
        stopb=(Button)findViewById(R.id.stopb);
        startb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customhandler.postDelayed(updateTimerThread,0);
            }
        });
        stopb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customhandler.removeCallbacks(updateTimerThread);
            }
        });
    }
    private final Runnable updateTimerThread=new Runnable() {
        @Override
        public void run() {
            Counter.setText(" "+i);
            customhandler.postDelayed(this,1000);
            i++;
        }
    };
}