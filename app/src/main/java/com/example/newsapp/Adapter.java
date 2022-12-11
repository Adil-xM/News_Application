package com.example.newsapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.security.AccessControlContext;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<Model> modelclassArray;


    public Adapter(Context context, ArrayList<Model> modelclassArray) {
        this.context = context;
        this.modelclassArray = modelclassArray;
    }



    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(R.layout.items_layout,null,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,webview.class);
                intent.putExtra("url",modelclassArray.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.date.setText("publier a "+modelclassArray.get(position).getPublishedAT());
        holder.author.setText(modelclassArray.get(position).getAuthor());
        holder.heading.setText(modelclassArray.get(position).getTitle());
        holder.content.setText(modelclassArray.get(position).getDescription());
        //Glide.with(context).load(modelclassArray.get(position).getUrlToimage()).placeholder(android.R.drawable.progress_indeterminate_horizontal).error(android.R.drawable.stat_notify_error).into(holder.image);
       //if(modelclassArray.get(position).getUrlToimage()!="null" || modelclassArray.get(position).getUrlToimage()!="")
        //Glide.with(context).load(modelclassArray.get(position).getUrlToimage()).dontAnimate().into(holder.image);
        //ImageLoader.getInstance().displayImage(modelclassArray.get(position).getUrlToimage(),holder.image);

    }

    @Override
    public int getItemCount() {
        return modelclassArray.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading,content,author,date;
        CardView cardview;
        ImageView image;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            heading=itemView.findViewById(R.id.mainhead);
            content=itemView.findViewById(R.id.content);
            author=itemView.findViewById(R.id.author);
            date=itemView.findViewById(R.id.date);
            image=itemView.findViewById(R.id.imageView);
            cardview=itemView.findViewById(R.id.cardviewid);


        }
    }
}
