package com.example.lkard.lk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {
    Long rez;
    Integer znak;
    TextView number1;
    TextView number2;
    TextView tv_znak;
    EditText et_rez;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        number1 = (TextView)findViewById(R.id.txt_number1);
        number2 = (TextView)findViewById(R.id.txt_number2);
        tv_znak = (TextView)findViewById(R.id.txt_znak);
        et_rez = (EditText) findViewById(R.id.et_rez);
        createNew();
    }
    public void OnBtnNewClick(View view){
        createNew();
    }
    public void OnBtnOkCkick(View viev){
        String buf = et_rez.getText().toString();
        if(buf.length()>0&&buf.length()<11) {
            Long buf1 = Long.parseLong(buf);
            if(rez.equals(buf1)) {
                Toast.makeText(this,"Верно",Toast.LENGTH_LONG).show();
                createNew();
            }
            else {
                Toast.makeText(this, "Не верно :(", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this, "Значение введено не верно", Toast.LENGTH_LONG).show();
        }

    }
    public void createNew(){
        et_rez.setText("");
        Random r = new Random();
        Integer x ;
        Integer y ;
        x = r.nextInt(100000);
        y = r.nextInt(100000);
        if(x<y){
            Integer buf = x;
            x = y;
            y=buf;
        }

        znak = r.nextInt(3);
        switch (znak){
            case 0:
                tv_znak.setText("+");
                rez = (long) (x + y);
                break;
            case 1:
                tv_znak.setText("-");
                rez = (long) (x - y);
                break;
            case 2:
                x = r.nextInt(10000)+1;
                y = r.nextInt(10000)+1;
                tv_znak.setText("*");
                rez =(long)(x * y);
                break;
        }
        number1.setText(x.toString());
        number2.setText(y.toString());
    }
}
