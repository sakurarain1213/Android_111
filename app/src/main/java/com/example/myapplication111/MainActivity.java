package com.example.myapplication111;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    int status = 1;
    public static final String TAG = "MainActivity";

    RightFragment rightFragment = new RightFragment();
    AnotherRightFragment anotherRightFragment = new AnotherRightFragment();

    //以上全是news 项目的添加条目



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //按钮设置界面跳转
        Button ok = (Button) this.findViewById(R.id.button111);  // 建立Button的信号槽机制
        ok.setOnClickListener(new ButtonListener());


        /*  每个应用程序可以注册和接受自己感兴趣的广播。

            广播消息可以来自于系统、其他应用程序。
            标准广播，一对多，无法规定接收顺序。
            有序广播，同一个时刻只有一个接收者收到消息。优先级高的先接收，并且可以决定中途停止消息传递。

            解耦
            内容生产方和消费方

         */





        //一以下是news 项目的添加条目

        replaceFragment(this.rightFragment);



    }

    //按钮跳转的模板方法  而且一定要去AndroidManifest中添加一句activity语句

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // 下面两句是跳转的模板了
            Intent intent = new Intent(MainActivity.this, TestActivity.class);//设置切换对应activity
            startActivity(intent);//开始切换
        }
    }


    public void onClick(View v) {
        if(v.getId() == R.id.button1)
        {
            if (1 == status)
            {
                replaceFragment(this.anotherRightFragment);
                status = 0;
            }
            else
            {
                replaceFragment(this.rightFragment);
                status = 1;
            }
        }
        /*
        switch (v.getId()) {
            case R.id.button1:
                if (1 == status)
                {
                    replaceFragment(this.anotherRightFragment);
                    status = 0;
                }
                else
                {
                    replaceFragment(this.rightFragment);
                    status = 1;
                }
                break;
            default:
                break;
        }
         */
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //transaction.replace(R.id.right_layout, fragment);
        transaction.replace(R.id.right_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "111111onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "111111onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "111111onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "111111onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "111111onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "111111onRestart");
    }





}