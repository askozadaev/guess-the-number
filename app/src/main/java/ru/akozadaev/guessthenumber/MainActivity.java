package ru.akozadaev.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.editTextNumber);
        Button button= (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Integer.parseInt(etInput.getText().toString());
                tvInfo.setText(getResources().getString(R.string.ahead));
                System.out.println(tvInfo.getText().toString());

                if (!gameFinished){
                    int inp=Integer.parseInt(etInput.getText().toString());
                    if (inp > guess)
                        tvInfo.setText(getResources().getString(R.string.ahead));
                    if (inp < guess)
                        tvInfo.setText(getResources().getString(R.string.behind));
                    if (inp == guess)
                    {
                        tvInfo.setText(getResources().getString(R.string.hit));
                        button.setText(getResources().getString(R.string.play_more));
                        gameFinished = true;
                    }
                }
                else
                {
                    guess = (int)(Math.random()*100);
                    button.setText(getResources().getString(R.string.input_value));
                    tvInfo.setText(getResources().getString(R.string.try_to_guess));
                    gameFinished = false;
                }
                etInput.setText("");
            }
        });
        guess = (int)(Math.random()*100);
        gameFinished = false;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

}