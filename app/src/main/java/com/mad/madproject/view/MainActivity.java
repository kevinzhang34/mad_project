package com.mad.madproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mad.madproject.R;
import com.mad.madproject.StaticContent;
import com.mad.madproject.contract.MainContract;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.model.RecipesIntentObject;
import com.mad.madproject.model.recipeRelated.remote.RecipeRemoteDataSource;
import com.mad.madproject.presenter.MainPresenter;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private Button mButton;
    private EditText mRecipe;

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
                mPresenter.getSearchRecipies(recipe);
            }
        });

        //this code will make sure that Presenter is properly initiated, with the singleton code of RecipeRemoteDatasource and the view it self.
        mPresenter = new MainPresenter(RecipeRemoteDataSource.getInstance(),this);
    }

    @Override
    public void getSearchResult(RecipesIntentObject recipes) {
        Intent intent = new Intent(MainActivity.this,RecipesActivity.class);
        Bundle bundle = new Bundle();
        //sending an object via bundle, the object must be implementing serializable.
        bundle.putSerializable(StaticContent.Model.RECIPES, recipes);
        intent.setClass(getApplicationContext(), RecipesActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }


}
