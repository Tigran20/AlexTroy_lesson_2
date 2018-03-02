package com.android.alextroy.lesson2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class YellowActivity extends BaseActivity {

    public static final String BUNDLE_ITEM = "bundle_item";

    private Button toRed;
    private Button sendToBlue;
    private Button getFromGreen;

    @Override
    protected String getTag() {
        return "TFS_ " + YellowActivity.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yellow);

        initViews();
    }

    private void initViews() {
        toRed = findViewById(R.id.to_red);
        sendToBlue = findViewById(R.id.send_to_blue);
        getFromGreen = findViewById(R.id.get_from_green);
    }

    private void setListeners() {
        toRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRedIntent = new Intent(YellowActivity.this, RedActivity.class);
                startActivity(toRedIntent);
            }
        });

        sendToBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toBlueIntent = new Intent(YellowActivity.this, BlueActivity.class);
                toBlueIntent.putExtra(BUNDLE_ITEM, "Hello from Yellow Activity!");
                startActivity(toBlueIntent);
            }
        });

        getFromGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = getIntent().getExtras().getString(BlueActivity.BUNDLE_FROM_BLUE_TO_YELLOW);
                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void removeListeners() {
        toRed.setOnClickListener(null);
        sendToBlue.setOnClickListener(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setListeners();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeListeners();
    }
}
