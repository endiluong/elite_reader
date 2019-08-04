package com.example.elitereader.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elitereader.Adapters.Home_RCV_Adapter;
import com.example.elitereader.Models.Novel;
import com.example.elitereader.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ArrayList<Novel> novels;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_home);
        novels = Novel.createNovelList(20);

        Home_RCV_Adapter adapter = new Home_RCV_Adapter(novels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }

}
