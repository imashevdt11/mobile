package com.example.avatarbook.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.avatarbook.databinding.FragmentAllFriendsBinding;
import com.example.avatarbook.room.AppDataBase;
import com.example.avatarbook.room.StudentDao;
import com.example.avatarbook.ui.dashboard.StudentAdapter;


public class AllFriendsFragment extends Fragment {
    private FragmentAllFriendsBinding binding;
    private AppDataBase appDataBase;
    private StudentDao studentDao;
    private StudentAdapter studentAdapter;
    RecyclerView rv_main_catalog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentAllFriendsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        rv_main_catalog = binding.rvMain;
        studentAdapter = new StudentAdapter();

        rv_main_catalog.setAdapter(studentAdapter);

        appDataBase = Room.databaseBuilder(binding.getRoot().getContext()
                        ,AppDataBase.class,"database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        studentDao = appDataBase.studentDao();
        studentAdapter.setList(studentDao.getAll());
        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}