package com.example.jetpackapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.jetpackapplication.databinding.MainActivity2Binding;
import com.example.jetpackapplication.ui.main.MainViewModel2;

public class MainActivity2 extends AppCompatActivity {

    private MainViewModel2 vmodel;
    private  MainActivity2Binding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vmodel = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(MainViewModel2.class);

        /**
         * 我理解的大概意思就是 这个方法就是把 LifecycleOwner 和 LiveData 绑定到一块，只有绑定到一块。当
         * 数据发生变化的时候 才会更新UI界面
         */
        mainBinding=DataBindingUtil.setContentView(this, R.layout.main_activity2);
        mainBinding.setModel(vmodel);
        mainBinding.setLifecycleOwner(this);//设置生命周期的主人


    }
}