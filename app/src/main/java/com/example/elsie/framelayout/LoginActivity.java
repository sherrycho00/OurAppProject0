package com.example.elsie.framelayout;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

public class LoginActivity extends FragmentActivity {
    private MySqliteHelper helper;
    Button sign;
    Button reg;

    String  name;
    String  mypwd;
    private EditText user;
    private EditText pwd;
    int userflag ;//定义一个标示判断 用户名是否存在
    int loginflag ;//登录时判断用户密码是否输入正确
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_login);

        //用户已存在，直接登录


        //播放动图
        //com.facebook.drawee.view.SimpleDraweeView mGif=(com.facebook.drawee.view.SimpleDraweeView)findViewById(R.id.gif);
        //ImageView imageView = (ImageView) findViewById(R.id.gif);
        ImageView  iv = (ImageView)findViewById(R.id.gif);
        ImageView  iv1 = (ImageView)findViewById(R.id.gif1);
        ImageView  iv2 = (ImageView)findViewById(R.id.gif2);
        //String   url = "res://" + getPackageName() + "/" + R.drawable.hello;
        //String   url = "http://img.zcool.cn/community/01619357b185dc0000018c1b86ea68.gif";
        //String   url = "http://img.mp.itc.cn/upload/20161106/ab60d2070c8a4b3c9c4c69e18d30a464_th.gif";
        String url="http://img1.2345.com/duoteimg/qqbiaoqing/160812512480/23.gif";
        //加载图片
        //Glide.with(this).load(url).placeholder(R.mipmap.place).error(R.mipmap.icon_photo_error).into(mIv);
        Glide.with(LoginActivity.this).load(url).into(iv);
        Glide.with(LoginActivity.this).load(url).into(iv1);
        Glide.with(LoginActivity.this).load(url).into(iv2);

        //Glide.with(this).load(url).placeholder(R.mipmap.place).error(R.mipmap.icon_photo_error).into(mIv);//GlideApp.with(this).load("http://goo.gl/gEgYUd").into(imageView);
//本地文件
//        File file = new File(Environment.getExternalStorageDirectory(), "hello.gif");
//        //加载图片
//        Glide.with(this).load(file).into(iv);
//        Glide.with(this).load(mGif).placeholder(R.mipmap.place).error(R.mipmap.icon_photo_error).into(mIv);
//        SimpleDraweeView s = (SimpleDraweeView) this.findViewById(R.id.gif);
//        DraweeController mDraweeController = Fresco.newDraweeControllerBuilder()
//                .setAutoPlayAnimations(true)
//                //设置uri,加载本地的gif资源
//                .setUri(Uri.parse("res://" + getPackageName() + "/" + R.drawable.hello))//设置uri
//                .build();
////设置Controller
//        s.setController(mDraweeController);



        sign=(Button)findViewById(R.id.login);
        reg=(Button)findViewById(R.id.register);
        //用户登录
        sign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                select();


            }

        });
        reg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        user = (EditText)findViewById(R.id.username);
        pwd=(EditText)findViewById(R.id.userpwd);

    }


    public void  insert()
    {


        helper = new MySqliteHelper(getApplicationContext());
        SQLiteDatabase db=helper.getWritableDatabase();    //建立打开可读可写的数据库实例



        //查询一下，是否用户名重复
        String sql1 = "select * from users";
            Cursor cursor = db.rawQuery(sql1, null);
            while (cursor.moveToNext()) {
                //第一列为id
                name =  cursor.getString(1); //获取第2列的值,第一列的索引从0开始
                mypwd = cursor.getString(2);//获取第3列的值

                if((user.getText().toString().isEmpty())||(pwd.getText().toString().isEmpty())){

                    Toast.makeText(this, "不能为空，请重新输入", Toast.LENGTH_SHORT).show();
                    break;
                }


            userflag = 1;  //不存在此用户


            if((user.getText().toString().equals(name)))
            {
                Toast.makeText(this, "已存在此用户，请重新注册", Toast.LENGTH_SHORT).show();


                userflag =0;
                break;
            }

        }

        if(userflag==1)
        {
            String sql2 = "insert into users(name,pwd) values ('"+user.getText().toString()+"','"+pwd.getText().toString()+"')";
            db.execSQL(sql2);
            Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
        }





    }


    public void select()
    {

        helper = new MySqliteHelper(getApplicationContext());
        SQLiteDatabase db=helper.getWritableDatabase();

        String sql = "select * from users";

        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            //第一列为id
            name =  cursor.getString(1); //获取第2列的值,第一列的索引从0开始
            mypwd = cursor.getString(2);//获取第3列的值



            if((user.getText().toString().equals(name))&&(pwd.getText().toString().equals(mypwd)))
            {
                Toast.makeText(this, "用户验证成功", Toast.LENGTH_SHORT).show();
                loginflag=1;

                //intent bundle传值
                Intent MainActivity = new Intent();
                MainActivity .setClass(LoginActivity.this,MainActivity.class);
                Bundle bundle = new Bundle(); //该类用作携带数据
                bundle.putString("user", user.getText().toString());
                MainActivity.putExtras(bundle);   //向MainActivity传值
                this.startActivity(MainActivity);
                finish();//退出


            }


        }

        if((user.getText().toString().isEmpty())||(pwd.getText().toString().isEmpty())){

            Toast.makeText(this, "不能为空，请重新输入", Toast.LENGTH_SHORT).show();
        }


        if(loginflag!=1)
        {
            Toast.makeText(this, "账号或者密码错误,请重新输入", Toast.LENGTH_SHORT).show();
        }

        cursor.close();
        db.close();
        //Toast.makeText(this, "已经关闭数据库", Toast.LENGTH_SHORT).show();
    }



}
