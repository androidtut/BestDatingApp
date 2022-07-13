package com.example.myquotes.Adapters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myquotes.Models.SharyModels;
import com.example.myquotes.R;

import java.util.ArrayList;

public class SharyAdapters extends RecyclerView.Adapter<SharyAdapters.SharyViewHolder>{
   ArrayList<SharyModels>list;
   Context context;

    public SharyAdapters(ArrayList<SharyModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SharyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_sharyactivity,parent,false);
        return new SharyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull SharyViewHolder holder, int position) {
     final SharyModels models = list.get(position);
     holder.title.setText(models.getTitle());
     setAnimation(holder.itemView);
     holder.share.setOnClickListener(v->{
         Intent intent = new Intent(Intent.ACTION_SEND);
         intent.setType("text/plain");
         intent.putExtra(Intent.EXTRA_TEXT,models.getTitle());
         context.startActivity(intent);
     });

     holder.whatsapp.setOnClickListener(v->{
         Intent intent = new Intent(Intent.ACTION_SEND);
         intent.setType("text/plain");
         intent.setPackage("com.whatsapp");
         intent.putExtra(Intent.EXTRA_TEXT,models.getTitle());
         context.startActivity(intent);
     });

     holder.copy.setOnClickListener(v->{
         ClipboardManager cbManager =  (ClipboardManager)(context.getSystemService(Context.CLIPBOARD_SERVICE));
         ClipData clipData;
         clipData = ClipData.newPlainText("text",models.getTitle());
         cbManager.setPrimaryClip(clipData);
     });

    }

    public void setAnimation(View v){
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right);
        v.setAnimation(animation);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SharyViewHolder extends RecyclerView.ViewHolder{
       TextView title;
       Button share,whatsapp,copy;
        public SharyViewHolder(@NonNull View itemView) {
            super(itemView);
            share = itemView.findViewById(R.id.share);
            whatsapp = itemView.findViewById(R.id.whatsapp);
            copy = itemView.findViewById(R.id.copy);
            title = itemView.findViewById(R.id.sharytext);
        }
    }
}
