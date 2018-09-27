package com.mad.madproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mad.madproject.R;

public class MainActivity extends AppCompatActivity {
    public Button mButton;
    EditText mRecipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecipe = (EditText)findViewById(R.id.searchET);
        mButton = (Button)findViewById(R.id.searchBtn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recipe = mRecipe.getText().toString();
                Intent intent = new Intent(MainActivity.this,SecActivity.class);
                intent.putExtra("Recipe",recipe);
                startActivity(intent);
            }
        });
    }
}
