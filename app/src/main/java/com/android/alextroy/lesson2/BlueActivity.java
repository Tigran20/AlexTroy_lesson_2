package com.android.alextroy.lesson2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BlueActivity extends BaseActivity {

    public static final String BUNDLE_ITEM = "bundle_item";
    public static final String BUNDLE_FROM_BLUE_TO_YELLOW = "bundle_from_blue_to_yellow";

    TextView messageFromYellowTV;
    Button returnResult;
    Button toYellow;
    String mes;

    @Override
    protected String getTag() {
        return "TFS_ " + BlueActivity.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue);

        initViews();

        Intent intent = getIntent();
        mes = intent.getStringExtra(GreenActivity.BUNDLE_FROM_GREEN_TO_BLUE);

        if (intent.hasExtra(YellowActivity.BUNDLE_ITEM)) {
            String messageFromYellow = intent.getStringExtra(YellowActivity.BUNDLE_ITEM);
            messageFromYellowTV.setText(messageFromYellow);
        }
    }

    private void initViews() {
        messageFromYellowTV = findViewById(R.id.message_from_yellow);
        toYellow = findViewById(R.id.to_yellow);
        returnResult = findViewById(R.id.return_result);
    }

    private void setListeners() {
        toYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BlueActivity.this, YellowActivity.class);
                intent.putExtra(BUNDLE_FROM_BLUE_TO_YELLOW, mes);
                startActivity(intent);
            }
        });
        returnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(BUNDLE_ITEM, "Hello from Blue Activity!");
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void removeListeners() {
        toYellow.setOnClickListener(null);
        returnResult.setOnClickListener(null);
    }

    public static void startForResult(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, BlueActivity.class);
        activity.startActivityForResult(intent, requestCode);
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
