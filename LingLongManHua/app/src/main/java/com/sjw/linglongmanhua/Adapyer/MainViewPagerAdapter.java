package com.sjw.linglongmanhua.Adapyer;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * description：
 * company：
 * Created by kaission on 2016/10/1.
 */
public class MainViewPagerAdapter extends PagerAdapter {
    private List<Fragment> fragmentList=null;
    private List<String> stringList=null;

    public MainViewPagerAdapter(List<Fragment> fragmentList, List<String> stringList) {
        this.fragmentList = fragmentList;
        this.stringList = stringList;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
