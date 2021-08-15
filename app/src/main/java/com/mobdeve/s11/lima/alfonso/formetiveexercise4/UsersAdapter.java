package com.mobdeve.s11.lima.alfonso.formetiveexercise4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder> {


    private ArrayList<Users> dataUsers;
    public UsersAdapter(ArrayList<Users> dataUsers){
        this.dataUsers = dataUsers;
    }
    @NonNull
    @NotNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user,parent,false);

        UsersViewHolder usersViewHolder = new UsersViewHolder(view);

        return usersViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UsersViewHolder holder, int position) {
        holder.setTvDesc(this.dataUsers.get(position).getDescription());
        holder.setTvName(this.dataUsers.get(position).getName());
        holder.setTvUsername(this.dataUsers.get(position).getUsername());
        holder.setTvNumber(this.dataUsers.get(position).getNumber());

    }

    @Override
    public int getItemCount() {
        return this.dataUsers.size();
    }
}
