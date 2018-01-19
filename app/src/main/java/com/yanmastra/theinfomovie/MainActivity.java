package com.yanmastra.theinfomovie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.Toast;

import com.yanmastra.theinfomovie.adapter.category.CategoryAdapter;
import com.yanmastra.theinfomovie.adapter.category.CategoryItemsAdapter;
import com.yanmastra.theinfomovie.model.category.Category;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements CategoryItemsAdapter.ItemClickListener{
    private List<Category> categories = new ArrayList<>();
    @BindView(R.id.rv_movies) RecyclerView rvMovies;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setData();
        categoryAdapter = new CategoryAdapter(categories);
        rvMovies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvMovies.setHasFixedSize(true);
        rvMovies.setAdapter(categoryAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.category_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setData(){
        Category category;
        for (int i=0 ; i<5; i++){
            category = new Category();
            List<String> dataItems = new ArrayList<>();
            for (int j=i; j<10; j++){
                dataItems.add("data ke "+i+", "+j);
            }
            CategoryItemsAdapter itemsAdapter = new CategoryItemsAdapter(dataItems, this);
            category.setCtgName("Category "+i);
            category.setCtgKey("Category key "+i);
            category.setAdapter(itemsAdapter);
            categories.add(category);
        }
    }

    @Override
    public void onItemClick(String data, int position) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    //TODO (1) creating model real data
    //TODO (2) creating data request

}
