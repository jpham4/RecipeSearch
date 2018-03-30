package com.example.jpham.recipesearch;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class RecipeClient {
    private AsyncHttpClient client;

    RecipeClient(){

        this.client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl){

        return relativeUrl;
    }

    // Method for accessing the search API
    public void getRecipes(final String query, JsonHttpResponseHandler handler){
        try {
            String url = getApiUrl("https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/search");
            client.addHeader("X-Mashape-Key", "H9O4xN0hDKmshwiRqRSqGj28V9I4p1oEMdYjsn7GuEPdPGOk0q");
            client.addHeader("X-Mashape-Host", "spoonacular-recipe-food-nutrition-v1.p.mashape.com");
            client.get(url + URLEncoder.encode(query, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
