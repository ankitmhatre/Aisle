package com.example.aisletest.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.aisletest.R;

public class MatchesFragment extends Fragment {

@Override
public View onCreateView(
        LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState
        ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.discover_fragment, container, false);
        }

public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        }
        }