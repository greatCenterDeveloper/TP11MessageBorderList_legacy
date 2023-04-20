package com.swj.tp11messageborderlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BorderAdapter extends RecyclerView.Adapter<BorderAdapter.VH> {

    Context context;
    ArrayList<BorderItem> borderItems;

    public BorderAdapter(Context context, ArrayList<BorderItem> borderItems) {
        this.context = context;
        this.borderItems = borderItems;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        VH holder = new VH(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        BorderItem border = borderItems.get(position);
        holder.tvName.setText(border.name);
        holder.tvNickname.setText(border.nickname);
        holder.tvTitle.setText(border.title);
        holder.tvContent.setText(border.content);
    }

    @Override
    public int getItemCount() { return borderItems.size(); }

    class VH extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvNickname;
        TextView tvTitle;
        TextView tvContent;

        public VH(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvNickname = itemView.findViewById(R.id.tv_nickname);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
