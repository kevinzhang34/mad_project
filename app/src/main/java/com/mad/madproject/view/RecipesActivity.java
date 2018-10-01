package com.mad.madproject.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mad.madproject.R;

public class SecActivity extends AppCompatActivity {
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        result = getIntent().getExtras().getString("Recipe");

        TextView textview = (TextView)findViewById(R.id.resultTV);
         textview.setText(result);
    }
}
