package kr.ac.korea.kucc.hw5.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import kr.ac.korea.kucc.hw5.R;

public class ItemInputActivity extends AppCompatActivity {
    public static final String KEY_ITEM = "item";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_input);

        editText = (EditText) findViewById(R.id.edit_new_item);
    }

    public void onSubmitButtonClick(View v) {
        String result = editText.getText().toString();
        if (result.length() == 0)
            return;

        Intent intent = new Intent();
        intent.putExtra(KEY_ITEM, result);
        setResult(RESULT_OK, intent);
        finish();
    }
}
