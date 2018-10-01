package com.mad.madproject.model.recipeRelated;

import com.mad.madproject.model.recipe;

import java.util.List;

public interface recipeDataSource {

    List<recipe> SearchByIngradians(String Ingradians);
}
