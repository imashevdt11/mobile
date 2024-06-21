package com.example.clothingapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.clothingapp.databinding.ViewholderCartBinding;
import com.example.clothingapp.domain.PopularDomain;
import com.example.clothingapp.helper.ChangeNumberItemsListener;
import com.example.clothingapp.helper.ManagementCart;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    ArrayList<PopularDomain> items;
    Context context;
    ViewholderCartBinding binding;
    ChangeNumberItemsListener changeNumberItemsListener;
    ManagementCart managementCart;

    public CartAdapter(ArrayList<PopularDomain> items, ChangeNumberItemsListener changeNumberItemsListener) {
        this.items = items;
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderCartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        managementCart = new ManagementCart(context);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.feeEachTime.setText("$" + items.get(position).getPrice());
        binding.totalEachItem.setText("$" + Math.round(items.get(position).getNumberInCart() + items.get(position).getPrice()));
        binding.numberItemTxt.setText(String.valueOf(items.get(position).getNumberInCart()));

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(binding.pic);


        binding.plusCartBtn.setOnClickListener(v -> managementCart.plusNumberItem(items, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.change();
        }));

        binding.minusCartBtn.setOnClickListener(v -> managementCart.minusNumberItem(items, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.change();
        }));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(ViewholderCartBinding binding) {super(binding.getRoot());}
    }
}
