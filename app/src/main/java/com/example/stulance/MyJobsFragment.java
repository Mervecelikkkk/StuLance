package com.example.stulance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import Adapter.SectionPagerAdapter;

public class MyJobsFragment extends Fragment {
    View myFragment;
    ViewPager viewPager;
    TabLayout tabLayout;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment= inflater.inflate(R.layout.fragment_my_jobs, container, false);
        viewPager=myFragment.findViewById(R.id.viewPager);
        tabLayout=myFragment.findViewById(R.id.tabLayout);
        return  myFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter=new SectionPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new WorkFragment(),  "Work In Progress" );
        adapter.addFragment(new PastFragment(), "Past Projects");

        viewPager.setAdapter(adapter);

    }
}
