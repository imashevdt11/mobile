package com.example.furniture.ui.categories;

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
import com.example.furniture.databinding.FragmentKidsBinding;
import com.example.furniture.models.FurnitureModel;

import java.util.ArrayList;
import java.util.List;

public class KidsFragment extends Fragment {

    FragmentKidsBinding binding;

    NavController navController;

    List<FurnitureModel> list_kids = new ArrayList<>();

    MAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentKidsBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        createList();
        adapter = new MAdapter();
        adapter.setList_m(list_kids);
        binding.rvKids.setAdapter(adapter);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnBack.setOnClickListener(v->{
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_fragment_kids_to_navigation_home);
        });
    }

    public void createList(){
        list_kids.add(new FurnitureModel("Kids", "Bed", "71711", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", "17%", R.drawable.kids));
        list_kids.add(new FurnitureModel("Kids", "Bed", "71711", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", "17%", R.drawable.kids));
        list_kids.add(new FurnitureModel("Kids", "Bed", "71711", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", "17%", R.drawable.kids));
        list_kids.add(new FurnitureModel("Kids", "Bed", "71711", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", "17%", R.drawable.kids));
        list_kids.add(new FurnitureModel("Kids", "Bed", "71711", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", "17%", R.drawable.kids));
        list_kids.add(new FurnitureModel("Kids", "Bed", "71711", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", "17%", R.drawable.kids));
        list_kids.add(new FurnitureModel("Kids", "Bed", "71711", "Lorem ipsum dolor sit amet, consecrate disciplining elit. Fuse commodo gulag in nisi consequat, at interdict null commodo.", "17%", R.drawable.kids));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}