package kr.co.landvibe.handicraft.main;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import kr.co.landvibe.handicraft.testFragment.TestFragment1;
import kr.co.landvibe.handicraft.testFragment.TestFragment2;
import kr.co.landvibe.handicraft.testFragment.TestFragment3;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private int tabCount;


    public ViewPageAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TestFragment1();
            case 1:
                return new TestFragment2();
            case 2:
                return new TestFragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
