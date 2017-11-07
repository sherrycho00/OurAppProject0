package com.example.elsie.framelayout;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Elsie on 2017/11/3.
 * 聊天区界面
 */

public class ChatFragment extends android.support.v4.app.Fragment{
//    加载聊天界面
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chat,container,false);
    }
}
