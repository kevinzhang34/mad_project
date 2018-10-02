package com.mad.madproject;

public interface StaticContent {

    interface httpURL {
        String Httpapi = "https://www.food2fork.com/api/";
        String searchAPI = "search";
        String recipeAPI = "get";
        String apiKEY = "62faf53331c64544196c73615054989a";
    }

    interface Model {
        String RECIPE = "recipe";
        interface ResponseAttributes {
            String COUNT = "count";
            String RECIPES = "recipes";
        }

        interface RecipeAttributes {
            String IMAGE_URL = "image_url";
            String SOURCE_URL = "source_url";
            String F2F_URL = "f2f_url";
            String TITLE = "title";
            String PUBLISHER = "publisher";
            String PUBLISHER_URL = "publisher_url";
            String SOCIAL_RANK = "social_rank";
            String INGREDIENTS = "ingredients";
        }
    }
}
