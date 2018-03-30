package practicaltest01var05.eim.systems.cs.pub.ro.practicaltest01var05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {


    private TextView sum = null;
    private EditText  text_input = null;
    private Button add_button = null;
    private Button compute_button = null;
    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;


    ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.add_button:
                    int new_int = Integer.parseInt(text_input.getText().toString());
                    if(sum.getText().toString() == "")
                        sum.setText(text_input.getText().toString() );
                    else
                        sum.setText(sum.getText().toString() + " + " + text_input.getText().toString() );

                    break;
                case R.id.compute_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);
                    intent.putExtra("All terms", sum.getText().toString());
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        sum = (TextView)findViewById(R.id.sum);
        text_input = (EditText)findViewById(R.id.text_input);
        sum.setText("");


        add_button = (Button)findViewById(R.id.add_button);
        compute_button = (Button)findViewById(R.id.compute_button);

        add_button.setOnClickListener(buttonClickListener);
        compute_button.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
