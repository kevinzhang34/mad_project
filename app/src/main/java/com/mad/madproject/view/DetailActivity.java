package com.mad.madproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mad.madproject.R;
import com.mad.madproject.contract.DetailContract;
import com.mad.madproject.contract.RecipesContract;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.model.recipeRelated.remote.RecipeRemoteDataSource;
import com.mad.madproject.presenter.DetailPresenter;

public class DetailActivity extends AppCompatActivity implements DetailContract.View{

    private String mRecipeId;
    private TextView mTitleTextView;
    private TextView mPublisherTextView;
    private TextView mSocialRankTextview;
    private TextView mIngredients;
    private DetailContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mRecipeId = (String) getIntent().getStringExtra("id");
        mPresenter = new DetailPresenter(RecipeRemoteDataSource.getInstance(), this);
        mTitleTextView = (TextView)findViewById(R.id.recipeTitleTV);
        mPublisherTextView = (TextView)findViewById(R.id.publisherTV);
        mSocialRankTextview = (TextView)findViewById(R.id.socialRankTV);
        mIngredients = (TextView)findViewById(R.id.ingredientsTV);


        mPresenter.fetch(mRecipeId);

    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void loadContent(Recipe recipe) {
        mTitleTextView.setText(recipe.getmTitle());
        mPublisherTextView.setText(recipe.getmPublisher());
        mSocialRankTextview.setText(recipe.getmSocialRank());
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: recipe.getmIngredients()) {
            stringBuilder.append(s);
            stringBuilder.append(", ");
        }
        mIngredients.setText(stringBuilder.toString());
    }
}


