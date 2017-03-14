package com.qhn.bhne.xhmusic.mvp.ui.adapter.pagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qhn.bhne.xhmusic.R;
import com.qhn.bhne.xhmusic.application.App;

import java.util.List;

/**
 * Created by qhn
 * on 2016/11/1 0001.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private List<String> mTitles;
    private List<Fragment> mFragmentList;
    private List<Integer> imageResIdList;//gpuv
    public MainPagerAdapter(FragmentManager fm, List<String> mTitles, List<Fragment> mFragmentList, List<Integer> imageResIdList) {
        super(fm);
        this.mTitles = mTitles;
        this.mFragmentList = mFragmentList;
        this.imageResIdList = imageResIdList;
    }


    @Override
    public int getItemPosition(Object object) {
       return POSITION_NONE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    /*@Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }*/
    public View getTabView(int position){
        View view = LayoutInflater.from(App.getAppContext()).inflate(R.layout.tab_item, null);
        TextView tv= (TextView) view.findViewById(R.id.txt_tab_title);
        ImageView img = (ImageView) view.findViewById(R.id.img_tab_icon);
        if (mTitles!=null)
            tv.setText(mTitles.get(position));
        else
            tv.setVisibility(View.GONE);
        if (imageResIdList!=null) {
            img.setImageResource(imageResIdList.get(position));
            img.setVisibility(View.VISIBLE);
        }
        return view;
    }
}
