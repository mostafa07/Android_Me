package com.example.android.android_me.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class BodyPartFragment extends Fragment {

    private int mImageResourceId;

    public BodyPartFragment() {
    }

    public BodyPartFragment(int imageResourceId) {
        mImageResourceId = imageResourceId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView bodyPartImageView = rootView.findViewById(R.id.bodyPartImageView);
        bodyPartImageView.setImageResource(mImageResourceId);
        return rootView;
    }
}
