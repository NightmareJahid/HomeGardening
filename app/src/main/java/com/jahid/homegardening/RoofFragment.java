package com.jahid.homegardening;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import com.jahid.homegardening.Data.AppData;
import com.jahid.homegardening.Activities.ItemData;
import com.jahid.homegardening.Data.ItemsModel;
import com.jahid.homegardening.aderpters.recyclerViewAdapter;
import com.jahid.homegardening.databinding.FragmentRoofBinding;

import java.util.ArrayList;
import java.util.List;


public class RoofFragment extends Fragment{

    private FragmentRoofBinding binding;
    private List<ItemsModel> itemsModelList;
    String tag;
    recyclerViewAdapter adapter;
    AppData appData;

    public RoofFragment(List<ItemsModel> itemsModelList, String tag) {
        this.itemsModelList = itemsModelList;
        this.tag = tag;
    }

    public void setClearButton () {
        itemsModelList.clear();
        adapter.notifyDataSetChanged();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRoofBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appData = AppData.getAppData();
        binding.itemRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        adapter = new recyclerViewAdapter(requireContext(), itemsModelList, new recyclerViewAdapter.isClicked() {
            @Override
            public void getItemClick(int itemPosition) {
                Intent intent = new Intent(requireContext(),ItemData.class);
                intent.putExtra("itemPosition",itemPosition);
                intent.putExtra("tag",tag);
                startActivity(intent);

            }
            @Override
            public void getFavClick(int favPosition) {
                appData.favList.add(itemsModelList.get(favPosition));
            }

            @Override
            public void getDelClick(int delPosition) {
                appData.favList.remove(delPosition);
                Toast.makeText(requireContext(), "পছন্দ তালিকা থেকে সরানো হয়েছে", Toast.LENGTH_SHORT).show();

            }
        },tag);

        binding.itemRecyclerView.setAdapter(adapter);
        binding.swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.notifyDataSetChanged();
                binding.swipeLayout.setRefreshing(false);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


    public void getSearch(String text) {
        List<ItemsModel> filteredList = new ArrayList<>();

        for (ItemsModel itemsModel : itemsModelList) {

            if (itemsModel.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(itemsModel);
            }
            if (!filteredList.isEmpty()) {
                adapter.setFilteredList(filteredList);
            }
        }
    }
}