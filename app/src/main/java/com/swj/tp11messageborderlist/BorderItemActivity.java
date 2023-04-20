package com.swj.tp11messageborderlist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

public class BorderItemActivity extends AppCompatActivity {

    TextInputEditText textInputEtName;
    TextInputEditText textInputEtNickName;
    TextInputEditText textInputEtTitle;
    TextInputEditText textInputEtContent;
    AppCompatButton btnCancel;
    AppCompatButton btnComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_border_item);

        textInputEtName = findViewById(R.id.text_input_et_name);
        textInputEtNickName = findViewById(R.id.text_input_et_nick_name);
        textInputEtTitle = findViewById(R.id.text_input_et_title);
        textInputEtContent = findViewById(R.id.text_input_et_content);
        btnCancel = findViewById(R.id.btn_cancel);
        btnComplete = findViewById(R.id.btn_complete);

        btnCancel.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(R.layout.dialog_cancel);
            builder.setPositiveButton("확인", (dialogInterface, i) -> {});
            AlertDialog dialog = builder.create();
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        });

        btnComplete.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(R.layout.dialog_complete);
            builder.setNegativeButton("취소", (dialogInterface, i) -> {});
            builder.setPositiveButton("확인", (dialogInterface, i) -> {
                String name = textInputEtName.getText().toString();
                String nickname = textInputEtNickName.getText().toString();
                String title = textInputEtTitle.getText().toString();
                String content = textInputEtContent.getText().toString();

                Intent intent = getIntent();
                intent.putExtra("name", name);
                intent.putExtra("nickname", nickname);
                intent.putExtra("title", title);
                intent.putExtra("content", content);
                setResult(RESULT_OK, intent);
                finish();
            });
            AlertDialog dialog = builder.create();
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        });
    }
}