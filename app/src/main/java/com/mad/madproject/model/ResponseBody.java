package com.mad.madproject.model;

import com.google.gson.annotations.SerializedName;
import com.mad.madproject.StaticContent;
import com.mad.madproject.model.recipeRelated.Recipe;

import java.util.List;

public class ResponseBody {

    @SerializedName(StaticContent.Model.ResponseAttributes.COUNT)
    private Integer mCount;

    @SerializedName(StaticContent.Model.ResponseAttributes.RECIPES)
    private List<Recipe> mRecipes;

    public ResponseBody(){}

    public Integer getmCount() {
        return mCount;
    }

    public void setmCount(Integer mCount) {
        this.mCount = mCount;
    }

    public List<Recipe> getmRecipes() {
        return mRecipes;
    }

    public void setmRecipes(List<Recipe> mRecipes) {
        this.mRecipes = mRecipes;
    }
}
