/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;
import com.example.android.android_me.fragments.BodyPartFragment;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        FragmentManager fragmentManager = getSupportFragmentManager();

        BodyPartFragment headFragment = new BodyPartFragment(AndroidImageAssets.getHeads().get(4));
        BodyPartFragment bodyFragment = new BodyPartFragment(AndroidImageAssets.getBodies().get(10));
        BodyPartFragment legFragment = new BodyPartFragment(AndroidImageAssets.getLegs().get(1));

        fragmentManager.beginTransaction()
                .add(R.id.headContainerFrame, headFragment)
                .add(R.id.bodyContainerFrame, bodyFragment)
                .add(R.id.legContainerFrame, legFragment)
                .commit();
    }
}
