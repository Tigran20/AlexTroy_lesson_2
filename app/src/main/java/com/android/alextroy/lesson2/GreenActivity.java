package com.android.alextroy.lesson2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GreenActivity extends BaseActivity {

    public static final String BUNDLE_FROM_GREEN_TO_BLUE = "bundle_from_green_to_blue";
    final int REQV_CODE = 2;

    Button toBlue;
    String greenMessage = "Hello from Green Activity!";

    @Override
    protected String getTag() {
        return "TFS_ " + GreenActivity.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green);

        toBlue = findViewById(R.id.to_blue);

        toBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlueActivity.startForResult(GreenActivity.this, REQV_CODE);

                Intent intent = new Intent(GreenActivity.this, BlueActivity.class);
                intent.putExtra(BUNDLE_FROM_GREEN_TO_BLUE, greenMessage);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQV_CODE && resultCode == RESULT_OK) {
            Log.d(getTag(), "We have message from Blue Act: " + data.getExtras().getString(BlueActivity.BUNDLE_ITEM));
            Toast.makeText(this, "We have message from Blue Act: " + data.getExtras().getString(BlueActivity.BUNDLE_ITEM), Toast.LENGTH_LONG).show();
        } else {
            Log.d(getTag(), "We have not message from Blue Act: something went wrong :( ");
            Toast.makeText(this, "We have not message from Blue Act: something went wrong :( ", Toast.LENGTH_SHORT).show();
        }
    }

}
