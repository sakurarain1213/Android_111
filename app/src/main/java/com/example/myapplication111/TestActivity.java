package com.example.myapplication111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_test);
        setContentView(R.layout.layouttest111);
        /*System.out.println("test .......");
        每个项目先去buile.gradle  和 settings.gradle 改配置

        先启动虚拟机  再启动项目

        打包生成apk 直接去build 打包即可  需要自己设置秘钥



        */




        Button ok2 = (Button) this.findViewById(R.id.button222);  // 建立Button的信号槽机制
        ok2.setOnClickListener(new TestActivity.ButtonListener());

    }

    /*
    @Override
    public void onBackPressed() {

        // 创建Intent对象并设置目标为MainActivity
        Intent intent = new Intent(TestActivity.this, MainActivity.class);

        // 启动MainActivity
        startActivity(intent);
    }
    */

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {


            //activity有生命周期  回到原来的页面 栈底 可以选择先结束本activity

            finish(); // 结束当前活动
            startActivity(new Intent(TestActivity.this, MainActivity.class)); // 启动MainActivity
        }
    }





}