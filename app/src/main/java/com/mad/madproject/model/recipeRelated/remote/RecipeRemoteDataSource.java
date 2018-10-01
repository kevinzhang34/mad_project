package com.mad.madproject.model.recipeRelated.remote;

import com.google.gson.Gson;
import com.mad.madproject.StaticContent;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.model.recipeRelated.RecipeDataSource;
import com.mad.madproject.serivce.RecipeService;
import com.mad.madproject.util.Convertor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class RecipeRemoteDataSource implements RecipeDataSource {

    private static RecipeRemoteDataSource INSTANCE;

    List<Recipe> mRecipes;

    Retrofit mRetrofit = new Retrofit
            .Builder()
            .baseUrl(StaticContent.httpURL.Httpapi)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //Singleton mode, making sure that you are always getting the same MYSELF.
    public static RecipeRemoteDataSource getInstance() {
        if (INSTANCE == null) INSTANCE = new RecipeRemoteDataSource();
        return INSTANCE;
    }

    @Override
    public List<Recipe> SearchByIngradians(String Ingradians, final GetRecipeCallback callback) {
        RecipeService request = mRetrofit.create(RecipeService.class);
        Convertor convertor = new Convertor();
        Call<List<Recipe>> repos = request.listRecipes(StaticContent.httpURL.apiKEY, Ingradians);
        //the enqueue method will send the request to the destination url.
        repos.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                callback.onRecipeLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {

            }
        });
        return mRecipes;
    }
}
