package an.blackjack;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class Bet extends AppCompatActivity {
    public Player p;
    TextView t;
    TextView mon;
    EditText cash;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Hello", "it changes");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet);

        Intent intent = getIntent();
        p = (Player) intent.getSerializableExtra(Menu.MESSAGE);
        t = (TextView) findViewById(R.id.welcome);
        t.setText("Hi " + p.getName());
        Log.i("text", p.getName());
        mon = (TextView) findViewById(R.id.dollars);
        mon.setText(String.valueOf(p.getCash()));
        Log.d("cash", mon.getText().toString());

        cash = (EditText) findViewById(R.id.editText);

        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scash = cash.getText().toString();
                int icash = Integer.parseInt(scash);

                Toast.makeText(getApplicationContext(), "betting" + cash.getText().toString(), Toast.LENGTH_LONG).show();
                p.setBet(icash);
            }
        });


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
