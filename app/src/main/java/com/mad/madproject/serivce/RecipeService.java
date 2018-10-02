package com.mad.madproject.serivce;

import com.mad.madproject.StaticContent;

import com.mad.madproject.model.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeService {

    @GET(StaticContent.httpURL.searchAPI)
    Call<ResponseBody> listRecipes(@Query("key") String key, @Query("q") String Indianians);

}
