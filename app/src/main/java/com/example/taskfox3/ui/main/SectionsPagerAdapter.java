package com.example.taskfox3.ui.main;

import android.content.Context;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskfox3.MainActivity;
import com.example.taskfox3.R;
import com.example.taskfox3.fragment.BlankFragmentCollection;
import com.example.taskfox3.fragment.BlankFragmentMap;
import com.example.taskfox3.fragment.DataAdapter;
import com.example.taskfox3.fragment.DataTable;

import java.util.ArrayList;
import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {


    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;



    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                BlankFragmentCollection blankFragmentCollection= new BlankFragmentCollection();
                return blankFragmentCollection;
            case 1:
                BlankFragmentMap blankFragmentMap = new BlankFragmentMap();
                return blankFragmentMap;
            default:return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }



}
