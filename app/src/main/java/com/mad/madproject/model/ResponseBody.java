package com.mad.madproject.model;

import com.google.gson.annotations.SerializedName;
import com.mad.madproject.StaticContent;

import java.util.List;

public class ResponseBody {

    private Integer count;

    private List<Recipe> recipes;

    public ResponseBody(){}

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
