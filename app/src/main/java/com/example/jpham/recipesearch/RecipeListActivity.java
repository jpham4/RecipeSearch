package com.example.jpham.recipesearch;

import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Future;

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

            }
        }

