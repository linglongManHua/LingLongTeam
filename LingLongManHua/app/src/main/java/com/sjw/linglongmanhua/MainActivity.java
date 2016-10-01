package com.sjw.linglongmanhua;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import com.sjw.linglongmanhua.fragment.CaricatureFragment;
import com.sjw.linglongmanhua.fragment.CommunityFragment;
import com.sjw.linglongmanhua.fragment.FindFragment;
import com.sjw.linglongmanhua.fragment.MineFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rgMenu = null;
    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;
    private CaricatureFragment caricatureFragment = null;
    private FindFragment findFragment = null;
    private CommunityFragment communityFragment = null;
    private MineFragment mineFragment = null;
    private Fragment showFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initView();
    }

    private void initView() {
        rgMenu = (RadioGroup) findViewById(R.id.rg_main);
        rgMenu.setOnCheckedChangeListener(this);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (caricatureFragment == null) {
            caricatureFragment = new CaricatureFragment();
            showFragment = caricatureFragment;
            fragmentTransaction.add(R.id.fl_main, caricatureFragment);
            fragmentTransaction.commit();
        }
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (caricatureFragment != null) {
            fragmentTransaction.hide(caricatureFragment);
        }
        if (findFragment != null) {
            fragmentTransaction.hide(findFragment);
        }
        if (communityFragment != null) {
            fragmentTransaction.hide(communityFragment);
        }
        if (mineFragment != null) {
            fragmentTransaction.hide(mineFragment);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (checkedId){
            case R.id.caricature_main:
                if(caricatureFragment!=null){
                    fragmentTransaction.show(caricatureFragment);
                }else{
                    caricatureFragment=new CaricatureFragment();
                    fragmentTransaction.add(R.id.fl_main,caricatureFragment);
                }
                break;
            case R.id.find_main:
                if(findFragment!=null){
                    fragmentTransaction.show(findFragment);
                }else{
                    findFragment=new FindFragment();
                    fragmentTransaction.add(R.id.fl_main,findFragment);
                }
                break;
            case R.id.community_main:
                if(communityFragment!=null){
                    fragmentTransaction.show(communityFragment);
                }else{
                    communityFragment=new CommunityFragment();
                    fragmentTransaction.add(R.id.fl_main,communityFragment);
                }
                break;
            case R.id.mine_main:
                if(mineFragment!=null){
                    fragmentTransaction.show(mineFragment);
                }else{
                    mineFragment=new MineFragment();
                    fragmentTransaction.add(R.id.fl_main,mineFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }
}
