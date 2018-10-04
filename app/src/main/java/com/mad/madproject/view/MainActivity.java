package com.mad.madproject.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mad.madproject.R;
import com.mad.madproject.contract.MainContract;
import com.mad.madproject.exception.NoRecipeException;
import com.mad.madproject.model.recipeRelated.remote.RecipeRemoteDataSource;
import com.mad.madproject.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private Button mButton;
    private EditText mRecipe;
    private ProgressDialog mProgressDialog;
    private Toast mToast;
    private MainContract.Presenter mPresenter;
    private int mduration = Toast.LENGTH_LONG;
    private Context mContext;
    final private CharSequence mtoastText ="No recipes found.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecipe = (EditText)findViewById(R.id.searchET);
        mButton = (Button)findViewById(R.id.searchBtn);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Searching...");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String ingradiant = mRecipe.getText().toString();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        //what the thread is going to do.
                        mProgressDialog.show();
                        mPresenter.getSearchRecipies(ingradiant);
                    }
                };
                runnable.run();
            }
        });

        //this will make sure that Presenter is properly initiated, with the singleton code of RecipeRemoteDatasource and the view it self.
        mPresenter = new MainPresenter(RecipeRemoteDataSource.getInstance(),this);
    }

    @Override
    public void getSearchResult() {
        mProgressDialog.cancel();
        Log.d("Justed to getSearchREsult()", "");
        Intent intent = new Intent(MainActivity.this,RecipesActivity.class);
        intent.setClass(getApplicationContext(), RecipesActivity.class);
        startActivity(intent);

    }

    @Override
    public void showNoRecipeException(NoRecipeException e) {
        mProgressDialog.cancel();
        mContext = getApplicationContext();
        Toast toast = Toast.makeText(mContext,mtoastText,mduration);
        toast.show();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }




}
