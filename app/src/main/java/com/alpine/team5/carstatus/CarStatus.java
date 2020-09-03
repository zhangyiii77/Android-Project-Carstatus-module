package com.alpine.team5.carstatus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class CarStatus extends AppCompatActivity {

    Switch closeall,leftfront,rightfront,leftback,rightback,carlock,carwindow,trunk,hood;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_status);

        closeall=findViewById(R.id.closeall);
        leftfront=findViewById(R.id.leftfront);
        img=findViewById(R.id.carstatusdisplay);
        rightfront=findViewById(R.id.rightfront);
        leftback=findViewById(R.id.leftback);
        rightback=findViewById(R.id.rightback);
        carlock=findViewById(R.id.CarLock);
        carwindow=findViewById(R.id.CarWindow);
        trunk=findViewById(R.id.trunk);

        closeall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    img.setImageResource(R.drawable.closeall);
                }else{

                    Toast.makeText(CarStatus.this,"有车门未关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });
        leftfront.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    img.setImageResource(R.drawable.leftfront);
                }else{

                    Toast.makeText(CarStatus.this,"左车门没关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });
        rightfront.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    img.setImageResource(R.drawable.rightfront);
                }else{

                    Toast.makeText(CarStatus.this,"右车门没关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });
        leftback.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    img.setImageResource(R.drawable.leftback);
                }else{

                    Toast.makeText(CarStatus.this,"左后门没关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });
        rightback.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    img.setImageResource(R.drawable.leftback);
                }else{

                    Toast.makeText(CarStatus.this,"右后门没关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });
        carlock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    img.setImageResource(R.drawable.closeall);
                }else{
                    Toast.makeText(CarStatus.this,"车锁没关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });
        carwindow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    img.setImageResource(R.drawable.closeall);
                }else{
                    Toast.makeText(CarStatus.this,"车窗没关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });
        trunk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    img.setImageResource(R.drawable.trunk);
                }else{
                    Toast.makeText(CarStatus.this,"车尾箱没关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}