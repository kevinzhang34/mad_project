package com.mad.madproject.exception;

public class NoRecipeException extends RuntimeException {

    private String mErrorMessage = "No Recipes";

    public String getErrorMessage() {
        return mErrorMessage;
    }
}
