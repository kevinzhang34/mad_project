package com.mad.madproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mad.madproject.R;
import com.mad.madproject.adapter.MyRecipesRecyclerviewAdapter;
import com.mad.madproject.contract.RecipesContract;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.model.recipeRelated.remote.RecipeRemoteDataSource;
import com.mad.madproject.presenter.RecipesPresenter;

import java.util.List;

public class RecipesActivity extends AppCompatActivity implements RecipesContract.View {

    private RecyclerView mRecyclerView;
    private MyRecipesRecyclerviewAdapter mAdapter;
    private RecipesContract.Presenter  mPresenter;

    /**
     * the life cycle method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        TextView textview = (TextView) findViewById(R.id.resultTV);
        mPresenter = new RecipesPresenter(RecipeRemoteDataSource.getInstance(), this);
        mPresenter.retriveRecipes();
    }

    @Override
    public void setPresenter(RecipesContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void displayAllRecipes(List<Recipe> recipes) {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyRecipesRecyclerviewAdapter(recipes, this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
