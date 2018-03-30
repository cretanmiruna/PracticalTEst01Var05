package practicaltest01var05.eim.systems.cs.pub.ro.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;

public class PracticalTest01Var05SecondaryActivity extends Activity {

    private TextView result = null;
    private Button return_button = null;
    private double summ;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.return_button:
                    setResult(RESULT_OK, null);
                    break;
            }
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        result = (TextView)findViewById(R.id.result);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("All terms")) {
            String new_sum = String.valueOf(intent.getIntExtra("All terms", -1));
            for (int index = 0; index < new_sum.split(" \\+ ").length; index++) {
                summ  += Integer.parseInt(new_sum.split(" \\+ ")[index]);
            }
            result.setText(intent.getIntExtra("All terms", -1) + " = " + summ);
        }

        return_button = (Button)findViewById(R.id.return_button);
        return_button.setOnClickListener(buttonClickListener);
    }

}
