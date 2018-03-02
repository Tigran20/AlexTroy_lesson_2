package com.android.alextroy.lesson2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RedActivity extends BaseActivity {

    Button toGreen;

    @Override
    protected String getTag() {
        return "TFS_ " + RedActivity.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toGreen = findViewById(R.id.to_green);

        toGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RedActivity.this, GreenActivity.class);
                startActivity(intent);
            }
        });
    }
}
