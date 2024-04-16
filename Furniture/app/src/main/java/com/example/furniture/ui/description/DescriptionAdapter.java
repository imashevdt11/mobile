package com.example.furniture.ui.description;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furniture.databinding.ItemDescriptionBinding;
import com.example.furniture.models.FurnitureModel;

import java.util.ArrayList;
import java.util.List;

public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionAdapter.ViewHolder> {

    ItemDescriptionBinding binding;

    List<FurnitureModel> listD = new ArrayList<>();

    public void setListD(List<FurnitureModel> listD) {
        this.listD = listD;
    }

    @NonNull
    @Override
    public DescriptionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemDescriptionBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DescriptionAdapter.ViewHolder holder, int position) {
        holder.onBind(listD.get(position));
    }

    @Override
    public int getItemCount() {
        return listD.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull ItemDescriptionBinding itemView) {
            super(itemView.getRoot());
        }

        public void onBind(FurnitureModel furnitureModel) {
            binding.nameCard.setText(furnitureModel.getTitle());
            binding.priceCard.setText(String.valueOf(furnitureModel.getPrice()));
            binding.descriptionCard.setText(furnitureModel.getDescription());
            binding.imageCard.setImageResource(furnitureModel.getImageInt());
        }
    }
}