package com.swj.tp11messageborderlist;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<BorderItem> borderItems = new ArrayList<>();
    BorderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new BorderAdapter(MainActivity.this, borderItems);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.appcompatbtn).setOnClickListener(view -> {
            Intent intent = new Intent(this, BorderItemActivity.class);
            resultLauncher.launch(intent);
        });
    }

    ActivityResultLauncher<Intent> resultLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if(result.getResultCode() == RESULT_OK) {
                                Intent intent = result.getData();
                                String name = intent.getStringExtra("name");
                                String nickname = intent.getStringExtra("nickname");
                                String title = intent.getStringExtra("title");
                                String content = intent.getStringExtra("content");

                                borderItems.add(0, new BorderItem(name, nickname, title, content));
                                adapter.notifyItemInserted(0);
                                recyclerView.scrollToPosition(0);
                            } else if(result.getResultCode() == RESULT_CANCELED) {
                                Snackbar.make(recyclerView, "취소했습니다.", Snackbar.LENGTH_INDEFINITE)
                                        .setAction("OK", view -> {}).show();
                            }
                        }
                    }
            );
}