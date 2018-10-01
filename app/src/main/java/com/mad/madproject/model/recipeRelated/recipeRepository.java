package com.mad.madproject.model.recipeRelated;

import com.mad.madproject.StaticContent;
import com.mad.madproject.model.recipe;
import com.mad.madproject.serivce.recipeService;
import com.mad.madproject.util.Convertor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class recipeRepository implements recipeDataSource {

    private final recipeDataSource mRecipeRemoteDataSource;

    private static recipeRepository INSTANCE;

    Retrofit mRetrofit = new Retrofit.
            Builder().
            baseUrl(StaticContent.httpURL.Httpapi).
            addConverterFactory(GsonConverterFactory.create()).
            build();

    List<recipe> mRecipes;

    private recipeRepository(recipeDataSource recipeDataSource) {
        mRecipeRemoteDataSource = recipeDataSource;
    }

    public static recipeRepository getInstance(recipeDataSource recipeDataSource) {
        if (INSTANCE == null) INSTANCE = new recipeRepository(recipeDataSource);
        else return INSTANCE;
        return null;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public List<recipe> SearchByIngradians(String ingradians) {
        recipeService request = mRetrofit.create(recipeService.class);
        Convertor convertor = new Convertor();
        Call<List<recipe>> repos = request.listRecipes(StaticContent.httpURL.apiKEY, ingradians);

        repos.enqueue(new Callback<List<recipe>>() {
            @Override
            public void onResponse(Call<List<recipe>> call, Response<List<recipe>> response) {
                mRecipes = response.body();
            }

            @Override
            public void onFailure(Call<List<recipe>> call, Throwable t) {

            }
        });
        return mRecipes;
    }
}
