package com.yaowen.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fragmentManager=getFragmentManager();
        radioGroup=(RadioGroup)findViewById(R.id.rg_tab);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                Fragment fragment=FragmentFactory.getInstanceByIndex(checkedId);
                transaction.replace(R.id.content, fragment);
                transaction.commit();
            }
        });

    }

}
