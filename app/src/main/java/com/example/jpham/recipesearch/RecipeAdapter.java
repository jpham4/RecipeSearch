package com.example.jpham.recipesearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class RecipeAdapter extends ArrayAdapter<Recipe> {
    public RecipeAdapter(@NonNull Context context, ArrayList<Recipe> aRecipes) {
        super(context, 0, aRecipes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        return null;
    }
}
