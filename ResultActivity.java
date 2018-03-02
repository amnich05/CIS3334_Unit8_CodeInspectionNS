package edu.css.amanda.cis3334_unit7asg_nicholsamanda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Double width;
    Double length;
    Double total;
    TextView tvResultWidth;
    TextView tvResultLength;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResultWidth = (TextView) findViewById(R.id.textViewResultWidth);
        tvResultLength = (TextView) findViewById(R.id.textViewResultLength);
        tvResult = (TextView) findViewById(R.id.textViewResult);

        Bundle extras = getIntent().getExtras();
        width = extras.getDouble("WIDTH_KEY");
        length = extras.getDouble("LENGTH_KEY");
        total = extras.getDouble("RESULT_KEY");

        tvResultWidth.setText(width.toString() + " ft");
        tvResultLength.setText(length.toString() + " ft");
        tvResult.setText(total.toString()  + " ft2");

    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("NEW_WIDTH_KEY", "\nWidth:" + width);
        intent.putExtra("NEW_LENGTH_KEY", "\nLength:" + length);
        intent.putExtra("NEW_RESULT_KEY", "\nFlooring Needed:" + total);
        setResult(RESULT_OK, intent);
        super.finish();
    }

}
