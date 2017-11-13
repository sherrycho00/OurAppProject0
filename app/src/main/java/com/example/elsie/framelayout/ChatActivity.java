package com.example.elsie.framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

        private List<comment> chatList=new ArrayList<>();
        private RecyclerView chatRecyclerView;
        private ChatAdapter adapter;
        //加载聊天界面
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.chat,container,false);


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
//        Fresco.initialize(this);
            setContentView(R.layout.chat);

            initMsgs();//初始化消息数据
            chatRecyclerView =(RecyclerView)findViewById(R.id.chat_activity);
            LinearLayoutManager layoutManager=new LinearLayoutManager(this);
            chatRecyclerView.setLayoutManager(layoutManager);
            adapter =new ChatAdapter(chatList);
            chatRecyclerView.setAdapter(adapter);
        }

    private void initMsgs() {
        comment chat1=new comment("Tom","12:00","TestTest",0,1,0);
        chatList.add(chat1);
        comment chat2=new comment("Tom","12:00","TestTest",3,0,1);
        chatList.add(chat2);
        comment chat3=new comment("Tom","12:00","TestTest",1,0,0);
        chatList.add(chat3);
        comment chat4=new comment("Tom","12:00","TestTest",2,0,0);
        chatList.add(chat3);
        comment chat5=new comment("Tom","12:00","TestTest",4,0,0);
        chatList.add(chat3);
    }
}

