package com.homework.ch12;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PastaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_recycler_view,container,false);

        String[] pastaNames = new String[Pasta.pastas.length];
        for(int i=0; i< pastaNames.length; i++){
            pastaNames[i] = Pasta.pastas[i].getName();
        }

        int[] pastaImages = new int[Pasta.pastas.length];
        for(int j=0; j< pastaImages.length; j++){
            pastaImages[j] = Pasta.pastas[j].getImageID();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pastaNames,pastaImages);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(gridLayoutManager);

        return recyclerView;
    }
}