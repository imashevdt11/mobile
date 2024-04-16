package com.example.furniture.ui.bedroom;

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
import com.example.furniture.databinding.FragmentBedroomBinding;
import com.example.furniture.models.FurnitureModel;

import java.util.ArrayList;
import java.util.List;


public class BedRoomFragment extends Fragment {
    private FragmentBedroomBinding binding;
    List<FurnitureModel> list_bedroom = new ArrayList<>();
    MAdapter adapter;
    NavController navController;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentBedroomBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        createList();
        adapter = new MAdapter();
        adapter.setList_m(list_bedroom);
        binding.rvBedRoom.setAdapter(adapter);
        return root;
    }

    private void createList() {
        list_bedroom.add(new FurnitureModel("Спальня","Кровать Red Flame", "1690",
                "Кровать двухспальная размер 2.6м х 2.4м производство Турция," +
                        " матрас набивной пружинный, кокосовая стружка", R.drawable.bedroom));
        list_bedroom.add(new FurnitureModel("Спальня","Кровать Red Flame", "1690",
                "Кровать двухспальная размер 2.6м х 2.4м производство Турция," +
                        " матрас набивной пружинный, кокосовая стружка", R.drawable.bedroom));
        list_bedroom.add(new FurnitureModel("Спальня","Кровать Red Flame", "1690",
                "Кровать двухспальная размер 2.6м х 2.4м производство Турция," +
                        " матрас набивной пружинный, кокосовая стружка", R.drawable.bedroom));
        list_bedroom.add(new FurnitureModel("Спальня","Кровать Red Flame", "1690",
                "Кровать двухспальная размер 2.6м х 2.4м производство Турция," +
                        " матрас набивной пружинный, кокосовая стружка", R.drawable.bedroom));
        list_bedroom.add(new FurnitureModel("Спальня","Кровать Red Flame", "1690",
                "Кровать двухспальная размер 2.6м х 2.4м производство Турция," +
                        " матрас набивной пружинный, кокосовая стружка", R.drawable.bedroom));
        list_bedroom.add(new FurnitureModel("Спальня","Кровать Red Flame", "1690",
                "Кровать двухспальная размер 2.6м х 2.4м производство Турция," +
                        " матрас набивной пружинный, кокосовая стружка", R.drawable.bedroom));
        list_bedroom.add(new FurnitureModel("Спальня","Кровать Red Flame", "1690",
                "Кровать двухспальная размер 2.6м х 2.4м производство Турция," +
                        " матрас набивной пружинный, кокосовая стружка", R.drawable.bedroom));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnBack.setOnClickListener(v->{
            navController = Navigation.findNavController(requireActivity(),
                    R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_navigation_bed_room_to_navigation_home);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
