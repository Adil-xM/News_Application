package com.example.newsapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Adapter;
import com.example.newsapp.AppUtil;
import com.example.newsapp.Model;
import com.example.newsapp.R;
import com.example.newsapp.databinding.FragmentHomeBinding;
import com.example.newsapp.impoNews;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    String api_key="f467e9c2a27b407f96206f695c938d93";
    ArrayList<Model> modelclassArray;
    Adapter adapter;
    String country="ma";
    private RecyclerView recyclerViewhome;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,null);
        recyclerViewhome=view.findViewById(R.id.recyclerviewHome);
        modelclassArray=new ArrayList<>();
        recyclerViewhome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelclassArray);
        recyclerViewhome.setAdapter(adapter);

        findNewsMethod();
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;
       // homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return view;
    }

    private void findNewsMethod() {
        AppUtil.getApiInterface().getNews(country,50,api_key).enqueue(new Callback<impoNews>() {
            @Override
            public void onResponse(Call<impoNews> call, Response<impoNews> response) {
                if (response.isSuccessful()){
                    modelclassArray.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<impoNews> call, Throwable t) {

            }
        });
    }

   /* @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/
}