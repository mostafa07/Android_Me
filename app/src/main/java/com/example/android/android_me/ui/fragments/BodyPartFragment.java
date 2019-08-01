package com.example.android.android_me.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment implements View.OnClickListener {

    private List<Integer> mImageIds;
    private int mListIndex;
    private ImageView mImageView;

    private static final String IMAGE_IDS_BUNDLE_KEY = "image_ids";
    private static final String LIST_INDEX_BUNDLE_KEY = "list_index";

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_IDS_BUNDLE_KEY);
            mListIndex = savedInstanceState.getInt(LIST_INDEX_BUNDLE_KEY);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        mImageView = rootView.findViewById(R.id.imageView);
        mImageView.setImageResource(mImageIds.get(mListIndex));
        mImageView.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(IMAGE_IDS_BUNDLE_KEY, (ArrayList<Integer>) mImageIds);
        outState.putInt(LIST_INDEX_BUNDLE_KEY, mListIndex);
    }

    @Override
    public void onClick(View view) {
        if (mListIndex < mImageIds.size() - 1) {
            ++mListIndex;
        } else {
            mListIndex = 0;
        }

        mImageView.setImageResource(mImageIds.get(mListIndex));
    }

    public void setImageIds(List<Integer> imageIds) {
        this.mImageIds = imageIds;
    }

    public void setListIndex(int listIndex) {
        this.mListIndex = listIndex;
    }
}
