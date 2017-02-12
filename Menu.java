package an.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu extends AppCompatActivity {
    EditText playerName;
    EditText money;
    Button game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        game = (Button) findViewById(R.id.play);
        playerName = (EditText) findViewById(R.id.name);
        money = (EditText) findViewById(R.id.mymoney);

        game.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = playerName.getText().toString();
                String smoney = money.getText().toString();
                int imoney = Integer.parseInt(smoney);
                Player player = new Player();
                if (name != "" && smoney != "") {
                    player = new Player(name, imoney);
                }
                Intent betting = new Intent(Menu.this, Bet.class);
                startActivity(betting);
            }
        });

    }
    public void sendMessage(View view) {

    }
}
