package com.mad.madproject.model.recipeRelated.remote;

import android.util.Log;
import com.google.gson.Gson;
import com.mad.madproject.StaticContent;
import com.mad.madproject.exception.NoRecipeException;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.model.ResponseBody;
import com.mad.madproject.model.recipeRelated.RecipeDataSource;
import com.mad.madproject.serivce.RecipeService;
import com.mad.madproject.util.Convertor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class RecipeRemoteDataSource implements RecipeDataSource {

    private static RecipeRemoteDataSource INSTANCE;

    private List<Recipe> mRecipes;

    private Retrofit mRetrofit = new Retrofit
            .Builder()
            .baseUrl(StaticContent.httpURL.Httpapi)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //Singleton mode, making sure that you are always getting the same MYSELF.
    public static RecipeRemoteDataSource getInstance() {
        if (INSTANCE == null) INSTANCE = new RecipeRemoteDataSource();
        return INSTANCE;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.mRecipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return this.mRecipes;
    }

    @Override
    public List<Recipe> SearchByIngradians(String Ingradians, final GetRecipeCallback callback) throws NoRecipeException{

        RecipeService request = mRetrofit.create(RecipeService.class);
        Call<ResponseBody> repos = request.listRecipes(StaticContent.httpURL.apiKEY,Ingradians);
        //the enqueue method will send the request to the destination url.
        repos.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body().getCount() == 0) callback.onDataNotAvailable();
                else {
                    List<Recipe> recipes = response.body().getRecipes();
                    setRecipes(recipes);
                    callback.onRecipeLoaded(recipes);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("Response failed with throwable : ", t.toString());
            }
        });
        return mRecipes;
    }
}
