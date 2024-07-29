package com.jahid.homegardening;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jahid.homegardening.aderpters.ItemsModel;
import com.jahid.homegardening.aderpters.recyclerViewAdapter;
import com.jahid.homegardening.databinding.FragmentRoofBinding;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;


public class RoofFragment extends Fragment {


    private FragmentRoofBinding binding;
    private List<ItemsModel> itemsModelList;

    public RoofFragment(List<ItemsModel> itemsModelList) {
        this.itemsModelList = itemsModelList;
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

        binding.itemRecyclerView.setHasFixedSize(true);
        binding.itemRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.itemRecyclerView.setAdapter(new recyclerViewAdapter(requireContext(), itemsModelList, new recyclerViewAdapter.isClicked() {
            @Override
            public void getItemClick(int itemPosition) {

                startActivity(new Intent(requireContext(),UnderConstruction.class));
                FancyToast.makeText(requireContext(),"Wake him up please.....",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
            }

            @Override
            public void getFavClick(int favPosition) {
                FancyToast.makeText(requireContext(),"Clickd on favorite button",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
            }
        }));



    }
}