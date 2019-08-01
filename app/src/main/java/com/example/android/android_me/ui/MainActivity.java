package com.example.android.android_me.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;
import com.example.android.android_me.ui.fragments.BodyPartFragment;
import com.example.android.android_me.ui.fragments.MasterListFragment;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int mHeadIndex;
    private int mBodyIndex;
    private int mLegIndex;

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.android_me_linear_layout) != null) {
            mTwoPane = true;

            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setVisibility(View.GONE);

            if (savedInstanceState == null) {
                FragmentManager fragmentManager = getSupportFragmentManager();

                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setImageIds(AndroidImageAssets.getHeads());

                BodyPartFragment bodyFragment = new BodyPartFragment();
                bodyFragment.setImageIds(AndroidImageAssets.getBodies());

                BodyPartFragment legFragment = new BodyPartFragment();
                legFragment.setImageIds(AndroidImageAssets.getLegs());

                fragmentManager.beginTransaction()
                        .add(R.id.headContainerFrame, headFragment)
                        .add(R.id.bodyContainerFrame, bodyFragment)
                        .add(R.id.legContainerFrame, legFragment)
                        .commit();
            }
        } else {
            mTwoPane = false;

            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("headIndex", mHeadIndex);
                    bundle.putInt("bodyIndex", mBodyIndex);
                    bundle.putInt("legIndex", mLegIndex);

                    Intent intent = new Intent(MainActivity.this, AndroidMeActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onImageClick(int position) {
        final int whichPart = position / 12;
        int clickedIndex = position - 12 * whichPart;

        if (mTwoPane) {
            BodyPartFragment newBodyPartFragment = new BodyPartFragment();

            switch (whichPart) {
                case 0:
                    newBodyPartFragment.setImageIds(AndroidImageAssets.getHeads());
                    newBodyPartFragment.setListIndex(clickedIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.headContainerFrame, newBodyPartFragment)
                            .commit();
                    break;
                case 1:
                    newBodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
                    newBodyPartFragment.setListIndex(clickedIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.bodyContainerFrame, newBodyPartFragment)
                            .commit();
                    break;
                case 2:
                    newBodyPartFragment.setImageIds(AndroidImageAssets.getLegs());
                    newBodyPartFragment.setListIndex(clickedIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.legContainerFrame, newBodyPartFragment)
                            .commit();
                    break;
                default:
                    break;
            }
        } else {
            switch (whichPart) {
                case 0:
                    mHeadIndex = clickedIndex;
                    break;
                case 1:
                    mBodyIndex = clickedIndex;
                    break;
                case 2:
                    mLegIndex = clickedIndex;
                    break;
                default:
                    break;
            }
        }
    }
}
