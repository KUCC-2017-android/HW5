package kr.ac.korea.kucc.hw5.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kr.ac.korea.kucc.hw5.R;
import kr.ac.korea.kucc.hw5.adapter.ItemAdapter;

public class MainActivity extends AppCompatActivity {
    public static final int REQ_CODE_INPUT = 1;

    private List<String> itemList = new ArrayList<>();
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ItemAdapter(itemList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public void onResultButtonClick(View v) {
        if (itemList.size() == 0) {
            Toast.makeText(this, "리스트가 비어있습니다", Toast.LENGTH_LONG).show();
            return;
        }

        Random random = new Random();
        String result = itemList.get(random.nextInt(itemList.size()));
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(ResultActivity.KEY_RESULT, result);
        startActivity(intent);
    }

    public void onAddButtonClick(View v) {
        Intent intent = new Intent(this, ItemInputActivity.class);
        startActivityForResult(intent, REQ_CODE_INPUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_INPUT) {
            if (resultCode == RESULT_OK) {
                itemList.add(0, data.getStringExtra(ItemInputActivity.KEY_ITEM));
                adapter.notifyItemInserted(0);
            }
        }
    }
}
