package com.example.jpham.recipesearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class RecipeListActivity extends AppCompatActivity {
    private ListView lvRecipes;
    private RecipeAdapter recipeAdapter;
    private RecipeClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        lvRecipes = findViewById(R.id.lvRecipes);
        ArrayList<Recipe> aRecipes = new ArrayList<>();
        recipeAdapter = new RecipeAdapter(this, aRecipes);
        lvRecipes.setAdapter(recipeAdapter);
        fetchRecipes();
    }

    private void fetchRecipes() {
        client = new RecipeClient();
        client.getRecipes("burger", new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response){
                try {
                    JSONArray results = null;
                    if (response != null){
                        results = response.getJSONArray("results");
                        final ArrayList<Recipe> recipes = Recipe.fromJson(results);
                        recipeAdapter.clear();
                        for (Recipe recipe : recipes){
                            recipeAdapter.add(recipe);
                        }
                        recipeAdapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
            }
        }

