package com.android.alextroy.lesson2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d(getTag(), "onCreate");
//        Toast.makeText(this, getTag() + " onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getTag(), "onStart");
//        Toast.makeText(this, getTag() + " onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getTag(), "onResume");
//        Toast.makeText(this, getTag() + " onResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(getTag(), "onPause");
//        Toast.makeText(this, getTag() + " onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(getTag(), "onStop");
//        Toast.makeText(this, getTag() + " onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(getTag(), "onDestroy");
//        Toast.makeText(this, getTag() + " onDestroy", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(getTag(), "onSaveInstanceState");
//        Toast.makeText(this, getTag() + " onSaveInstanceState", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(getTag(), "onRestoreInstanceState");
//        Toast.makeText(this, getTag() + " onRestoreInstanceState", Toast.LENGTH_LONG).show();
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(getTag(), "onActivityResult");
    }

    protected abstract String getTag();
}
