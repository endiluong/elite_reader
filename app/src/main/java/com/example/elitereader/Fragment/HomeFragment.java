package com.example.elitereader.Fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elitereader.Adapters.Home_RCV_Adapter;
import com.example.elitereader.Models.Novel;
import com.example.elitereader.Models.NovelList;
import com.example.elitereader.R;
import com.example.elitereader.network.ApiService;
import com.example.elitereader.network.InternetConnection;
import com.example.elitereader.network.RetroClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    ArrayList<Novel> novels;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_home);

        if (InternetConnection.checkConnection(getContext())) {
            final ProgressDialog dialog;
            Context context;
            dialog = new ProgressDialog(getContext());
            dialog.setTitle("Loading");
            dialog.setMessage("Please Wait,.....");
            dialog.show();
            ApiService api = RetroClient.getApiService();
            //JSON
            Call<NovelList> call = api.getMyJSON();
            call.enqueue(new Callback<NovelList>() {
                @Override
                public void onResponse(Call<NovelList> call, Response<NovelList> response) {
                    dialog.dismiss();
                    if (response.isSuccessful()) {
                        novels = response.body().getNovels();
                        Home_RCV_Adapter adapter = new Home_RCV_Adapter(novels);
                        recyclerView.setAdapter(adapter);
                    } else {
                        Snackbar.make(view, "Error: Something went wrong", 2000).show();
                    }
                }

                @Override
                public void onFailure(Call<NovelList> call, Throwable t) {
                    dialog.dismiss();
                    Snackbar.make(view, "Error: No Internet Connection", 2000).show();

                }
            });
        }


//        novels = Novel.createNovelList(20);


//        Home_RCV_Adapter adapter = new Home_RCV_Adapter(novels);
//        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }

}
