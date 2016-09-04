package com.victor_xiao.messagetest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button bth = (Button) this.findViewById(R.id.button_hint);
        bth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个提示对话框")//显示的消息内容
                        .setTitle("提示");//对话框标题

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了忽略按钮", Toast.LENGTH_LONG).show();

                    }

                });
                builder.show();
            }
        });

        Button button = (Button) findViewById(R.id.button_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View v = inflater.inflate(R.layout.login_dialog, null);

               builder.setView(v);

                final EditText userid;
                final EditText password;
                userid = (EditText)v.findViewById(R.id.edittextuserid);
                password = (EditText) v.findViewById(R.id.edittextpwd);

                builder.setTitle("Login");


                builder.setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //login
                                String tag = "test1";

                                String TextId ;
                                String Textpwd ;
                                TextId = userid.getText().toString();
                                Textpwd = password.getText().toString();

                                Log.d(tag, TextId);
                                Log.d(tag, Textpwd);

                                if (TextId.equals("abc") && Textpwd.equals("123")) {
                                    Log.d(tag, "right");
                                    Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_LONG).show();
                                } else {
                                    Log.d(tag, "wrong");
                                    Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_LONG).show();
                                }
                            }
                        })

                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cancel
                            }
                        });
                builder.show();
            }
        });


    }

}
