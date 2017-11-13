package com.example.elsie.framelayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Elsie on 2017/11/3.
 * 聊天区界面
 * 这个类只是实现显示聊天界面
 * 这是个类，不是活动
 */

public class ChatFragment extends android.support.v4.app.Fragment{

//    声明关于侧滑菜单的相关变量
//    private Toolbar                 toolbar;
//    private DrawerLayout            mDrawerLayout;
//    private ActionBarDrawerToggle   mDrawerToggle;
//    private ListView                lvLeftMenu;
//    private String[]                lvs={"item1","item2"};
//    private ArrayAdapter            arrayAdapter;
//    实现动画效果
//    private AnimationDrawable       mAnimationDrawable;

//    加载聊天界面
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat,container,false);

//        //        获取控件
//        toolbar = (Toolbar)view.findViewById(R.id.tl_custom);
//        mDrawerLayout = (DrawerLayout)view.findViewById(R.id.dl_left);
//        lvLeftMenu = (ListView)view.findViewById(R.id.lv_left_menu);
////        findView();
//
//
//////        设置标题栏
//        toolbar.setTitle("分类");
//        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
////        setSupportActionBar(toolbar);
////        设置返回键可用
////        getSupportActionBar().setHomeButtonEnabled(true);
////        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//
//
//        mDrawerToggle.syncState();
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//
//
////        设置菜单列表
//
//        arrayAdapter = new ArrayAdapter (getActivity(),android.R.layout.simple_list_item_1,lvs);
//        lvLeftMenu.setAdapter(arrayAdapter);


        return view;
 }

//    @Override
//    public void onStart() {
//        super.onStart();
//        toolbar = (Toolbar)getView().findViewById(R.id.tl_custom);
//        mDrawerLayout = (DrawerLayout)getView().findViewById(R.id.dl_left);
//        lvLeftMenu = (ListView)getView().findViewById(R.id.lv_left_menu);
//
//    }

//
//    private void findView() {
//        toolbar = (Toolbar)getView().findViewById(R.id.tl_custom);
//        mDrawerLayout = (DrawerLayout)getView().findViewById(R.id.dl_left);
//        lvLeftMenu = (ListView)getView().findViewById(R.id.lv_left_menu);
//    }
//
}
