package com.example.furniture.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.airbnb.lottie.LottieAnimationView;
import com.example.furniture.R;
import com.example.furniture.databinding.FragmentHomeBinding;
import com.example.furniture.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    List<CategoryModel> list_category = new ArrayList<>();

    CategoryAdapter adapter;

    LottieAnimationView lotty_sale, lotty_ad;

    NavController navController;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//        lotty_ad = binding.lottySale;
//        lotty_sale = binding.lottyAd;
//        lotty_ad.setAnimation(R.raw.sale);
//        lotty_sale.setAnimation(R.raw.furnituree);
        createList();
        adapter = new CategoryAdapter();
        adapter.setMain_list(list_category);
        binding.rvCatalogCategory.setAdapter(adapter);
        return root;
    }

    private void createList() {
        list_category.add(new CategoryModel("Bedroom", R.drawable.bedroom));
        list_category.add(new CategoryModel("Zal", R.drawable.living_room));
        list_category.add(new CategoryModel("Kitchen", R.drawable.kitchen));
        list_category.add(new CategoryModel("Kids", R.drawable.kids));
        list_category.add(new CategoryModel("Garden", R.drawable.garden));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.saleCardView.setOnClickListener(v -> {
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_navigation_home_to_fragment_sale);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}