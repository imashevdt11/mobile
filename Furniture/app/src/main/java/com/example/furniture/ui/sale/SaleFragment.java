package com.example.furniture.ui.sale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.furniture.MAdapter;
import com.example.furniture.R;
import com.example.furniture.databinding.FragmentSaleBinding;
import com.example.furniture.models.FurnitureModel;

import java.util.ArrayList;
import java.util.List;

public class SaleFragment extends Fragment {

    FragmentSaleBinding binding;

    NavController navController;

    List<FurnitureModel> list_s = new ArrayList<>();

    MAdapter adapter;

    public SaleFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSaleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        createList();
        adapter = new MAdapter();
        adapter.setList_m(list_s);
        binding.rvSale.setAdapter(adapter);
        return root;
    }

    private void createList() {
        list_s.add(new FurnitureModel("zal","Some furniture", "77000", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", R.drawable.living_room));
        list_s.add(new FurnitureModel("zal","Some furniture", "77000", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", R.drawable.living_room));
        list_s.add(new FurnitureModel("zal","Some furniture", "77000", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", R.drawable.living_room));
        list_s.add(new FurnitureModel("zal","Some furniture", "77000", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", R.drawable.living_room));
        list_s.add(new FurnitureModel("zal","Some furniture", "77000", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", R.drawable.living_room));
        list_s.add(new FurnitureModel("zal","Some furniture", "77000", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", R.drawable.living_room));
        list_s.add(new FurnitureModel("zal","Some furniture", "77000", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", R.drawable.living_room));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnBack.setOnClickListener(v -> {
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_fragment_sale_to_navigation_home);
        });
    }
}