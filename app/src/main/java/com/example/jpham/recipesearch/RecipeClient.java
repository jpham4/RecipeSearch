package com.example.jpham.recipesearch;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class RecipeClient {
    private static final String API_BASE_URL = "https://spoonacular.com/food-api";
    private AsyncHttpClient client;

    public RecipeClient(){
        this.client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl){
        return API_BASE_URL + relativeUrl;
    }

    // Method for accessing the search API
    public void getRecipes(final String query, JsonHttpResponseHandler handler){
        try {
            String url = getApiUrl("https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/search");
            client.get(url + URLEncoder.encode(query, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
