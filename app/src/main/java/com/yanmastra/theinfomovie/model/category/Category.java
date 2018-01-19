package com.yanmastra.theinfomovie.model.category;

import com.yanmastra.theinfomovie.adapter.category.CategoryItemsAdapter;

/**
 * Created by Mastra on 1/19/2018.
 */

public class Category {
    private String ctgName;
    private String ctgKey;
    private CategoryItemsAdapter adapter;

    public String getCtgName() {
        return ctgName;
    }

    public void setCtgName(String ctgName) {
        this.ctgName = ctgName;
    }

    public String getCtgKey() {
        return ctgKey;
    }

    public void setCtgKey(String ctgKey) {
        this.ctgKey = ctgKey;
    }

    public CategoryItemsAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(CategoryItemsAdapter adapter) {
        this.adapter = adapter;
    }
}
