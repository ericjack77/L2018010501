package com.example.student.l2018010501;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int ch,tmp=-1;
    boolean[] chks=new boolean[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View v)
    {
        AlertDialog.Builder dia=new AlertDialog.Builder(MainActivity.this);
        dia.setTitle("Hello Title");
        dia.setMessage("Hello msg");
        dia.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "按下了確定", Toast.LENGTH_SHORT).show();
            }
        });
        dia.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "按下取消", Toast.LENGTH_SHORT).show();
            }
        });
        dia.setNeutralButton("HELP", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "想要幫助?", Toast.LENGTH_SHORT).show();
            }
        });
        dia.show();
    }

    public void click2(View v)
    {
        AlertDialog.Builder dia=new AlertDialog.Builder(MainActivity.this);
        dia.setTitle("Hello Title");
        dia.setMessage("Hello msg");
        final EditText ed=new EditText(MainActivity.this);
        final TextView tv =findViewById(R.id.textView);
        dia.setView(ed);
        dia.setPositiveButton("送出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "按下了確定", Toast.LENGTH_SHORT).show();

                tv.setText(ed.getText().toString());
            }
        });
        dia.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "按下取消", Toast.LENGTH_SHORT).show();
                tv.setText("");
            }
        });
        dia.show();
    }

    public  void click3(View v)
    {
        AlertDialog.Builder dia=new AlertDialog.Builder(MainActivity.this);
        dia.setTitle("列表");
        final TextView tv2=findViewById(R.id.textView2);
        final String fruits[]={"Apple","Pineapple","Tomato"};
        dia.setItems(fruits, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv2.setText(fruits[i]);
            }

        });
        dia.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dia.setCancelable(false); //設定是否允許隨意取消  false-否
        dia.show();
    }

    public  void click4(View v)
    {
        AlertDialog.Builder dia=new AlertDialog.Builder(MainActivity.this);
        dia.setTitle("列表");
        final TextView tv3=findViewById(R.id.textView3);
        final String fruits[]={"Apple","Pineapple","Tomato"};
        tmp=ch;
        dia.setSingleChoiceItems(fruits, ch, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tmp=i;
            }
        });
        dia.setPositiveButton("送出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ch=tmp;
                tv3.setText(fruits[ch]);
            }
        });
        dia.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv3.setText("");
            }
        });
        dia.show();
    }

    public void click5(View v)
    {
        AlertDialog.Builder dia=new AlertDialog.Builder(MainActivity.this);
        dia.setTitle("複選列表");
        final TextView tv4=findViewById(R.id.textView4);
        final String fruits[]={"Apple","Pineapple","Tomato","香蕉","火龍果"};
        dia.setMultiChoiceItems(fruits, chks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });
        dia.setPositiveButton("送出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<=4;i++)
                {
                    if (chks[i])
                    {
                        sb.append(fruits[i]+",");
                    }

                }
                tv4.setText(sb.toString());
            }
        });
        dia.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dia.show();
    }

    public void click6(View v)
    {
        AlertDialog.Builder dia=new AlertDialog.Builder(MainActivity.this);
        dia.setTitle("列表");
        LayoutInflater flater=LayoutInflater.from(MainActivity.this);
        View v1=flater.inflate(R.layout.layout1,null);
        dia.setView(v1);

        final TextView tv6=v1.findViewById(R.id.textView6);
        Button bu7=v1.findViewById(R.id.button7);
        bu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv6.setText("Hello world");
            }
        });

        dia.setPositiveButton("送出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dia.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        dia.show();
    }
}
