package com.example.aisletest.home;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.aisletest.R;
import com.example.aisletest.utils.BlurUtils;

public class DiscoverFragment extends Fragment {

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

        Bitmap bitmap = ((BitmapDrawable) ((ImageView) view.findViewById(R.id.beena_iv)).getDrawable()).getBitmap();
        //Let's apply Gaussian blur effect with radius "10.5" and set to ImageView.
        ((ImageView) view.findViewById(R.id.beena_iv)).setImageBitmap(new BlurUtils().blur(DiscoverFragment.this.getActivity(), bitmap, 10.5f));

        Bitmap bitmap2 = ((BitmapDrawable) ((ImageView) view.findViewById(R.id.teena_iv)).getDrawable()).getBitmap();
        //Let's apply Gaussian blur effect with radius "10.5" and set to ImageView.
        ((ImageView) view.findViewById(R.id.teena_iv)).setImageBitmap(new BlurUtils().blur(DiscoverFragment.this.getActivity(), bitmap2, 10.5f));


    }
}