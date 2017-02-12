package com.example.leon.blackjack;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;

    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.buttonHit);

        b2 = (Button)findViewById(R.id.buttonStand);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Your code goes here
                Context context = getApplicationContext();
                CharSequence text = "(┛◉Д◉)┛彡┻━┻";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Your code goes here
                Context context = getApplicationContext();
                CharSequence text = "¯\\_(ツ)_/¯";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });


    }
}
