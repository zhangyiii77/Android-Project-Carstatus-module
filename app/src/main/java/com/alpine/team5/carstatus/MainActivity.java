package com.alpine.team5.carstatus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyReceiver myReceiver = new MyReceiver();

    TextView mileage,mileage_available;
    ImageView img;
    Button button;
    Switch aSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mileage = findViewById(R.id.mileage_text);
        mileage_available = findViewById(R.id.mileage_available_text);
        aSwitch = findViewById(R.id.switch_aircondition);
        button=findViewById(R.id.nextpage);



        findViewById(R.id.nextpage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,CarStatus.class);
                startActivity(i);
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    img.setImageResource(R.drawable.aircondition);
                }else{
                    Toast.makeText(MainActivity.this,"空调未开",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        //动态注册广播接收器
        registerReceiver(batReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        //取消注册
        unregisterReceiver(batReceiver);
    }

    //电量的广播接收器
    BroadcastReceiver batReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //更新电量状态,显示到界面

            //获取电量数据
            Bundle b = intent.getExtras();
            int level = b.getInt(BatteryManager.EXTRA_LEVEL);
            int scale = b.getInt(BatteryManager.EXTRA_SCALE);
            int status = b.getInt(BatteryManager.EXTRA_STATUS);
            int percent = level*100/scale;

            //更新百分比
            TextView tvPercent = findViewById(R.id.batterytext);
            tvPercent.setText(percent+"%");
            //
            ImageView imageView = findViewById(R.id.batterydisplay);
            switch ((percent+100)/2){
                case 0: imageView.setImageResource(R.drawable.battery1);break;
                case 1: imageView.setImageResource(R.drawable.battery2);break;
                case 2: imageView.setImageResource(R.drawable.battery3);break;
                case 3: imageView.setImageResource(R.drawable.battery4);break;
                case 4: imageView.setImageResource(R.drawable.battery5);break;
            }

            String mileage_num = ((100-percent)*10)+"km";
            mileage.setText(mileage_num);
            String mileage_num1 = (percent*10)+"km";
            mileage_available.setText(mileage_num1);



        }
    };

}