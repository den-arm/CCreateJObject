package com.example.ccreatejobject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CounterNative cn;
    Button btn,btn2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);

        tv = findViewById(R.id.textView);

//        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
//        setSupportActionBar(mActionBarToolbar);
//        getSupportActionBar().setTitle("我的标题");

        cn = new CounterSub();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                ResultValue rvObj = (ResultValue)actNative.nativeExec();
                tv.setText("Value=" + rvObj.getmValue());
                break;
            case R.id.button2:
                finish();
                break;
        }

    }
}