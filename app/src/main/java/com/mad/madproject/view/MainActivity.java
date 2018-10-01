package com.mad.madproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mad.madproject.R;
import com.mad.madproject.contract.MainContract;
import com.mad.madproject.model.recipe;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    public Button mButton;
    EditText mRecipe;

    private MainContract.Presenter mPresenter;


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
                mPresenter.getSearch(recipe);
                /**/
            }
        });
    }

    @Override
    public void search() {

    }

    @Override
    public void getPopularRecipe() {

    }

    @Override
    public void openDetailActivity(List<recipe> recipes) {
        Intent intent = new Intent(MainActivity.this,RecipesActivity.class);
        intent.putExtra("Recipe",recipe);
        startActivity(intent);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
     mPresenter = presenter;
    }


}
