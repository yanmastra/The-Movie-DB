package com.yanmastra.theinfomovie.adapter.category;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yanmastra.theinfomovie.R;
import com.yanmastra.theinfomovie.model.category.Category;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mastra on 1/19/2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    Context context;
    List<Category> categories = new ArrayList<>();

    public CategoryAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.category_list, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.bind(this.categories.get(position), position);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.rv_movie_items) RecyclerView rvMovieItems;
        @BindView(R.id.tv_category) TextView tvCategory;
        @BindView(R.id.tv_see_more) TextView tvSeeMore;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Category category, final int position){
            tvCategory.setText(category.getCtgName());
            rvMovieItems.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            rvMovieItems.setHasFixedSize(true);
            rvMovieItems.setAdapter(category.getAdapter());
            tvSeeMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "See more "+category.getCtgName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
