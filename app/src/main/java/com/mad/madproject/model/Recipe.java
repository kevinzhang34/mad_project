package com.mad.madproject.model;

import com.google.gson.annotations.SerializedName;
import com.mad.madproject.StaticContent;

import java.io.Serializable;

public class Recipe implements Serializable{

    @SerializedName(StaticContent.Model.RecipeAttributes.RECIPE_ID)
    private String mRecipeId;

    @SerializedName(StaticContent.Model.RecipeAttributes.IMAGE_URL)
    private String mImageURL;

    @SerializedName(StaticContent.Model.RecipeAttributes.SOURCE_URL)
    private String mSourceUrl;

    @SerializedName(StaticContent.Model.RecipeAttributes.F2F_URL)
    private String mF2fUrl;

    @SerializedName(StaticContent.Model.RecipeAttributes.TITLE)
    private String mTitle;

    @SerializedName(StaticContent.Model.RecipeAttributes.PUBLISHER)
    private String mPublisher;

    @SerializedName(StaticContent.Model.RecipeAttributes.PUBLISHER_URL)
    private String mPublisherUrl;

    @SerializedName(StaticContent.Model.RecipeAttributes.SOCIAL_RANK)
    private String mSocialRank;

    @SerializedName(StaticContent.Model.RecipeAttributes.INGREDIENTS)
    private String[] mIngredients;

    public String getRecipeId() {
        return mRecipeId;
    }

    public void setRecipeId(String id) {
        this.mRecipeId = id;
    }

    public String getmImageURL() {
        return mImageURL;
    }

    public void setmImageURL(String mImageURL) {
        this.mImageURL = mImageURL;
    }

    public String getmSourceUrl() {
        return mSourceUrl;
    }

    public void setmSourceUrl(String mSourceUrl) {
        this.mSourceUrl = mSourceUrl;
    }

    public String getmF2fUrl() {
        return mF2fUrl;
    }

    public void setmF2fUrl(String mF2fUrl) {
        this.mF2fUrl = mF2fUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmPublisher() {
        return mPublisher;
    }

    public void setmPublisher(String mPublisher) {
        this.mPublisher = mPublisher;
    }

    public String getmPublisherUrl() {
        return mPublisherUrl;
    }

    public void setmPublisherUrl(String mPublisherUrl) {
        this.mPublisherUrl = mPublisherUrl;
    }

    public String getmSocialRank() {
        return mSocialRank;
    }

    public void setmSocialRank(String mSocialRank) {
        this.mSocialRank = mSocialRank;
    }

    public String[] getmIngredients() {
        return mIngredients;
    }

    public void setmIngredients(String[] mIngredients) {
        this.mIngredients = mIngredients;
    }

    public Recipe(){}
}
