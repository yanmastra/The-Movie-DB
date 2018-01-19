package com.yanmastra.theinfomovie.adapter.category;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanmastra.theinfomovie.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mastra on 1/19/2018.
 */

public class CategoryItemsAdapter extends RecyclerView.Adapter<CategoryItemsAdapter.ItemsViewHolder> {
    List<String> data = new ArrayList<>();
    ItemClickListener onClickListener;

    public interface ItemClickListener{
        void onItemClick(String data, int position);
    }

    public CategoryItemsAdapter(List<String> data, ItemClickListener itemClick) {
        this.data = data;
        this.onClickListener = itemClick;
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.category_items, parent, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {
        holder.bind(data.get(position), position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ItemsViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_content)
        TextView tvContent;
        public ItemsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final String items, final int position){
            tvContent.setText(items);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onItemClick(items, position);
                }
            });
        }
    }
}
