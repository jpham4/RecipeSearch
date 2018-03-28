package com.example.jpham.recipesearch;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeAdapter extends ArrayAdapter<Recipe> {
    private static class ViewHolder{
        public ImageView ivFoodCover;
        public TextView tvTitle;
        public TextView tvReadyInMinutes;
    }
    public RecipeAdapter(@NonNull Context context, ArrayList<Recipe> aRecipes) {
        super(context, 0, aRecipes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final Recipe recipe = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_recipe, parent, false);
            viewHolder.ivFoodCover = convertView.findViewById(R.id.ivFoodCover);
            viewHolder.tvTitle = convertView.findViewById(R.id.tvTitle);
            viewHolder.tvReadyInMinutes = convertView.findViewById(R.id.tvReadyInMinutes);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvTitle.setText(recipe.getTitle());
        viewHolder.tvReadyInMinutes.setText(recipe.getReadyInMinutes());
        Picasso.with(getContext()).load(Uri.parse(recipe.getImage())).error(R.drawable.ic_nocover).into(viewHolder.ivFoodCover);
        return convertView;
    }
}
