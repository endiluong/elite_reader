package com.example.elitereader.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elitereader.Models.Novel;
import com.example.elitereader.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Home_RCV_Adapter extends RecyclerView.Adapter<Home_RCV_Adapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgV;
        public TextView tvName, tvChapter, tvInformation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgV = (ImageView) itemView.findViewById(R.id.home_item_img);
            tvName = (TextView) itemView.findViewById(R.id.home_item_tv_name);
            tvChapter = (TextView) itemView.findViewById(R.id.home_item_tv_chapter);
            tvInformation = (TextView) itemView.findViewById(R.id.home_item_tv_info);
        }
    }

    private List<Novel> mNovels;

    public Home_RCV_Adapter(List<Novel> novels) {
        this.mNovels = novels;
    }

    @NonNull
    @Override
    public Home_RCV_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflat custom layout
        View view = inflater.inflate(R.layout.home_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Novel novel = mNovels.get(position);
        //
        ImageView imageView = holder.imgV;
        TextView tvName = holder.tvName;
        TextView tvChapter = holder.tvChapter;
        TextView tvInformation = holder.tvInformation;


        tvName.setText(novel.getName());
        tvChapter.setText(novel.getChapter());
        tvInformation.setText(novel.getDescription());
        imageView.setImageResource(R.drawable.ic_notifications_black_24dp);


    }

    @Override
    public int getItemCount() {
        return mNovels.size();
    }
}
