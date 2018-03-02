package edu.css.amanda.cis3334_unit7asg_nicholsamanda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    EditText etWidth;               // the edit text field for the entered width
    EditText etLength;              // the edit text field for the entered length
    Double width, length, total;   // declare width, length, and result variables
    TextView tvResult;              // the text view that will display the result in MainActivity

    public static final String WIDTH_KEY = "WIDTH_KEY";
    public static final String LENGTH_KEY = "LENGTH_KEY";
    public static final String RESULT_KEY = "RESULT_KEY";

    private static final int MY_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWidth = (EditText) findViewById(R.id.editTextWidth);
        etLength = (EditText) findViewById(R.id.editTextLength);
        tvResult = (TextView) findViewById(R.id.textViewMainResult);


    }

    public void buttonShowResultClick(View view) {
        width = Double.parseDouble(etWidth.getText().toString());
        length = Double.parseDouble(etLength.getText().toString());

        total = width * length;

        Intent ResultIntent = new Intent(this, ResultActivity.class);
        ResultIntent.putExtra(WIDTH_KEY, width);
        ResultIntent.putExtra(LENGTH_KEY, length);
        ResultIntent.putExtra(RESULT_KEY, total);
        startActivityForResult(ResultIntent, MY_REQUEST_CODE);

    //    tvResult.setText("\nWidth is " + width
    //                    + "\nLength is " + length
    //                    + "\nTotal Flooring Needed is: " + result);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == MY_REQUEST_CODE) {
            if (data.hasExtra("NEW_WIDTH_KEY")) {
                String result = data.getExtras().getString("NEW_WIDTH_KEY");
                if (result != null && result.length() > 0) {
                    tvResult.setText("\nWidth is: " + width + " ft"
                                    +"\nLength is: " + length + " ft"
                                    +"\nTotal Flooring Needed is: " + total + " ft2");
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
