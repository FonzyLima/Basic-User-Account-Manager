package com.mobdeve.s11.lima.alfonso.formetiveexercise4;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class UsersViewHolder extends RecyclerView.ViewHolder {
    private TextView tvUsername, tvName, tvDesc;


    public UsersViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);

        this.tvUsername = itemView.findViewById(R.id.tv_item_username);
        this.tvName = itemView.findViewById(R.id.tv_item_name);
        this.tvDesc = itemView.findViewById(R.id.tv_item_description);
    }

    public void setTvUsername(String username){
        this.tvUsername.setText(username);
    }

    public void setTvName(String name){
        this.tvName.setText(name);
    }

    public void setTvDesc(String desc){
        this.tvDesc.setText(desc);
    }




}
