package com.example.elsie.framelayout;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elsie on 2017/11/3.
 * 聊天区界面
 */

public class ChatFragment extends android.support.v4.app.Fragment {
    //public class ChatFragment extends FragmentActivity{
//    private List<comment> chatList=new ArrayList<>();
//    private RecyclerView chatRecyclerView;
//    private ChatAdapter adapter;
    //加载聊天界面
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chat, container, false);


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Fresco.initialize(this);
//        setContentView(R.layout.chat);
//        initMsgs();//初始化消息数据
//        chatRecyclerView =(RecyclerView)findViewById(R.id.chat_activity);
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
//        chatRecyclerView.setLayoutManager(layoutManager);
//        adapter =new ChatAdapter(chatList);
//        chatRecyclerView.setAdapter(adapter);
//    }
//
//    private void initMsgs() {
//        comment chat1=new comment("Tom","12:00","TestTest",0,0,0);
//        chatList.add(chat1);
//        comment chat2=new comment("Tom","12:00","TestTest",0,0,0);
//        chatList.add(chat2);
//        comment chat3=new comment("Tom","12:00","TestTest",0,0,0);
//        chatList.add(chat3);
//
//    }

    }
}
