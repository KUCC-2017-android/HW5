package kr.ac.korea.kucc.hw5.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import kr.ac.korea.kucc.hw5.R;

public class ResultActivity extends AppCompatActivity {
    public static final String KEY_RESULT = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView resultView = (TextView) findViewById(R.id.text_result);
        Intent intent = getIntent();
        resultView.setText(intent.getStringExtra(KEY_RESULT));
    }
}
