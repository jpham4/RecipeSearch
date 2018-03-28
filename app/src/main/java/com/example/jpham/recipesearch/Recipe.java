package com.example.jpham.recipesearch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Recipe {
    private String id;
    private String title;
    private int readyInMinutes;
    private String image;

    public Recipe(String id, String title, int readyInMinutes, String image ){
        this.id = id;
        this.title = title;
        this.image = image;
        this.readyInMinutes = readyInMinutes;
    }

    public Recipe() {

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public String getImage() {
        return image;
    }

    public static Recipe fromJson(JSONObject jsonObject){
        Recipe recipe = new Recipe();
        try {
            recipe.id = jsonObject.getString("id");
            recipe.title = jsonObject.getString("title");
            recipe.readyInMinutes = jsonObject.getInt("readyInMinutes");
            recipe.image = jsonObject.getString("image");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return recipe;
    }

    public static ArrayList<Recipe> fromJson(JSONArray jsonArray){
        ArrayList<Recipe> recipes = new ArrayList<>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject recipeJson = null;
            try {
                recipeJson = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }
            Recipe recipe = Recipe.fromJson(recipeJson);
            if (recipe != null){
                recipes.add(recipe);
            }
        }
        return recipes;
    }
}
