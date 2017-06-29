package kr.co.landvibe.handicraft.main;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import kr.co.landvibe.handicraft.furniture.list.FurnitureListFragment;
import kr.co.landvibe.handicraft.preview.PreviewFragment;
import kr.co.landvibe.handicraft.schedule.ScheduleFragment;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private int tabCount;


    public ViewPageAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PreviewFragment();
            case 1:
                return new ScheduleFragment();
            case 2:
                return new FurnitureListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
