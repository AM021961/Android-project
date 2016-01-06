package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button bt1,bt2,bt3;
    EditText et1;
    TextView tv1;
    String name="";
    String temp="";
    String[] name1 = {};
    Object[] tempArray ;
    HashSet<String> name2 = new HashSet<String>();
    Random rd = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button)findViewById(R.id.Button1);
        bt2 = (Button)findViewById(R.id.Button2);
        bt3 = (Button)findViewById(R.id.Button3);
        et1 = (EditText)findViewById(R.id.EditText);
        tv1 = (TextView)findViewById(R.id.TextView3);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name2.add(et1.getText().toString())) {
                    name = name + et1.getText().toString();
                    name = name + "、";
                    tempArray = name2.toArray();
                }
                et1.setText("");
                tv1.setText(name);
                System.out.println(name2);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(tempArray[rd.nextInt(tempArray.length)].toString());
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name2.remove(et1.getText().toString())){
                    temp = et1.getText().toString()+"、";
                    name = name.replace(temp,"");
                    tempArray = name2.toArray();
                }
                tv1.setText(name);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
