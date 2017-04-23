package com.example.jitendra.coupon.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.example.jitendra.coupon.fragments.Tab1;
import com.example.jitendra.coupon.fragments.Tab2;
import com.example.jitendra.coupon.fragments.Tab3;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private Fragment currentFragment;
    private AHBottomNavigation bottomNavigation;

    public ViewPagerAdapter(FragmentManager fm, AHBottomNavigation navigation) {
        super(fm);

        this.bottomNavigation = navigation;

        fragmentList.clear();
        fragmentList.add(new Tab1());
        fragmentList.add(new Tab2());

        fragmentList.add(new Tab3());
        //fragmentList.add(new Tab4());
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (currentFragment != object) {
            currentFragment = (Fragment) object;
        }
        bottomNavigation.setCurrentItem(position);
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
